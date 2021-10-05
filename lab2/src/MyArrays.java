import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

public class MyArrays {

    public void arraySizeCheck(String[][] arr) throws MyArraySizeException {
        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException("Array size is incorrect");
        } else System.out.println("Array size is correct");
    }

    public int getArrayElementsSum(String[][] arr) throws MyArrayDataException {
        int sum = 0;
            for (int i = 0; i < arr[0].length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    try {
                        sum += Integer.parseInt(arr[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Array data is incorrect at row " + (i + 1) + " column " + (j + 1), e);
                    }
                }
            }
        return sum;
    }
}
