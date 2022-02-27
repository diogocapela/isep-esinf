package graphexamples;

import graph.AdjacencyMatrixGraph;
import java.util.LinkedList;

/**
 * A class to represent maps of cities and connecting highways Stores a graph of
 * String vertex and Highway edges Does not support multiple highways between
 * the same cities
 */
public class HighwayMap implements Cloneable {

    AdjacencyMatrixGraph<String, Highway> map;

    public HighwayMap() {
        map = new AdjacencyMatrixGraph<String, Highway>();
    }

    /**
     * Returns the number of cities in the map
     *
     * @return number of cities in the map
     */
    public int numCities() {
        return map.numVertices();
    }

    /**
     * Inserts a new city in the map. Fails if city already exists
     *
     * @param city
     * @return false if city exists in the map
     */
    public boolean insertCity(String city) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Inserts a new highway in the map fails if already exists
     *
     * @param from the source city
     * @param to the destination city
     * @param name of highway
     * @param distance distance in km
     * @param cost cost in euros
     * @return false if a city does not exist or highway already exists between
     * cities
     */
    public boolean insertHighway(String from, String to, String name, double distance, double cost) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the highways that depart from a city
     *
     * @param city
     * @return List of Highways
     */
    public Iterable<Highway> departingHighways(String city) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the direct connections of a city
     *
     * @param city
     * @return list of cities
     */
    public Iterable<String> oneHopConnections(String city) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns if two cities are connected with a path of highways
     *
     * @param from the departing city
     * @param to the destination city
     * @return List of stops (null if cities do not exist, empty if no path)
     */
    public Iterable<String> existsConnection(String from, String to) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the path between two cities with the minimum number of highways
     *
     * @param from the departing city
     * @param to the destination city
     * @return minimum number of connecting cities, null if cities do not exist
     * or are not connected
     */
    public Iterable<String> travelViaMinimumNumberOfHighways(String from, String to) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the path between two cities with the minimum distance
     *
     * @param from the departing city
     * @param to the destination city
     * @param path list of connecting cities
     * @return distance (-1 case of wrong cities)
     */
    public double minimumDistance(String from, String to, LinkedList<String> path) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the path between two cities with the minimum cost
     *
     * @param from the departing city
     * @param to the destination city
     * @param path list of connecting cities
     * @return cost (-1 case of wrong cities)
     */
    public double minimumCost(String from, String to, LinkedList<String> path) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns a clone of the graph (a shallow copy).
     *
     * @return the new cloned map
     */
    @SuppressWarnings("unchecked")
    public HighwayMap clone() {
        HighwayMap newMap = new HighwayMap();
        newMap.map = (AdjacencyMatrixGraph<String, Highway>) map.clone();
        return newMap;
    }

    /**
     * Implementation of equals
     *
     * @param the other map to test for equality
     * @return true if both objects represent the same map
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof HighwayMap)) {
            return false;
        }

        return map.equals(((HighwayMap) obj).map);
    }
}
