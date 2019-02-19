package graphexamples;

import graphbase.Edge;
import graphbase.Graph;
import static graphbase.GraphAlgorithms.DepthFirstSearch;
import java.util.Queue;

/**
 *
 * @author DEI-ESINF
 */

public class AirportNet {
    
   private Graph<String, Integer> airport;
   
   public AirportNet(){
        airport = new Graph<>(true) ; 
    }
    
    public void addAirport(String a){
       
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void addRoute(String a1, String a2, double miles, Integer npasseng){
      
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public int keyAirport(String airp){
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String airportbyKey(int key){
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Integer trafficAirports(String airp1, String airp2){
        
       throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Double milesAirports(String airp1, String airp2){
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String nroutesAirport(){
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
                             
    public String AirpMaxMiles( ){
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Boolean ConnectAirports(String airp1, String airp2){
       
       throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String toString() {
        return airport.toString();
    }    
}
