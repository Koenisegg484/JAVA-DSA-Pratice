import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is a program to implement tree in java: \n\n1 Insert node\n2 Pre Order Traversal\n3 Post Order Traversal\n4 In Order Traversal\n5 Level Order Traversal\n6 Search using Level order traversal \n7 Delete a node");
        binarytree bintree = new binarytree();
        
        int ch = 0;
        do{
            System.out.print("Enter your choice : ");
            ch = sc.nextInt();

            switch(ch){
                case 1:
                bintree.insertNode();
                break;
    
                case 2:
                bintree.preOrderTraversal(bintree.root);
                System.out.println();
                break;
    
                case 3: 
                bintree.postOrderTaversal(bintree.root);
                System.out.println();
                break;
    
                case 4:
                bintree.inOrderTaversal(bintree.root);
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
                System.out.print("Enter data of node to delete it : ");
                String value = sc.next();
                bintree.deleteNode(value);
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