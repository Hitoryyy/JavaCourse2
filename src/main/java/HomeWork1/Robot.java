package HomeWork1;

public class Robot implements Running, Jumping {

    private String name = "Робот";
    private int Run;
    private int Jump;

    public Robot(String name, int Run, int Jump) {
        this.name = name;
        this.Run = Run;
        this.Jump = Jump;
    }

    public Robot(int Run, int Jump) {
        this.Run = Run;
        this.Jump = Jump;
    }

    @Override
    public boolean jump(int height) {
        return this.Jump >= height;
    }

    @Override
    public boolean run(int length) {
        return this.Run >= length;
    }
}
