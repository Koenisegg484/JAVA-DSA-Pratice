import java.util.*;

public class AllJavaPrograms_of_Arrays {
    static Scanner sc = new Scanner(System.in);


    // Array Traversal
//     public void arrayTraversal(int array []){
//         try {
//             for (int i=0; i< array.length; i++){
//                 System.out.print(array[i] + " ");
//             }
//         }catch (Exception e){
//             System.out.println("Array does not exist! ");
//         }
//     }


    // Array Search Element
    // public void searchInArray(int srch, int array[]){
    //     for(int i=0; i<array.length; i++){
    //         if(array[i] == srch){
    //             System.out.print("The element is found at index: "+i);
    //             return ;
    //         }
    //     }
    //     System.out.print("The value was not found");
    // }


    // Deletion of element in Arrays
//    public void deleteValue(int indexToDelete, int array[]){
//        try{
//            array[indexToDelete] = Integer.MIN_VALUE;
//            System.out.print("Successfully Deleted.");
//        }
//        catch(ArrayIndexOutOfBoundsException e){
//            System.out.print("The index is not present in the array.");
//        }
//    }

//    Two Dimensional Arrays
//    public void twoDimensionalArrays(int r, int c){
//        int [] [] int2dArray = new int [r] [c];
//        System.out.println("Enter elements in the array: ");
//        for(int i=0; i<r; i++){
//            for(int j=0; j<c; j++){
//                int2dArray[i][j] = sc.nextInt();
//            }
//        }
//        System.out.println("Printing the Array: ");
//        System.out.print(Arrays.deepToString(int2dArray));
//    }

    int int2dArrays [] [] = {{1,2},{3,4}};
//    Traversing two dimensional arrays
//    public void twoDimensionalArray(int r, int c, int value){
//        try{
//            if(int2dArrays[r][c] == Integer.MIN_VALUE){
//                int2dArrays[r][c] = value;
//                System.out.println("Successfully Inserted");
//            }
//            else {
//                System.out.println("This cell is already occupied.");
//            }
//        }catch(ArrayIndexOutOfBoundsException e){
//            System.out.println("Invalid Index of 2DArray");
//        }
//    }


//  Accessing elements of the 2d arrays
//    public void access2Dblock(int r, int c){
//        try{
//            System.out.println("Cell value is : "+int2dArrays[r][c]);
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Invalid index for 2d array.");
//        }
//    }


//    Searching the elemnt in the array
    public void searchinTheArray(int srchelemt){
        for(int r = 0; r<int2dArrays.length; r++){
            for (int c=0; c<int2dArrays[r].length; c++){
                if(int2dArrays[r][c] == srchelemt) {
                    System.out.println("The element was found at the row : " + r + "and column : " + c);
                    return;
                }
            }
        }
        System.out.println("The value does not exist in the array");
    }
    public static void main(String[] args){
        int array[] = {11,22,33,44,55};
        AllJavaPrograms_of_Arrays at = new AllJavaPrograms_of_Arrays();
//        at.deleteValue(2, array);
//        at.arrayTraversal(array);
//        at.twoDimensionalArrays(2,2);
//        at.twoDimensionalArray(1,1,22);
//        at.access2Dblock(1,1);
        at.searchinTheArray(3);
    }    
}
