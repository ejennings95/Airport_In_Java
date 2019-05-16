import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AirportTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @DisplayName("should start with hangar equating to an empty array")
    @Test
    void hangarArray() {
        Airport heathrow = new Airport();
        assertEquals(new ArrayList<Object>(), heathrow.hangar);
    }

    @DisplayName("should be able to land a plane")
    @Test
    void landPlane() throws PlaneAlreadyLandedException, BadWeatherException {
        Weather weather = spy(Weather.class);
        Airport heathrow = new Airport(weather);
        when(weather.randomise()).thenReturn(0);
        Plane plane = mock(Plane.class);
        heathrow.landPlane(plane);
        assertEquals(1, heathrow.getHangar().size());
    }

    @DisplayName("should not be able to land a plane in stormy weather")
    @Test
    void stormyLandPlane() throws PlaneAlreadyLandedException, BadWeatherException {
        Weather weather = spy(Weather.class);
        Airport heathrow = new Airport(weather);
        when(weather.randomise()).thenReturn(1);
        Plane plane = mock(Plane.class);
        Assertions.assertThrows(BadWeatherException.class, () -> {
            heathrow.landPlane(plane);
        });
    }

    @DisplayName("should be able to take off a plane")
    @Test
    void takeOffPlane() throws PlaneAlreadyLandedException, PlaneAlreadyFlyingException, PlaneNotInHangarException, BadWeatherException {
        Weather weather = spy(Weather.class);
        Airport heathrow = new Airport(weather);
        when(weather.randomise()).thenReturn(0);
        Plane plane = mock(Plane.class);
        heathrow.landPlane(plane);
        assertEquals(1, heathrow.getHangar().size());
        heathrow.takeOffPlane(plane);
        assertEquals(0, heathrow.getHangar().size());
    }

    @DisplayName("should not be able to take off a plane in stormy weather")
    @Test
    void stormyTakeOffPlane() throws PlaneAlreadyLandedException, BadWeatherException {
        Weather weather = spy(Weather.class);
        Airport heathrow = new Airport(weather);
        when(weather.randomise()).thenReturn(0);
        Plane plane = mock(Plane.class);
        heathrow.landPlane(plane);
        Assertions.assertThrows(BadWeatherException.class, () -> {
            when(weather.randomise()).thenReturn(1);
            heathrow.takeOffPlane(plane);
        });
    }

    @DisplayName("should not be able to land a plane with a landed status")
    @Test
    void unableToLandPlane() throws PlaneAlreadyLandedException, BadWeatherException {
        Weather weather = spy(Weather.class);
        Airport heathrow = new Airport(weather);
        when(weather.randomise()).thenReturn(0);
        Plane plane = mock(Plane.class);
        when(plane.getStatus()).thenReturn("landed");
        Assertions.assertThrows(PlaneAlreadyLandedException.class, () -> {
            heathrow.landPlane(plane);
        });
    }

    @DisplayName("should not be able to take off a plane with a flying status")
    @Test
    void unableToTakeOffFlyingPlane() throws PlaneAlreadyFlyingException, BadWeatherException {
        Weather weather = spy(Weather.class);
        Airport heathrow = new Airport(weather);
        when(weather.randomise()).thenReturn(0);
        Plane plane = mock(Plane.class);
        when(plane.getStatus()).thenReturn("flying");
        Assertions.assertThrows(PlaneAlreadyFlyingException.class, () -> {
            heathrow.takeOffPlane(plane);
        });
    }

    @DisplayName("should not be able to take off a plane if not in hangar")
    @Test
    void unableToTakeOffPlaneNotInHangar() throws PlaneNotInHangarException, PlaneAlreadyLandedException, BadWeatherException {
        Weather weather = spy(Weather.class);
        Airport heathrow = new Airport(weather);
        Airport gatwick = new Airport(weather);
        when(weather.randomise()).thenReturn(0);
        Plane plane = mock(Plane.class);
        heathrow.landPlane(plane);
        when(plane.getStatus()).thenReturn("landed");
        Assertions.assertThrows(PlaneNotInHangarException.class, () -> {
            gatwick.takeOffPlane(plane);
        });
    }
}
