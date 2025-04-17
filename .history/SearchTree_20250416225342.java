
//advanced topics
import java.util.*;

public class SearchTree<E extends Comparable<E>> {

   private SearchTreeNode<E> overallRoot;

   // int tree search
   public void add(E data) {
      add(overallRoot, data);
   }

   private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
      if (root == null) {
         root = new SearchTreeNode<E>(value);
      } else if (value.compareTo(root.data) <= 0) {
         root.left = add(root.left, value);
      } else
         root.right = add(root.right, value);
      return root;
   }

   private boolean contains(SearchTreeNode<E> root, E value) {
      if (root == null) {
         return false;
      } else {
         int compare = value.compareTo(root.data);
         if (compare == 0) {
            return true;
         } else if (compare < 0) {
            return contains(root.left, value);
         } else {
            return contains(root.right, value);
         }
      }
   }

}