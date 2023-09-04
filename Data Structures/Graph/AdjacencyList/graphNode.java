import java.util.ArrayList;

class graphNode{
    String name;
    int index;

    ArrayList<graphNode> neighbours = new ArrayList<graphNode>();

    graphNode(String name, int ind){
        this.name = name;
        this.index = ind;
    }
}