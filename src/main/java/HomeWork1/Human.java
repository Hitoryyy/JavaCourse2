package HomeWork1;

public class Human implements Running, Jumping {

    private final String name = "Человек";
    private int Run;
    private int Jump;

    public Human(int Run, int Jump) {
        this.Run = Run;
        this.Jump = Jump;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean jump(int height) {
        return this.Jump >= height;
    }

    @Override
    public boolean run(int length) {
        return this.Jump >= length;
    }
}
