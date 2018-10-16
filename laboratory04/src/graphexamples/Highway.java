
package graphexamples;

/**
 * A class to represent highways  
 * Stores name, distance (km) and cost (euro)
 * when used in a map, different parts of the same highway, connecting different cities, have the same name
 * distinction needs to be done with distance and/or cost (this is how it is implemented in the tests)
 * another approach could be to use different names for different parts of the highway
 * or add an id to represent different stretches
 *
 * @author DEI-ESINF
 */
public class Highway {

	public String name;
	public double distance;
	public double cost;
	
	public Highway(String n, double dist, double cst){
		name = n;
		distance = dist;
		cost = cst;
	}
}