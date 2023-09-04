import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("This is a program to implemet basics of hashing and Resolving collisions");
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        DirectChaining dc = new DirectChaining(size);
        System.out.println("------------Menu------------");
        System.out.println("1. Insert String in the hashtable\n2. Display th hash table\n3. Search a word in hashTable\n4. Delete a word from table.\n5. Exit the program.");

        int ch = 0;
        do{
            System.out.print("Enter your choice : ");
            ch = sc.nextInt();
            sc.nextLine();

            switch(ch){
                case 1:
                System.out.print("Enter the string to store : ");
                String word = sc.nextLine();
                dc.insertinHashTable(word);
                break;

                case 2:
                dc.displayHashTable();
                break;

                case 3:
                System.out.print("Enter the string to search : ");
                String srch = sc.nextLine();
                dc.searchHashTable(srch);
                break;

                case 4:
                System.out.print("Enter the string to delete : ");
                String del = sc.nextLine();
                dc.deleteFromHashTable(del);
                break;

                case 5:
                System.out.println("Exitting...");
                break;

                default:
                System.out.println("You entered the wrong choice.");
                break;
            }
        }while(ch != 5);
    }
}