import java.util.*;

public class BreadthFirstSearch {

    public static void main(String[] args) {

        Node nodeTelAviv = new Node("TelAviv", 0);
        Node nodeParis = new Node("Paris", 1);
        Node nodeMilan = new Node("Milan", 2);
        Node nodeNewYork = new Node("NewYork", 3);
        Node nodeRome = new Node("Rome", 4);
        Node nodeYerushalayim = new Node("Yerushalayim", 5);

        nodeTelAviv.connect(new Node("NewYork", 500));
        nodeTelAviv.connect(nodeNewYork);
        nodeTelAviv.connect(nodeMilan);

        nodeParis.connect(new Node("Yerushalayim", 350));
        nodeParis.connect(nodeYerushalayim);
        nodeParis.connect(nodeMilan);

        nodeMilan.connect(new Node("Rome", 150));
        nodeMilan.connect(nodeRome);
        nodeMilan.connect(nodeParis);

        nodeNewYork.connect(new Node("Milan", 400));
        nodeNewYork.connect(new Node("Rome", 450));
        nodeNewYork.connect(nodeTelAviv);

        nodeRome.connect(new Node("Paris", 200));
        nodeRome.connect(nodeMilan);
        nodeRome.connect(nodeParis);

        nodeYerushalayim.connect(new Node("Paris", 200));
        nodeYerushalayim.connect(new Node("Milan", 500));
        nodeYerushalayim.connect(nodeMilan);

        BreadthFirstSearch.search(nodeParis, nodeTelAviv);
    }

    public static <T> boolean search(Node startVertex, Node endVertex) {
    	
        Queue<Node> queue = new ArrayDeque<>();
        // setting found to false
        boolean found = false;
        // clearing all marks
        Set<Node> adjacents = new HashSet<>();
        // marking the startVertex
        adjacents.add(startVertex);
        // enqueue the startVertex into the queue
        queue.add(startVertex);
        Node currentVertex;
        
        // do while !queue.isEmpty() AND !found
        while (!queue.isEmpty() && !found) {
            // set current vertex = queue.dequeue()
            currentVertex = queue.remove();
            System.out.println("Visited node: " + currentVertex);
            // if current vertex equals endVertex, then setting found to true
            if (currentVertex.getValue() == endVertex.getValue()) {
                found = true;
            } 
            else {
                // if adjacent vertex is not marked, marking the adjacent vertex
                adjacents.add(currentVertex);
                // enqueue it into the queue
                queue.addAll(currentVertex.getAdjacents());
                queue.removeAll(adjacents);
            }
        }
        return found;
    }
}


