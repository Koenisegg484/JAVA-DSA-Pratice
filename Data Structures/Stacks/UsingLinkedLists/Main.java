import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Stack nstack = new Stack();
        System.out.println("This is STACK using linked lists...\n1 for push in stack.\n2 for pop in stack.\n3 for peek in stack.\n4 for delete the stack.");
        int choice = 0;
        while(choice != 6){
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    nstack.push();
                    break;
                case 2:
                    nstack.pop();
                    break;
                case 3:
                    nstack.peek();
                    break;
                case 4:
                    nstack.delete();
                    break;
                case 5:
                    System.out.println("This is STACK using linked lists...\n1 for push in stack.\n2 for pop in stack.\n3 for peek in stack.\n4 for delete the stack.");
                    break;
                case 6:
                    break;
                default:
                    System.out.println("You entered wrong input.");
                    System.out.println("This is STACK using linked lists...\n1 for push in stack.\n2 for pop in stack.\n3 for peek in stack.\n4 for delete the stack.");


            }
        }

    }    
}
