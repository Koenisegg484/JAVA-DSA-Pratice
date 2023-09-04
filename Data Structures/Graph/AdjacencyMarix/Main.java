import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void printElements(ArrayList<graphNode> gn1){
        for(graphNode gn : gn1){
            System.out.println(gn.name + "  index: "+ gn.index);
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("This is an implementation of graph.");
        ArrayList<graphNode> nodeList = new ArrayList<graphNode>();
        System.out.print("Eter the number you want to input in the graph : ");
        int i = sc.nextInt();
        for(int j=0; j<i; j++){
            System.out.print("Enter the string input : ");
            String name = sc.next();
            nodeList.add(new graphNode(name, j));
        }

        graph g = new graph(nodeList);
        System.out.println("Printing the graph elements.");
        printElements(nodeList);
        int ch = 0;
        while(ch != 3){
            System.out.print("Press 1 for joining two nodes, press 2 for printing the graph elements, press 2 for exitting : ");
            ch = sc.nextInt();
            switch(ch){
                case 1:
                System.out.print("Enter the first index : ");
                int f = sc.nextInt();
                System.out.print("Enter the second index : ");
                int s = sc.nextInt();
                g.undirectedEdge(f, s);
                System.out.println("The nodes have been connected.");
                break;

                case 2:
                printElements(nodeList);
                break;

                case 3: 
                break;

                default:
                System.out.println("Enter the right choice.");
                break;
            }
        }
        g.printAdjacencyMatrix();

        sc.close();
    }
}
