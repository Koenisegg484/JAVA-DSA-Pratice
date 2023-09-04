public class binarynode {

    String data;
    binarynode left;
    binarynode right;
    int height;

    binarynode(String value){
        this.data = value;
        this.left = null;
        this.right = null;
        this.height = 0;
    }

    // void addnodel(binarynode children){
    //     if(this.left == null){
    //         this.left = children;
    //     }else{
    //         System.out.println("There is already a child of this node, do you want to update\n(y/n)");
    //         String y = "";
    //         if(sc.nextLine() == y){
    //             this.left = children;
    //         }
    //     }
    // }
    // void addnoder(binarynode children){
    //     if(this.right == null){
    //         this.right = children;
    //     }else{
    //         System.out.println("There is already a child of this node, do you want to update\n(y/n)");
    //         String y = "";
    //         if(sc.nextLine() == y){
    //             this.right = children;
    //         }
    //     }
    // }

    
}
