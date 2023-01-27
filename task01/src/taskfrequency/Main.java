package taskfrequency;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: <file_name.txt>");
        } else {
            try {
                List<String> wordList = TextProcessor.buffAddWordsToList(args[0]);
                TextProcessor.calculateWordFrequency(wordList);
            } catch (IOException e) {
                System.out.println("File not found.");
                System.exit(1);
            }
        }
    }
}
