//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;

        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            
            //checks if the links contains any parentheses
            int index = markdown.indexOf("(", closeParen-1);
            if(index == closeParen-1) {
                closeParen = markdown.indexOf(")", closeParen+1);
            }

            //checks if the index is out of bounds
            if(openBracket == -1 || closeBracket == -1 || openParen == -1 || closeParen == -1){
                break;
            }
            
            //checks if the brackets contains backticks
            if(markdown.substring(closeBracket, closeBracket + 2).contains("`")) {
                closeBracket += 2;
            }

            //checks if the parentheses contain spaces
            if(markdown.substring(openParen, closeParen).contains(" ")) {
                currentIndex = closeParen + 1;
                continue;
            }

            //checks if it's an image or if contains backticks
            if(openBracket != 0) {
                if(markdown.substring(openBracket - 1, openBracket).equals("!") || markdown.substring(openBracket - 1, openBracket).equals("`")) {
                    currentIndex = closeParen + 1;
                    continue;
                }
            }

            //trims the link before adding to the list (remove any spaces)
            if(openParen - closeBracket == 1) {
                String link = markdown.substring(openParen + 1, closeParen);
                toReturn.add(link.trim());
            }
            currentIndex = closeParen + 1;
        }

        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}