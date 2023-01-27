package taskfrequency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextProcessor {
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

        Integer totalWordCount = wordList.size();
        Float wordFrequency = 0.0f;

        for (String word: wordList) {
            wordCounts.merge(word, 1, 
                (a, b) -> a + b
            );
        }

        for (String word: wordCounts.keySet()) {
            wordFrequency = (float) wordCounts.get(word) / (float) totalWordCount;
            wordFrequencies.put(word, wordFrequency);
        }

        // Cheating lol
        wordFrequencies.remove("");

        long maxSize = 10;

        Map<String, Float> sortedWordFrequencies = wordFrequencies.entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .limit(maxSize)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        sortedWordFrequencies.forEach(
            (word, frequency) -> {
                System.out.printf("%s: %f\n", word, frequency);
            }
        );
    }
}
