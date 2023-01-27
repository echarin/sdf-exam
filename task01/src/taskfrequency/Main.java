package taskfrequency;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: <file_name.txt>");
        } else {
            String filePath = Constants.DEFAULT_DIRECTORY + File.separator + args[0];
            try {
                List<String> wordList = TextProcessor.buffAddWordsToList(filePath);
                TextProcessor.calculateWordFrequency(wordList);
            } catch (IOException e) {
                System.out.println("File not found.");
                System.exit(1);
            }
        }
    }
}
