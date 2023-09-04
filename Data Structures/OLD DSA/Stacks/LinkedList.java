public class LinkedList {

    public class Node {
        int data;
        Node next;
    }
    public Node head;
    public Node tail;
    public int size;

    public Node createSinglyLinkedList(int value){
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.data = value;
        head = node;
        tail = node;
        size++;
        return head;
    }

    public void insertAtBeginning(int value){
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    public void deleteNodeFromBeginning(){
        head = head.next;
        size--;
        System.out.println("Top Node deleted");
    }
}
