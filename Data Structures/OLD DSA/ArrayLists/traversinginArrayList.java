import java.util.*;

public class traversinginArrayList {
    public static void main (String [] args){
        ArrayList <String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        list1.add("c");
        list1.add("d");
        list1.add("e");
        for(String elm : list1){
            System.out.println(elm);
        }
        System.out.println();

        Iterator <String> iterator = list1.iterator();
        while(iterator.hasNext()){
            String letter = iterator.next();
            System.out.println(letter);
        }

    }    
}
