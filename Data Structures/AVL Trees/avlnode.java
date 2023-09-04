public class avlnode {
    int value;
    int height;
    avlnode left;
    avlnode right;

    avlnode(int value){
        this.value = value;
        this.height = 0;
        this.left = null;
        this.right = null;
    }
}
