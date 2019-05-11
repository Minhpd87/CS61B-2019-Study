import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    OffByN test = new OffByN(5);

    @Test
    public void equalChars() {
        assertTrue(test.equalChars('a','f'));
        assertTrue(test.equalChars('f','a'));
        assertFalse(test.equalChars('f','h'));
    }
}
