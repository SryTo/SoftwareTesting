package serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import service.Calculate;
public class CalculateTest {
    @Test
    public void testadd() {
    	assertEquals(4, new Calculate().add(1,3));
    }
}
