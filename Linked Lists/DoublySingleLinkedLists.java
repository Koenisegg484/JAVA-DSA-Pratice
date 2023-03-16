import java.util.*;
public class DoublySingleLinkedLists {

    static Scanner sc = new Scanner(System.in);
    static class nodes {
        int data;
        nodes prev;
        nodes next;

        nodes(int datavalue){
            this.data = datavalue;
        }
        nodes(){}
    }

    static public nodes head = null;
    static public nodes tail = null;
    static public int sizeOfTheLinkedList = 0;
    static class DoublyLinkedList{
        static void createLinkedList(){
            System.out.print("Enter data in the node : ");
            nodes newNode = new nodes(sc.nextInt());
            head = newNode;
            tail = newNode;
            sizeOfTheLinkedList++;
            System.out.println("Doubly linked list has been created successfully.");
            return;
        }

//        class for inserting nodes in the linked list
        class InsertionInDoublyLinkedLists{
//            Method for inserting node at the beginning of the linked list
            static void atTheBeginning(){
                if (head == null ){
                    createLinkedList();
                }else {
                    System.out.print("Enter data in the node : ");
                    nodes newNode = new nodes(sc.nextInt());
                    newNode.next = head.next;
                    head.next.prev = newNode;
                    head = newNode;
                    sizeOfTheLinkedList++;
                    System.out.println("Node inserted at the beginning in linked list successfully");
                }
            }
            static void atTheMiddle(){
                if (head == null){
                    createLinkedList();
                }else {
                    System.out.println("Enter data in the node : ");
                    nodes newNode = new nodes(sc.nextInt());
                    nodes tempNode = new nodes();
                    nodes tempNode2 = new nodes();
                    tempNode = head;
                    tempNode2 = head.next;
                    for (int i=0; i<(sizeOfTheLinkedList/2)-1; i++){
                        tempNode = tempNode.next;
                        tempNode2 = tempNode2.next;
                    }
                    newNode.next = tempNode.next;
                    newNode.prev = tempNode;
                    tempNode2.prev = newNode;
                    System.out.println("Node inserted successfully in the node.");
                    return;
                }
            }

}

    }

//    Class for traversing the linked list
    static class LLTraversal{
        static void frontTraversal(){
            nodes tempNode = new nodes();
            tempNode = head;
            int i = 1;
            do {
                System.out.println("The data at node "+ i+" is       "+tempNode.data);
                tempNode = tempNode.next;
            }while (i<=sizeOfTheLinkedList);
        }
}

    public static void main(String[] args) {
        DoublyLinkedList linklist = new DoublyLinkedList();
        DoublySingleLinkedLists links = new DoublySingleLinkedLists();
        int choice;
        do {
            System.out.print("Enter you choice : ");
            choice = sc.nextInt();
            if (choice == 1){
                DoublyLinkedList.InsertionInDoublyLinkedLists.atTheBeginning();
            } else if (choice == 2) {
                DoublyLinkedList.InsertionInDoublyLinkedLists.atTheMiddle();
            } else if (choice == 9) {
                LLTraversal.frontTraversal();
            } else if (choice == 7) {
                break;
            }
        }while (choice != 7);
//        System.out.println(links.head.data);

    }
}
