//imports the packages needed to use JUnit
import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

//defines the class
public class testSnippets {
    @Test
    public void testSnippet1() throws IOException {
        List testList = List.of("`google.com", "google.com", "ucsd.edu");
        Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);
        assertEquals(testList, MarkdownParse.getLinks(content));
    }
}
