package HomeWork1;

public class Cat implements Running, Jumping {

    private String name = "Кот";
    private int Run;
    private int Jump;

    public Cat(String name, int Run, int Jump) {
        this.name = name;
        this.Run = Run;
        this.Jump = Jump;
    }

    public Cat(int Run, int Jump) {
        this.Run = Run;
        this.Jump = Jump;
    }

    @Override
    public boolean run(int length) {
        return this.Run >= length;
    }

    @Override
    public boolean jump(int height) {
        return this.Jump >= height;
    }
}
