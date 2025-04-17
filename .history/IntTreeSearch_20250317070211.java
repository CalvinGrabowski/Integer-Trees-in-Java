//int tree search

public class IntTreeSearch {

   private Tree overallRoot;
   
   public IntTreeSearch() {
      overallRoot = null;
   }
   
   public boolean contains(int value) {
      return contains(overallRoot, value);
   }
   public boolean contains(Tree root, int value) {
      if(root == null) {
         return false;
      }
      else if(root.data == value) {
         return true;
      }
      if(root.data > value) {
         return contains(root.left, value);
      }
      else {
         return contains (root.right, value);
      }  
      
   }
   
   
   
   public void add(int value) {
      overallRoot = add(overallRoot, value);
   }
   private Tree add(Tree root, int value) {
      if(root == null) {
         root = new Tree(value);
         //System.out.println(root.data);
      }
      else if(value <= root.data) {
         //add to the left
         root.left = add(root.left, value);
         
      }
      else {
         //add to the right
         root.right = add(root.right, value);
      }
      return root;
   }
   
   public void print() {
      System.out.print("In order: ");
      print(overallRoot);
      System.out.println();
   }
   //It reads from left to right 
   private void print(Tree root) {
      if(root != null) {
         print(root.left);
         System.out.print(" " + root.data);
         print(root.right);
      }
   }
   
   public void printSideways() {
      System.out.println("printSideways: ");
      printSideways(overallRoot, 0);
      System.out.println();
   }
   private void printSideways(Tree root, int level) {
      if(root!= null) {
         printSideways(root.right, level + 1);
         for(int i = 0; i < level; i++) {
            System.out.print("    ");
         }
         System.out.println(root.data);
         //it counts up one every time it goes to the right or left showing the different levels and adding that many spaces
         printSideways(root.left, level + 1);      
      }
   }
   
}