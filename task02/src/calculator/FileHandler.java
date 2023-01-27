package calculator;

public class FileHandler {
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
}
