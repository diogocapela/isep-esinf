/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphexamples;

import graphexamples.LabyrinthCheater;
import java.util.LinkedList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Unit tests class
 * for LabyrinthCheater class
 *
 * @author DEI-ESINF
 * 
 */

public class LabyrinthCheaterTest {

	LabyrinthCheater map = new LabyrinthCheater();
	
	@Before
	public void setUp() throws Exception {
		
		// See Map.png in the source folder of the test
		
		for(char c = 'A'; c < 'E'; c++)
			map.insertRoom(String.valueOf(c), false);
		map.insertRoom("E", true);
		for(char c = 'F'; c < 'J'; c++)
			map.insertRoom(String.valueOf(c), false);
		map.insertRoom("J", true);
		map.insertRoom("K", true);
		for(char c = 'L'; c < 'S'; c++)
			map.insertRoom(String.valueOf(c), false);
		map.insertRoom("S", true);
		map.insertRoom("T", false);
		
		map.insertDoor("A", "B");
		map.insertDoor("B", "G");
		map.insertDoor("G", "H");
		map.insertDoor("H", "C");
		map.insertDoor("C", "D");
		map.insertDoor("D", "E");
		map.insertDoor("D", "I");	
		map.insertDoor("A", "F");
		map.insertDoor("K", "L");
		map.insertDoor("I", "J");
		map.insertDoor("F", "K");
		map.insertDoor("L", "Q");
		map.insertDoor("L", "M");
		map.insertDoor("M", "N");
		map.insertDoor("N", "S");
				
	}

	@Test
	public void testInsertRoom() {
		System.out.println("Test of insert room");

		LabyrinthCheater tempMap = new LabyrinthCheater();

		assertTrue("result should be true", tempMap.insertRoom("A", false));
		assertTrue("result should be true", tempMap.insertRoom("B", false));
		
		assertFalse("duplicate room should fail", tempMap.insertRoom("A", true));
	}

	@Test
	public void testInsertDoor() {
		System.out.println("Test of insert door");

		
		LabyrinthCheater tempMap = new LabyrinthCheater();

		tempMap.insertRoom("A", false);
		tempMap.insertRoom("B", false);
		
		tempMap.insertRoom("C", true);
		tempMap.insertRoom("D", false);
		
		assertTrue("result should be true", tempMap.insertDoor("A", "B"));
		assertTrue("result should be true", tempMap.insertDoor("C", "B"));
		assertTrue("result should be true", tempMap.insertDoor("D", "A"));
		
		assertFalse("should fail on inexistent room", tempMap.insertDoor("A", "E"));
		
		assertFalse("should fail on already existent door", tempMap.insertDoor("A", "D"));
		
		
	}

	@Test
	public void testRoomsInReach() {
		fail("Not implemented yet.");
	}

	@Test
	public void testNearestExit() {
		fail("Not implemented yet.");	}

	@Test
	public void testPathToExit() {
		fail("Not implemented yet.");	}

}
