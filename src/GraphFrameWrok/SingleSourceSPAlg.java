package GraphFrameWrok;

import java.util.PriorityQueue;

import java.util.*;

public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    int infinity = 1000000;
    Vertex source;
    PriorityQueue<Vertex> pq;
    List<Vertex> v;
    Vertex[] ResultVertices;
    String[] paths;

    // Constructor
    public SingleSourceSPAlg(Graph graph) {
        this.graph = graph;
        this.v = graph.getVertices();
        paths = new String[v.size()];
    }

    // Dijkstra Algorithm method
    public void computeDijkstraAlg(Vertex source) {
        // initialize the source
        this.source = source;

        // initialize priority queue with comparator of key: cost
        pq = new PriorityQueue<>(Comparator.comparingInt((Vertex o) -> o.cost));
        
        // initialize result list
        ResultVertices = new Vertex[v.size()];

        // initialize the paths array
        for (int i = 0; i < paths.length; i++) {
            paths[i] = "loc. " + (char) (source.label + 64) + ": city " + source.label;
        }

        // set the cost of all graph vertices to infinity
        for (int i = 0; i < graph.getVerticesNo(); i++) {
            v.get(i).setCost(infinity);
        }

        // set the source cost to 0
        source.setCost(0);

        Vertex vertex = source;
        pq.add(vertex);

        // for each vertex in the graph
        while (!pq.isEmpty()) {
            // extract the minimum cost vertex u
            vertex = pq.peek();
            pq.remove();
            // add it to the result list
            ResultVertices[vertex.label - 1] = vertex;
            // for each vertex adjacent to u
            for (int j = 0; j < vertex.getNoAdjacentVertices(); j++) {
                // extract the neighboring vertex
                Edge edge = vertex.adjacentVertices.get(j);
                Vertex adj = edge.destination;
                // if the cost of the vertex is greater than the cost
                // of u + the weight of the edge between them
                if ((vertex.cost + edge.weight) < adj.cost) {
                    // update the cost of the vertex to the cost 
                    // of u + the weight of the edge between them
                    int cost = vertex.getCost() + edge.getWeight();
                    adj.setCost(cost);
                    // store the path
                    paths[adj.getLabel() - 1] = (paths[vertex.getLabel() - 1] + " - loc. " + (char) (adj.getLabel() + 64) + ":"
                            + " city " + adj.getLabel());
                    // update the queue
                    pq.add(adj);
                }
            }
        }
        // display the result
        display();
    }

    // diplay the paths to each vertex from the source
    public void display() {
        char s = (char) (source.getLabel() + 64);
        System.out.println("The starting point location is " + s
                + "\nThe routes from location " + s + " to the rest of the locations are:");
        for (int i = 0; i < ResultVertices.length; i++) {
            Vertex vx = ResultVertices[i];
            // in the entry is null there no solution i.e. no path
            if (vx == null) {
                System.out.println("*NO PATH!*" + paths[i]);
                continue;
            }
            if (vx.equals(source)) {
                continue;
            }
            System.out.print(paths[i]);
            System.out.println(" --- route length: " + vx.getCost());
        }
        System.out.println("");
    }
}
