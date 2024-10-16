import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCounter {
    public ArrayList<String> readFileInList(int min) throws IOException {
        String text = Files.readString(Path.of("./Text.txt"));
        text = text.replaceAll("\\p{Punct}|\\n|\\r|\u2026", " ");
        String[] splitText = text.split(" ");
        ArrayList<String> words = new ArrayList<>();
        for (String word : splitText) {
            if (word.length() >= min) {
                words.add(word.toLowerCase());
            }
        }
        return words;
    }

    public HashMap<String, Integer> wordCounter(ArrayList<String> words) {
        HashMap<String, Integer> countWord = new HashMap<>();
        words.trimToSize();
        for (int i = 0; i < words.size(); i++) {
            String addWord = words.get(i);
            if (countWord.containsKey(addWord)) {
                int count = countWord.get(addWord);
                countWord.put(addWord, ++count);
            } else {
                countWord.put(addWord, 1);
            }
        }
        return countWord;
    }

    public void showResult(HashMap<String, Integer> wordCount) {
        String format = "|%1$-30.18s| ";
        System.out.format(format, "СЛОВО");
        System.out.println("СКОЛЬКО РАЗ ВСТРЕЧАЕТСЯ В ТЕКСТЕ");
        wordCount.entrySet().forEach(entry -> {
            System.out.format(format, entry.getKey());
            System.out.println(entry.getValue());
        });
    }
}
