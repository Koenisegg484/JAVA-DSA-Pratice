import java.util.*;

public class DeletingElminArrayList {
    
    public static void main(String[] args){
        ArrayList <String> list3 = new ArrayList<String>(Arrays.asList("a","b","c","e","f","g"));
        System.out.println(list3);
        System.out.println("Enter an element to remove it from the list : ");
        Scanner sc = new Scanner (System.in);
        String t = sc.next();
        sc.close();
        list3.remove(t);
        System.out.println(list3);
    }
}
