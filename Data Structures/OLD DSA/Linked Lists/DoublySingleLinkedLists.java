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
                    return;
                }else {
                    System.out.print("Enter data in the node : ");
                    nodes newNode = new nodes(sc.nextInt());
                    newNode.next = head;
                    newNode.prev = null;
                    head.prev = newNode;
                    head = newNode;
                    sizeOfTheLinkedList++;
                    System.out.println("Node inserted at the beginning in linked list successfully");
                    return;
                }
            }
            static void atTheMiddle(){
                if (head == null){
                    createLinkedList();
                }else {
                    System.out.print("Enter data in the node : ");
                    nodes newNode = new nodes(sc.nextInt());
                    nodes tempNode = head;
                    for (int i=0; i<(sizeOfTheLinkedList/2)-1; i++){
                        tempNode = tempNode.next;
                    }
                    newNode.prev = tempNode;
                    newNode.next = tempNode.next;
                    tempNode.next = newNode;
                    newNode.next.prev = newNode;
                    sizeOfTheLinkedList++;
                    System.out.println("Node inserted successfully in the node.");
                    return;
                }
            }

            static void atTheEnd(){
                if (head == null){
                    createLinkedList();
                    return;
                }else {
                    System.out.print("Enter data in the node : ");
                    nodes newNode = new nodes(sc.nextInt());
                    newNode.next = null;
                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = newNode;
                    sizeOfTheLinkedList++;
                    System.out.println("Node inserted at the end of the doubly linked list.");
                }
            }
}
        void deleteListEntirely(){
            System.out.print("Enter 1 to confirm deletion of the node : ");
            int c = sc.nextInt();
            if (c==1){
                head = null;
                tail = null;
                sizeOfTheLinkedList=0;
                System.out.println("The Doubly linked list has been deleted.");
                return;
            }else {
                System.out.println("No changes were made.");
            }
        }
        void  deletionInDoublyLinkedLists(){
            if (head == null){
                System.out.println("No nodes to delete.");
                return;
            } else if (sizeOfTheLinkedList == 1) {
                head = null;
                tail = null;
                sizeOfTheLinkedList--;
                System.out.println("The linked list has been deleted.");
                return;
            } else {
                nodes tempNode = head;
                for(int j=1; j<=sizeOfTheLinkedList; j++){
                    System.out.println("Node "+ j+"       "+tempNode.data);
                    tempNode = tempNode.next;
                }
                System.out.print("Enter the index of the node to delete it : ");
                int target = sc.nextInt();
                if (target == 1){
                    head = head.next;
                    head.prev = null;
                    sizeOfTheLinkedList--;
                    System.out.println("First node deleted.");
                    return;
                } else if (target == sizeOfTheLinkedList) {
                    tail = tail.prev;
                    tail.next = null;
                    sizeOfTheLinkedList--;
                    System.out.println("Last node deleted.");
                    return;
                }
                tempNode = head;
                for (int i=1; i<=target-2; i++){
                    tempNode = tempNode.next;
                }
                tempNode.next = tempNode.next.next;
                tempNode.next.prev = tempNode;
                sizeOfTheLinkedList--;
                System.out.println("Node deleted successfully.");
                return;
            }
            }

    }

//    Class for traversing the linked list
    static class LLTraversal{
        static void frontTraversal(){
            if (head == null){
                System.out.println("The linked list does not exist.");
                return;
            }else {
                nodes tempNode = new nodes();
                tempNode = head;
                for(int j=1; j<=sizeOfTheLinkedList; j++){
                    System.out.println("The data at node "+ j+" is       "+tempNode.data);
                    tempNode = tempNode.next;
                }
            }
        }
        static void reverseTraversal(){
            if(tail == null){
                System.out.println("The linked list does not exist.");
                return;
            }else {
                nodes tempNode = tail;
                for(int i=sizeOfTheLinkedList; i>=1; i--){
                    System.out.println("The data at node "+ i+" is       "+tempNode.data);
                    tempNode = tempNode.prev;
                }
                return;
            }
        }
}

//static
void searchingTheNode(){
    System.out.print("Enter data to search : ");
    int target = sc.nextInt();
    nodes tempNode = head;
    boolean flag = false;
    for (int i=1; i<=sizeOfTheLinkedList; i++){
        if (tempNode.data == target){
            System.out.println("The data is in the "+i+"th node.");
            flag = true;
        }
        tempNode = tempNode.next;
    }
    if (flag == false){
        System.out.println("The data does not exist in the linked list.");
        return;
    }
}

    public static void main(String[] args) {
        DoublyLinkedList linklist = new DoublyLinkedList();
        DoublySingleLinkedLists links = new DoublySingleLinkedLists();
        int choice;
        System.out.println("This is a program to implement the Doubly linked lists.\nPress 1 to enter the node at the start of the linked list.\nPress 2 to insert the node at the middle of the linked list.\nPress 3 to insert node at the end of the linked list.\nPress 4 to search data in the linked list.\nPress 6 to delete a node from the linked list.\nPress 6 to delete the whole linked list.\nPress 7 to do forward traversing.\nPress 8 to do backwards traversing.\nPress 9 to exit the loop.");

        do {
            System.out.print("Enter you choice : ");
            choice = sc.nextInt();
            if (choice == 1){
                DoublyLinkedList.InsertionInDoublyLinkedLists.atTheBeginning();
                System.out.println("Press 0 for the main menu.");
            } else if (choice == 2) {
                DoublyLinkedList.InsertionInDoublyLinkedLists.atTheMiddle();
                System.out.println("Press 0 for the main menu.");
            } else if (choice == 3) {
                DoublyLinkedList.InsertionInDoublyLinkedLists.atTheEnd();
                System.out.println("Press 0 for the main menu.");
            } else if (choice == 4) {
                links.searchingTheNode();
                System.out.println("Press 0 for the main menu.");
            } else if (choice == 5) {
                linklist.deletionInDoublyLinkedLists();
                System.out.println("Press 0 for the main menu.");
            } else if (choice == 6) {
                linklist.deleteListEntirely();
                System.out.println("Press 0 for the main menu.");
            } else if (choice == 8) {
                LLTraversal.reverseTraversal();
                System.out.println("Press 0 for the main menu.");
            } else if (choice == 7) {
                LLTraversal.frontTraversal();
                System.out.println("Press 0 for the main menu.");
            } else if (choice == 9) {
                break;
            }else {
                System.out.println("Press 1 to enter the node at the start of the linked list.\nPress 2 to insert the node at the middle of the linked list.\nPress 3 to insert node at the end of the linked list.\nPress 4 to search data in the linked list.\nPress 6 to delete a node from the linked list.\nPress 6 to delete the whole linked list.\nPress 7 to do forward traversing.\nPress 8 to do backwards traversing.\nPress 9 to exit the loop.");
            }
        }while (choice != 9);
//        System.out.println(links.head.data);

    }
}
