import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @DisplayName("should start with plane status flying")
    @Test
    void status() {
        Plane plane = new Plane();
        assertEquals("flying", plane.status);
    }

    @DisplayName("should be able to set plane status to landed")
    @Test
    void landedStatus() {
        Plane plane = new Plane();
        plane.landed();
        assertEquals("landed", plane.status);
    }

    @DisplayName("should be able to set plane status to flying")
    @Test
    void flyingStatus() {
        Plane plane = new Plane();
        plane.landed();
        assertEquals("landed", plane.status);
        plane.flying();
        assertEquals("flying", plane.status);
    }

}