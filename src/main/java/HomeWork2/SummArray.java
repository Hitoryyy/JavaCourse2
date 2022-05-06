package HomeWork2;

public class SummArray {
    public static int summArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int size = 4;
        int summ = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != size) {
                throw new MyArraySizeException("Размер массива должен быть 4х4!");
            }
            for (int j = 0; j < array[i].length; j++){
                try {
                    summ += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("в строке [%d] и в столбце [%d] не числа", j + 1, i + 1));
                }
            }
        }
        System.out.println("Сумма равна: " + summ);
        return summ;
    }
}
