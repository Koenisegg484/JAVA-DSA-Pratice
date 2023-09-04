import java.util.Scanner;

public class binarytree {

    Scanner sc = new Scanner(System.in);
    
    String treeArray[];
    int lastIndex;

    binarytree(int size){
        this.treeArray = new String[size+1];
        this.lastIndex = 0;
    }

    boolean isFull(){
        if(treeArray.length-1 == lastIndex){
            return true;
        }
        return false;
    }

    void insertNode(){
        System.out.print("Enter data :");
        String data = sc.nextLine();

        if(!isFull()){
            treeArray[lastIndex+1] = data;
            lastIndex++;
        }else{
            System.out.println("The tree is full.");
        }

    }

    void preOrderTraversal(int index){
        if(index > lastIndex){
            return;
        }
        System.out.print(treeArray[index]+"  ");
        preOrderTraversal(index*2);
        preOrderTraversal(index*2+1);
    }
    void postOrderTaversal(int index){
        if(index > lastIndex){
            return;
        }
        postOrderTaversal(index*2);
        postOrderTaversal(index*2+1);
        System.out.print(treeArray[index]+"  ");
    }
    void inOrderTaversal(int index){
        if(index > lastIndex){
            return;
        }
        inOrderTaversal(index*2);
        System.out.print(treeArray[index]+"  ");
        inOrderTaversal(index*2+1);
    }

    void levelOrderTrversal(){
        for (int i =1; i<=lastIndex; i++){
            System.out.print(treeArray[i]+"  ");
        }
    }

    void searchLOT(){
        System.out.print("Enter data to search in tree : ");
        String srch = sc.nextLine();
        for(int i=1; i<=lastIndex; i++){
            if(treeArray[i].equals(srch)){
                System.out.println("The elements exist in the tree.");
                return;
            }
        }
        System.out.println("The element does not exist in the tree.");
    }

    void deleteNode(){
        System.out.print("Enter data of node to delete it : ");
        String toDelete = sc.nextLine();
        for(int i=1; i<=lastIndex; i++){
            if(treeArray[i].equals(toDelete)){
                treeArray[i] = treeArray[lastIndex];
                treeArray[lastIndex] = null;
                lastIndex --;
                return;
            }
        }

        System.out.println("The node data you entered does not exist in the tree.");
        return;
    }

    void deleteTree(){
        System.out.print("Confirm 1 to delete the whole tree : ");
        int ch = sc.nextInt();

        if (ch==1){
            try{
                treeArray = null;
                lastIndex = 0;
            }catch(Exception e ){
                System.out.println("There was an error deleting the tree.");
            }
        }else{
            System.out.println("No changes were made to the tree.");
        }
    }
}
