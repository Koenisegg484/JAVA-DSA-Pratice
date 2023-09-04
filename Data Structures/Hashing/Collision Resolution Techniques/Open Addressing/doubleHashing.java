import java.util.ArrayList;

public class doubleHashing {

    String[] hashTable;
    int usedcells;

    doubleHashing(int size){
        hashTable = new String[size];
        usedcells = 0;
    }

    private int modASCIIHashFunction(String word, int m){
        char[] ch = word.toCharArray();
        int sum=0;
        for(int i=0; i<ch.length; i++){
            sum += ch[i];
        }

        return sum%m;
    }

    private int sumofall(int sum){
        int value = 0;
        while(sum > 0){
            value = sum%10;
            sum = sum/10;
        }

        return value;
    }

    private int secondHashFunction(String word, int m){
        char[] ch = word.toCharArray();
        int sum = 0;
        for(int i=0; i<ch.length; i++){
            sum = sum + ch[i];            
        }

        while(sum > hashTable.length){
            sum = sumofall(sum);
        }

        
        return sum%m;
    }

    private double getLoadFactor(){
        double loadFactor = usedcells * 1.0/hashTable.length;
        return loadFactor;
    }

    void rehashKeys(String word){
        ArrayList<String> data = new ArrayList<String>();
        for(int i=0; i<hashTable.length; i++){
            if(hashTable[i] != null){
                data.add(hashTable[i]);
            }
        }
        data.add(word);

        hashTable = new String[hashTable.length];
        for(String s : data){
            insertInHashTable(s);
        }
    }

    void insertInHashTable(String word){
        double loadFactor = getLoadFactor();
        if(loadFactor >= 0.75){
            rehashKeys(word);
        }else{
            int x = modASCIIHashFunction(word, hashTable.length);
            int y = secondHashFunction(word, hashTable.length);

            for(int i=0; i<hashTable.length; i++){
                int newIndex = ( x+ i*y) % hashTable.length;
                System.out.println(newIndex);
                if(hashTable[newIndex] == null){
                    hashTable[newIndex] = word;
                    System.out.println("DataInserted : "+hashTable[newIndex]);
                    break;
                }
            }
        }
        usedcells++;
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
        int x = modASCIIHashFunction(word01, hashTable.length);
        int y = secondHashFunction(word01, hashTable.length);
        for(int i = 0; i<hashTable.length; i++){
            int newIndex = (x + i*y)%hashTable.length;
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
            int x = modASCIIHashFunction(word01, hashTable.length);
            int y = secondHashFunction(word01, hashTable.length);
            for(int i = 0; i<hashTable.length; i++){
            int newIndex = (x + i*y)%hashTable.length;
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
