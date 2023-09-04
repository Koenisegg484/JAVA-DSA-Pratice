import java.util.ArrayList;

public class linearProbing {
    String[] hashTable;
    int usedCellNumber;

    linearProbing(int size){
        hashTable = new String[size];
        usedCellNumber = 0;
    }

    private int modASCIIHashFunctions(String word, int m){
        char ch[];
        ch = word.toCharArray();
        int sum = 0;
        for (int i=0; i<word.length(); i++){
            sum = sum + ch[i];
        }
        return sum%m;
    }

    private double getLoad(){
        double loadFactor = usedCellNumber* 1.0/hashTable.length;
        return loadFactor;
    }

    private void rehashKeys(String word){
        usedCellNumber = 0;
        ArrayList<String> data = new ArrayList<String>();
        for(String s : hashTable){
            if(s != null){
                data.add(s);
            }
        }
        data.add(word);

        hashTable = new String[hashTable.length*2];

        for (String s : data){
            insertInHashTable(s);
        }
    }

    void insertInHashTable(String word01){
        double loadFactor = getLoad();

        if(loadFactor >= 0.75){
            rehashKeys(word01);
        }else{
            int index = modASCIIHashFunctions(word01, hashTable.length);
            for (int i=index; i<index+hashTable.length; i++){
                int newIndex = i%hashTable.length;

                if(hashTable[newIndex] == null){
                    hashTable[newIndex] = word01;
                    System.out.println("Data inserted : "+hashTable[newIndex]);
                    break;
                }else{
                    System.out.println("Trying next...");
                }
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
        int index = modASCIIHashFunctions(word01, hashTable.length);
        for(int i = index; i<index+hashTable.length; i++){
            int newIndex = i%hashTable.length;
            if(hashTable[newIndex] != null && hashTable[newIndex].equals(word01)){
                System.out.println("The word exists in the hashtable.");
                return true;
            }
        }
        System.out.println("The word does not exist in the hashtable.");
        return false;
    }

    void deleteFromHashTable(String word01){
        boolean toDeleteorNot = searchHashTable(word01);
        if(toDeleteorNot){
            int index = modASCIIHashFunctions(word01, hashTable.length);
            for(int i=index; i<index+hashTable.length; i++){
                int newIndex = i%hashTable.length;
                if(hashTable[newIndex]!=null && hashTable[newIndex].equals(word01)){
                    hashTable[newIndex] = null;
                    System.out.println("Value deleted.");
                    return;
                }
            }

        }else{
            System.out.println("The word you want to delete does not exist in the hash table.");
        }
    }
}
