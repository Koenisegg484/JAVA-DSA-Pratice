public class node {
    public int data;
    public node prev;
    public node next;

    node (){
        this.next = null;
        this.prev = null;
    }
    node (int value){
        this.data = value;
        this.next = null;
        this.prev = null;
    }
}