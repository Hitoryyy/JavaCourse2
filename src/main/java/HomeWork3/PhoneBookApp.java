package HomeWork3;

public class PhoneBookApp {
    public static void main(String[] args) {

        phoneBook();
    }

    private static void phoneBook() {
        Book directory = new Book();

        directory.add("Ivanov", "3478174");
        directory.add("Petrov", "762131232");
        directory.add("Korolev", "937491735");
        directory.add("<Bobanova>", "21411415");
        directory.add("Zueva", "2185815");


        System.out.println(directory.get("Korolev"));
        System.out.println(directory.get("Zueva"));

    }

}
