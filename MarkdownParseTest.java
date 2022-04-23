//imports the packages needed to use JUnit
import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

//defines the class
public class MarkdownParseTest {
    //defines the code below to be a test
    @Test
    //defines the method
    public void addition() {
        //testing that the actual result from 1+1 is equal to the expected output of 2
        assertEquals(2, 1+1);
    }
    @Test
    public void testGetLinks() throws IOException {
        List testList = List.of("https://something.com", "some-thing.html");
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        assertEquals(testList, MarkdownParse.getLinks(content));
    }
}
