import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class WeatherTest {

    @DisplayName("should have original condition as clear")
    @Test
    void condition() {
        Weather weather = new Weather();
        assertEquals("clear", weather.condition);
    }

    @DisplayName("should have condition as clear if randomise returns 0")
    @Test
    void clearCondition() {
        Weather weather = spy(Weather.class);
        when(weather.randomise()).thenReturn(0);
        assertEquals("clear", weather.getCondition());
    }

    @DisplayName("should have condition as stormy if randomise returns 1")
    @Test
    void stormyCondition() {
        Weather weather = spy(Weather.class);
        when(weather.randomise()).thenReturn(1);
        assertEquals("stormy", weather.getCondition());
    }
}