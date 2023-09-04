public class Main {
    public static void main(String[] args) {
        System.out.println("This is a program to implement basic sorting algorithms : ");
        int [] arr = new int[]  {10,21, 43, 5, 88, 54, 76,32, 65, 889, 344, 2};
        SortingAlgos bb = new SortingAlgos();
        System.out.println("Before sorting : ");
        bb.display(arr);
        System.out.println();
        bb.heapSort(arr);
        System.out.println("\nAfter sorting : ");
        bb.display(arr);

    }
        
}
