

package PL;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DEI-ESINF
 */
public class TREE_WORDSTest {
    
    public TREE_WORDSTest() {
    }

    /**
     * Test of createTree method, of class TREE_WORDS.
     */
    @Test
    public void testCreateTree() throws Exception {
        System.out.println("createTree");
        TREE_WORDS instance = new TREE_WORDS();
        instance.createTree();
        System.out.println(instance);
    }
    /**
     * Test of getWordOccurrences method, of class TREE_WORDS.
     */
    @Test
    public void testGetWordsOcorrences() throws Exception {
        System.out.println("getwordsoccurrences");
        int[] occurExpected = {1,2,3};
        String[][] wordsExpected = {{"casaco","correu","do","estava","fecho","frio","pois"},    //1
                                    {"Luis","a","disse","o","ola"},                             //2
                                    {"Maria"} };                                                //3

        TREE_WORDS instance = new TREE_WORDS();
        instance.createTree();
        Map<Integer,List<String>> occur = instance.getWordsOccurrences();

        int idx=0;
        for(Map.Entry<Integer,List<String>> e: occur.entrySet()){
            assertEquals(occurExpected[idx], e.getKey().intValue());
            assertEquals( Arrays.asList(wordsExpected[idx++]), e.getValue());
        }
    }  
}
