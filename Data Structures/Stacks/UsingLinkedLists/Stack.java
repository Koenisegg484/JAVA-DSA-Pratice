import java.util.Scanner;

public class Stack {
    static Scanner sc = new Scanner(System.in);
    int topofstack = -1;

    linkedList stll = new linkedList();

    void push(){
        stll.pushinLL();
    }
    void pop(){
        if(isEmpty()){
            System.out.println("The stack is empty.");
        }else{
            stll.popinLL();
        }
    }
    void peek(){
        if(isEmpty()){
            System.out.println("The stack is empty.");
        }else{
            stll.peekinLL();
        }
    }

    void delete(){
        if(isEmpty()){
            System.out.println("The stack is empty.");
        }else{
            stll.deletestll();
        }
    }


    private class node{
        int data;
        node next;

        node(int value){
            this.data = value;
            this.next = null;
        }
    }

    boolean isEmpty(){
        if(topofstack <= -1){
            return true;
        }
        // System.out.println("The stack is not yet empty.");
        return false;
    }

    private class linkedList{
        node head = null;
        // node tail = null;

        void createll(){
            System.out.print("Enter data : ");
            int value = sc.nextInt();
            node nn = new node(value);
            head = nn;
            topofstack++;
        }

        void pushinLL(){
            if(head == null){
                createll();
            }else{
                System.out.print("Enter data : ");
                int value = sc.nextInt();
                node nn = new node(value);
                nn.next=head;
                head = nn;
                topofstack++;
                traversal();             
            }
        }

        void popinLL(){
            head = head.next;
            topofstack--;
        }

        void peekinLL(){
            System.out.println(head.data);
        }

        void deletestll(){
            head = null;
            topofstack = -1;
        }

        void traversal(){
            node trvn = head;
            while(trvn != null){
                System.out.println(trvn.data);
                trvn = trvn.next;
            }
        }
    }
}
