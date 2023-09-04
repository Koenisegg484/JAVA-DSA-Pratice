import java.util.Scanner;

public class CircularDoublyLinkedLists {
    static Scanner sc = new Scanner(System.in);
    static class CDoublyLL{
        public static class nodes{
            int data;
            nodes prev;
            nodes next;
            nodes(){}
            nodes(int datavalue){
                this.data = datavalue;
            }
        }
        public static nodes head = null;
        public static nodes tail = null;
        public static int sizeOfTheLCircularLL = 0;

        static void startTheLinkedList(){
            System.out.print("Enter the data in the node : ");
            nodes newNode = new nodes(sc.nextInt());
            head = newNode;
            tail = newNode;
            sizeOfTheLCircularLL++;
            System.out.println("Linked list has been created.");
            return;
        }

        class deletionInTheList{
            static void deleteANode(){
                nodes tempNode = head;
                for (int i=1; i<=sizeOfTheLCircularLL;i++){
                    System.out.println("Node "+i+"      "+tempNode.data);
                    tempNode = tempNode.next;
                }
                System.out.print("Enter the index of the node you want to delete : ");
                int index = sc.nextInt();
                if (head == null||tail== null){
                    System.out.println("Linked list is empty.");
                    return;
                } else if (index == 1) {
                    head = head.next;
                    head.prev = null;
                } else if (index == sizeOfTheLCircularLL) {
                    tail = tail.prev;
                    tail.next = null;
//                    Added a comment
                } else {
                    tempNode = head;
                    for (int i=1; i<=index-2; i++){
                        tempNode = tempNode.next;
                    }
                    tempNode.next = tempNode.next.next;
                    tempNode.next.prev = tempNode;
                }
                sizeOfTheLCircularLL--;
                System.out.println("Node deleted successfully.");

            }
            static void deleteWholeList(){
                System.out.print("Press 1 to confirm deletion of the linked list : ");
                int i = sc.nextInt();
                if (i==1){
                    head=null;
                    tail=null;
                    System.out.println("Linked list deleted successfully.");
                    return;
                }else {
                    System.out.println("No changes were made.");
                }
            }
        }
        class traversal{
            static void frontTraversal(){
            if (head==null){
                System.out.println("The linked list is empty.");
                return;
            }else {
                nodes trvNode = head;
                for (int i=1; i<=sizeOfTheLCircularLL; i++){
                    System.out.println("The data at node "+i+" is       "+trvNode.data);
                    trvNode = trvNode.next;
                }
                return;
            }
            }
            static void backTraversal(){
                if (head==null){
                    System.out.println("The Linked list is empty.");
                    return;
                }else {
                    nodes trvNode = tail;
                    for (int i=sizeOfTheLCircularLL; i>=1; i--){
                        System.out.println("The data at node "+i+" is       "+trvNode.data);
                        trvNode = trvNode.prev;
                    }
                    return;
                }
            }
        }
        void searchInTheLinkedList(){
            System.out.print("Enter data to search : ");
            int target = sc.nextInt();
            boolean flag = false;
            nodes tempNode = head;
            for (int i=1; i<=sizeOfTheLCircularLL; i++){
                if (tempNode.data == target){
                    System.out.println("Data is at node "+i);
                    flag = true;
                }
                tempNode = tempNode.next;
            }
            if (flag == false){
                System.out.println("The data does not exist in the linked list.");
            }
        }
//        Class containing insertion methods in the Circular Doubly Linked lists
        static class InsertionInCircularDoublyLinkedLists{
            void atTheBegining(){
                if (head == null){
                    startTheLinkedList();
                }else {
                    System.out.print("Enter data in the node : ");
                    nodes newNode = new nodes(sc.nextInt());
                    newNode.prev = null;
                    newNode.next = head;
                    head.prev = newNode;
                    head = newNode;
                    sizeOfTheLCircularLL++;
                    System.out.println("Node inserted at the beginning.");
                    return;
                }
            }
            void atTheMiddle(){
                if (head == null){
                    startTheLinkedList();
                }else {
                    nodes tempNode = head;
                    System.out.print("Enter data in the node : ");
                    nodes newNode = new nodes(sc.nextInt());
                    for (int i=0; i<(sizeOfTheLCircularLL/2)-1;i++){
                        tempNode = tempNode.next;
                    }
                    newNode.prev = tempNode;
                    newNode.next = tempNode.next;
                    tempNode.next = newNode;
                    newNode.next.prev = newNode;
                    sizeOfTheLCircularLL++;
                    System.out.print("Node inserted in the middle.");
                    return;
                }
            }

            void atTheEnd(){
                if (head == null){
                    startTheLinkedList();
                }else {
                    System.out.print("Enter data in the node : ");
                    nodes newNode = new nodes(sc.nextInt());
                    nodes tempnode = tail;
                    newNode.next = null;
                    newNode.prev = tail;
                    tail.next = newNode;
                    tail = newNode;
                    sizeOfTheLCircularLL++;
                    System.out.println("Node inserted at the end.");
                }
            }
}
    }
    public static void main(String [] args){
        CDoublyLL LinkedList = new CDoublyLL();
        CDoublyLL.InsertionInCircularDoublyLinkedLists links = new CDoublyLL.InsertionInCircularDoublyLinkedLists();
        int choice;
        System.out.println("This is a program to implement the Circular Doubly linked lists.\nPress 1 to enter the node at the start of the linked list." +
                "\nPress 2 to insert the node at the middle of the linked list." +
                "\nPress 3 to insert node at the end of the linked list.\nPress 4 to search data in the linked list." +
                "\nPress 5 to delete a node from the linked list.\nPress 6 to delete the whole linked list." +
                "\nPress 7 to do forward traversing.\nPress 8 to do backwards traversing." +
                "\nPress 9 to exit the loop.");
        do{
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            if (choice == 1){
                links.atTheBegining();
                System.out.println("Press 0 for main menu.");
            } else if (choice == 2) {
                links.atTheMiddle();
                System.out.println("Press 0 for main menu.");
            } else if (choice == 3) {
                links.atTheEnd();
                System.out.println("Press 0 for main menu.");
            } else if (choice == 4) {
                LinkedList.searchInTheLinkedList();
                System.out.println("Press 0 for main menu.");
            } else if (choice == 5) {
                CDoublyLL.deletionInTheList.deleteANode();
                System.out.println("Press 0 for main menu.");
            } else if (choice == 6) {
                CDoublyLL.deletionInTheList.deleteWholeList();
                System.out.println("Press 0 for main menu.");
            } else if (choice == 7) {
                CDoublyLL.traversal.frontTraversal();
                System.out.println("Press 0 for main menu.");
            } else if (choice == 8) {
                CDoublyLL.traversal.backTraversal();
                System.out.println("Press 0 for main menu.");
            } else if (choice == 9) {
                break;
            }else {
                System.out.println("Press 1 to enter the node at the start of the linked list.\nPress 2 to insert the node at the middle of the linked list.\nPress 3 to insert node at the end of the linked list.\nPress 4 to search data in the linked list.\nPress 6 to delete a node from the linked list.\nPress 6 to delete the whole linked list.\nPress 7 to do forward traversing.\nPress 8 to do backwards traversing.\nPress 9 to exit the loop.");
            }

        }while (choice != 9);

    }
}
