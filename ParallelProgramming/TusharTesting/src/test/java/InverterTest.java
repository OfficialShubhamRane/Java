import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class InverterTest {


    @Test
    public void testInvert() {
        assertEquals("oof", Inverter.invert("foo"));
        assertEquals("", Inverter.invert((String) ""));
        assertEquals(" ", Inverter.invert(" "));
    }

}
