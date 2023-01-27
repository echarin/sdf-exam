package taskfrequency;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // if (args.length != 1) {
        //     System.out.println("Usage: <file_name.txt>");
        // } else {
    
        // }

        try {
            List<String> wordList = TextProcessor.buffAddWordsToList(Constants.TESTFILE);
            System.out.println(wordList);
        } catch (IOException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        // String testString = "Test.,:!-(){}[]'\" TEST";
        // TextProcessor.parseLine(testString);    
    }
}
