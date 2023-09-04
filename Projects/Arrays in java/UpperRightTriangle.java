import java.util.Scanner;

public class UpperRightTriangle{
    public static void main(String [] args){

        // UpperRightTriangle up = new UpperRightTriangle();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the matrix : ");
        int n = sc.nextInt();
        // for(int i=0; i<n; i++){
        //     System.out.print(i+ ". ");
        //     for (int j=0; j<n; j++){
        //         if (j>=i){
        //             System.out.print("*");
        //         }
        //         else{
        //             System.out.print(" ");
        //         }
        //         // System.out.print("*");
        //     }
        //     System.out.println();
        // }

        int matrix[][] = new int [n][n];
        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Printing the matrix: ");
        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        // System.out.println("Transpose of the above matrix");
        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                // 00 01 02 03 04
                // 10 11 12 13 14
                // 20 21 22 23 24
                // 30 31 32 33 34
                // 40 41 42 43 44
                if (j>=i){
                    // up.swaps(matrix[i][j],matrix[j][i]);
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        System.out.println("Printing the transposed matrix: ");
        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        for(int i=0; i<n; i++){
            for (int j=0; j<n/2; j++){
                int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n-j-1];
                    matrix[i][n-j-1] = temp;
            }
        }
        System.out.println("Printing the rotated matrix :");
        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        sc.close();
        // up.close();
    }
}