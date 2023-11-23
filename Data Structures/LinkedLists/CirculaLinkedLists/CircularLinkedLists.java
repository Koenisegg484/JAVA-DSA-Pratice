import java.util.Scanner;

public class CircularLinkedLists {
    static Scanner sc = new Scanner(System.in);
    public node head = null;
    public node tail = null;
    int size = 0;

    void createCll(){
        System.out.print("Enter data : ");
        int value = sc.nextInt();
        node nn = new node(value);
        head = nn;
        tail = nn;
        tail.next = head;
        size++;
    }

    void traversal(){
        node trvn = head;
        int i = 1;
        while(i <= size){
            System.out.println(i+") "+trvn.data);
            i++;
            trvn = trvn.next;
        }
    }

    class InsertioninCll{
        void atBeginning(){
            if(head == null){
                createCll();
            }else{
                System.out.print("Enter data : ");
                int value = sc.nextInt();
                node nn = new node(value);
                tail.next = nn;
                nn.next = head;
                head = nn;
                size++;
            }
        }

        void atEnd(){
            if(head == null){
                createCll();
            }else{
                System.out.print("Enter data : ");
                int value = sc.nextInt();
                node nn = new node(value);
                nn.next = head;
                tail.next = nn;
                tail = nn;
                size++;
            }
        }

        void atPosition(){
            if(head == null){
                createCll();
            }else{
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
                    while (i<=size){
                        if(i == pos-1){
                            System.out.print("Enter data : ");
                            int value = sc.nextInt();
                            node nn2 = new node(value);
                            nn2.next = nn.next;
                            nn.next = nn2;
                            size++;
                        }
                        nn = nn.next;
                        i++;
                    }
                }
            }
        }
    }

    void toSearch(){
        System.out.print("Enter data to search : ");
        int srch = sc.nextInt();
        node nn = head;
        int i = 1;
        while (i <= size){
            if(nn.data == srch){
                System.out.println("The data was found at "+i+"th place.");
            }
            nn = nn.next;
            i++;
        }
    }

    void deleteWholell(){
        System.out.print("Confirm 1 to delete the whole circularly linked list : ");
        int ch = sc.nextInt();
        if (ch == 1){
            head = null;
            tail = null;
            size = 0;
        }
    }

    void deleteNode(){
        traversal();
        System.out.print("Enter position of node to delete : ");
        int del = sc.nextInt();
        if(del <= 1){
            tail.next = head.next;
            head = head.next;
            size--;
            if(size == 0){
                head = null;
                tail = null;
            }
            return;
        }else if(del >= size){
            int i = 1;
            node nn = head;
            while (i<= size-1){
                nn=nn.next;
                i++;
            }
            nn.next = head;
            tail = nn;
            size--;
            if(size == 0){
                head = null;
                tail = null;
            }
            return;
        }else{
            int i = 1;
            node nn = head;
            while (i<= del){
                nn=nn.next;
                i++;
            }
            node nn2 = nn.next;
            nn.next = nn2.next;
            size--;
            return;
        }
    }
}
