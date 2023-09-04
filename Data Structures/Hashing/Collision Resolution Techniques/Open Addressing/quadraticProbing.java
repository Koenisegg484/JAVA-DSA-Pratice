import java.util.ArrayList;;

public class quadraticProbing{
    String [] hashTable;
    int usedCellNumber;

    quadraticProbing(int size){
        hashTable = new String[size];
        usedCellNumber = 0;
    }

    private int modASCIIHashFunction(String word, int m){
        char[] ch = word.toCharArray();
        int sum = 0;
        for(int i=0; i<ch.length; i++){
            sum = sum + ch[i];
        }

        return sum%m;
    }

    private double getLoadFactor(){
        double loadFactor = usedCellNumber * 1.0/hashTable.length;
        return loadFactor;
    }

    private void rehashKeys(String word){
        usedCellNumber = 0;
        ArrayList<String> data = new ArrayList<String>();
        for(int i=0; i<hashTable.length; i++){
            if(hashTable[i] != null){
                data.add(hashTable[i]);
            }
        }
        data.add(word);

        hashTable = new String[hashTable.length*2];
        for(String s: data){
            insertInHashTable(s);
        }
    }

    void insertInHashTable(String s){
        double loadFactor = getLoadFactor();
        if(loadFactor >= 0.75){
            rehashKeys(s);
        }else{
            int index = modASCIIHashFunction(s, hashTable.length);
            int counter = 0;
            for(int i=index; i<index+hashTable.length; i++){
                int newIndex = (index + (counter*counter)) % hashTable.length;
                if(hashTable[newIndex] == null){
                    hashTable[newIndex] = s;
                    System.out.println("Data inserted : "+hashTable[newIndex]);
                    break;
                }else{
                    System.out.println("Trying next cell...");
                }
                counter++;
            }
        }
        usedCellNumber++;
    }

    void printHashTable(){
        if(hashTable == null){
            System.out.println("The hashtable is empty.");
            return;
        }else{
            System.out.println("-------------HASH TABLE-------------");
            for(int i=0; i<hashTable.length; i++){
            System.out.println("Index: "+i+"    Key:"+hashTable[i]);
        }
        }
    }

    boolean searchHashTable(String word01){
        int index = modASCIIHashFunction(word01, hashTable.length);
        int counter = 0;
        for(int i = index; i<index+hashTable.length; i++){
            int newIndex = (i + (counter*counter)) % hashTable.length;
            if(hashTable[newIndex] != null && hashTable[newIndex].equals(word01)){
                System.out.println("The word exists in the hashtable.");
                return true;
            }
            counter++;
        }
        System.out.println("The word does not exist in the hashtable.");
        return false;
    }

    void deleteFromHashTable(String word01){
        boolean toDeleteorNot = searchHashTable(word01);
        if(toDeleteorNot){
            int index = modASCIIHashFunction(word01, hashTable.length);
            int counter = 0;
            for(int i=index; i<index+hashTable.length; i++){
                int newIndex = (i +(counter*counter))%hashTable.length;
                if(hashTable[newIndex]!=null && hashTable[newIndex].equals(word01)){
                    hashTable[newIndex] = null;
                    System.out.println("Value deleted.");
                    return;
                }
                counter++;
            }

        }else{
            System.out.println("The word you want to delete does not exist in the hash table.");
        }
    }

    
}