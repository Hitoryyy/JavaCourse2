package HomeWork1;

public class JumpDistance implements Wall {

    private final int height;

    public JumpDistance(int height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Jumping jumping) {
        if (jumping.jump(this.height)) {
            System.out.println("Перепрыгнул через стену");
            return true;
        }
        System.out.println("Не препрыгнул через стену");
        return false;
    }
}
