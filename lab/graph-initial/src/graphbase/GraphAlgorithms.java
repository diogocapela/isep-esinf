/*
* A collection of graph algorithms.
 */
package graphbase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author DEI-ESINF
 */
public class GraphAlgorithms {

    /**
     * Performs breadth-first search of a Graph starting in a Vertex
     *
     * @param g Graph instance
     * @param vInf information of the Vertex that will be the source of the
     * search
     * @return qbfs a queue with the vertices of breadth-first search
     */
    public static <V, E> LinkedList<V> BreadthFirstSearch(Graph<V, E> g, V vert) {

        if (!g.validVertex(vert)) {
            return null;
        }

        LinkedList<V> resultQueue = new LinkedList<>();

        boolean[] knownVertices = new boolean[g.numVertices()];
        Arrays.fill(knownVertices, Boolean.FALSE);

        LinkedList<V> auxQueue = new LinkedList<>();

        resultQueue.add(vert);
        auxQueue.add(vert);

        knownVertices[g.getKey(vert)] = true;

        while (!auxQueue.isEmpty()) {
            V currentVert = auxQueue.remove();

            Iterable<Edge<V, E>> edges = g.outgoingEdges(currentVert);

            for (Edge<V, E> edge : edges) {

                V destVert = edge.getVDest();

                if (!knownVertices[g.getKey(destVert)]) {
                    knownVertices[g.getKey(destVert)] = true;
                    resultQueue.add(destVert);
                    auxQueue.add(destVert);
                }
            }
        }

        return resultQueue;
    }

    /**
     * Performs depth-first search starting in a Vertex
     *
     * @param g Graph instance
     * @param vOrig Vertex of graph g that will be the source of the search
     * @param visited set of discovered vertices
     * @param qdfs queue with vertices of depth-first search
     */
    private static <V, E> void DepthFirstSearch(Graph<V, E> g, V vOrig, boolean[] visited, LinkedList<V> qdfs) {

        visited[g.getKey(vOrig)] = true;
        qdfs.add(vOrig);

        Iterable<Edge<V, E>> edges = g.outgoingEdges(vOrig);

        for (Edge<V, E> edge : edges) {

            V destVert = edge.getVDest();

            if (!visited[g.getKey(destVert)]) {
                DepthFirstSearch(g, destVert, visited, qdfs);
            }
        }

    }

