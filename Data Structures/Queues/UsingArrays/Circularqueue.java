import java.util.Scanner;

public class Circularqueue {
    int [] cqarray;
    int topofqueue;    
    int beginningofqueue;
    static Scanner sc = new Scanner(System.in);

    Circularqueue(int size){
        this.cqarray = new int[size];
        this.topofqueue = -1;
        this.beginningofqueue = -1;
    }

    boolean isFull(){
        if(topofqueue == cqarray.length-1 && beginningofqueue == 0){
            return true;
        }else if(topofqueue+1 == beginningofqueue){
            return true;
        }
        return false;
    }

    boolean isEmpty(){
        if(topofqueue == -1){
            return true;
        }
        return false;
    }

    void enqueue(){
        if(isFull()){
            System.out.println("The queue is full.");
        }else{
            if(isEmpty()){
                beginningofqueue = 0;
            }
            if(topofqueue == cqarray.length-1){
                topofqueue = 0;
            }else{
                topofqueue++;
            }
            System.out.print("Enter data : ");
            int value = sc.nextInt();
            cqarray[topofqueue] = value;
        }
    }

    void dequeue(){
        if(isEmpty()){
            System.out.println("The queue is empty.");
        }else{
            // cqarray[beginningofqueue] = 0;
            if(beginningofqueue == topofqueue){
                beginningofqueue =topofqueue = -1;
            }else if(beginningofqueue == cqarray.length-1){
                beginningofqueue = 0;
            }else{
                beginningofqueue++;
            }
        }
    }

    void peek(){
        if(isEmpty()){
            System.out.println("Te queue is empty.");
        }
        else{
            System.out.println(cqarray[beginningofqueue]);
        }
    }

    void delete(){
        int j = cqarray.length;
        cqarray = null;
        cqarray = new int[j];
        topofqueue = -1;
        beginningofqueue = -1;
    }
}
