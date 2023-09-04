import java.util.ArrayList;

public class graph{

    ArrayList<graphNode> nodeList = new ArrayList<graphNode>();

    public graph(ArrayList<graphNode> nodelist){
        this.nodeList = nodelist;
    }

    public void addUndirectedNode(int i, int j){
        graphNode first = nodeList.get(i);
        graphNode second = nodeList.get(j);

        first.neighbours.add(second);
        second.neighbours.add(first);
    }

    public String printAdjacencyMatrix(){
        StringBuilder s = new StringBuilder();
        for(int i=0; i<nodeList.size(); i++){
            s.append(nodeList.get(i).name+ " :");
            for (int j=0; j<nodeList.get(i).neighbours.size(); j++){
                if(j == nodeList.get(i).neighbours.size()-1){
                    s.append(nodeList.get(i).neighbours.get(j).name);
                }else{
                    s.append(nodeList.get(i).neighbours.get(j).name+" -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}