    /**
     * @param g Graph instance
     * @param vInf information of the Vertex that will be the source of the
     * search
     * @return qdfs a queue with the vertices of depth-first search
     */
    public static <V, E> LinkedList<V> DepthFirstSearch(Graph<V, E> g, V vert) {

        if (!g.validVertex(vert)) {
            return null;
        }
        boolean[] visited = new boolean[g.numVertices()];
        Arrays.fill(visited, Boolean.FALSE);

        LinkedList<V> qdfs = new LinkedList<>();

        DepthFirstSearch(g, vert, visited, qdfs);
        return qdfs;

        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns all paths from vOrig to vDest
     *
     * @param g Graph instance
     * @param vOrig Vertex that will be the source of the path
     * @param vDest Vertex that will be the end of the path
     * @param visited set of discovered vertices
     * @param path stack with vertices of the current path (the path is in
     * reverse order)
     * @param paths ArrayList with all the paths (in correct order)
     */
    private static <V, E> void allPaths(Graph<V, E> g, V vOrig, V vDest, boolean[] visited,
            LinkedList<V> path, ArrayList<LinkedList<V>> paths) {

        visited[g.getKey(vOrig)] = true;
        path.push(vOrig);

        Iterable<V> vertices = g.adjVertices(vOrig);
        for (V currentV : vertices) {
            if (currentV.equals(vDest)) {
                path.push(vDest);
                paths.add(path);
                path.pop();
            } else {
                if (!visited[g.getKey(currentV)]) {
                    allPaths(g, currentV, vDest, visited, path, paths);
                }
            }
        }

        visited[g.getKey(vOrig)] = false;
        path.pop();

    }

    /**
     * @param g Graph instance
     * @param voInf information of the Vertex origin
     * @param vdInf information of the Vertex destination
     * @return paths ArrayList with all paths from voInf to vdInf
     */
    public static <V, E> ArrayList<LinkedList<V>> allPaths(Graph<V, E> g, V vOrig, V vDest) {
        if (!g.validVertex(vDest) || !g.validVertex(vOrig)) {
            return null;
        }

        ArrayList<LinkedList<V>> paths = new ArrayList<>();

        LinkedList<V> auxStack = new LinkedList<>();

        boolean[] knownVertices = new boolean[g.numVertices()];
        Arrays.fill(knownVertices, Boolean.FALSE);

        allPaths(g, vOrig, vDest, knownVertices, auxStack, paths);

        return paths;

    }

    /**
     * Computes shortest-path distance from a source vertex to all reachable
     * vertices of a graph g with nonnegative edge weights This implementation
     * uses Dijkstra's algorithm
     *
     * @param g Graph instance
     * @param vOrig Vertex that will be the source of the path
     * @param visited set of discovered vertices
     * @param pathkeys minimum path vertices keys
     * @param dist minimum distances
     */
    protected static <V, E> void shortestPathLength(Graph<V, E> g, V vOrig, V[] vertices,
            boolean[] visited, int[] pathKeys, double[] dist) {

        Iterable<V> verticesIterator = g.vertices();
        for (V v : verticesIterator) {
            int index = g.getKey(v);
            dist[index] = Double.MAX_VALUE;
            visited[index] = false;
            vertices[index] = null;
        }

        dist[g.getKey(vOrig)] = 0;

        while (vOrig != null) {
            visited[g.getKey(vOrig)] = true;

            verticesIterator = g.adjVertices(vOrig);
            for (V vertice : verticesIterator) {
                Edge<V, E> edge = g.getEdge(vOrig, vertice);
                int aux = g.getKey(vertice);

                if (visited[aux] == false && dist[aux] > (dist[g.getKey(vOrig)] + edge.getWeight())) {
                    dist[aux] = (dist[g.getKey(vOrig)] + edge.getWeight());
                    pathKeys[aux] = g.getKey(vOrig);
                    vertices[aux] = vOrig;
                }
            }

            vOrig = getVertMinDist(g, dist, visited);

        }
    }

    public static <V, E> V getVertMinDist(Graph<V, E> g, double[] dist, boolean[] visited) {
        V vOrig = null;
        double min = Double.MAX_VALUE;

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] < min && dist[i] != 0 && visited[i] == false) {
                min = dist[i];
                vOrig = g.allkeyVerts()[i];
            }
        }

        return vOrig;
    }

    /**
     * Extracts from pathKeys the minimum path between voInf and vdInf The path
     * is constructed from the end to the beginning
     *
     * @param g Graph instance
     * @param voInf information of the Vertex origin
     * @param vdInf information of the Vertex destination
     * @param pathkeys minimum path vertices keys
     * @param path stack with the minimum path (correct order)
     */
    protected static <V, E> void getPath(Graph<V, E> g, V vOrig, V vDest, V[] verts, int[] pathKeys, LinkedList<V> path) {

        if (vDest != null) {
            path.addFirst(vDest);

            if (g.getKey(vOrig) != g.getKey(vDest)) {
                int indexDest = pathKeys[g.getKey(vDest)];
                vDest = verts[indexDest];
                getPath(g, vOrig, vDest, verts, pathKeys, path);
            }

        }
    }

    //shortest-path between voInf and vdInf
    public static <V, E> double shortestPath(Graph<V, E> g, V vOrig, V vDest, LinkedList<V> shortPath) {

        if (!g.validVertex(vDest) || !g.validVertex(vOrig)) {
            return 0;
        }

        int destIdx = g.getKey(vDest);

        boolean[] knownVertices = new boolean[g.numVertices()];
        int[] pathKeys = new int[g.numVertices()];
        double[] minDist = new double[g.numVertices()];

        shortestPathLength(g, vOrig, g.allkeyVerts(), knownVertices, pathKeys, minDist);

        if (minDist[destIdx] == -1 || minDist[destIdx] == Double.MAX_VALUE) {
            return -1;
        }
        getPath(g, vOrig, vDest, g.allkeyVerts(), pathKeys, shortPath);
        revPath(shortPath);
        if (minDist[destIdx] == 0) {
            return 0;
        }

        return minDist[destIdx];
    }

    /**
     * Reverses the path
     *
     * @param path stack with path
     */
    private static <V, E> LinkedList<V> revPath(LinkedList<V> path) {

        LinkedList<V> pathcopy = new LinkedList<>(path);
        LinkedList<V> pathrev = new LinkedList<>();

        while (!pathcopy.isEmpty()) {
            pathrev.push(pathcopy.pop());
        }

        return pathrev;
    }
}
