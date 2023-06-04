
package AirFreightApp;

import GraphFrameWrok.Edge;
import GraphFrameWrok.Vertex;

/**
 *
 * @author danaa
 */
public class Route extends Edge{
    
    public Route(Vertex source, Vertex destination, int weight) {
        super(source, destination, weight);
    }
    
    @Override
    public void displayInfo(){
        System.out.println
       ("-------------------------------------------------\n"
       + (destination.label + " --- route length: " + weight)
       + "\n---------------------------------------------------\n");
    }
}
