package taskfrequency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TextProcessor {

    public Map<String, Integer> wordFrequencies = new HashMap<>();

    public static List<String> buffAddWordsToList(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = "";
        List<String> wordList = new LinkedList<>();

        while ((line = br.readLine()) != null) {
            for (String word: parseLine(line)) {
                wordList.add(word);
            }
        }

        br.close();
        return wordList;
    }

    public static String[] parseLine(String line) {
        return line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
    }

    public static void calculateWordFrequency(List<String> wordList) {
        Map<String, Float> wordFrequencies = new HashMap<>();
        Map<String, Integer> wordCounts = new HashMap<>();

        Integer wordCount = words.size();
        Float wordFrequency = 0.0f;

        // Populate the map of words
        for (String word: wordList) {
            
        }

        // Then calculate word frequency for each word
    }
}
