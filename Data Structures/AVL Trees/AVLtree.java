// import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AVLtree {
    Scanner sc = new Scanner(System.in);
    avlnode root;

    void levelOrdertraversal(){
        // ArrayList<avlnode> array = new ArrayList<avlnode>(10);
        if(root == null){
            System.out.println("The Tree is empty.");
            return;
        }
        Queue<avlnode> queue = new LinkedList<avlnode>();
        queue.add(root);
        // array.add(0, root);
        // int i = 0;

        while(!queue.isEmpty()){
            avlnode tempnode = queue.remove();
            System.out.print(tempnode.value+"  ");
            // array.add(i, tempnode);
            // i++;
            
            if(tempnode.left != null){
                queue.add(tempnode.left);
            }
            if(tempnode.right != null){
                queue.add(tempnode.right);
            }
        }

        // System.out.println(array);

        // for(int j=0; j<array.size(); j++){
        //         if(j != 0 && array.get(j).height != array.get(j-1).height){
        //         System.out.println();
        //     }
        //     System.out.print(array.get(j).value+"  ");
        // }
    }

    private int getHeight(avlnode node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    // Rotate right
    private avlnode rotateRight(avlnode disbalancedNode){
        avlnode newRoot = disbalancedNode.left;
        disbalancedNode.left = newRoot.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot;
    }

    private avlnode rotateLeft(avlnode disbalancedNode){
        avlnode newRoot = disbalancedNode.right;
        disbalancedNode.right = newRoot.left;
        newRoot.left = disbalancedNode;

        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot;
    }

    private int getBalance(avlnode node){
        if(node == null) return 0;
        
        return getHeight(node.left) - getHeight(node.right);
    }

    private avlnode insertNode(avlnode node, int value){
        if(root == null){
            avlnode nn = new avlnode(value);
            root = nn;
            root.height = 1;
            return nn;
        }
        if (node == null){
            avlnode nn = new avlnode(value);
            node = nn;
            node.height = 1;
            return nn;
        }else if(value <= node.value){
            node.left = insertNode(node.left, value);
        }else{
            node.right = insertNode(node.right, value);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        if(balance > 1 && value < node.left.value){//Left Left Condition
            return rotateRight(node);
        }
        
        if(balance > 1 && value > node.left.value){//Left Right Condition
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        
        if(balance < -1 && value > node.right.value){
            return rotateLeft(node);
        }

        if(balance < -1 && value < node.right.value){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    void insertion(){

        System.out.print("Enter data : ");
        int value = sc.nextInt();
        root = insertNode(root, value);


        // System.out.print("How many elements you want to enter in the AVL Tree : ");
        // int size = sc.nextInt();

        // int array[] = new int[size];
        // for (int i=0; i<size; i++){
        //     System.out.print("Enter data : ");
        //     array[i] = sc.nextInt();
        // }

        // for (int i=0; i<size; i++){
        //     insertNode(root, array[i]);
        // }
    }

    private avlnode minimumInTheRight(avlnode node){
        if(node.left == null){
            return node;
        }else{
            return minimumInTheRight(node.left);
        }
    }

    private avlnode deleteNode(avlnode node, int toDelete){
        if (root == null){
            System.out.println("The tree is empty.");
            return null;
        }
        if(root.left==null && root.right==null && toDelete == root.value){
            // root.value = Integer.MIN_VALUE;
            root = null;
            return null;
        }
        if(node == null){
            System.out.println("The avl tree does not exist...");
            return null;
        }
        if(toDelete < node.value){
            node.left = deleteNode(node.left, toDelete);
        }else if(toDelete > node.value){
            node.right = deleteNode(node.right, toDelete);
        }else{
            if(node.left != null && node.right != null){
                avlnode tempnode = node.right;
                avlnode minimumNode = minimumInTheRight(tempnode);
                node.value = minimumNode.value;
                root.right = deleteNode(node.right, minimumNode.value);
            }else if(node.left !=  null){
                node = node.left;
            }else if(node.right != null){
                node = node.right;
            }else{
                return null;
            }
        }

        int balance = getBalance(node);
        
        // Left Left Condition
        if (balance>1 && getBalance(node.left)>=0){
            return rotateRight(node);
        }
        if(balance>1 && getBalance(node.left)<=0){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if(balance<-1 && getBalance(node.right)<=0){
            return rotateLeft(node);
        }
        if(balance<-1 && getBalance(node.right)>=0){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    void deletion(){
        System.out.print("Enter data to delete : ");
        int toDel = sc.nextInt();
        deleteNode(root, toDel);
    }

    void deleteWhole(){
        System.out.print("Confirm 1 to delete the whole avl Tree : ");
        int ch = sc.nextInt();
        if(ch == 1){
            this.root = null;
        }else{
            System.out.println("No changes wer made to the AVL Tree.");
        }
    }

    void searchLOT(avlnode node, int srch){

        if(node.value == srch){
            System.out.println("The value exists in the tree.");
            return;
        }else if(srch < node.value){
            searchLOT(node.left,srch);
        }else if(srch > node.value){
            searchLOT(node.right, srch);
        }

        System.out.println("The value does not exist in the AVL Tree.");
        return;
    }


}