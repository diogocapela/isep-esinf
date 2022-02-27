
package graph;

import java.util.LinkedList;

/**
 *
 * @author DEI-ESINF
 */
public class EdgeAsDoubleGraphAlgorithms {

    /**
     * Determine the shortest path to all vertices from a vertex using Dijkstra's algorithm
     * To be called by public short method
     *
     * @param graph Graph object
     * @param sourceIdx Source vertex 
     * @param knownVertices previously discovered vertices
     * @param verticesIndex index of vertices in the minimum path
     * @param minDist minimum distances in the path
     *
     */
    private static <V> void shortestPath(AdjacencyMatrixGraph<V,Double> graph, int sourceIdx, boolean[] knownVertices, int[] verticesIndex, double [] minDist)	{  
		throw new UnsupportedOperationException("Not supported yet.");	
    }


    /**
     * Determine the shortest path between two vertices using Dijkstra's algorithm
     *
     * @param graph Graph object
     * @param source Source vertex 
     * @param dest Destination vertices
     * @param path Returns the vertices in the path (empty if no path)
     * @return minimum distance, -1 if vertices not in graph or no path
     *
     */
    public static <V> double shortestPath(AdjacencyMatrixGraph<V, Double> graph, V source, V dest, LinkedList<V> path){
		throw new UnsupportedOperationException("Not supported yet.");	
    }


    /**
     * Recreates the minimum path between two vertex, from the result of Dikstra's algorithm
     * 
     * @param graph Graph object
     * @param sourceIdx Source vertex 
     * @param destIdx Destination vertices
     * @param verticesIndex index of vertices in the minimum path
     * @param Queue Vertices in the path (empty if no path)
     */
    private static <V> void recreatePath(AdjacencyMatrixGraph<V, Double> graph, int sourceIdx, int destIdx, int[] verticesIndex, LinkedList<V> path){

        path.add(graph.vertices.get(destIdx));
        if (sourceIdx != destIdx){
            destIdx = verticesIndex[destIdx];        
            recreatePath(graph, sourceIdx, destIdx, verticesIndex, path);
        }
    }

    /**
     * Creates new graph with minimum distances between all pairs
     * uses the Floyd-Warshall algorithm
     * 
     * @param graph Graph object
     * @return the new graph 
     */

    public static <V> AdjacencyMatrixGraph<V, Double> minDistGraph(AdjacencyMatrixGraph<V, Double> graph){
            throw new UnsupportedOperationException("Not supported yet.");	
    }


}
