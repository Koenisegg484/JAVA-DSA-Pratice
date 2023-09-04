import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.println("This is an implementation of AVL trees : ");
        Scanner sc = new Scanner(System.in);
        System.out.println("1 Insert node\n2 Level Order Traversal\n3 Delete a node\n4 Delete whole tree\n5 Search using Level order traversal ");
        AVLtree avLtree = new AVLtree();
        
        int ch = 0;
        do{
            System.out.print("Enter your choice : ");
            ch = sc.nextInt();

            switch(ch){
                case 1:
                avLtree.insertion();
                break;

                case 2:
                avLtree.levelOrdertraversal();
                System.out.println();
                break;

                case 3:
                avLtree.deletion();
                break;

                case 4:
                avLtree.deleteWhole();
                break;

                case 5:
                System.out.print("Enter data to search : ");
                int srch = sc.nextInt();
                avLtree.searchLOT(avLtree.root, srch);
                break;

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