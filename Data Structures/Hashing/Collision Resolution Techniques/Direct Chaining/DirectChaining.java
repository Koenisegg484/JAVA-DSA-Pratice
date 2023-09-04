import java.util.LinkedList;
import java.util.ArrayList;

public class DirectChaining {
    LinkedList<String>[] hashtable;
    int maxChain = 5;

    DirectChaining(int size){
        this.hashtable = new LinkedList[size];
    }

    
    private int modASCIIHashFunction(String word, int m){ //m is the size of the array to be created for storing hash values

        char ch[] = word.toCharArray();
        int i, sum=0;

        for(i=0; i<word.length(); i++){
            sum = sum+ch[i];
        }

        return sum%m;
    }

    void insertinHashTable(String word){

        int newIndex = modASCIIHashFunction(word, hashtable.length);

        if(hashtable[newIndex] == null){
            hashtable[newIndex] = new LinkedList<String>();
            hashtable[newIndex].add(word);
        }else{
            hashtable[newIndex].add(word);
        }
    }

    void displayHashTable(){
        if(hashtable == null){
            System.out.println("The hash table is Empty...");
        }else{
            System.out.println("----------HASH TABLE---------");
            for (int j = 0; j<hashtable.length; j++){
                System.out.println("Index: "+j+"   key: "+hashtable[j]);
            }
        }
    }

    boolean searchHashTable(String word){
        if(hashtable == null){
            System.out.println("The linked list is empty.");
            return false;
        }
        
        int newIndex = modASCIIHashFunction(word, hashtable.length);
        if(hashtable[newIndex] != null && hashtable[newIndex].contains(word)){
            System.out.println("The String exist in the hash table.");
            return true;
        }else{
            System.out.println("The word does not exist in the hash table.");
            return false;
        }
    }

    void deleteFromHashTable(String word){
        int newIndex = modASCIIHashFunction(word, hashtable.length);
        boolean result = searchHashTable(word);

        if(result == true ){
            hashtable[newIndex].remove(word);
            System.out.println("Deleted from the hashtable.");
        }else{
            System.out.println("The word does not exist in the hash table.");
        }
    }
    
}
