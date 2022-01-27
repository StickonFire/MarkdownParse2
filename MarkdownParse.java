// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String[] markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        
        /*
        int currentIndex = 0;
        
        while(currentIndex < markdown.length()) {
            
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")");
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            
        }
        */

        for(int i=0; i<markdown.length; i++) {

            if(markdown[i].contains("[") && markdown[i].contains("]") 
                && markdown[i].contains("(") && markdown[i].contains(")")) {
                int openParen = markdown[i].indexOf("(");
                int closeParen = markdown[i].lastIndexOf(")");
                toReturn.add(markdown[i].substring(openParen + 1, closeParen));   
            }
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        String[] contentsArray = contents.split("\n");
        ArrayList<String> links = getLinks(contentsArray);
        System.out.println(links);
    }
}