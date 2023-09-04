import java.util.*;
public class stacksUsingLL {
    static Scanner sc = new Scanner(System.in);
    static LinkedList stckll;
    public static void Stack1(){
        stckll = new LinkedList();
    }

    public static void push01(){
        if(stckll.head == null){
            System.out.print("Enter data in the node : ");
            stckll.createSinglyLinkedList(sc.nextInt());
            System.out.println("linkedlist created\nNode inserted");
//            stckll.size++;
        }else {
            System.out.print("Enter data in the node : ");
            stckll.insertAtBeginning(sc.nextInt());
            System.out.println("Node inserted");
//            stckll.size++;
        }
    }

    public static boolean isEmpty(){
        if (stckll.size == 0){
            return true;
        }else {
            return false;
        }
    }
    public static void pop01(){
        if (isEmpty()){
            System.out.println("The stack is empty.");
        }else {
            stckll.deleteNodeFromBeginning();
        }

    }

    public static void main(String[] args){
        Stack1();
        pop01();
        push01();
        pop01();
        push01();
        pop01();

    }

}
