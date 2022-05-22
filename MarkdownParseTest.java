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
    public void testFile() throws IOException {
        List testList = List.of("https://something.com", "some-thing.html");
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        assertEquals(testList, MarkdownParse.getLinks(content));
    }
    @Test
    public void testFile1() throws IOException {
        List testList = List.of("https://something[]().com");
        Path fileName = Path.of("test_file1.md");
        String content = Files.readString(fileName);
        assertEquals(testList, MarkdownParse.getLinks(content));
    }
    @Test
    public void testFile2() throws IOException {
        List testList = List.of();
        Path fileName = Path.of("test_file2.md");
        String content = Files.readString(fileName);
        assertEquals(testList, MarkdownParse.getLinks(content));
    }
    @Test
    public void testFile3() throws IOException {
        List testList = List.of();
        Path fileName = Path.of("test_file3.md");
        String content = Files.readString(fileName);
        assertEquals(testList, MarkdownParse.getLinks(content));
    }
    @Test
    public void testFile4() throws IOException {
        List testList = List.of();
        Path fileName = Path.of("test_file4.md");
        String content = Files.readString(fileName);
        assertEquals(testList, MarkdownParse.getLinks(content));
    }
    @Test
    public void testFile5() throws IOException {
        List testList = List.of();
        Path fileName = Path.of("test_file5.md");
        String content = Files.readString(fileName);
        assertEquals(testList, MarkdownParse.getLinks(content));
    }
    @Test
    public void testFile6() throws IOException {
        List testList = List.of();
        Path fileName = Path.of("test_file6.md");
        String content = Files.readString(fileName);
        assertEquals(testList, MarkdownParse.getLinks(content));
    }
    @Test
    public void testFile7() throws IOException {
        List testList = List.of();
        Path fileName = Path.of("test_file7.md");
        String content = Files.readString(fileName);
        assertEquals(testList, MarkdownParse.getLinks(content));
    }

    //test snippets for lab report 4
    @Test
    public void testSnippet1() throws IOException {
        List testList = List.of("`google.com", "google.com", "ucsd.edu");
        Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);
        assertEquals(testList, MarkdownParse.getLinks(content));
    }
    @Test
    public void testSnippet2() throws IOException {
        List testList = List.of("a.com(())", "example.com");
        Path fileName = Path.of("snippet2.md");
        String content = Files.readString(fileName);
        assertEquals(testList, MarkdownParse.getLinks(content));
    }
    @Test
    public void testSnippet3() throws IOException {
        List testList = List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        Path fileName = Path.of("snippet3.md");
        String content = Files.readString(fileName);
        assertEquals(testList, MarkdownParse.getLinks(content));
    }
}
