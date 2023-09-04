import java.util.*;

public class srchElementinArraylist {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        ArrayList <String> list2 = new ArrayList<String>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("d");
        list2.add("e");
        list2.add("f");

        Iterator <String> iterator = list2.iterator();
        while(iterator.hasNext()){
            String elm = iterator.next();
            System.out.println(elm);
        }
        System.out.println();
        System.out.print("ENTER AN ELEMENT TO SEARCH FOR IN THE ARRAY LIST : ");
        String s = sc.next();

        int i = 0;
        for(String elm: list2){
            if (elm.equals(s)){
                System.out.println("The element was found at "+list2.indexOf(elm));
                return;
            }
            
            i++;
        }
        System.out.println("The element was not found in the given list.");

    }
    
}
