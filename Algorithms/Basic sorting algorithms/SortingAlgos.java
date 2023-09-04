import java.util.ArrayList;
import java.util.Collections;

public class SortingAlgos{

    void display(int arr[]){
        for (int i =0; i<arr.length; i++){
            System.out.print(arr[i]);
            if(i != arr.length-1){
                System.out.print(" -> ");
            }
        }
    }

    
    void bubbleSort1(int [] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;                
                }
            }
        }
    }

    void selectionSort(int [] arr){
        for (int j=0; j<arr.length; j++){
            int minIndex = j;
            for(int i = j+1; i<arr.length; i++){
                if(arr[i] < arr[minIndex]){
                    minIndex = i;
                }
            }
            if(minIndex != j){
                int temp = arr[j];
                arr[j] = arr[minIndex];
                arr[minIndex] = temp;
            }            
        }
    }

    void insertionSort(int [] arr){
        for(int i=0; i<arr.length; i++){
            int temp = arr[i], j = i;
            while(j>0 && arr[j-1]>temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private void printBuckets(ArrayList<Integer>[] buckets){
        for (int i=0; i<buckets.length; i++){
            System.out.println("Bucket no. : "+(i+1));
            for (int j=0; j<buckets[i].size(); j++){
                System.out.print(buckets[i].get(j)+"  ");
            }
            System.out.println();
        }
    }

    void bucketSort(int [] arr){
        int numberfBuckets = (int) Math.ceil(Math.sqrt(arr.length));           
        int maxValue = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > maxValue){
                maxValue = arr[i];
            }
        }

        ArrayList<Integer>[] buckets = new ArrayList[numberfBuckets];
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new ArrayList<Integer>();
        }

        for (int value: arr){
            int bucketNumber = (int) Math.ceil(((float) value * numberfBuckets)/ (float) maxValue);
            buckets[bucketNumber-1].add(value);
        }

        System.out.println("Printing Buckets before sorting :");
        printBuckets(buckets);

        for(ArrayList <Integer> buck: buckets){
            Collections.sort(buck);
        }

        System.out.println("Printing Buckets after sorting :");
        printBuckets(buckets);

        int index = 0;
        for(ArrayList<Integer> buck : buckets){
            for(int value: buck){
                arr[index] = value;
                index++;
            }
        }
    }

    private void mergeMethod(int[] a, int left, int middle, int right){
        int[] leftTempArray = new int[middle-left+2];
        int[] rightTempArray = new int[right - middle + 1];

        for(int i = 0; i<= middle-left; i++){
            leftTempArray[i] = a[left+i];
        }
        for(int i=0; i<right-middle; i++){
            rightTempArray[i] = a[middle + 1 + i];
        }

        leftTempArray[middle - left + 1] = Integer.MAX_VALUE;
        rightTempArray[right - middle] = Integer.MAX_VALUE;
        int i=0, j=0;
        for(int k=left; k<=right; k++){
            if(leftTempArray[i]<rightTempArray[j]){
                a[k] = leftTempArray[i];
                i++;
            }else{
                a[k] = rightTempArray[j];
                j++;
            }
        }
    }

    void mergeSort(int[] arr, int left, int right){
        if(right > left){
            int middle = (left+right)/2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle+1, right);
            
            mergeMethod(arr, left, middle, right);
        }
    }

    private int partition(int[] arr, int start, int end){
        int pivot = end;
        int i=start-1;
        for(int j=start; j<=end; j++){
            if(arr[j] <= arr[pivot]){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        return i;
    }

    void quickSort(int [] arr, int left, int right){
        if(left < right){
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot-1);
            quickSort(arr, pivot+1, right);
        }        
    }
    private class heapMethods{
        int [] heapArray;
        int sizeOfTree;
        heapMethods(int size){
            heapArray = new int[size+1];
            sizeOfTree = 0;
        }

        private boolean isEmpty(){
            if(sizeOfTree == 0){
                return true;
            }
            return false;
        }

        private void heapifyB2T(int index){
            // System.out.println("Checking heapify on : "+heapArray[index]);
            int parent = index/2;
            if(index<=1){
                return;
            }

            if(heapArray[index] < heapArray[parent]){
                int tem = heapArray[index];
                heapArray[index] = heapArray[parent];
                heapArray[parent] = tem;
            }
            heapifyB2T(parent);
        }

        private void heapifyT2B(int index){
            int leftChild = index*2;
            int rightChild = leftChild+1;
            int swapChild = 0;

            if(sizeOfTree < leftChild){
                return;
            }

            if(sizeOfTree == leftChild){
                if(heapArray[index] > heapArray[leftChild]){
                    int tem = heapArray[index];
                    heapArray[index] = heapArray[leftChild];
                    heapArray[leftChild] = tem;
                }
                return;
            }else{
                if(heapArray[leftChild] < heapArray[rightChild]){
                    swapChild = leftChild;
                }else{
                    swapChild = rightChild;
                }
                if(heapArray[index] > heapArray[swapChild]){
                    int tep = heapArray[index];
                    heapArray[index] = heapArray[swapChild];
                    heapArray[swapChild] = tep;
                }
            }
            heapifyT2B(swapChild);

        }
        

        void insert(int data){
            if(sizeOfTree == heapArray.length - 1){
                System.out.println("The heap is full.");
                return;
            }
            heapArray[sizeOfTree+1] = data;
            sizeOfTree++;
            heapifyB2T(sizeOfTree);
        }

        int extractRoot(){
            if(isEmpty()){
                System.out.println("Tree is empty.");
                return -1;
            }
            int root1 = heapArray[1];
            heapArray[1] = heapArray[sizeOfTree];
            sizeOfTree--;
            heapifyT2B(1);
            return root1;

        }
    }

    void heapSort(int arr[]){
        heapMethods hm = new heapMethods(arr.length);
        for(int num : arr){
            hm.insert(num);
        }
        System.out.println("Data is inserted into the binary heap tree.");
        int j = 0;
        while(!hm.isEmpty()){
            arr[j++] = hm.extractRoot();
        }
        System.out.println("The array has been sorted.");
        return;
    }
}