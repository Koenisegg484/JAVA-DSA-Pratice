import java.util.ArrayList;
import java.util.Scanner;

class arrLists{
    public static void main(String [] args){
        ArrayList <String> firstlist = new ArrayList<String>(10);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the initial size of the arrayList : ");
        int t = sc.nextInt();
        for (int i=0; i<t; i++){
            System.out.print("Enter a number : ");
            firstlist.add(i, sc.next());
        }
        for (String elm: firstlist){
            System.out.println(elm);
        }
        while(true){
            System.out.println("Enter 1 to add more elements, 2 to exit : ");
            int ch = sc.nextInt();
            if (ch ==1){
                t++;
                System.out.print("Enter a number : ");
                firstlist.add(t, sc.next());
            }else if(ch ==2){
                break;
            }
        }
        for (String elm: firstlist){
            System.out.println(elm);
        }
        sc.close();

    }
}