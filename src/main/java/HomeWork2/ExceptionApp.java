package HomeWork2;

public class ExceptionApp {
    public static void main(String[] args) {

        String[][] arr1 = new String[][]{
                {"15", "866", "454", "54"},
                {"456", "iuou", "10", "12"},
                {"454", "7", "7", "45"},
                {"46", "5", "66", "6"}
        };

        String[][] arr2 = new String[][] {
                {"15", "866", "454", "54"},
                {"456", "78", "10", "12"},
                {"454", "7", "7", "45", "3242"},
                {"46", "5", "66", "6"}
        };

        String[][] arr3 = new String[][] {
                {"15", "866", "454", "54"},
                {"456", "78", "10", "12"},
                {"454", "7", "7", "45"},
                {"46", "5", "66", "6"}
        };

        try {
            CreateArraySize.size(arr1);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            SummArray.summArray(arr2);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            SummArray.summArray(arr3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
