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

            //checks if the index is out of bounds
            if(openBracket == -1 || closeBracket == -1 || openParen == -1 || closeParen == -1){
                break;
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

            //checks if there is brackets between the openParen and closeBracket
            if(markdown.substring(closeBracket + 1, openParen).contains("]")) {
                closeBracket = markdown.indexOf("]", closeBracket + 1);
            }

            //checks if the link contains any parentheses
            if(markdown.substring(openParen + 1, closeParen).contains("(")) {
                closeParen = markdown.indexOf(")", closeParen + 1);
                if(closeParen + 1 < markdown.length()) {
                    if(markdown.substring(closeParen + 1, closeParen + 2).equals(")")) {
                        closeParen += 1;
                    }
                }
            } 

            //trims the link before adding to the list (remove any spaces)
            if(openParen - closeBracket == 1) {
                String link = markdown.substring(openParen+1, closeParen);
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