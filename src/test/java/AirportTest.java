import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AirportTest {

    @DisplayName("should start with hangar equating to an empty array")
    @Test
    void hangarArray() {
        Airport heathrow = new Airport();
        assertEquals(new ArrayList<Object>(), heathrow.hangar);
    }

    @DisplayName("should be able to land a plane")
    @Test
    void landPlane() {
        Airport heathrow = new Airport();
        Plane plane = mock(Plane.class);
        heathrow.landPlane(plane);
        assertEquals(1, heathrow.getHangar().size());
    }

}