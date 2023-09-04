import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("This is an implementation of binary tree using arrays: ");
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of the array for tree : ");
        int size = sc.nextInt();
        binarytree bintree = new binarytree(size);
        
        System.out.println("1 Insert node\n2 Pre Order Traversal\n3 Post Order Traversal\n4 In Order Traversal\n5 Level Order Traversal\n6 Search using Level order traversal \n7 Delete a node");
        int ch = 0;
        do{
            System.out.print("Enter your choice : ");
            ch = sc.nextInt();

            switch(ch){
                case 1:
                bintree.insertNode();
                break;
    
                case 2:
                bintree.preOrderTraversal(1);
                System.out.println();
                break;
    
                case 3: 
                bintree.postOrderTaversal(1);
                System.out.println();
                break;
    
                case 4:
                bintree.inOrderTaversal(1);
                System.out.println();
                break;
    
                case 5:
                bintree.levelOrderTrversal();
                System.out.println();
                break;
    
                case 6:
                bintree.searchLOT();
                break;

                case 7:
                bintree.deleteNode();
                break;

                case 8:
                bintree.deleteTree();

                case 11:
                System.out.println("Exitting....");
                break;

                default:
                System.out.println("Enter the right choice.");
                break;
    
            }

        }while(ch != 11);

        sc.close();


    }
    
}
