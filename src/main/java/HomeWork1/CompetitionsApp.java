package HomeWork1;

public class CompetitionsApp {

    public static void main(String[] args) {

        Running[] runnings = {
                new Cat(100, 220),
                new Human(1232, 22),
                new Robot(5332, 83)
        };

        Jumping[] jumpings = {
                new Cat(123, 13),
                new Human(441, 66),
                new Robot(343, 77),
        };

        Distance[] distance = {
                new Distance(2122),
                new Distance(900),
                new Distance(1110)
        };

        JumpDistance[] jumpDistances = {
                new JumpDistance(21),
                new JumpDistance(33),
                new JumpDistance(18)
        };

        for (Running r : runnings) {
            for (Distance d : distance) {
                if (!d.overcome(r)) break;
            }
        }

        System.out.println();

        for (Jumping j : jumpings) {
            for (JumpDistance jd : jumpDistances) {
                if (!jd.overcome(j)) break;
            }
        }

    }
}