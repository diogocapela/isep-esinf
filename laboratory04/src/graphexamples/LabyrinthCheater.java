
package graphexamples;

import graph.AdjacencyMatrixGraph;
import java.util.LinkedList;

/**
 * A class to represent a labyrinth map with rooms, doors and exits
 * Methods discover the nearest exit and the path to it
 * Stores a graph of private Room vertex and Door edges
 *
 * @author DEI-ESINF
 * 
 */
public class LabyrinthCheater {

    private class Room{
    }

    private class Door{
    }

    AdjacencyMatrixGraph<Room, Door> map;

    public LabyrinthCheater(){
        map = new AdjacencyMatrixGraph<Room, Door>();
    }

    /**
     * Inserts a new room in the map
     * @param city
     * @return false if city exists in the map
     */
    public boolean insertRoom(String name, boolean hasExit){
        throw new UnsupportedOperationException("Not supported yet.");	
    }

    /**
     * Inserts a new door in the map
     * fails if room does not exist or door already exists
     * @param from room
     * @param to room
     * @return false if a room does not exist or door already exists between rooms
     */
    public boolean insertDoor(String from, String to){
        throw new UnsupportedOperationException("Not supported yet.");	
    }

    /**
     * Returns a list of rooms which are reachable from one room
     * @param room 
     * @return list of room names or null if room does not exist
     */
    public Iterable<String> roomsInReach(String room){
        throw new UnsupportedOperationException("Not supported yet.");	
    }

    /**
     * Returns the nearest room with an exit
     * @param room from room
     * @return room name or null if from room does not exist or there is no reachable exit
     */
    public String nearestExit(String room){
        throw new UnsupportedOperationException("Not supported yet.");	
    }

    /**
     * Returns the shortest path to the nearest room with an exit
     * @param room from room
     * @return list of room names or null if from room does not exist or there is no reachable exit
     */
    public LinkedList<String> pathToExit(String from){
        throw new UnsupportedOperationException("Not supported yet.");	
    }
	
}
