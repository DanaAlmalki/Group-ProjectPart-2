package GraphFrameWrok;

import AirFreightApp.Location;
import AirFreightApp.Route;
import java.util.*;

import java.io.*;

public class Graph {

    // number of vertices of the graph
    private int verticesNo;

    // number of edges of the graph
    private int edgeNo;

    // set to true if the graph is directed graph, and set to false if the graph is undirected
    private boolean isDigraph;

    // list/vectorrepresenting the list of vertices of a graph.
    private List<Vertex> vertices;

    // list of all edges of a graph.
    private List<Edge> edges;

    //constructor  
    public Graph() {

        // Initialize the number of vertices and edges to 0.
        this.verticesNo = 0;
        this.edgeNo = 0;

        // set Graph UnDigraph
        this.isDigraph = false;

        // Create a list to store the vertices.
        this.vertices = new ArrayList<>();
        
        // Create a list to store the edges.
        this.edges = new ArrayList<>();

    }

    // Add Edge Function 
    public void addEdge(Vertex source, Vertex destination, int weight) {
        // create edge  object 
        Edge edge1 = createEdge(source, destination, weight);
        // add an adjacent vertex
        source.addAdjacentVertex(edge1);
        // add to edges list
        edges.add(edge1);
//        // If the graph is not directed, add the edge in the opposite direction too.
//        if (!isDigraph) {
//            // create edge  object 
//            Edge edge2 = createEdge(destination, source, weight);
//            // add an adjacent vertex
//            destination.addAdjacentVertex(edge2);
//            // add to edges list
//            edges.add(edge2);
//            // increment number of edges
//            this.edgeNo++;
//        }
        // increment number of edges
        this.edgeNo++;
    }

    // Make Graph Function 
    public void makeGraph(int verticesNo, int edgeNo) {
        
        // Set vertices number
        setVerticesNo(verticesNo);

        // Randomly initialize the vertices' labels
        for (int i = 0; i < verticesNo; i++) {
            int vertexLabel = i + 1 ;
            vertices.add(createVertex(vertexLabel));
        }
        int s, t, weight;
            // create connected graph on purpose
            for (int i = 0; i < verticesNo - 1; i++) {
                addEdge(vertices.get(i), vertices.get(i + 1), ((int) (Math.random() * 40) + 1));
            }
            // Create edges that connects the created vertices randomly and assigning them random weights
            for (int i = 0; i < edgeNo - (verticesNo - 1); i++) {
                // prevent adding an edge between a vertex and itself
                do {
                    s = (int) (Math.random() * verticesNo);
                    t = (int) (Math.random() * verticesNo);
                } while (s == t);
                // make sure there is no duplicate edges
                Vertex sourceVertex = vertices.get(s);
                Vertex targetVertex = vertices.get(t);
                int label = targetVertex.getLabel();

                if (!sourceVertex.edgeExist(label)) {
                    weight = (int) (Math.random() * 40) + 1;
                    addEdge(sourceVertex, targetVertex, weight);
                } else {
                    i--;
                }
            }
    }

    //Read Graph Frome File Function 
    public void readGraphFromFile(File fileName) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(fileName)) {
            // check if graph is directed 
            if ("1".equals(scanner.next())) {
                isDigraph = true;
            }
            // read number of vertices
            verticesNo = Integer.parseInt(scanner.next());
            // read number of edges
            edgeNo = Integer.parseInt(scanner.next());
            scanner.nextLine();
            // read and add vertices and edges
            while (scanner.hasNext()) {
                // get vertices labels
                int source = ((int) scanner.next().charAt(0)) - 64;
                int destination = ((int) scanner.next().charAt(0)) - 64;
                // check that it was not added before
                if (vertices.size() < source) {
                    vertices.add(createVertex(source));
                }
                if (vertices.size() < destination) {
                    vertices.add(createVertex(destination));
                }
                // read the weight
                int weight = Integer.parseInt(scanner.next());
                // add a new edge
                addEdge(vertices.get(source - 1), vertices.get(destination - 1), weight);
            }
        }
    }

    public void printGraph() {
        vertices.forEach((vertex) -> {
            vertex.displayInfo();
        });
    }

    public void addVertex(Vertex vertex) {
        this.vertices.add(vertex);

        this.verticesNo++;
    }

    public int getVerticesNo() {
        return this.verticesNo;
    }

    public void setVerticesNo(int verticesNo) {
        this.verticesNo = verticesNo;
    }

    public int getEdgeNo() {
        return edgeNo;
    }

    public void setEdgeNo(int edgeNo) {
        this.edgeNo = edgeNo;
    }

    public boolean isDigraph() {
        return isDigraph;
    }

    public void setDigraph(boolean isDigraph) {
        this.isDigraph = isDigraph;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public boolean AllVisited() {
        for (int i = 0; i < vertices.size(); i++) {
            if (!vertices.get(i).isVisited()) {
                return false;
            }
        }
        return true;
    }
    
    public Edge createEdge(Vertex source, Vertex destination, int weight) {
        return new Route(source, destination, weight);
    }

    public Vertex createVertex(int label) {
        return new Location(label);
    }

}