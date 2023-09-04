import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class binarytree {

    Scanner sc = new Scanner(System.in);
    binarynode root;
    // int height;
    binarytree(){
        // this.height = 0;
        this.root = null;
    }

    void preOrderTraversal(binarynode root){
        if(root == null){
            return;
        }
        System.out.print(root.data+"  ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    void inOrderTaversal(binarynode root){
        if(root == null){
            return;
        }
        inOrderTaversal(root.left);
        System.out.print(root.data+"  ");
        inOrderTaversal(root.right);
    }

    void postOrderTaversal(binarynode root){
        if(root == null){
            return;
        }
        postOrderTaversal(root.left);
        postOrderTaversal(root.right);
        System.out.print(root.data+"  ");
    }

    void levelOrderTrversal(){
        Queue<binarynode> queue = new LinkedList<binarynode>();
        queue.add(root);
        // int h = height;

        while(!queue.isEmpty()){



            binarynode presentnode = queue.remove();
            System.out.print(presentnode.data+"  ");
            if(presentnode.left != null){
                queue.add(presentnode.left);
            }
            if(presentnode.right != null){
                queue.add(presentnode.right);
            }
        }
        
    }

    void searchLOT(){
        System.out.print("Enter data to search in tree : ");
        String srch = sc.nextLine();
        Queue<binarynode> queue = new LinkedList<binarynode>();
        queue.add(root);

        while(!queue.isEmpty()){
            binarynode presentnode = queue.remove();
            if(presentnode.data.equals(srch)){
                System.out.println("The element exists in the tree.");
                return;
            }
            if(presentnode.left != null){
                queue.add(presentnode.left);
            }
            if(presentnode.right != null){
                queue.add(presentnode.right);
            }
        }
        System.out.println("The node with that data does not exist in the tree.");
    }

    void insertNode(){
        System.out.print("Enter data in node : ");
        String sn = sc.nextLine();
        binarynode newnode = new binarynode(sn);

        if(root == null){
            root = newnode;
            // height++;
            return;
        }else{
            Queue<binarynode> queue = new LinkedList<binarynode>();
            queue.add(root);
            while(!queue.isEmpty()){
                binarynode presentnode = queue.remove();
                if(presentnode.right==null || presentnode.left== null){
                    if(presentnode.left== null){
                        presentnode.left = newnode;
                        // height++;
                        return;
                    }else if(presentnode.right== null){
                        presentnode.right = newnode;
                        // height++;
                        return;
                    }
                }else{
                    if(presentnode.left != null){
                        queue.add(presentnode.left);
                    }
                    if(presentnode.right != null){
                        queue.add(presentnode.right);
                    }
                }
            }
        }

    }

    // private binarynode deepestNode(){
    //     Queue<binarynode> queue = new LinkedList<binarynode>();
    //     queue.add(root);
    //     binarynode presentnode = null;
    //     while(!queue.isEmpty()){
    //         presentnode = queue.remove();
    //         if(presentnode.left != null){
    //             queue.add(presentnode.left);
    //         }
    //         if(presentnode.right != null){
    //             queue.add(presentnode.right);
    //         }
    //     }
    //     return presentnode;
    // }

    // private void deleteDeepestNode(){
    //     Queue<binarynode> queue = new LinkedList<binarynode>();
    //     queue.add(root);
    //     binarynode prevNode, presentNode = null;
    //     while (!queue.isEmpty()){
    //         prevNode = presentNode;
    //         presentNode = queue.remove();
    //         if(presentNode.left == null){
    //             prevNode.right = null;
    //             return;
    //         }else if(presentNode.right == null){
    //             presentNode.left = null;
    //             return;
    //         }
    //         queue.add(presentNode.left);
    //         queue.add(presentNode.right);
    //     }
    // }

    // void deleteNode(String value){
        
    //     // Queue<binarynode> queue = new LinkedList<binarynode>();
    //     // queue.add(root);
    //     // while(!queue.isEmpty()){
    //     //         binarynode presentNode = queue.remove();
    //     //         System.out.println(presentNode.data);
    //     //         if(presentNode.data == value){
    //     //             presentNode.data = deepestNode().data;
    //     //             deleteDeepestNode();
    //     //             return;
    //     //         }
    //     //         else{
    //     //         if(presentNode.left != null) queue.add(presentNode.left);
    //     //         if(presentNode.right != null) queue.add(presentNode.right);
    //     //         }
    //     // }
    //     // System.out.println("The node to be deleted was not found in the tree.");
    //     // return;

    //     Queue<binarynode> queue = new LinkedList<binarynode>();
    //     queue.add(root);
    //     while (!queue.isEmpty()) {
    //     binarynode presentNode = queue.remove();
    //     if (presentNode.data == value) {
    //     presentNode.data = deepestNode().data;
    //     deleteDeepestNode();
    //     System.out.println("The node is deleted!");
    //     return;
    //     } else {
    //     if (presentNode.left != null) queue.add(presentNode.left);
    //     if (presentNode.right != null) queue.add(presentNode.right);
    //     }
    // }
    // System.out.println("The node does not exist in this BT");

    // }

    void deleteTree(){
        System.out.print("Confirm 1 to delete the tree : ");
        int ch = sc.nextInt();
        if(ch == 1){
            root = null;
            System.out.println("The tree has been deleted.");
        }else{
            System.out.println("No changes were made.");
        }
    }











    public binarynode getDeepestNode() {
        Queue<binarynode> queue = new LinkedList<binarynode>();
        queue.add(root);
        binarynode presentNode = null;
        while (!queue.isEmpty()) {
          presentNode = queue.remove();
          if (presentNode.left != null) {
            queue.add(presentNode.left);
          }
          if (presentNode.right != null) {
            queue.add(presentNode.right);
          }
        }
        return presentNode;
      }
    
      // Delete Deepest node
      public void deleteDeepestNode() {
        Queue<binarynode> queue = new LinkedList<binarynode>();
        queue.add(root);
        binarynode previousNode, presentNode = null;
        while (!queue.isEmpty()) {
          previousNode = presentNode;
          presentNode = queue.remove();
          if (presentNode.left == null) {
            previousNode.right = null;
            return;
          } else if (presentNode.right == null) {
            presentNode.left = null;
            return;
          }
          queue.add(presentNode.left);
          queue.add(presentNode.right);
        }
      }
    
      // Delete Given node
      void deleteNode(String value) {
        Queue<binarynode> queue = new LinkedList<binarynode>();
        queue.add(root);
        while (!queue.isEmpty()) {
          binarynode presentNode = queue.remove();
          if (presentNode.data == value) {
            presentNode.data = getDeepestNode().data;
            deleteDeepestNode();
            System.out.println("The node is deleted!");
            return;
          } else {
            if (presentNode.left != null) queue.add(presentNode.left);
            if (presentNode.right != null) queue.add(presentNode.right);
          }
        }
        System.out.println("The node does not exist in this BT");
      }
}
