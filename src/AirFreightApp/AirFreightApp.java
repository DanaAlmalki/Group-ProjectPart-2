
package AirFreightApp;

import GraphFrameWrok.DBAllSourceSPAlg;
import java.io.File;
import java.io.FileNotFoundException;

public class AirFreightApp {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // create AFRouteMap object
        AFRouteMap map = new AFRouteMap();
        // create file object
        File f = new File("DI.txt");
        // read graph from file
        map.readGraphFromFile(f);
        // create DBAllSourceSPAlg
        DBAllSourceSPAlg d = new DBAllSourceSPAlg(map);
        // call method to compute paths of all possible sources
        d.computeDijkstraBasedSPAlg();
    }   
}
