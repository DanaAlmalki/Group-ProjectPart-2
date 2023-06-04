
package AirFreightApp;

import GraphFrameWrok.Vertex;

public class Location extends Vertex{
    public String city;

    public Location(int label) {
        super(label);
        this.city = "Loc" + label; 
    }
    
    @Override
    public void displayInfo(){
        System.out.println
        ("-------------------------------------------------\n"
       + "C: city " + label
       + "\n-------------------------------------------------");
        adjacentVertices.forEach((adjacentVertice) -> {
            adjacentVertice.displayInfo();
        });
    } 
}
