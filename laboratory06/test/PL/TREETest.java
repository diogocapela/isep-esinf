/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DEI-ESINF
 */
public class TREETest {
    Integer[] arr = {20,15,10,13,8,17,40,50,30,7};
    int[] nnodes= {1,2,4,2,1};
    Integer[] inorderT= {7,8,10,13,15,17,20,30,40,50};
    Integer[] bstAscDes = {7, 8, 10, 13, 15, 17, 20, 50, 40, 30};
    TREE<Integer> instance;
        
    public TREETest() {
    }
    
    @Before
    public void setUp(){
        instance = new TREE();
        for(int i :arr)
            instance.insert(i);        
    }
    /**
     * Test of isLeaf method, of class TREE.
     */
    @Test
    public void testcontains() {
        System.out.println("contains");
        assertTrue(instance.contains(7));
        assertTrue(instance.contains(13));
        assertFalse(instance.contains(80));
        assertFalse(instance.contains(45));
    }    
    
    /**
     * Test of isLeaf method, of class TREE.
     */
    @Test
    public void testIsLeaf() {
        System.out.println("isLeaf");
        assertTrue(instance.isLeaf(7));
        assertTrue(instance.isLeaf(13));
        assertTrue(instance.isLeaf(17));
        assertTrue(instance.isLeaf(30));
        assertTrue(instance.isLeaf(50));
        assertFalse(instance.isLeaf(40));
        assertFalse(instance.isLeaf(20));
        assertFalse(instance.isLeaf(8));
        assertFalse(instance.isLeaf(999));
    }    
    /**
     * Test of autumnTree method, of class TREE.
     */
    @Test
    public void testAutumnTree() {
        System.out.println("autumntree");
        TREE<Integer> newTree = (TREE<Integer>) instance.autumnTree();
        
        Integer[] a = {8,10,15,20,40};
        assertEquals(Arrays.asList(a), newTree.inOrder());
        System.out.println(newTree);
    } 
    
    /**
     * Test of ascdes method, of class TREE.
     */
    @Test
    public void testAscdes() {
        System.out.println("ascdes");
        assertEquals(Arrays.asList(bstAscDes),instance.ascdes());
    } 
    
    /**
     * Test of ascdes method, of class TREE.
     */
    @Test
    public void testnumNodesByLevel() {
        System.out.println("numNodesByLevel");
        assertArrayEquals( nnodes, instance.numNodesByLevel());
    }  
}
