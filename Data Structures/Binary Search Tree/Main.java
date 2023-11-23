import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("This is a program to implement Binary Search tree using linked list.");
        System.out.println("-------------MENU-------------");
        System.out.println("\n1 Insert a node\n2 Pre order traversal\n3 Post Order traversal\n4 In Order traversal\n5 Level Order traversal\n6 Search in tree\n7 Delete a node\n\n");
        int ch = 0;

        binarysearchtree bst = new binarysearchtree();

        do{
            System.out.print("Enter your choice : ");
            ch = sc.nextInt();


            switch(ch){
                case 1:
                    bst.insertion();
                    break;

                case 2:
                    bst.preOrdertraversal(bst.root);
                    System.out.println();
                    break;
                case 3:
                    bst.postOrdertraversal(bst.root);
                    System.out.println();
                    break;
                case 4:
                    bst.inOrdertraversal(bst.root);
                    System.out.println();
                    break;
                case 5:
                    bst.levelOrdertraversal();
                    System.out.println();
                    break;
                case 6:
                    bst.searchLot();
                    break;
                case 7:
                    bst.deletion();
                    break;
                case 8:
                    bst.deleteTree();
                    break;
                case 11:
                    System.out.println("Exitting...");
                    return;
                default:
                    System.out.println("Enter the right choice from the menu.");
            }
        }while (ch != 11);
        sc.close();
    }
}