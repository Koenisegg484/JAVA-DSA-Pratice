import java.util.Scanner;

public class SinglyLinkedLists {
    static Scanner sc = new Scanner(System.in);
    node head = null;
    node tail = null;
    int size = 0;

    void createLinkList(){
        System.out.print("Enter data : ");
        int value = sc.nextInt();
        node nn = new node(value);
        nn.next = head;
        head = nn;
        tail = nn;
        size++;
    }
    void traversal(){
        if (head == null){
            System.out.println("The linked list is empty.");
        }
        else{
            node trvnode = new node();
            trvnode = head;
            int i = 0;
            while (trvnode != null){
                System.out.println((i+1)+")"+trvnode.data);
                trvnode = trvnode.next;
                i++;
            }
        }
    }
    class InsertioninLL{
        void atBeginning(){
            if (head == null){
                createLinkList();
            }else{
                System.out.print("Enter data : ");
                int value = sc.nextInt();
                node nn = new node(value);
                nn.next = head;
                head = nn;
                size++;
            }
        }

        void atEnd(){
            if(head == null){
                createLinkList();
            }else{
                System.out.println("Enter data : ");
                int value = sc.nextInt();
                node nn = new node(value);
                tail.next = nn;
                size++;
            }
        }

        void atPosition(){
            if(head == null){
                createLinkList();
            }else{
                traversal();
                System.out.println("Enter the position you want to enter node : ");
                int pos = sc.nextInt();
                if(pos == 1){
                    atBeginning();
                    return;
                }else if(pos == size){
                    atEnd();
                    return;
                }
                System.out.print("Enter data : ");
                int value = sc.nextInt();
                node nn = new node();
                nn = head;
                for(int i = 1; i<size; i++){
                    if(i == pos-1){
                        node nn2 = new node(value);
                        nn2.next = nn.next;
                        nn.next = nn2;
                        size++;
                        break;
                    }
                    nn = nn.next;
                }
            }
        }
    }
    void toSearch(){
        System.out.print("Enter data to search in Linked List: ");
        int srch = sc.nextInt();
        int i = 1;
        node nn = head;
        while(i!= size){
            if(nn.data == srch){
                System.out.println("The data was found at "+i+"th place.");
                // break;
            }
            nn = nn.next;
            i++;
        }
    }

    void deleteNode(){
        if (head == null){
            System.out.println("The Linked List does not exist.");
        }else{
            traversal();
            System.out.println("Enter position of node to delete : ");
            int pos = sc.nextInt();
            if(pos == 0){
                head = head.next;
                size--;
                if(size == 0){
                    tail = null;
                }
                return;
            }else if(pos >= size){
                node temp = head;
                for (int i=1; i<size; i++){
                    temp = temp.next;
                }
                if(temp == head){
                    head = null;
                    tail = null;
                    size--;
                    return;
                }
                temp.next = null;
                tail = temp;
                size--;
                return;
            }else{
                int i=1;
                node nn = head;
                while(nn != null){
                    if(i==pos-1){
                        node nn2 = nn.next;
                        nn.next = nn2.next;
                        size--;
                        return;
                    }
                    nn = nn.next;
                }
            }
        }
    }

    void deleteWholeLinkedList(){
        System.out.print("Confirm 1 to delete whole linked list :  ");
        int ch = sc.nextInt();
        if(ch==1){
            head = tail = null;
            System.out.println("Whole Linked List deleted.");
        }
    }

}
