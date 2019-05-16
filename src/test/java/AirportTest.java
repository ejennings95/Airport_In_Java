import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    void landPlane() throws PlaneAlreadyLandedException {
        Airport heathrow = new Airport();
        Plane plane = mock(Plane.class);
        heathrow.landPlane(plane);
        assertEquals(1, heathrow.getHangar().size());
    }

    @DisplayName("should be able to take off a plane")
    @Test
    void takeOffPlane() throws PlaneAlreadyLandedException {
        Airport heathrow = new Airport();
        Plane plane = mock(Plane.class);
        heathrow.landPlane(plane);
        assertEquals(1, heathrow.getHangar().size());
        heathrow.takeOffPlane(plane);
        assertEquals(0, heathrow.getHangar().size());
    }

    @DisplayName("should not be able to land an plane with a landed status")
    @Test
    void unableToLandPlane() throws PlaneAlreadyLandedException {
        Airport heathrow = new Airport();
        Plane plane = mock(Plane.class);
        when(plane.getStatus()).thenReturn("landed");
        Assertions.assertThrows(PlaneAlreadyLandedException.class, () -> {
            heathrow.landPlane(plane);
        });
    }
}