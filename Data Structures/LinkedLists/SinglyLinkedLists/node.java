public class node{
        public int data;
        public node next;
        // node prev;

        node(){
            this.next = null;
            // this.prev = null;
        }
        node(int value){
            this.data = value;
            this.next = null;
        }
}
