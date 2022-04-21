package Lesson1.interfaces;

public interface HardWorkable extends Workable {

    void workHard();

    default void workVeryHard(){
        workHard();
    }

}
