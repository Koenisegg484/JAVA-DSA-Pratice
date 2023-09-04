import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class binarysearchtree {
    binaryNode root;

    Scanner sc =  new Scanner(System.in);
    binarysearchtree(){
        this.root = null;
    }

    private binaryNode insertNode(binaryNode currentNode, int value){
        if(root == null){
            binaryNode newnode = new binaryNode(value);
            root = newnode;
            System.out.println("Inserted Successfully.");
            return newnode;
        }
        if(currentNode == null){
            binaryNode newnode = new binaryNode(value);
            System.out.println("Inserted Successfully.");
            return newnode;
        }else if(value <= currentNode.value){
            currentNode.left = insertNode(currentNode.left, value);
            return currentNode;
        }else{
            currentNode.right = insertNode(currentNode.right, value);
            return currentNode;
        }
    } 

    void insertion(){
        System.out.print("Enter data : ");
        int value = sc.nextInt();
        insertNode(root, value);
    }

    void preOrdertraversal(binaryNode currentNode){
        if(root == null){
            System.out.println("The binary tree is empty.");
            return;
        }
        if(currentNode == null){
            return;
        }
        System.out.print(currentNode.value+ "  ");
        preOrdertraversal(currentNode.left);
        preOrdertraversal(currentNode.right);
    }

    void postOrdertraversal(binaryNode currentNode){
        if(root == null){
            System.out.println("The binary tree is empty.");
            return;
        }
        if(currentNode == null){
            return;
        }
        postOrdertraversal(currentNode.left);
        postOrdertraversal(currentNode.right);
        System.out.print(currentNode.value+ "  ");
    }

    void inOrdertraversal(binaryNode currentnode){
        if(root == null){
            System.out.println("The binary tree is empty.");
            return;
        }
        if(currentnode == null){
            return;
        }
        inOrdertraversal(currentnode.left);
        System.out.print(currentnode.value + "  ");
        inOrdertraversal(currentnode.right);
    }

    void levelOrdertraversal(){
        if(root == null){
            System.out.println("The binary tree is empty.");
            return;
        }
        Queue<binaryNode> queue = new LinkedList<binaryNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            binaryNode currentnode = queue.remove();
            System.out.print(currentnode.value+"  ");
            
            if(currentnode.left!=null){
                queue.add(currentnode.left);
            }
            if(currentnode.right != null){
                queue.add(currentnode.right);
            }
        }
    }

    void searchLot(){
        System.out.print("Enter data to search : ");
        int srch = sc.nextInt();
        
        Queue<binaryNode> qu = new LinkedList<binaryNode>();
        qu.add(root);

        while(!qu.isEmpty()){
            binaryNode presentnode = qu.remove();
            if(presentnode.value == srch ){
                System.out.println("The node exists in the tree.");
                return;
            }else{
                if(presentnode.left != null) qu.add(presentnode.left);
                if(presentnode.right != null) qu.add(presentnode.right);
            }
        }

        System.out.println("The node does not exist in the tree.");
    }

    binaryNode minimumNode(binaryNode node){
        if(node.left == null){
            return node;
        }else{
            return minimumNode(node.left);
        }
    }

    binaryNode deleteNode(binaryNode root1, int value){
        
        // if(root1 == null){
        //     System.out.println("The tree is empty. No nodes to delete.");
        //     return null;
        // }

        if(root1.value > value){
            root1.left = deleteNode(root1.left, value);
        }else if(root1.value < value){
            root1.right = deleteNode(root1.right, value);
        }else{
            if(root1.left != null && root1.right != null){
                binaryNode tempnode = root1;
                binaryNode minnodeforRight = minimumNode(tempnode.right);
                root1.value = minnodeforRight.value;
                root1.right = deleteNode(root1.right, minnodeforRight.value);
            }else if(root1.left != null){
                root1 = root1.left;
            }else if(root1.right != null){
                root1 = root1.right;
            }else{
                root1 = null;
            }
        }

        return root1;
    }

    void deletion(){
        if(root == null){
            System.out.println("The binary tree is empty.");
            return;
        }
        System.out.print("Enter data of node to delete it : ");
        int del = sc.nextInt();
        deleteNode(root, del);
    }

    void deleteTree(){
        System.out.println("Confirm 1 to delete the whole tree : ");
        int ch = sc.nextInt();
        if(ch == 1){
            root = null;
            System.out.println("The tree has been deleted.");
        }else{
            System.out.println("No changes were made to the tree.");
        }
    }
}
