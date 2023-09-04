import java.util.Scanner;

public class stack{
    int [] starray;
    int topofstack;
    static Scanner sc = new Scanner(System.in);

    stack(int size){
        this.starray = new int[size];
        this.topofstack = -1;
    }

    boolean isEmpty(){
        if(topofstack <= -1){
            return true;
        }
        // System.out.println("The stack is not yet empty.");
        return false;
    }

    boolean isFull(){
        if(topofstack >= starray.length){
            return true;
        }
        // System.out.println("The stack is not yet full.");
        return false;
    }

    void push(){
        if(isFull()){
            System.out.println("The stack is full.");
        }else{
            System.out.println("Enter data : ");
            int value = sc.nextInt();
            starray[topofstack+1] = value;
            topofstack++;
        }
    }

    void pop(){
        if(isEmpty()){
            System.out.println("The stack is empty.");
        }else{
            System.out.println("Deleting top element from stack... ");
            topofstack--;
        }
    }

    int peek(){
        if(isEmpty()){
            System.out.println("The stack is empty.");
            return -1;
        }else{
            return starray[topofstack];
        }
    }

    void delete(){
        starray = null;
        topofstack = -1;
    }
}