package GraphFrameWrok;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vertex implements Comparable<Vertex>{

    public int label;
    public boolean isVisited;
    public List<Edge> adjacentVertices;
    public int cost;
    
    public Vertex(int label) {
        this.label = label;
        this.isVisited = false;
        this.adjacentVertices = new ArrayList<>();
        this.cost = 0;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public List<Edge> getAdjacentVertices() {
        Collections.sort(adjacentVertices, (e1, e2) -> e1.getWeight() - e2.getWeight());
        return adjacentVertices;
    }
    public int getNoAdjacentVertices(){
    return adjacentVertices.size();
    }
    
    public void setAdjacentVertices(List<Edge> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }
    
    public void addAdjacentVertex(Edge edge) {
        adjacentVertices.add(edge);
    }
    
    // check if an edge exist with vertex of label d as destination 
    public boolean edgeExist(int d){
        for (Edge adjacentVertice : adjacentVertices) {
            if (adjacentVertice.getDestination().getLabel()==d) {
                return true;
            }
        }
        return false;
    }    
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return label + "";
    }
    
    public void displayInfo() {
        
    }

    @Override
    public int compareTo(Vertex t) {
        if (this.cost <= t.cost) {
                return -1;
            }
            else {
                return 1;
            }
    }

}