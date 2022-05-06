package HomeWork3;

import java.util.HashMap;
import java.util.Map;

public class UniqueWordApp {

    public static void main(String[] args) {

        Map<String, Integer> ws = new HashMap<>();
        String[] words = {
                "Yahoo", "Google", "Yandex",
                "Cat", "Dog", "Line", "Java",
                "Java", "C", "Application",
                "Gamma", "Yahoo"
        };

        for (int i = 0; i < words.length; i++) {
            if (ws.containsKey(words[i])) {
                ws.put(words[i], ws.get(words[i]) + 1);
            } else {
                ws.put(words[i], 1);
            }
            System.out.println(ws);
        }
    }


}
