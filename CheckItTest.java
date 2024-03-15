import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class CheckItTest {

    @Test
    public void predicateCoverageTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Test case 1: a is true, b is true, c is true : makes p true
        CheckIt.checkIt(true, true, true);
        assertEquals("P is true\n", outputStream.toString());

        // Test case 8: a is false, b is false, c is false : makes p false
        CheckIt.checkIt(false, false, false);
        assertEquals("P isn't true\n", outputStream.toString());
    }

    @Test
    public void clauseCoverageTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Test case 1: a is true, b is true, c is true
        CheckIt.checkIt(true, true, true);
        assertEquals("P is true\n", outputStream.toString());

        // Test case 2: a is true, b is true, c is false
        CheckIt.checkIt(true, true, false);
        assertEquals("P is true\n", outputStream.toString());

        // Test case 3: a is true, b is false, c is true
        CheckIt.checkIt(true, false, true);
        assertEquals("P is true\n", outputStream.toString());

        // Test case 4: a is true, b is false, c is false
        CheckIt.checkIt(true, false, false);
        assertEquals("P is true\n", outputStream.toString());

        // Test case 5: a is false, b is true, c is true
        CheckIt.checkIt(false, true, true);
        assertEquals("P is true\n", outputStream.toString());

        // Test case 6: a is false, b is true, c is false
        CheckIt.checkIt(false, true, false);
        assertEquals("P isn't true\n", outputStream.toString());

        // Test case 7: a is false, b is false, c is true
        CheckIt.checkIt(false, false, true);
        assertEquals("P isn't true\n", outputStream.toString());

        // Test case 8: a is false, b is false, c is false
        CheckIt.checkIt(false, false, false);
        assertEquals("P isn't true\n", outputStream.toString());
    }

    @Test
    public void CACCTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Test case 2: a is true, b is true, c is false
        CheckIt.checkIt(true, true, false);
        assertEquals("P is true\n", outputStream.toString());

        // Test case 6: a is false, b is true, c is false
        CheckIt.checkIt(false, true, false);
        assertEquals("P isn't true\n", outputStream.toString());
    }

    @Test
    public void RACCTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Test case 3: a is true, b is false, c is true
        CheckIt.checkIt(true, false, true);
        assertEquals("P is true\n", outputStream.toString());

        // Test case 7: a is false, b is false, c is true
        CheckIt.checkIt(false, false, true);
        assertEquals("P isn't true\n", outputStream.toString());
    }
}
