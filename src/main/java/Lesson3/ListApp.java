package Lesson3;

import java.util.*;

public class ListApp {
    public static void main(String[] args) {
        int[] array = new int[10];


        //массив с элементами меньше 5
        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(10);
        // 10, 10
        list.remove(0); // 10
        list.get(1); //arr[1]

        list.size(); // 1
        list.contains(10); //true

        for (int x : array) {
            if (x < 5) {
                list.add(x);
            }
        }

        Object[] objects = list.toArray(new Integer[0]);


        Collections.sort(list);
    }

}
