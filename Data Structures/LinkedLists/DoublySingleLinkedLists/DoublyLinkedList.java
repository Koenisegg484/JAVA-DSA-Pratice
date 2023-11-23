import java.util.Scanner;

public class DoublyLinkedList {
    node head = null;
    node tail = null;
    int size = 0;

    static Scanner sc = new Scanner(System.in);

    void createdll(){
        System.out.print("Enter data : ");
        int value = sc.nextInt();
        node nn = new node(value);

        head = nn;
        tail = nn;
        size++;
    }

    void traversal(){
        if(head == null){
            System.out.println("The doubly linked list is empty.");
        }
        else{
            node trvn = head;
            int i = 1;
            while(trvn != null){
                System.out.println(i+") "+trvn.data);
                trvn = trvn.next;
                i++;
            }
        }
    }

    void reversetraversal(){
        if(head == null){
            System.out.println("The doubly linked list is empty.");
        }else{
            node trvn = tail;
            int i = 1;
            while(trvn!= null){
                System.out.println(i+") "+trvn.data);
                trvn = trvn.prev;
                i++;
            }
        }
    }

    class Insertionindll{
        void atBeginning(){
            if (head == null){
                createdll();
            }else{
                System.out.print("Enter data : ");
                int value = sc.nextInt();
                node nn = new node(value);
                nn.next = head;
                head.prev = nn;
                head = nn;
                size++;
            }
        }

        void atEnd(){
            if (head == null){
                createdll();
            }else{
                System.out.print("Enter data : ");
                int value = sc.nextInt();
                node nn = new node(value);
                tail.next = nn;
                nn.prev = tail;
                tail = nn;
            }
        }

        void atPosition(){
            traversal();
            System.out.print("Enter the position to put the node at : ");
            int pos = sc.nextInt();
            int i = 1;
            node nn = head;
            while(i<=pos){
                nn = nn.next;
            }
            System.out.print("Enter data : ");
            int value = sc.nextInt();
            node nn2 = new node(value);

            nn2.next = nn.next;
            nn.next.prev = nn2;
            nn2.prev = nn;
        }
    }

    void searchNode(){
        System.out.print("Enter data to search : ");
        int srch = sc.nextInt();
        int i = 1;
        node nn = head;
        while(nn!=null){
            if(nn.data == srch){
                System.out.println("The data was found at "+i+"th position.");
            }
            i++;
            nn = nn.next;
        }
    }

    void deleteNode(){
        traversal();
        System.out.print("Enter the position of node to delete : ");
        int del = sc.nextInt();
        if(del <= 1){
            head = head.next;
            size--;
            if(size == 0){
                head = null;
                tail = null;
            }
            return;
        }else if(del >= size){
            tail = tail.prev;
            size--;
            if(size == 0){
                head = null;
                tail = null;
            }
            return;
        }else{
            node nn = head;
            int i = 1;
            while (nn != null){
                if(i == del-1){
                    node nn2 = nn.next;
                    nn.next = nn2.next;
                    nn2.next.prev = nn;
                    size--;
                    return;
                }
                nn = nn.next;
            }
        }
    }

    void deleteWholedll(){
        System.out.print("Confirm 1 to delete the whole linked list : ");
        int ch = sc.nextInt();
        if(ch == 1){
            head = null;
            tail = null;
            size = 0;
        }
    }
}
