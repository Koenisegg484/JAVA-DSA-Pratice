import javax.lang.model.type.ArrayType;
import java.lang.reflect.Array;
import java.util.Arrays;

public class pr002 {

    public static class arr_method{
        int arr[] = null;
        public arr_method(int sizeofArray){
            arr = new int[sizeofArray];
            for (int i=0; i<arr.length;i++){
                arr[i] = Integer.MIN_VALUE;
            }
        }
        public void insert(int location, int valueToBeInserted){
            try {
                if (arr[location] == Integer.MIN_VALUE){
                    arr[location] = valueToBeInserted;
                    System.out.println("Successfully Inserted.");
                }
                else {
                    System.out.println("The cell is already occupied.");
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Invalid index to access array. \n"+e);
            }

        }
    }

    public static void main(String[] args) {
        arr_method am = new arr_method(5);
        am.insert(0,12);
        am.insert(1,22);
        am.insert(2,33);
        am.insert(3,44);
        am.insert(4, 55);
        System.out.println(Arrays.toString(am.arr));
        am.insert(33, 4434);
        System.out.println(Arrays.toString(am.arr));

    }
}
