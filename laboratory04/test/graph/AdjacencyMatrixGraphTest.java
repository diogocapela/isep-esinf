
package graph;

import java.util.Iterator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests class
 * for AdjacencyMatrixGraph
 *
 * @author DEI_ESINF
 * 
 */
public class AdjacencyMatrixGraphTest {

    public AdjacencyMatrixGraphTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }	
	
    @Test
    public void testNumVertices() {

		System.out.println("Test of numVertices");
		AdjacencyMatrixGraph<String, Integer> instance = new AdjacencyMatrixGraph<String,Integer>();
		assertTrue("result should be zero", (instance.numVertices()==0));
		instance.insertVertex("Vert 1");
		assertTrue("result should be one", (instance.numVertices()==1));
		instance.insertVertex("Vert 2");
		assertTrue("result should be two", (instance.numVertices()==2));
		instance.removeVertex("Vert 1");
		assertTrue("result should be one", (instance.numVertices()==1));
		instance.removeVertex("Vert 2");
		assertTrue("result should be zero", (instance.numVertices()==0));
    }

    @Test
    public void testNumEdges() {
		System.out.println("Test of numEdges");
		AdjacencyMatrixGraph<String, Integer> instance = new AdjacencyMatrixGraph<String,Integer>();
		
		assertTrue("result should be zero", (instance.numEdges()==0));
	
		for(int i = 1 ; i < 5; i++)
			instance.insertVertex("Vert "+i);
		
		instance.insertEdge("Vert 3",  "Vert 2", 12);
		assertTrue("result should be one", (instance.numEdges()==1));
		
		instance.insertEdge("Vert 1",  "Vert 4", 11);
		assertTrue("result should be two", (instance.numEdges()==2));
		
		instance.removeEdge("Vert 2", "Vert 3");
		assertTrue("result should be one", (instance.numEdges()==1));
		
		instance.removeEdge("Vert 4", "Vert 1");
		assertTrue("result should be zero", (instance.numEdges()==0));
    }

    @Test
    public void testVertices() {
		System.out.println("Test of vertices getter");

		AdjacencyMatrixGraph<String, Integer> instance = new AdjacencyMatrixGraph<String,Integer>();
		
		Iterator<String> itVert = instance.vertices().iterator();
		
		assertTrue("vertices should be empty", (itVert.hasNext()==false));

		instance.insertVertex("Vert 1");
		instance.insertVertex("Vert 2");
		
		itVert = instance.vertices().iterator();
				
		assertTrue("first vertice should be \"Vert 1\"", (itVert.next().compareTo("Vert 1")==0));
		assertTrue("second vertice should be \"Vert 2\"", (itVert.next().compareTo("Vert 2")==0));

		instance.removeVertex("Vert 1");
		
		itVert = instance.vertices().iterator();
		assertTrue("first vertice should now be \"Vert 2\"", (itVert.next().compareTo("Vert 2")==0));
		
		instance.removeVertex("Vert 2");
		
		itVert = instance.vertices().iterator();
		assertTrue("vertices should now be empty", (itVert.hasNext()==false));

		instance.insertVertex("Vert 1");
	
		itVert = instance.vertices().iterator();

		instance.removeVertex("Vert 1");

		assertTrue("iterator should still give \"Vert 1\" (no change in cloned obj)", (itVert.next().compareTo("Vert 1")==0));
		assertTrue("instance vertices should be empty", (instance.vertices().iterator().hasNext()==false));
	
    }

    @Test
    public void testEdges() {
		System.out.println("Test of Edges getter");

		AdjacencyMatrixGraph<String, String> instance = new AdjacencyMatrixGraph<String,String>();
		
		Iterator<String> itEdge = instance.edges().iterator();
		
		assertTrue("edges should be empty", (itEdge.hasNext()==false));

		for(int i = 1 ; i < 5; i++)
			instance.insertVertex("Vert "+i);

		instance.insertEdge("Vert 1", "Vert 2", "Edge 1");
		instance.insertEdge("Vert 2", "Vert 4", "Edge 2");
		instance.insertEdge("Vert 1", "Vert 3", "Edge 3");
		
		itEdge = instance.edges().iterator();
				
		assertTrue("first edge should be \"Edge 1\"", (itEdge.next().compareTo("Edge 1")==0));
		assertTrue("second edge should be \"Edge 3\"", (itEdge.next().compareTo("Edge 3")==0));
		assertTrue("third edge should be \"Edge 2\"", (itEdge.next().compareTo("Edge 2")==0));

		instance.removeEdge("Vert 1", "Vert 2");
		
		itEdge = instance.edges().iterator();
		assertTrue("first edge should now be \"Edge 3\"", (itEdge.next().compareTo("Edge 3")==0));
		
		instance.removeEdge("Vert 1", "Vert 3");
		instance.removeEdge("Vert 2", "Vert 4");
		
		itEdge = instance.edges().iterator();
		assertTrue("vertices should now be empty", (itEdge.hasNext()==false));
    }

    @Test   
    public void testOutDegree() {
		System.out.println("Test of Out degree");

		AdjacencyMatrixGraph<String, String> instance = new AdjacencyMatrixGraph<String,String>();
		
		for(int i = 1 ; i <= 5; i++)
			instance.insertVertex("Vert "+i);
		
		assertTrue("out degree should be zero", (instance.outDegree("Vert 2")==0));

		instance.insertEdge("Vert 1", "Vert 2", "Edge 1");
		instance.insertEdge("Vert 2", "Vert 4", "Edge 2");
		instance.insertEdge("Vert 1", "Vert 3", "Edge 3");
		instance.insertEdge("Vert 2", "Vert 3", "Edge 4");
		instance.insertEdge("Vert 1", "Vert 5", "Edge 5");
		
		assertTrue("out degree should be 3", (instance.outDegree("Vert 2")==3));

		instance.removeEdge("Vert 1", "Vert 2");
		
		assertTrue("out degree should be 2", (instance.outDegree("Vert 2")==2));

		instance.removeEdge("Vert 2", "Vert 4");
		instance.removeEdge("Vert 2", "Vert 3");
		assertTrue("out degree should be zero", (instance.outDegree("Vert 2")==0));
    }

    @Test
    public void testInDegree() {
		System.out.println("Test of In degree");

		AdjacencyMatrixGraph<String, String> instance = new AdjacencyMatrixGraph<String,String>();
		
		for(int i = 1 ; i <= 5; i++)
			instance.insertVertex("Vert "+i);
		
		assertTrue("in degree should be zero", (instance.inDegree("Vert 3")==0));

		instance.insertEdge("Vert 1", "Vert 2", "Edge 1");
		instance.insertEdge("Vert 2", "Vert 4", "Edge 2");
		instance.insertEdge("Vert 1", "Vert 3", "Edge 3");
		instance.insertEdge("Vert 2", "Vert 3", "Edge 4");
		instance.insertEdge("Vert 3", "Vert 5", "Edge 5");
		
		assertTrue("in degree should be 3", (instance.inDegree("Vert 3")==3));

		instance.removeEdge("Vert 1", "Vert 3");
		
		assertTrue("in degree should be 2", (instance.inDegree("Vert 3")==2));

		instance.removeEdge("Vert 3", "Vert 5");
		instance.removeEdge("Vert 2", "Vert 3");
		assertTrue("in degree should be zero", (instance.outDegree("Vert 3")==0));
		
    }

    @Test
	public void testDirectConnections() {
		fail("Not implemented yet");
    }

	
    @Test
	public void testOutgoingEdges() {
		fail("Not implemented yet");
    }

    @Test
	public void testIncomingEdges() {
            System.out.println("Test of Incoming Edges");

            AdjacencyMatrixGraph<String, String> instance = new AdjacencyMatrixGraph<String,String>();

            for(int i = 1 ; i <= 5; i++)
                    instance.insertVertex("Vert "+i);

            Iterator<String> itEdge = instance.incomingEdges("Vert 2").iterator();

            assertTrue("edges should be empty", (itEdge.hasNext()==false));

            instance.insertEdge("Vert 1", "Vert 2", "Edge 1");
            instance.insertEdge("Vert 2", "Vert 4", "Edge 2");
            instance.insertEdge("Vert 1", "Vert 5", "Edge 3");
            instance.insertEdge("Vert 2", "Vert 3", "Edge 4");
            instance.insertEdge("Vert 1", "Vert 3", "Edge 5");

            itEdge = instance.incomingEdges("Vert 1").iterator();

            assertTrue("first edge should be \"Edge 1\"", (itEdge.next().compareTo("Edge 1")==0));
            assertTrue("second edge should be \"Edge 5\"", (itEdge.next().compareTo("Edge 5")==0));
            assertTrue("third edge should be \"Edge 3\"", (itEdge.next().compareTo("Edge 3")==0));

            instance.removeEdge("Vert 1", "Vert 2");

            itEdge = instance.incomingEdges("Vert 1").iterator();
            assertTrue("first edge should now be \"Edge 5\"", (itEdge.next().compareTo("Edge 5")==0));

            instance.removeEdge("Vert 1", "Vert 3");
            instance.removeEdge("Vert 1", "Vert 5");

            itEdge = instance.incomingEdges("Vert 1").iterator();
            assertTrue("vertices should now be empty", (itEdge.hasNext()==false));
	}

    @Test
	public void testGetEdge() {
		System.out.println("Test of Get Edge");

		AdjacencyMatrixGraph<String, String> instance = new AdjacencyMatrixGraph<String,String>();
		
		for(int i = 1 ; i <= 5; i++)
			instance.insertVertex("Vert "+i);
		
		instance.insertEdge("Vert 1", "Vert 2", "Edge 1");
		instance.insertEdge("Vert 2", "Vert 4", "Edge 2");
		instance.insertEdge("Vert 1", "Vert 5", "Edge 3");
		instance.insertEdge("Vert 2", "Vert 3", "Edge 4");
		instance.insertEdge("Vert 1", "Vert 3", "Edge 5");
		
		assertTrue("edge should be null", instance.getEdge("Vert 2", "Vert 5")==null);
		
		assertTrue("edge should be \"Edge 2\"", instance.getEdge("Vert 4", "Vert 2").compareTo("Edge 2")==0);

		instance.removeEdge("Vert 2", "Vert 4");
		
		assertTrue("edge should be null", instance.getEdge("Vert 2", "Vert 5")==null);
		instance.insertEdge("Vert 2", "Vert 4", "Edge 6");
		assertTrue("edge should be \"Edge 6\"", instance.getEdge("Vert 4", "Vert 2").compareTo("Edge 6")==0);
    }

    @Test
    public void testEndVertices() {
		System.out.println("Test of end vertices");

		AdjacencyMatrixGraph<String, String> instance = new AdjacencyMatrixGraph<String,String>();
		
		for(int i = 1 ; i <= 5; i++)
			instance.insertVertex("Vert "+i);
		
		instance.insertEdge("Vert 1", "Vert 2", "Edge 1");
		instance.insertEdge("Vert 2", "Vert 4", "Edge 2");
		instance.insertEdge("Vert 1", "Vert 5", "Edge 3");
		instance.insertEdge("Vert 2", "Vert 3", "Edge 4");
		instance.insertEdge("Vert 3", "Vert 1", "Edge 5");
		
		Object [] endVertices = instance.endVertices("Edge 6");
		
		assertTrue("endVertices should be null", endVertices==null);
		
		endVertices = instance.endVertices("Edge 5");
				
		String v1 = (String) endVertices[0];
		String v2 = (String) endVertices[1];

		assertTrue("first vertex should be \"Vert 1\"", v1.compareTo("Vert 1")==0);
		assertTrue("second vertex should be \"Vert 3\"", v2.compareTo("Vert 3")==0);
    }

    @Test
    public void testInsertEdge() {
		System.out.println("Test of insert edge");

		AdjacencyMatrixGraph<String, String> instance = new AdjacencyMatrixGraph<String,String>();
		
		for(int i = 1 ; i < 5; i++)
			instance.insertVertex("Vert "+i);
		
		assertTrue("result should be zero", (instance.numEdges()==0));
		
		instance.insertEdge("Vert 1", "Vert 2", "Edge 1");
		assertTrue("result should be one", (instance.numEdges()==1));
		
		instance.insertEdge("Vert 1", "Vert 3", "Edge 2");
		assertTrue("result should be two", (instance.numEdges()==2));

		instance.removeEdge("Vert 1",  "Vert 3");
		assertTrue("result should be one", (instance.numEdges()==1));
		
		instance.insertEdge("Vert 2", "Vert 4", "Edge 3");
		assertTrue("result should be two", (instance.numEdges()==2));
		
		Iterator <String> itEdge = instance.edges().iterator();
				
		assertTrue("first edge should be \"Edge 1\"", (itEdge.next().compareTo("Edge 1")==0));
		assertTrue("second edge should be \"Edge 3\"", (itEdge.next().compareTo("Edge 3")==0));

    }

    @Test
    public void testInsertVertex() {
		System.out.println("Test of insert vertex");

		AdjacencyMatrixGraph<String, Integer> instance = new AdjacencyMatrixGraph<String,Integer>();
		assertTrue("result should be zero", (instance.numVertices()==0));
		instance.insertVertex("Vert 1");
		assertTrue("result should be one", (instance.numVertices()==1));
		instance.insertVertex("Vert 2");
		assertTrue("result should be two", (instance.numVertices()==2));

		assertFalse("insert should fail on existing vertex", instance.insertVertex("Vert 2"));
		
		instance.removeVertex("Vert 1");
		assertTrue("result should be one", (instance.numVertices()==1));

		instance.insertVertex("Vert 3");
		assertTrue("result should be two", (instance.numVertices()==2));
		
		instance.insertVertex("Vert 4");

		Iterator <String> itVert = instance.vertices().iterator();
		
		assertTrue("first vertex should be \"Vert 2\"", (itVert.next().compareTo("Vert 2")==0));
		assertTrue("second vertex should be \"Vert 3\"", (itVert.next().compareTo("Vert 3")==0));
		assertTrue("third vertex should be \"Vert 4\"", (itVert.next().compareTo("Vert 4")==0));
		
		// Force resize of matrix
		
		for (int i = 0; i< 100 ; i++)
			instance.insertVertex("Vert "+ i);
		
		instance.insertEdge("Vert 1", "Vert 80", 80);
		
		Iterator<Integer> itEdge = instance.edges().iterator();
		
		assertTrue("edge should be 80", itEdge.next()==80);	
    }

    @Test
    public void testRemoveVertex() {
		System.out.println("Test of remove vertex");

		AdjacencyMatrixGraph<String, String> instance = new AdjacencyMatrixGraph<String,String>();
		
		for(int i = 1 ; i <= 5; i++)
			instance.insertVertex("Vert "+i);
		
		instance.insertEdge("Vert 1", "Vert 2", "Edge 1");
		instance.insertEdge("Vert 2", "Vert 4", "Edge 2");
		instance.insertEdge("Vert 1", "Vert 5", "Edge 3");
		instance.insertEdge("Vert 2", "Vert 3", "Edge 4");
		instance.insertEdge("Vert 3", "Vert 1", "Edge 5");
		instance.insertEdge("Vert 4", "Vert 1", "Edge 6");
		

		assertTrue("result should be 5", (instance.numVertices()==5));
		assertTrue("result should be 6", (instance.numEdges()==6));
		
		instance.removeVertex("Vert 3");

		assertTrue("result should be 4", (instance.numVertices()==4));
		assertTrue("result should be 3", (instance.numEdges()==4));
		
		// Vertex 2 was removed - The vertices should now be 1, 2, 4, 5
		// Edge matrix should collapse - line and column 2 should refer to Vert 4
		// Requesting the edge between first and third vertices should give "Edge 6"
		// Requesting the edge between second and fourth vertices should give "Edge 2"
		
		Iterator <String> itVert = instance.vertices().iterator();

		String v1 = itVert.next();
		assertTrue("Vertex should be \"Vert 1\"", v1.compareTo("Vert 1")==0);
		String v2 = itVert.next();
		assertTrue("Vertex should be \"Vert 2\"", v2.compareTo("Vert 2")==0);
		String v3 = itVert.next();
		assertTrue("Vertex should be \"Vert 4\"", v3.compareTo("Vert 4")==0);
		String v4 = itVert.next();
		assertTrue("Vertex should be \"Vert 5\"", v4.compareTo("Vert 5")==0);
		
		assertTrue("edge should be \"Edge 6\"", instance.getEdge(v1, v3).compareTo("Edge 6")==0);
		assertTrue("edge should be \"Edge 2\"", instance.getEdge(v2, v3).compareTo("Edge 2")==0);
		assertTrue("edge should be null", instance.getEdge(v2, v4)==null);
    }

    @Test
    public void testRemoveEdge() {
		System.out.println("Test of remove edge");

		AdjacencyMatrixGraph<String, String> instance = new AdjacencyMatrixGraph<String,String>();
		
		for(int i = 1 ; i < 5; i++)
			instance.insertVertex("Vert "+i);
		
		assertTrue("result should be zero", (instance.numEdges()==0));
		
		instance.insertEdge("Vert 1", "Vert 2", "Edge 1");
		assertTrue("result should be one", (instance.numEdges()==1));
		
		instance.insertEdge("Vert 1", "Vert 3", "Edge 2");
		assertTrue("result should be two", (instance.numEdges()==2));

		instance.removeEdge("Vert 1",  "Vert 3");
		assertTrue("result should be one", (instance.numEdges()==1));
		
		instance.insertEdge("Vert 2", "Vert 4", "Edge 3");
		assertTrue("result should be two", (instance.numEdges()==2));
		
		Iterator <String> itEdge = instance.edges().iterator();
				
		assertTrue("first edge should be \"Edge 1\"", (itEdge.next().compareTo("Edge 1")==0));
		assertTrue("second edge should be \"Edge 3\"", (itEdge.next().compareTo("Edge 3")==0));

		instance.removeEdge("Vert 4",  "Vert 2");
		instance.removeEdge("Vert 2",  "Vert 1");
		assertTrue("result should be zero", (instance.numEdges()==0));	
    }
	
    @Test
    public void testClone() {
		System.out.println("Test of Clone");

		AdjacencyMatrixGraph<String, String> instance = new AdjacencyMatrixGraph<String,String>();
		
		for(int i = 1; i<= 5; i++)
			instance.insertVertex("Vert "+i);
		
		instance.insertEdge("Vert 1", "Vert 2", "Edge 1");
		instance.insertEdge("Vert 2", "Vert 4", "Edge 2");
		instance.insertEdge("Vert 1", "Vert 3", "Edge 3");
		instance.insertEdge("Vert 2", "Vert 3", "Edge 4");
		instance.insertEdge("Vert 1", "Vert 5", "Edge 5");
		
		@SuppressWarnings("unchecked")
		AdjacencyMatrixGraph<String, String> instance2 = (AdjacencyMatrixGraph<String, String>) instance.clone();
	
		assertTrue("number of vertices should be equal", instance.numVertices()==instance2.numVertices());
		assertTrue("number of edges should be equal", instance.numEdges()==instance2.numEdges());
		
		Iterator <String> itVert = instance2.vertices().iterator();

		for(int j = 1; j<=5; j++)
			assertTrue("vertex should be \"Vert \""+j, (itVert.next().compareTo("Vert "+j)==0));

		String edge = instance2.getEdge("Vert 1", "Vert 2");
		assertTrue("edge should be \"Edge 1\"", edge.compareTo("Edge 1")==0);
		edge = instance2.getEdge("Vert 2", "Vert 4");
		assertTrue("edge should be \"Edge 2\"", edge.compareTo("Edge 2")==0);
		edge = instance2.getEdge("Vert 1", "Vert 3");
		assertTrue("edge should be \"Edge 3\"", edge.compareTo("Edge 3")==0);
		edge = instance2.getEdge("Vert 2", "Vert 3");
		assertTrue("edge should be \"Edge 4\"", edge.compareTo("Edge 4")==0);
		edge = instance2.getEdge("Vert 1", "Vert 5");
		assertTrue("edge should be \"Edge 5\"", edge.compareTo("Edge 5")==0);
		
		
		instance.removeVertex("Vert 2");

		
		// instance should be different
		assertTrue("should be now 4 vertices", instance.numVertices()==4);
		assertTrue("should be only two edges", instance.numEdges()==2);

		// instance 2 should maintain the same as before
		
		assertTrue("number of vertices should as before", instance2.numVertices()==5);
		assertTrue("number of edges should as before", instance2.numEdges()==5);

		
		itVert = instance2.vertices().iterator();
		
		itVert.next();
		
		assertTrue("Vertex should be \"Vert 2\"", itVert.next().compareTo("Vert 2")==0);
		
		edge = instance2.getEdge("Vert 2", "Vert 4");
		assertTrue("edge should be \"Edge 2\"", edge.compareTo("Edge 2")==0);
		
    }

    @Test
    public void testEqualsObject() {
		System.out.println("Test Equals");
		
		AdjacencyMatrixGraph<String, String> instance = new AdjacencyMatrixGraph<String,String>();
		
		AdjacencyMatrixGraph<String, String> instance2 = instance; 
		
		for(int i = 1; i<= 5; i++)
			instance.insertVertex("Vert "+i);
		
		instance.insertEdge("Vert 1", "Vert 2", "Edge 1");
		instance.insertEdge("Vert 2", "Vert 4", "Edge 2");
		instance.insertEdge("Vert 1", "Vert 3", "Edge 3");
		instance.insertEdge("Vert 2", "Vert 3", "Edge 4");
		instance.insertEdge("Vert 1", "Vert 5", "Edge 5");
		
		assertFalse("should not be equal to null", instance.equals(null));
		
		assertTrue("should be equal to itself", instance.equals(instance2));
		
		assertTrue("should be equal to a clone", instance.equals(instance.clone()));
		
		AdjacencyMatrixGraph<String, String> instance3 = new AdjacencyMatrixGraph<String, String>();

		for(int i = 1; i<= 5; i++)
			instance3.insertVertex("Vert "+i);
		
		instance3.insertEdge("Vert 1", "Vert 2", "Edge 1");
		instance3.insertEdge("Vert 2", "Vert 4", "Edge 2");
		instance3.insertEdge("Vert 1", "Vert 3", "Edge 3");
		instance3.insertEdge("Vert 2", "Vert 3", "Edge 4");

		assertFalse("should not be equal", instance.equals(instance3));

		instance3.insertEdge("Vert 1", "Vert 5", "Edge 5");
		
		assertTrue("should be equal", instance.equals(instance3));
    }

    @Test
    public void testToString() {
		System.out.println("Test of To String");
		
		AdjacencyMatrixGraph<String, String> instance = new AdjacencyMatrixGraph<String,String>();
		
		for(int i = 1 ; i <= 5; i++)
			instance.insertVertex("Vert "+i);
		
		instance.insertEdge("Vert 1", "Vert 2", "Edge 1");
		instance.insertEdge("Vert 2", "Vert 4", "Edge 2");
		instance.insertEdge("Vert 1", "Vert 3", "Edge 3");
		instance.insertEdge("Vert 2", "Vert 3", "Edge 4");
		instance.insertEdge("Vert 1", "Vert 5", "Edge 5");

		System.out.println(instance);
    }

	
}