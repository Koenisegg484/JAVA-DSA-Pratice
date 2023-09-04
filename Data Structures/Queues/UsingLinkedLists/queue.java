import java.util.Scanner;

public class queue {
    static  Scanner sc = new Scanner(System.in);

    LinkedList qll = new LinkedList();

    boolean isEmpty(){
        if (qll.head == null){
            return true;
        }
        return false;
    }

    void enqueue(){
        qll.insertinLl();
    }
    
    void dequeue(){
        if(isEmpty()){
            System.out.println("The queue is empty.");
        }else{
            qll.deletenode();
        }
    }

    void peek(){
        if(isEmpty()){
            System.out.println("The queue is empty.");
        }else{
            qll.qpeek();
            qll.traversal();
        }
    }

    void deletell(){
        qll.deletell();
    }


    private class node{
        int data;
        node next;

        node(int value){
            this.data = value;
            this.next = null;
        }
    }

    class LinkedList{
        node head = null;
        node tail = null;
        int size = 0;

        void createll(){
            System.out.print("Enter data : ");
            int value = sc.nextInt();
            node nn = new node(value);
            head = nn;
            tail = nn;
            size++;
        }

        void insertinLl(){
            if(head == null){
                createll();
            }else{
                System.out.print("Enter data : ");
                int value = sc.nextInt();
                node nn = new node(value);
                tail.next = nn;
                tail = nn;
                size++;
            }
        }

        void traversal(){
            node trvn = head;
            while(trvn != null){
                System.out.print(trvn.data);
                if(trvn.next != null){
                    System.out.print(" -> ");
                }
                trvn = trvn.next;
            }
        }

        void deletenode(){
            node nn = head;
            head = nn.next;
            size--;
            if(size == 0){
                deletell();
            }
        }

        void qpeek(){
            System.out.println(head.data);
        }

        void deletell(){
            head = null;
            tail = null;
            size = 0;
        }
    }
}
