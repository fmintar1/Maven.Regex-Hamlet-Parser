import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        assertTrue(hamletText.contains("HAMLET"));
        assertTrue(hamletText.contains("Hamlet"));
        assertFalse(hamletText.contains("LEON"));
        assertFalse(hamletText.contains("Leon"));
        hamletText = hamletParser.replaceText("Hamlet", hamletText, "Leon");
        hamletText = hamletParser.replaceText("HAMLET", hamletText, "LEON");
        assertFalse(hamletText.contains("HAMLET"));
        assertFalse(hamletText.contains("Hamlet"));
        assertTrue(hamletText.contains("LEON"));
        assertTrue(hamletText.contains("Leon"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        assertTrue(hamletText.contains("Horatio"));
        assertTrue(hamletText.contains("HORATIO"));
        assertFalse(hamletText.contains("Tariq"));
        assertFalse(hamletText.contains("TARIQ"));
        hamletText = hamletParser.replaceText("Horatio", hamletText, "Tariq");
        hamletText = hamletParser.replaceText("HORATIO", hamletText, "TARIQ");
        assertFalse(hamletText.contains("Horatio"));
        assertFalse(hamletText.contains("HORATIO"));
        assertTrue(hamletText.contains("Tariq"));
        assertTrue(hamletText.contains("TARIQ"));
    }

    @Test
    public void testFindHoratio() {
        assertTrue(hamletText.contains("Horatio"));
        assertTrue(hamletText.contains("HORATIO"));
        hamletText = hamletParser.replaceText("Horatio", hamletText, "");
        hamletText = hamletParser.replaceText("HORATIO", hamletText, "");
        assertFalse(hamletText.contains("Horatio"));
        assertFalse(hamletText.contains("HORATIO"));
    }

    @Test
    public void testFindHamlet() {
        assertTrue(hamletText.contains("Hamlet"));
        assertTrue(hamletText.contains("HAMLET"));
        hamletText = hamletParser.replaceText("Hamlet", hamletText, "");
        hamletText = hamletParser.replaceText("HAMLET", hamletText, "");
        assertFalse(hamletText.contains("Hamlet"));
        assertFalse(hamletText.contains("HAMLET"));
    }
}