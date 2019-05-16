import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    @DisplayName("should start with dockedbikes equating to an empty array")
    @Test
    void hangarArray() {
        Airport heathrow = new Airport();
        assertEquals(new ArrayList<Object>(), heathrow.hangar);
    }

}