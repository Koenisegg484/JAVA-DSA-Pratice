import java.util.Scanner;

public class CircularDoublyLinkedList {

    static Scanner sc = new Scanner(System.in);
    public node head = null;
    public node tail = null;
    int size = 0;

    void createCDLL(){
        System.out.print("Enter data : ");
        int value = sc.nextInt();
        node nn = new node(value);
        head = nn;
        tail = nn;
        head.prev = tail;
        tail.next = head;
        size ++;
    }

    void reversetraversal(){
        if(tail == null){
            System.out.println("The circular doubly linked list is empty.");
        }else{
            node trvn = tail;
            int i = 1;
            while(i<=size){
                System.out.println(i+") "+trvn.data);
                trvn = trvn.prev;
                i++;
            }
        }
    }

    void traversal(){
        if(head == null){
            System.out.println("The Circular doubly linked list is empty.");
        }else{
            node nn = head;
            int i = 1;
            while(i <= size){
                System.out.println(i+") "+nn.data);
                nn = nn.next;
                i++;
            }
        }
    }

    class InsertioninCDLL{


        void atBeginning(){
            if(head == null){
                createCDLL();
            }else{
                System.out.print("Enter data : ");
                int value = sc.nextInt();
                node nn = new node(value);
                nn.next = head;
                nn.prev = tail;
                head.prev = nn;
                tail.next = nn;
                head = nn;
                size++;
            }
        }

        void atEnd(){
            if(head == null){
                createCDLL();
            }else{
                System.out.print("Enter data : ");
                int value = sc.nextInt();
                node nn = new node(value);
                nn.prev = tail;
                tail.next = nn;
                nn.next = head;
                tail = nn;
                size++;
            }
        }

        void atPosition(){
            traversal();
            System.out.print("Enter position to put the node at : ");
            int pos = sc.nextInt();
            if(pos <= 1){
                atBeginning();
            }else if(pos >= size){
                atEnd();
            }else{
                node nn = head;
                int i = 1;
                while(i != pos-1){
                    nn = nn.next;
                    i++;
                }
                System.out.print("Enter data : ");
                int value = sc.nextInt();
                node nn2 = new node(value);
                nn2.prev = nn;
                nn2.next = nn.next;
                nn.next.prev = nn2;
                nn.next = nn2;
                size++;
            }
        }
    }

    void searchNode(){
        System.out.print("Enter data to search : ");
        int srch = sc.nextInt();
        node nn = head;
        int i = 1;
        while(i<=size){
            if(nn.data == srch){
                System.out.println("The data was found at "+i+"th place.");
            }
            i++;
            nn = nn.next;
        }
    }

    void deleteNode(){
        traversal();
        System.out.print("Enter position of node to delete : ");
        int del = sc.nextInt();
        if(del <= 1){
            tail.next = head.next;
            head = head.next;
            head.prev = tail;
            size--;
            if(size == 0){
                head = null;
                tail = null;
            }
        }else if(del >= size){
            head.prev = tail.prev;
            tail = tail.prev;
            tail.next = head;
            size--;
            if(size == 0){
                head = null;
                tail = null;
            }
        }else{
            node nn = head;
            int i = 1;
            while (i<del-1){
                nn = nn.next;
                i++;
            }
            node nn2 = nn.next;
            nn.next = nn2.next;
            nn2.next.prev = nn;
            size--;
            if(size == 0){
                head = null;
                tail = null;
            }
        }
    }


    void deleteWholeCDLL(){
        System.out.print("Confirm 1 to delete whole circular doubly linked list.");
        int ch = sc.nextInt();
        if (ch == 1){
            head = null;
            tail = null;
            size = 0;
        }
    }
    
}
