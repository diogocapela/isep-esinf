
package PL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author DEI-ESINF
 */
public class TREE_WORDS extends BST<TextWord> {
    
    public void createTree() throws FileNotFoundException{
        Scanner readfile = new Scanner(new File("src/PL/xxx.xxx"));
        while(readfile.hasNextLine()){
            String[] pal = readfile.nextLine().split("(\\,)|(\\s)|(\\.)");
            for(String word : pal)
                if (word.length() >0 )
                    insert(new TextWord(word, 1));
        }
        readfile.close();
    }

    /**
     * Inserts a new word in the tree, or increments the number of its occurrences.
       * @param element
     */
    @Override
    public void insert(TextWord element){
        root = insert(element, root);
    }
    
    private Node<TextWord> insert(TextWord element, Node<TextWord> node){
        throw new UnsupportedOperationException("Not supported yet.");

    }

    /**
     * Returns a map with a list of words for each occurrence found.
     * @return a map with a list of words for each occurrence found.
     */
    public Map<Integer,List<String>> getWordsOccurrences(){
        throw new UnsupportedOperationException("Not supported yet.");

    }

}
