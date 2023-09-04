import java.util.Scanner;

public class binaryHeap{
    int arr[];
    int sizeOfTree;
    int heapType;

    Scanner sc = new Scanner(System.in);

    binaryHeap(){
        System.out.print("Enter the size of the tree : ");
        int size = sc.nextInt();
        this.arr = new int[size+1];
        this.sizeOfTree = 0;
        System.out.print("Enter 1 for Min heap, 2 for Max heap : ");
        this.heapType = sc.nextInt();
    }

    boolean isEmpty(){
        if(sizeOfTree == 0){
            return true;
        }
        return false;
    }

    void peek(){
        if(isEmpty()){
            System.out.println("The Binary Heap is empty.");
            return;
        }
        System.out.println(arr[1]);
    }

    void levelOrder(){
        for(int i=1; i <= sizeOfTree; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    // private void swaps(int i, int j){
    //     int temp = i;
    //     i = j;
    //     j = temp;
    //     return;
    // }

    private void heapifyB2T(int index, int heapType){
        int parent = index/2;
        if(index <= 1){
            return;
        }
        if(heapType == 1){
            if(arr[index] < arr[parent]){
                int temo = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temo;
            }
        }      
        else if(heapType == 2){
            if(arr[index] > arr[parent]){
                int temo = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temo;
            }
        }

        heapifyB2T(parent, heapType);
    }

    void insertNode(int heapType){
        if(sizeOfTree == arr.length-1){
            System.out.println("The array is full.");
            return;
        }
        System.out.print("Enter data : ");
        int data = sc.nextInt();
        arr[sizeOfTree+1] = data;
        sizeOfTree++;

        heapifyB2T(sizeOfTree, heapType);

    }

    private void heapifyT2B(int index, int heapType){
        int left = index*2;
        int right = left+1;
        int swapChild = 0;

        if(sizeOfTree < left){
            return;
        }

        if(heapType == 2){
            if (sizeOfTree == left){
                if(arr[index] < arr[left]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }else{
                if(arr[left] > arr[right]){
                    swapChild = left;
                }else{
                    swapChild = right;
                }
                if(arr[index] < arr[swapChild]){
                    int temp = arr[swapChild];
                    arr[swapChild] = arr[index];
                    arr[index] = temp;
                }
            }            
        }
        else if(heapType == 1){
            if (sizeOfTree == left){
                if(arr[index] > arr[left]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }else{
                if(arr[left] < arr[right]){
                    swapChild = left;
                }else{
                    swapChild = right;
                }
                if(arr[index] > arr[swapChild]){
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }
        }

        heapifyT2B(swapChild, heapType);
    }

    int extractNode(int heapType){
        if (isEmpty()){
            System.out.println("The tree is Empty.");
            return -1;
        }

        int extractedNode = arr[1];
        arr [1] = arr[sizeOfTree];
        sizeOfTree--;

        heapifyT2B(1, heapType);
        return extractedNode;
    }

    void deleteTree(){
        System.out.print("Confirm 1 to delete the tree : ");
        int ch = sc.nextInt();
        if(ch == 1){
            arr = null;
            sizeOfTree = 0;
        }
    }
}