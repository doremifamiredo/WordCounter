import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        WordCounter wordCounter = new WordCounter();
        ArrayList<String> wordsList = wordCounter.readFileInList( 5);
        HashMap<String, Integer> wordCount = wordCounter.wordCounter(wordsList);
        wordCounter.showResult(wordCount);
    }
}