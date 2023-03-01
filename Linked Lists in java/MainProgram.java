import java.util.*;
public class MainProgram{
    static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){
        SinglyLinkedLists sll = new SinglyLinkedLists();
        System.out.print("Enter a number in the head of linked list: ");
        int ndv = sc.nextInt();
        // System.out.println(sll.createSinglyLinkedList(ndv));
        sll.createSinglyLinkedList(ndv);

        System.out.println(sll.head.value);
    }
}