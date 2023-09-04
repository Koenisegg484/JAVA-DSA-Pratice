import java.util.*;
public class pr001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating and printing the array: ");
        int []Arr = new int[5];
        for (int i=0; i<5; i++){
            System.out.print("Enter a value: ");
            Arr[i] = sc.nextInt();
        }
        System.out.println("Printing the array: ");
        System.out.println(Arrays.toString(Arr));

    }

}
