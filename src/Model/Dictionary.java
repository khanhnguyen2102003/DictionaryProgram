package Model;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    public void addWord(String english, String vietnamese) {
        dictionary.put(english, vietnamese);
    }

    public void deleteWord(String english) {
        dictionary.remove(english);
    }

    public String translateWord(String english) {
        return dictionary.get(english);
    }

    public boolean wordExists(String english) {
        return dictionary.containsKey(english);
    }
}
