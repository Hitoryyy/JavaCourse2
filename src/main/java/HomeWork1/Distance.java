package HomeWork1;

public class Distance implements Treadmill {

    private final int length;

    public Distance(int length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Running running) {
        if (running.run(this.length)) {
            System.out.println("пробежал на беговой дорожке " + running);
            return true;
        }
        System.out.println("Не может столько пробежать");
        return false;
    }
}
