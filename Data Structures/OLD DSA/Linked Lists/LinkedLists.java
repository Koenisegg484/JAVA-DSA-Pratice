import java.util.Scanner;
public class LinkedLists {

    static Scanner sc = new Scanner(System.in);

    static class SinglyLinkedLists{
        static class nodes{
            int data;
            nodes next;
            nodes(int value){
                this.data = value;
                this.next = null;
            }
            nodes(){
                this.next = null;
            }
        }

        static nodes head = null;
        static nodes tail = null;
        static int sizeOfTheLinkedList = 0;

        static void startLinkedList(){
            System.out.print("Enter data in the node: ");
            nodes Node1 = new nodes(sc.nextInt());
            Node1.next = null;
            head = Node1;
            tail = Node1;
            head.next = tail;
            sizeOfTheLinkedList++;
            System.out.println("Linked List has been created.Total nodes are : "+sizeOfTheLinkedList);
        }
        static class InsertionInLinkedList{
            void atBeginning(){
                if (head == null){
                    startLinkedList();
                }else {
                    System.out.print("Enter data in the node: ");
                    nodes newNode = new nodes(sc.nextInt());
                    newNode.next = head;
                    head = newNode;
                    sizeOfTheLinkedList++;
                    System.out.println("The node has been inserted at the beginning of the linked list.Total nodes are : "+sizeOfTheLinkedList);
                }
            }

            void atTheEnd(){
                if (head == null){
                    startLinkedList();
                }else {
                    System.out.print("Enter data in the node: ");
                    nodes newNode = new nodes(sc.nextInt());
                    tail.next = newNode;
                    tail = newNode;
                    sizeOfTheLinkedList++;
                    System.out.println("The node has been inserted at the end of the linked list.Total nodes are : "+sizeOfTheLinkedList);
                }
            }

            void inTheMiddle(){
                if (head == null){
                    startLinkedList();
                }else {
                    nodes nodeTemp = new nodes();
                    nodeTemp = head;
                    for(int i=1; i<=(sizeOfTheLinkedList/2)-1; i++){
                        nodeTemp = nodeTemp.next;
                    }
                    System.out.print("Enter data in the node: ");
                    nodes newNode = new nodes(sc.nextInt());
                    newNode.next = nodeTemp.next;
                    nodeTemp.next = newNode;
                    sizeOfTheLinkedList++;
                    System.out.println("The node has been inserted at the middle of the linked list.Total nodes are : "+sizeOfTheLinkedList);
                }
            }

            int sizeOfLL(){
                return sizeOfTheLinkedList;
            }

            void deletingANode(){
                nodes tempNode = new nodes();
                tempNode = head;
                for(int i=1; i<= sizeOfTheLinkedList; i++){
                    System.out.println("Node "+i+" : "+tempNode.data);
                    tempNode = tempNode.next;
                }
                System.out.print("Enter the index of the node you want to delete : ");
                int target = sc.nextInt();
//                For deleting the node at the start of the linked list
                if (target == 1){
                    head = head.next;
                    sizeOfTheLinkedList--;
                    System.out.println("Node deleted successfully.The final linked list is as followed...");
                    traverseLinkedList();
                    return;
                }
                tempNode = head;
                for (int i=1; i<=target-1; i++){
                    tempNode = tempNode.next;
                }
//                For deleting the last and only  node
                if(tempNode == head){
                    head = tail = null;
                    sizeOfTheLinkedList--;
                    System.out.println("Node deleted successfully.The final linked list is as followed...");
                    traverseLinkedList();
                    return;
//                    For deleting the last node
                } else if(target == sizeOfTheLinkedList){
                    tempNode.next = null;
                    tail = tempNode;
                    sizeOfTheLinkedList--;
                    System.out.println("Node deleted successfully.The final linked list is as followed...");
                    traverseLinkedList();
                    return;
                }
//                For deleting the specified node of the linked list
                nodes tempnode2 = tempNode.next;
                tempNode.next = tempnode2.next;
                sizeOfTheLinkedList--;
                System.out.println("Node deleted successfully.The final linked list is as followed...");
                traverseLinkedList();
            }
//            for deleting the whole singly linked list
            void deleteWholeLinkedList(){
                System.out.print("Press 1 to confirm deletion of the Linked list : ");
                int a = sc.nextInt();
                if (a == 1){
                    tail = head = null;
                    sizeOfTheLinkedList = 0;
                    System.out.println("Successfully deleted the whole linked list.");
                    return;
                }
                else {
                    System.out.println("No changes were made to the linked list.");
                    traverseLinkedList();
                    return;
                }
            }
            void traverseLinkedList(){
                if (head == null){
                    System.out.println("The linked list is empty.Exitting the program.");
                    return;
                }
                nodes tempNode = new nodes();
                tempNode = head;
                for (int i=1; i<=sizeOfTheLinkedList; i++){
                    System.out.println("Data of node "+i+" "+tempNode.data+"            Address of the next node : "+tempNode.next);
                    tempNode = tempNode.next;
                }
            }

            void searchInLinkedList(){
                System.out.print("Enter the number you want to search : ");
                int target = sc.nextInt();
                nodes trvNode = new nodes();
                trvNode = head;
                int i = 1;
                int fl = 0;
                while(trvNode.next != null){
                    if(trvNode.data == target){
                        System.out.println("The data exists in the linked list at the node no. "+i);
                        fl = 1;
                    }
                    i++;
                    trvNode = trvNode.next;
                }
                if (fl == 0){
                    System.out.println("The data does not exist in the linked list.");
                }

            }

        }
    }
    public static void main(String [] args){
        int choice ;
        SinglyLinkedLists.InsertionInLinkedList LinkList = new SinglyLinkedLists.InsertionInLinkedList();
        System.out.println("This is a program to implement the linked list data structure\nPress 1 for inserting node at the beginning.\nPress 2 for inserting the node at the middle.\nPress 3 for inserting the node at the end.\nPress 4 to search an element in the linked list.\nPress 5 to delete a specific node.\nPress 6 to delete the whole linked list.\nPress 7 to exit the inserting loop and see the linked list.");
        do {
            System.out.print("Enter your choice :");
            choice = sc.nextInt();
            if (choice == 1){
                LinkList.atBeginning();
                System.out.println("Press 8 for the main menu.");
            } else if (choice == 2) {
                LinkList.inTheMiddle();
                System.out.println("Press 8 for the main menu.");
            } else if (choice == 3) {
                LinkList.atTheEnd();
                System.out.println("Press 8 for the main menu.");
            } else if(choice == 4) {
                LinkList.searchInLinkedList();
                System.out.println("Press 8 for the main menu.");
            } else if(choice == 5){
                LinkList.deletingANode();
                System.out.println("Press 8 for the main menu.");
            } else if(choice == 6){
                LinkList.deleteWholeLinkedList();
                System.out.println("Press 8 for the main menu.");
            } else if (choice == 7) {
                break;
            } else if(choice == 8){
                System.out.println("This is a program to implement the linked list data structure\nPress 1 for inserting node at the beginning.\nPress 2 for inserting the node at the middle.\nPress 3 for inserting the node at the end.\nPress 4 to search an element in the linked list.\nPress 5 to delete a specific node.\nPress 6 to delete the whole linked list.\nPress 7 to exit the inserting loop and see the linked list.");
            }
        }while(choice != 7);
        System.out.println("\n\nThe fineal Linked list is \n\n");
        LinkList.traverseLinkedList();
        System.out.println(LinkList.sizeOfLL()/2);
    }
}
