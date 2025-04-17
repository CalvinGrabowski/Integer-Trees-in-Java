//this is the binary tree build

public class Tree {

   //yes should be yes, no should be no
   
   int data;
   Tree right;
   Tree left;
   
   public Tree(int node) {
      this(node, null, null);                         //makes a basic tree
   }
   
   public Tree(int node, Tree left, Tree right) {     //makes a tree with a question/animal as the node and a path for yes and for no
      this.data = node;
      this.right = right;
      this.left = left;
   }
 
  //getters
   
   public Tree getYes() {
      return right;                            //returns the yes branch (tree)
   }
   
   public Tree getNo() {
      return left;                             //returns the no branch (tree)
   }
   
  
   
   public Integer data() {
      return data;
   }

   public void print() {
      System.out.println(data);
   }
}