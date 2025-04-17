

public class Tree {
   
   //this is normally called tree node but I named it tree because it makes more sense in my head and is quicker to type out
   public int data;
   public Tree left;
   public Tree right;
   
   //these are two constructors that make and store the data, the left branch, and the right branch
   public Tree(int data) {
      this(data,null,null);
   }
   
   public Tree(int data, Tree left, Tree right) {
      this.data = data;
      this.left = left;
      this.right = right;
   
   }
   
   
 
}