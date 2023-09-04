import java.util.ArrayList;

public class treenode{
    
    String data;
    ArrayList<treenode> child;
    
    treenode(String value){
        this.data = value;
        this.child = new ArrayList<treenode>();
    }

    public void addNode(treenode child1){
        this.child.add(child1);
    }

    public String printnode(int level){
        String ret;
        ret = "|"+"_".repeat(level)+data+"\n";

        for (treenode node : this.child){
            ret+= node.printnode(level+1);
        }

        return ret;
    }
}