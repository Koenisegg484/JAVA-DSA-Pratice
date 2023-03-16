import java.util.*;
public class CircularLinkedList {

    static Scanner sc = new Scanner(System.in);

    static class circularLinkedList{

        static class nodes {
            int data;
            nodes next;

            nodes(){
                this.next = null;
            }
            nodes (int datavalue){
                this.data = datavalue;
            }
        }

        public static nodes head = null;
//        public static nodes tail = null;
        public static int sizeOfTheCircularLinkList = 0;

        static void createCircularLinkList(){
            System.out.print("Enter data in the node : ");
            int dataValue = sc.nextInt();
            nodes newNode = new nodes();
            newNode.data = dataValue;
            newNode.next = newNode;
            head = newNode;
//            tail = newNode;
            sizeOfTheCircularLinkList++;
            System.out.println("Linked list created successfully.");
        }

//        Method  for searching a particular node in the linked list
        void searchInNode(){
            System.out.print("Enter data to serch in the linked list : ");
            int target = sc.nextInt();
            nodes tempNode = new nodes();
            tempNode = head;
            boolean flag = false;
            for (int i=1; i<=sizeOfTheCircularLinkList; i++){
                if (target == tempNode.data){
                    System.out.println("The data exists at node "+i);
                    flag = true;
                }
                tempNode = tempNode.next;
            }
            if (flag == false){
                System.out.println("The data does not exist in the linked list.");
            }
            return;
        }

//        Method containing methods of deletion in a circular linked list
       void deleteNode(){
            nodes tempNode = new nodes();
            tempNode = head;
            System.out.println("Choose the index of the node to delete it : ");
            for (int i=1; i<=sizeOfTheCircularLinkList; i++){
                System.out.println("Node "+i+"  "+tempNode.data);
                tempNode = tempNode.next;
            }
            System.out.print("Enter node index : ");
            int target = sc.nextInt();
            if (target == 1){
                head = head.next;
                sizeOfTheCircularLinkList--;
                System.out.println("Node deleted successfully.");
                return;
            } else if (target >= sizeOfTheCircularLinkList) {
                nodes delNode = new nodes();
                delNode = head;
                for (int i=1; i<sizeOfTheCircularLinkList; i++){
                    delNode = delNode.next;
                }
                delNode.next = head;
                sizeOfTheCircularLinkList--;
                System.out.println("Node deleted successfully.");
                return;
            }
            nodes delNode2 = new nodes();
            delNode2 = head;
            for (int i=1; i<=target-2; i++){
                delNode2 = delNode2.next;
            }
            nodes temp = delNode2.next;
            delNode2.next = temp.next;
            sizeOfTheCircularLinkList--;
            System.out.println("Node deleted successfully.");
            return;
        }

//        Method to delete the whole linked list
        void deleteWholeLinkedList(){
            System.out.print("Press 1 to confirm linked list deletion : ");
            int c = sc.nextInt();
            if (c == 1){
                head = null;
                sizeOfTheCircularLinkList = 0;
                System.out.println("The linked list has been deleted.");
                return;
            }else {
                System.out.println("No changes were made to the linked list.");
                return;
            }
        }
//        Class containing methods of insertion in a circular linked list.
        static class InsertionInCLinkList{

            void atTheBeginning(){
                if (head == null){
                    createCircularLinkList();
                }else {
                    System.out.print("Enter data in the node : ");
                    nodes newNode = new nodes(sc.nextInt());
                    newNode.next = head;
                    head = newNode;
//                    tail = newNode;
                    sizeOfTheCircularLinkList++;
                    System.out.println("The node has been inserted at the beginning successfully.");
                }
            }

            void atTheEnd(){
                if(head == null){
                    createCircularLinkList();
                }else {
                    nodes newNode = new nodes();
                    newNode = head;
                    for (int i=1; i<= sizeOfTheCircularLinkList; i++){
                        newNode = newNode.next;
                    }
                    System.out.print("Enter data in the node : ");
                    nodes newNode2 = new nodes(sc.nextInt());
                    newNode2.next = newNode.next;
                    newNode.next = newNode2;
                    sizeOfTheCircularLinkList++;
                    System.out.println("Linked list inserted successfully at the end.");
                }
            }

            void atTheMiddle(){
                if(head == null){
                    createCircularLinkList();
                }else {
                    nodes tempNode = new nodes();
                    tempNode = head;
                    for (int i=1; i<=(sizeOfTheCircularLinkList/2)-1; i++){
                        tempNode = tempNode.next;
                    }
                    System.out.print("Enter data in the node : ");
                    nodes newNode = new nodes(sc.nextInt());
                    newNode.next = tempNode.next;
                    tempNode.next = newNode;
                    sizeOfTheCircularLinkList++;
                    System.out.println("Linked list inserted succesfully at the middle.");
                }
    }

            void traverseClinkedList(){
                    if (head == null){
                        System.out.println("The linke dlist does not exist.");
                    }else {
                        nodes trvNode = new nodes();
                        trvNode = head;
                        int i = 1;
                        do {
                            System.out.println("The data at node "+i+" : "+trvNode.data+"           Address of the next node is : "+trvNode.next);
                            i++;
                            trvNode = trvNode.next;
                        }while (i <= sizeOfTheCircularLinkList);
                    }
                }

        }

    }
    public static void main(String[] args) {
        circularLinkedList.InsertionInCLinkList csll = new circularLinkedList.InsertionInCLinkList();
        circularLinkedList linklist = new circularLinkedList();
        System.out.println("This is a program to implement the circular linked list.\nPress 1 to enter the node at the start of the linked list.\nPress 2 to insert the node at the middle of the linked list.\nPress 3 to insert node at the end of the linked list.\nPress 4 to delete a node from the linked list.\nPress 5 to search data in the linked list.\nPress 6 to delete the whole linked list.\nPress 7 to exit the loop.");
        int choice;
        do {
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();
            if (choice == 1){
                csll.atTheBeginning();
            }else if (choice == 2){
                csll.atTheMiddle();
            }else if (choice == 3) {
                csll.atTheEnd();
            }else if(choice == 4){
                linklist.deleteNode();
            }else if(choice == 5){
                linklist.searchInNode();
            }else if(choice == 6){
                linklist.deleteWholeLinkedList();
            }else if (choice == 7) {
                break;
            }else if(choice == 9){
                csll.traverseClinkedList();
            }else {
                System.out.println("This is a program to implement the circular linked list.\nPress 1 to enter the node at the start of the linked list.\nPress 2 to insert the node at the middle of the linked list.\nPress 3 to insert node at the end of the linked list.\nPress 4 to delete a node from the linked list.\nPress 5 to search data in the linked list.\nPress 6 to delete the whole linked list.\nPress 7 to exit the loop.");
            }
            System.out.println("Press 8 for the main menu.");
        }while (choice != 7);


        csll.traverseClinkedList();
        System.out.println("The size of the circular linked list is "+linklist.sizeOfTheCircularLinkList);
//        System.out.println(linklist.tail.data);
//        System.out.println(linklist.head.data);
        return;

    }
}
