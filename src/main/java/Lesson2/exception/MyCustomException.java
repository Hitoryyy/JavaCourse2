package Lesson2.exception;

public class MyCustomException extends Exception {

    public MyCustomException(int a) {
        super("Не умею делить на a");
    }
}
