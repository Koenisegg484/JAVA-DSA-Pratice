import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Implementation of Binary Heap Tree .");

        binaryHeap bnh = new binaryHeap();

        System.out.println("1. Peek\n2. Insert a node\n3. Extract a node\n4. Level Order Traversal\n5. Delete whole tree\n");
        
        int ch = 0;

        do{
            System.out.print("Enter Your coice : ");
            ch = sc.nextInt();

            switch(ch){
                case 1:
                bnh.peek();
                break;

                case 2:
                bnh.insertNode(bnh.heapType);
                break;

                case 3:
                bnh.extractNode(bnh.heapType);
                break;

                case 4:
                bnh.levelOrder();
                System.out.println();
                break;

                case 5:
                bnh.deleteTree();
                break;

                case 11:
                System.out.println("Exitting...");

                default:
                System.out.println("Enter the right choice.");
            }
        }while (ch != 11);
        sc.close();
    }
}
