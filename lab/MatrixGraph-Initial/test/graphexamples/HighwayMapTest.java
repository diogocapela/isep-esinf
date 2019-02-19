/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphexamples;

import graphexamples.Highway;
import graphexamples.HighwayMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Unit tests class
 * for HigthwayMap class
 *
 * @author DEI-ESINF
 * 
 */

public class HighwayMapTest {

	HighwayMap routeMap = new HighwayMap();

	String [] cities = { "Porto", "Braga", "Vila Real", "Aveiro", "Viseu", "Coimbra", "Leiria", 
			             "Guarda", "Castelo Branco", "Lisboa", "Faro", "Évora"};

	@Before
	public void setUp() throws Exception {
		
		for (int i = 0; i< cities.length; i++)
			routeMap.insertCity(cities[i]);
		
		routeMap.insertHighway("Porto", "Aveiro", "A1", 75.0, 3.0);
		routeMap.insertHighway("Porto", "Braga", "A3", 60.0, 4.0);
		routeMap.insertHighway("Porto", "Vila Real", "A4", 100.0, 0.0);
		routeMap.insertHighway("Viseu", "Guarda", "A25", 90.0, 0.0);
		routeMap.insertHighway("Guarda",  "Castelo Branco", "A23", 110.0, 3.0);
		routeMap.insertHighway("Aveiro", "Coimbra", "A1", 60.0, 5.0);
		routeMap.insertHighway("Coimbra", "Lisboa", "A1", 200.0, 7.0);
		routeMap.insertHighway("Coimbra",  "Leiria", "A34", 80.0, 0.0);
		routeMap.insertHighway("Aveiro", "Leiria", "A17", 110.0, 9.0);
		routeMap.insertHighway("Leiria", "Lisboa", "A8", 150.0, 2.0);

		
		routeMap.insertHighway("Aveiro", "Viseu", "A25", 85.0, 5.0);
		routeMap.insertHighway("Leiria", "Castelo Branco", "A23", 170.0, 12.0);
		routeMap.insertHighway("Lisboa", "Faro", "A2", 280.0, 20.0);


	}

	@Test
	public void testInsertCity() {

		System.out.println("Test of insert city");

		HighwayMap tempMap = new HighwayMap();

		assertTrue("result should be zero", (tempMap.numCities()==0));
		
		tempMap.insertCity("Guimarães");
		assertTrue("result should be one", (tempMap.numCities()==1));
		tempMap.insertCity("Vila do Conde");
		assertTrue("result should be two", (tempMap.numCities()==2));

		assertFalse("insert should fail on existing city", tempMap.insertCity("Guimarães"));
		
	}

	@Test
	public void testInsertHighway() {

		System.out.println("Test of insert highway");

		
		HighwayMap tempMap = new HighwayMap();

		tempMap.insertCity("Póvoa do Varzim");
		tempMap.insertCity("Viana do Castelo");
		tempMap.insertCity("Ponte de Lima");
		tempMap.insertCity("Vilar de Mouros");
		
		tempMap.insertHighway("Viana do Castelo", "Ponte de Lima", "A27", 31.0, 2.0);
		tempMap.insertHighway("Vilar de Mouros", "Viana do Castelo", "A28", 30.0, 3.0);
		Iterator<Highway >itBefore = tempMap.departingHighways("Viana do Castelo").iterator();
		
		tempMap.insertHighway("Póvoa do Varzim", "Viana do Castelo", "A28", 45.0, 3.0);

		Iterator<Highway >itAfter = tempMap.departingHighways("Viana do Castelo").iterator();

		int countBefore = 0;
		while(itBefore.hasNext()) {itBefore.next();countBefore++;}
		assertTrue("before should give two highways", countBefore==2);
		
		int countAfter = 0;
		while(itAfter.hasNext()) {itAfter.next();countAfter++;}
		assertTrue("after should give three highways", countAfter==3);

		Iterator<Highway> it = tempMap.departingHighways("Viana do Castelo").iterator();

		Highway hw = it.next();
		assertTrue("First highway should be A28 to Póvoa do Varzim (45 km)", hw.name.equals("A28") && hw.distance==45);

		hw = it.next();
		assertTrue("Second highway should be A27 to Ponte de Lima", hw.name.equals("A27"));
		
		hw = it.next();
		assertTrue("third highway should be A28 to Vilar de Mouros (30 km)", hw.name.equals("A28") && hw.distance == 30);
		

	}

	@Test
	public void testDepartingHighways() {

		System.out.println("Test of departing highways");
		
		Iterator<Highway> it = routeMap.departingHighways("Coimbra").iterator();

		Highway hw = it.next();
		assertTrue("First highway should be A1 to Aveiro (60 km)", hw.name.equals("A1") && hw.distance==60);

		hw = it.next();
		assertTrue("Second highway should be A34 to Leiria", hw.name.equals("A34"));
		
		hw = it.next();
		assertTrue("third highway should be A1 to Lisboa (200 km)", hw.name.equals("A1") && hw.distance == 200);
		

		HighwayMap tempMap = new HighwayMap();

		tempMap.insertCity("Póvoa do Varzim");
		tempMap.insertCity("Viana do Castelo");
		tempMap.insertCity("Ponte de Lima");
		tempMap.insertCity("Vilar de Mouros");
		
		tempMap.insertHighway("Viana do Castelo", "Ponte de Lima", "A27", 31.0, 2.0);
		tempMap.insertHighway("Vilar de Mouros", "Viana do Castelo", "A28", 30.0, 3.0);

		Iterator<Highway >itBefore = tempMap.departingHighways("Viana do Castelo").iterator();
		
		tempMap.insertHighway("Póvoa do Varzim", "Viana do Castelo", "A28", 45.0, 3.0);

		Iterator<Highway >itAfter = tempMap.departingHighways("Viana do Castelo").iterator();
		
		int countBefore = 0;
		while(itBefore.hasNext()) {itBefore.next();countBefore++;}
		assertTrue("before should give two highways", countBefore==2);
		
		int countAfter = 0;
		while(itAfter.hasNext()) {itAfter.next();countAfter++;}
		assertTrue("after should give three highways", countAfter==3);
	}

