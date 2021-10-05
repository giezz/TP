import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

public class Main {

    public static void main(String[] args) {

        MyArrays MyArrays = new MyArrays();

        String[][] correctArray = new String[][] {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        String[][] incorrectArray = new String[][] {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "c", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "b"}
        };

        try {
            System.out.println(MyArrays.getArrayElementsSum(incorrectArray));
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            MyArrays.arraySizeCheck(correctArray);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }
}
