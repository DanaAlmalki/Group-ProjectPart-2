/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphFrameWrok;

import java.util.List;

/**
 *
 * @author danaa
 */
public class DBAllSourceSPAlg extends ShortestPathAlgorithm {
    
    List<Vertex> v;
    
    // constructor
    public DBAllSourceSPAlg(Graph graph){
        this.graph = graph;
    }
    
    public void computeDijkstraBasedSPAlg(){
        // get list of vertices
        v = graph.getVertices();
        
        // iterate over the vertices
        for (int i = 0; i < v.size(); i++) {
            // apply Dijkstra algorithm to each vertex as the source
            SingleSourceSPAlg m = new SingleSourceSPAlg(graph);
            m.computeDijkstraAlg(graph.getVertices().get(i));
        }
    }
}
