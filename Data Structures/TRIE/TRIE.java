import java.util.Scanner;

public class TRIE{

    private trieNode root;

    Scanner sc = new Scanner(System.in);

    TRIE(){
        this.root = new trieNode();
        System.out.println("Trie has been created.");
    }

    void insertNode(){
        System.out.print("Enter a string to insert in the TRIE : ");
        String word = sc.nextLine();

        trieNode current = root;
        for (int i=0; i<word.length(); i++){

            char ch = word.charAt(i);
            trieNode node = current.children.get(ch);

            if(node == null){
                node = new trieNode();
                current.children.put(ch, node);
            }

            current = node;

        }
        current.endOfString = true;        
    }

    boolean seachString(String srch){
        // System.out.print("Enter a word to search in the TRIE : ");
        // String srch = sc.nextLine();

        trieNode current = root;
        for(int i=0; i<srch.length(); i++){
            trieNode node = current.children.get(srch.charAt(i));

            if(node == null){
                System.out.println("The desired word does not exist in the trie.");
                return false;
            }
            current = node;
        }

        if(current.endOfString == true){
            System.out.println("The desired word exists in the trie.");
            return true;
        }else{
            System.out.println("The desired word is a prefix substring in the trie.");
            return true;
        }
    }

    private boolean deleteNode(trieNode parentNode, String word, int index){
        char ch = word.charAt(index);
        trieNode currentNode = parentNode.children.get(ch);
        boolean ifToDelete;

        if(currentNode.children.size() > 1){
            deleteNode(currentNode, word, index+1);
            return false;
        }

        if(index == word.length()-1){
            if(currentNode.children.size()>=1){
                currentNode.endOfString = false;
                return false;
            }else{
                parentNode.children.remove(ch);
                return true;
            }
        }

        if(currentNode.endOfString == true){
            deleteNode(currentNode, word, index+1);
            return false;
        }
        ifToDelete = deleteNode(currentNode, word, index+1);

        if (ifToDelete == true){
            parentNode.children.remove(ch);
            return true;
        }else{
            return false;
        }
    }

    void delete(){
        System.out.print("Enter the word to delete from trie : ");
        String word = sc.nextLine();

        if(seachString(word) == true){
            deleteNode(root, word, 0);
        }else{
            System.out.println("The string does not exist in the trie to be deleted");
        }
    }



}