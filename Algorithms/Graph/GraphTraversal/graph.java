import java.util.ArrayList;
import java.util.LinkedList;

public class graph {
    ArrayList<graphNode> nodeList = new ArrayList<graphNode>();   
    int adjacencyMatrix[][];

    graph(ArrayList<graphNode> abc){
        adjacencyMatrix = new int[abc.size()][abc.size()];
        this.nodeList = abc;
    }
    
    public void undirectedEdge(int i, int j){
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    public void printAdjacencyMatrix(){
        System.out.println("   A  B  C  D  E");
        for(int i=0; i<nodeList.size();  i++){
            System.out.print(nodeList.get(i).name+ " : ");
            for(int j=0; j<nodeList.size(); j++){
                System.out.print(adjacencyMatrix[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public ArrayList<graphNode> getNeighbours(graphNode node){
        ArrayList<graphNode> neighbours = new ArrayList<graphNode>();
        int ind = node.index;
        for(int i=0; i<adjacencyMatrix.length; i++){
            if(adjacencyMatrix[ind][i] == 1){
                neighbours.add(nodeList.get(i));
            }
        }

        return neighbours;
    }

    void breadthFirstSearch(graphNode node){
        LinkedList<graphNode> queue = new LinkedList<graphNode>();
        queue.add(node);
        while(!queue.isEmpty()){
            graphNode currNode = queue.remove(0);
            currNode.isVisited = true;
            System.out.println(currNode.name);
            ArrayList<graphNode
        }
    }
}