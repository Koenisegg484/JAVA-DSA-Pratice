import java.util.ArrayList;

public class graph {

    int adjacencyMatrix[][];
    ArrayList<graphNode> graphList;

    graph(ArrayList<graphNode> tempGraph){
        this.graphList = tempGraph;
        this.adjacencyMatrix = new int[graphList.size()][graphList.size()];
    }

    public void undirectedEdge(int i, int j){
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    public void printAdjacencyMatrix(){
        System.out.println("   A  B  C  D  E");
        for(int i=0; i<graphList.size();  i++){
            System.out.print(graphList.get(i).name+ " : ");
            for(int j=0; j<graphList.size(); j++){
                System.out.print(adjacencyMatrix[i][j]+"  ");
            }
            System.out.println();
        }
    }

    // public void addNode(){
    //     System.out.print("Enter string : ");
    //     String name = sc.nextLine();
    //     System.out.print("Enter its index : ");
    //     int index = sc.nextInt();

    //     graphNode nn = new graphNode(name, index);
    //     graphList.add(nn);

    // }

}
