import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the queue : ");
        int size = sc.nextInt();
        Circularqueue nq = new Circularqueue(size);
        int ch = 0;
        System.out.print("This is a queue program.\n1 for enqueue\n2 for dequeue\n3 for peek\n4 for delete queue\n");
        do {
            System.out.print("Enter choice : ");
            ch = sc.nextInt();
            switch(ch){
                case 1:
                    nq.enqueue();
                    break;
                case 2:
                    nq.dequeue();
                    break;
                case 3:
                    nq.peek();
                    break;
                case 4:
                    nq.delete();
                    break;
                case 5:
                    System.out.print("This is a queue program.\n1 for enqueue\n2 for dequeue\n3 for peek\n4 for delete queue\n");
                    break;
                case 6:
                    break;
                default:
                    System.out.println("You entered wrong choice.");
                    break;
            }
            
        } while (ch != 6);
        sc.close();
    }
}