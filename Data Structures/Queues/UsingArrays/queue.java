import java.util.Scanner;

public class queue {
    int [] qarray;
    int topofqueue;
    int beginningofqueue;

    private Scanner sc = new Scanner(System.in); 

    queue(int size){
        this.qarray = new int [size];
        this.topofqueue = -1;
        this.beginningofqueue = -1;
    }

    boolean isEmpty(){
        if (beginningofqueue == -1 || beginningofqueue == qarray.length){
            return true;
        }
        return false;
    }

    boolean isFull(){
        if(topofqueue == qarray.length-1){
            return true;
        }
        return false;
    }

    void enqueue(){
        if(isFull()){
            System.out.println("The queue is full.");
        }
        // else if(isEmpty()){
        //     beginningofqueue = 0;
        //     System.out.print("Enter data : ");
        //     int value = sc.nextInt();
        //     topofqueue++;
        //     qarray[topofqueue] = value;
        // }
        else{
            if(isEmpty()){
                beginningofqueue = 0;
            }
            System.out.print("Enter data : ");
            int value = sc.nextInt();
            topofqueue++;
            qarray[topofqueue] = value;
        }
    }

    void dequeue(){
        if(isEmpty()){
            System.out.println("The queue is empty.");
        }else{
            beginningofqueue++;
            // return qarray[beginningofqueue];
            if(beginningofqueue > topofqueue){
                beginningofqueue = topofqueue = -1;
            }
        }
    }

    void peek(){
        if(isEmpty()){
            System.out.println("The queue is empty.");
        }else{
            System.out.println(qarray[beginningofqueue]);
        }
    }

    void delete(){
        qarray = null;
        topofqueue = -1;
        beginningofqueue = -1;
        System.out.println("The queue has been deleted.");
    }
}
