 
package graph;

import java.util.Iterator;
import java.util.LinkedList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author DEI-ESINF
 */
public class EdgeAsDoubleGraphAlgorithmsTest {
    
    AdjacencyMatrixGraph <String, Double> distanceMap = new AdjacencyMatrixGraph<>();

    public EdgeAsDoubleGraphAlgorithmsTest() {
    }
    
    @Before
    public void setUp() throws Exception {
		distanceMap.insertVertex("Porto");
		distanceMap.insertVertex("Braga");
		distanceMap.insertVertex("Vila Real");
		distanceMap.insertVertex("Aveiro");
		distanceMap.insertVertex("Coimbra");
		distanceMap.insertVertex("Leiria");

		distanceMap.insertVertex("Viseu");
		distanceMap.insertVertex("Guarda");
		distanceMap.insertVertex("Castelo Branco");
		distanceMap.insertVertex("Lisboa");
		distanceMap.insertVertex("Faro");
		distanceMap.insertVertex("Évora");
		

		distanceMap.insertEdge("Porto", "Aveiro", 75.0);
		distanceMap.insertEdge("Porto", "Braga", 60.0);
		distanceMap.insertEdge("Porto", "Vila Real", 100.0);
		distanceMap.insertEdge("Viseu", "Guarda", 75.0);
		distanceMap.insertEdge("Guarda",  "Castelo Branco", 100.0);
		distanceMap.insertEdge("Aveiro", "Coimbra", 60.0);
		distanceMap.insertEdge("Coimbra", "Lisboa", 200.0);
		distanceMap.insertEdge("Coimbra",  "Leiria",  80.0);
		distanceMap.insertEdge("Aveiro", "Leiria", 120.0);
		distanceMap.insertEdge("Leiria", "Lisboa", 150.0);

		
		distanceMap.insertEdge("Aveiro", "Viseu", 85.0);
		distanceMap.insertEdge("Leiria", "Castelo Branco", 170.0);
		distanceMap.insertEdge("Lisboa", "Faro", 280.0);

	}

 	
	@Test
	public void testShortestPath() {
		System.out.println("Test of shortest path");
		
		LinkedList<String> path = new LinkedList<String>();
		
		assertTrue("Should be -1 if vertex does not exist", EdgeAsDoubleGraphAlgorithms.shortestPath(distanceMap,  "Porto",  "LX",  path) == -1);
		
		assertTrue("Should be -1 if there is no path", EdgeAsDoubleGraphAlgorithms.shortestPath(distanceMap, "Porto", "Évora", path)==-1);
		
		assertTrue("Should be 0 if source and vertex are the same", EdgeAsDoubleGraphAlgorithms.shortestPath(distanceMap,  "Porto",  "Porto",  path) == 0);
		
		assertTrue("Path should be single vertex if source and vertex are the same", path.size() == 1);
		
		assertTrue("Path between Porto and Lisboa should be 335 Km", EdgeAsDoubleGraphAlgorithms.shortestPath(distanceMap,  "Porto",  "Lisboa",  path) == 335);
		
		Iterator<String> it = path.iterator();

		assertTrue("First in path should be Porto", it.next().compareTo("Porto")==0);
		assertTrue("then Aveiro", it.next().compareTo("Aveiro")==0);
		assertTrue("then Coimbra", it.next().compareTo("Coimbra")==0);
		assertTrue("then Lisboa", it.next().compareTo("Lisboa")==0);

		assertTrue("Path between Braga and Leiria should be 255 Km", EdgeAsDoubleGraphAlgorithms.shortestPath(distanceMap,  "Braga",  "Leiria",  path) == 255);
		
		it = path.iterator();

		assertTrue("First in path should be Braga", it.next().compareTo("Braga")==0);
		assertTrue("then Porto", it.next().compareTo("Porto")==0);
		assertTrue("then Aveiro", it.next().compareTo("Aveiro")==0);
		assertTrue("then Leiria", it.next().compareTo("Leiria")==0);
		
		assertTrue("Path between Porto and Castelo Branco should be 335 Km", EdgeAsDoubleGraphAlgorithms.shortestPath(distanceMap,  "Porto",  "Castelo Branco",  path) == 335);
		assertTrue("Path between Porto and Castelo Branco should be 5 cities", path.size() == 5);
		
		it = path.iterator();

		assertTrue("First in path should be Porto", it.next().compareTo("Porto")==0);
		assertTrue("then Aveiro", it.next().compareTo("Aveiro")==0);
		assertTrue("then Viseu", it.next().compareTo("Viseu")==0);
		assertTrue("then Guarda", it.next().compareTo("Guarda")==0);
		assertTrue("then Castelo Branco", it.next().compareTo("Castelo Branco")==0);
		
		// Changing Viseu to Guarda should change shortest path between Porto and Castelo Branco

		distanceMap.removeEdge("Viseu", "Guarda");
		distanceMap.insertEdge("Viseu", "Guarda", 125.0);
		
		assertTrue("Path between Porto and Castelo Branco should now be 365 Km", EdgeAsDoubleGraphAlgorithms.shortestPath(distanceMap,  "Porto",  "Castelo Branco",  path) == 365);
		assertTrue("Path between Porto and Castelo Branco should be 4 cities", path.size() == 4);
		
		it = path.iterator();
	
		assertTrue("First in path should be Porto", it.next().compareTo("Porto")==0);
		assertTrue("then Aveiro", it.next().compareTo("Aveiro")==0);
		assertTrue("then Leiria", it.next().compareTo("Leiria")==0);
		assertTrue("then Castelo Branco", it.next().compareTo("Castelo Branco")==0);
		
		
	}

	@Test
	public void testMinDistGraph() {
		fail("not implemented yet");
	}

}
