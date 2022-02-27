package tree;

import java.util.List;

public class Utils {

   public static <E extends Comparable<E>> Iterable<E> sortByBST(List<E> listUnsorted) {
      BST tree = new BST();
      for (E e : listUnsorted) {
         tree.insert(e);
      }
      return tree.inOrder();
   }
}
