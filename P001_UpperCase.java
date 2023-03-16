import java.util.Scanner;

public class P001_UpperCase {
    public static String capitaliseword(String str){
        if(str.isEmpty())
            return str;
        char chr = str.charAt(str.length()-1);
        if(str.length() == 1)
            return Character.toString(Character.toUpperCase(chr));
        if((str.substring((str.length()-2), str.length()-1).equals(" ")))
            chr = Character.toUpperCase(chr);

        return  capitaliseword(str.substring(0, str.length()-1)) + Character.toString(chr);
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String sentence = sc.next();
        String UppercasedSentece = capitaliseword(sentence);
        System.out.println(UppercasedSentece);
//        System.out.println(capitaliseword(sentence));
    }
}