	@Test
	public void testOneHopConnections() {
		System.out.println("Test of one hope connections");
		
		Iterator<String> it = routeMap.oneHopConnections("Coimbra").iterator();

		String city = it.next();
		assertTrue("First should be Aveiro", city.equals("Aveiro"));

		city = it.next();
		assertTrue("Second should be Leiria", city.equals("Leiria"));
		
		city = it.next();
		assertTrue("third should be Lisboa", city.equals("Lisboa"));
		

		HighwayMap tempMap = new HighwayMap();

		tempMap.insertCity("Póvoa do Varzim");
		tempMap.insertCity("Viana do Castelo");
		tempMap.insertCity("Ponte de Lima");
		tempMap.insertCity("Vilar de Mouros");
		
		tempMap.insertHighway("Viana do Castelo", "Ponte de Lima", "A27", 31.0, 2.0);
		tempMap.insertHighway("Vilar de Mouros", "Viana do Castelo", "A28", 30.0, 3.0);

		Iterator<String>itBefore = tempMap.oneHopConnections("Viana do Castelo").iterator();
		
		tempMap.insertHighway("Póvoa do Varzim", "Viana do Castelo", "A28", 45.0, 3.0);

		Iterator<String>itAfter = tempMap.oneHopConnections("Viana do Castelo").iterator();
		
		int countBefore = 0;
		while(itBefore.hasNext()) {itBefore.next();countBefore++;}
		assertTrue("before should give two cities", countBefore==2);
		
		int countAfter = 0;
		while(itAfter.hasNext()) {itAfter.next();countAfter++;}
		assertTrue("after should give three cities", countAfter==3);
	}

	@Test
	public void testExistsConnection() {
		System.out.println("Test of exists connection");

		Iterable<String> path;

		assertTrue("Should be null if city does not exist", routeMap.existsConnection("Porto", "LX")==null);
		assertTrue("Should be null if there is no path", routeMap.existsConnection("Porto", "Évora")==null);
		assertTrue("Should be Porto", routeMap.existsConnection("Porto", "Porto").iterator().next().equals("Porto"));
		
		path = routeMap.existsConnection("Porto", "Castelo Branco");
		
		Iterator<String> it = path.iterator();

		assertTrue("First should be Porto", it.next().compareTo("Porto")==0);
		assertTrue("then Aveiro", it.next().compareTo("Aveiro")==0);
		assertTrue("then Viseu", it.next().compareTo("Viseu")==0);
		assertTrue("then Guarda", it.next().compareTo("Guarda")==0);
		assertTrue("then Castelo Branco", it.next().compareTo("Castelo Branco")==0);

	}

	@Test
	public void testTravelViaMinimumNumberHighways() {
		fail("Not implemented yet.");
	}	

	@Test
	public void testMinimumDistance(){
		fail("Not implemented yet.");
	}
	
	@Test
	public void testMinimumCost(){
		fail("Not implemented yet.");
	}
	
	
	@Test
	public void testClone() {
		System.out.println("Test of Clone");

		HighwayMap tempMap = routeMap.clone();
		
		assertTrue("number of cities should be equal", routeMap.numCities()==tempMap.numCities());
		
		for(String city : cities){
			Iterable<Highway> original = routeMap.departingHighways(city);
			Iterable<Highway> copy = tempMap.departingHighways(city);
			assertTrue("departing highways should be equal", copy.equals(original));
		}
		
		tempMap.insertCity("Guimarães");
		assertFalse("number of cities should be different", routeMap.numCities()==tempMap.numCities());

		tempMap = routeMap.clone();
		
		tempMap.insertHighway("Porto", "Lisboa", "A1", 300.0, 30.0);
		
		Iterable<Highway> original = routeMap.departingHighways("Porto");
		Iterable<Highway> copy = tempMap.departingHighways("Porto");
	
		assertFalse("departing highways should be differnet", copy.equals(original));
				
	}

	@Test
	public void testEqualsObject() {
		System.out.println("Test Equals");
		
		assertFalse("should not be equal to null", routeMap.equals(null));
		
		assertTrue("should be equal to itself", routeMap.equals(routeMap));

		HighwayMap tempMap = routeMap.clone(), tempMap1 = routeMap.clone();
		
		assertTrue("should be equal to a clone", routeMap.equals(tempMap));
		
		tempMap.insertCity("Guimarães");
		
		assertFalse("should not be equal", tempMap.equals(tempMap1));
		
		tempMap1.insertCity("Guimarães");
		
		assertTrue("should be equal", tempMap.equals(tempMap1));

	}


}
