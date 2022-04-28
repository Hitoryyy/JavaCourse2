package Lesson2.poly;

public interface Swimmable {

    default void swim(){
        System.out.println("Плывёт как-то по умолчанию");
    }
}
