package HomeWork2;

public class CreateArraySize {

    public static String[][] size(String[][] array) throws MyArraySizeException {
        int sizeArr = 4;

        if (array.length != sizeArr) {
            throw new MyArraySizeException("Размер массива должен быть 4х4!");
        }
            return array;
    }
}
