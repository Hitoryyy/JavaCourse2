package HomeWork5;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ArrayThread {

    static final int SIZE = 10000000;
    static final int H = SIZE / 2;

    public static void main(String[] args) {
        System.out.println("Время выполнения 1-го метода: " + firstMethod() + " мс.");
        System.out.println("Время выполнения 2-го метода: " + secondMethod() + " мс.");
    }

    private static long firstMethod() {
        float[] array = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
        }
        return System.currentTimeMillis() - a;
    }

    private static long secondMethod() {
        float[] array = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = 1;
        }
        float[] firstArray = new float[H];
        float[] secondArray = new float[H];
        long a = System.currentTimeMillis();
        System.arraycopy(array, 0, firstArray, 0, H);
        System.arraycopy(array, H, secondArray, 0, H);
        Thread firstThread = new Thread(() -> {
            for (int i = 0; i < H; i++) {
                firstArray[i] = (float) (firstArray[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
            }
        });
        firstThread.start();
        Thread secondThread = new Thread(() -> {
            for (int i = 0; i < H; i++) {
                secondArray[i] = (float) (secondArray[i] * Math.sin(0.2f + (float) (i + H) / 5) * Math.cos(0.2f + (float) (i + H) / 5) * Math.cos(0.4f + (float) (i + H) / 2));
            }
        });
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(firstArray, 0, array, 0, H);
        System.arraycopy(secondArray, 0, array, H, H);
        return System.currentTimeMillis() - a;
    }
}
