package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TREE_WORDS extends BST<TextWord> {

   public void createTree() throws FileNotFoundException {
      Scanner readfile = new Scanner(new File("src/main/resources/TREE_WORDSHelper.txt"));
      while (readfile.hasNextLine()) {
         String[] pal = readfile.nextLine().split("(\\,)|(\\s)|(\\.)");
         for (String word : pal)
            if (word.length() > 0)
               insert(new TextWord(word, 1));
      }
      readfile.close();
   }

   /**
    * Inserts a new word in the tree, or increments the number of its occurrences.
    *
    * @param element
    */
   @Override
   public void insert(TextWord element) {
      root = insert(element, root);
   }

   private Node<TextWord> insert(TextWord element, Node<TextWord> node) {
      if (node == null) {
         return new Node(element, null, null);
      }

      if (node.getElement().compareTo(element) < 0) {
         node.setRight(insert(element, node.getRight()));
         return node;
      }

      if (node.getElement().compareTo(element) > 0) {
         node.setLeft(insert(element, node.getLeft()));
         return node;
      }

      node.getElement().incOcorrences();
      return node;

   }

   /**
    * Returns a map with a list of words for each occurrence found.
    *
    * @return a map with a list of words for each occurrence found.
    */
   public Map<Integer, List<String>> getWordsOccurrences() {
      Map<Integer, List<String>> map = new HashMap<>();
      for (TextWord tx : inOrder()) {
         int numberOfOcorrences = tx.getOcorrences();
         if (!map.containsKey(numberOfOcorrences)) {
            map.put(numberOfOcorrences, new ArrayList<String>());
         }
         map.get(numberOfOcorrences).add(tx.getWord());
      }
      return map;
   }

}
