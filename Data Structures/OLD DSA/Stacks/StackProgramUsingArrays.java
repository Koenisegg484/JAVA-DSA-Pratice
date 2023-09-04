import java.util.*;

public class StackProgramUsingArrays{

    static Scanner sc = new Scanner(System.in);

    public static class stack001{
        int arr[] ;
        int topofstack;

        stack001(int size){
            this.arr = new int[size];
            this.topofstack = -1;
            System.out.println("The stack has been created with size : "+size);
        }

        boolean isEmpty(){
            if(topofstack == -1){
                return true;
            }else {
                return false;
            }
        }
        boolean isFull(){
            if(topofstack == arr.length - 1){
                return true;
            }else{
                return false;
            }
        }

        void push(){
            if(isFull()){
                System.out.println("The stack is full.");
                return;
            }else{
                System.out.print("Enter data in the stack : ");
                arr[++topofstack] = sc.nextInt();
                System.out.println("Value inserted.");
            }
        }
        void pop(){
            if(isEmpty()){
                System.out.println("The stack is empty.");
            }else{
                int tempdata = arr[topofstack];
                topofstack--;
                System.out.println("Data at the top deleted : "+tempdata);
            }
        }
        void peek(){
            if(isEmpty()){
                System.out.println("The stack is empty.");
                // return -1;
            }else{
                System.out.println("The data at the top is : "+arr[topofstack]);
            }
        }
        void deletestack(){
            System.out.print("Press 1 to confirm deleting stack : ");
            int ch = sc.nextInt();
            if(ch == 1){
                topofstack = -1;
                // arr = null;
                System.out.println("The stack was deleted successfully.");
            }else{
                System.out.println("No changes were made.");
            }
        }
    }
    public static void main(String[] args){
        stack001 UserStack = new stack001(5);
        while(true){
            System.out.print("Enter choice : ");
            int i = sc.nextInt();
            if(i == 0){
                UserStack.push();
            }else if(i == 1){
                UserStack.pop();
            }else if(i == 2){
                UserStack.peek();
            }else if(i == 3){
                UserStack.deletestack();
            }
            else{
                break;
            }
        }

    }
}
