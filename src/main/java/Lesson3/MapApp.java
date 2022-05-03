package Lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapApp {
    public static void main(String[] args) {

        //equals
        //hashCode

        Map<String, Integer> map = new HashMap<>();//создание
        map.put("key", 100);
        map.put("key", 200); //перезапишет

        map.containsKey("key");

        map.remove("key");
        map.size();


        map.getOrDefault("123", 10);//default

        map.get("key");//null

        map.isEmpty();

        map.values(); //Collection

        map.keySet(); //Set

        Set<Integer> set = new HashSet<>();

    }
}
