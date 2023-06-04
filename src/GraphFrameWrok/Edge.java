/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphFrameWrok;

public class Edge {

    public Vertex source;
    public Vertex destination;
    public Vertex parent;
    public int weight; 

    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.parent = null;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public void displayInfo() {
        System.out.println("Source vertex: " + source + ", Destination vertex: " + destination + ", Parent vertex: " + parent + ", Weight: " + weight);
    }

}
