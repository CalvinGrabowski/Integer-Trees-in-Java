//Calvin Grabowski
//Advanced Topics
//Period 7
//Chapter 17 Binary Trees

public class IntTree {
      
   private Tree overallRoot;
   
   //this constructs a tree with max # of branches
   public IntTree(int max) {
      if(max < 0) {
         throw new IllegalArgumentException("max: " + max);
      } //this makes the tree not accept any negative number or zero
      overallRoot = buildTree(1, max);
   }
   
   //this makes me able to construct trees in whatever way I want and allows myself the ablity to make trees into IntTrees
   public IntTree(int num, Tree left, Tree right) {
      overallRoot = new Tree(num, left, right);
   }
   
   
   private Tree buildTree(int n, int max) {
     //this counts each spot as one number up to #max
      if(n > max) {
         return null;
      }
      else {
         return new Tree(n, buildTree(2 * n, max), buildTree(2 * n + 1, max));
      }
   }
   
   
   public void printPreorder() {
      System.out.print("preorder: ");
      printPreorder(overallRoot);
      System.out.println();
   }
   //this reads it by printing the top to the left until it hits the bottom where it will go up and to the right when it can then all the way to the left 
   private void printPreorder(Tree root) {
      if(root != null) {
         System.out.print(" " + root.data);
         printPreorder(root.left);
         printPreorder(root.right);
      }
      
   }
   
   
   public void printInorder() {
      System.out.print("Inorder: ");
      printInorder(overallRoot);
      System.out.println();
   }
   //It reads from left to right 
   private void printInorder(Tree root) {
      if(root != null) {
         printInorder(root.left);
         System.out.print(" " + root.data);
         printInorder(root.right);
      }
   }
   
   
   public void printPostorder() {
      System.out.print("Postorder: ");
      printPreorder(overallRoot);
      System.out.println();
   }
   //goes from the top and all the way to the bottom left, then it goes up and to the right, 
   //then up, then to the right and down to the left, then up and to the right, climbing up the ladder
   private void printPostorder(Tree root) {
      if(root != null) {
         printPostorder(root.left);
         printPostorder(root.right);
         System.out.println(" " + root.data);
      }
   }
   
   
   public void printSideways() {
      System.out.println("printSideways: ");
      printSideways(overallRoot, 0);
      System.out.println();
   }
   //this prints it sideways with tabs in between the letters showing how far the levels are.
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
   
   //another method the book made me write to make count the sum of the tree
   public int sum() {
      System.out.print("sum : ");
      return sum(overallRoot);
   }
   private int sum(Tree root) {
      if(root == null) {
         return 0;
      }
      else {
         //this adds all the numbers in the tree and the branches by recursing the branches
         return root.data + sum(root.left) + sum(root.right);
      }
   }
   
   public int countLevels() {
      System.out.print("countLevels: ");
      return countLevels(overallRoot);
   }
   //this counted the level spliting off into all directions
   private int countLevels(Tree root) {
      if(root == null) {
         return 0;
      }
      else {
         //this made sure that it only took the greater number out of left and right so you wouldn't get the total amount of pathways
         return 1 + Math.max(countLevels(root.left), countLevels(root.right));
      }
   }
   
   //yet another method the book made me write and it counted all the leaves 
   public int countLeaves() {
      System.out.print("countLeaves: ");
      return countLeaves(overallRoot);
   }
   //this made the 
   private int countLeaves(Tree root) {
      if(root != null) {
         //this made each branch return the number of branches it had until it reached the top and that was the total
         return 1 + countLeaves(root.left) + countLeaves(root.right);
      }
      else {
         return 0;
      }
   }
   
   // #3  
   public int depthSum() {
      return depthSum(overallRoot, 1);
   }
   //this goes through and counts each level and adds up one each time it goes to the left or right
   //and it also holds the root that gets past through it
   private int depthSum(Tree root, int level) {
      if(root == null) {
         return 0;
      }
      else {
         //this multiplied the level by the depth and the level times the number in the branch
         return root.data * level + depthSum(root.left, level+1) + depthSum(root.right, level+1);
      }
   }
   
   // #7
   public boolean isFull() {
      return isFull(overallRoot);
   }
   //this saw if the tree had both left and right branches either be null or numbers no in between
   private boolean isFull(Tree root) {
      if(root == null) {
         return true;
      }
      if(root.left == null && root.right == null) {
         return true;
      }  
      //if there was any branches that had a number on one side and null on the other the code resulted in false
      if(root.left != null && root.right != null) {
         return isFull(root.left) && isFull(root.right);
      }
      return false;
   }
   
   
   // #8: This would pring the method with all the slots of a tree being filled from the same perspective as making a tree
   //like how I made the reference trees it looks a lot like how I made those
   public String toString() {
      return toString(overallRoot);
   }
   
   private String toString(Tree root) {
      //this returns the number with the (z,x,x) format for each x gets recursed and they can be empty and return empty
      if(root != null) {
         return "(" + root.data + ", " + toString(root.left) + ", " + toString(root.right) + ")";
      }
      return "empty";
      
   }
   
   // #15: this cut the trees to only follow the pathways that fit within the min and the max
   // the first part would call the method trim and make sure that it wouldn't break if it returned null
   public IntTree trim(int min, int max) {
      Tree test = trim(overallRoot, min, max);
      if(test != null) {
         return new IntTree(test.data, test.left, test.right);
      }
      else {
         return null;
      }
   }
   //this second part would make it so it would keep anything unless it was outside the boundries of the min and the max
   private Tree trim(Tree root, int min, int max) {
      if(root.data < min || root.data > max) {
         return null;
      }
      else { 
         return new Tree(root.data, trim(root.left, min, max), trim(root.right, min, max));
      }
   }
   
   
   
   
   // #20: This makes sure that every node up to the bottom will be full
   // the first part only calls the method so it can stay privated and unaffected from the world around it
   public IntTree makePerfect() {
      System.out.println("Perfect Tree:");
      int levels = countLevels(overallRoot);
      Tree tree = makePerfect(overallRoot, levels);
      return new IntTree(tree.data, tree.left, tree.right);
   }
   // This makes the tree add 0 to each side that doesn't have a number until it reaches the bottom
   private Tree makePerfect(Tree root, int levels) {
      if(root.left == null || root.right == null || root.right == null && root.left == null) {
         if(levels > 0) {
            //the levels keeps track of how far the method has to go and makes sure there was not anything added after that
           // that purpose is to stop it from going indefently with 0's    
            if(root.left == null) 
               root.left = new Tree(0);
            if(root.right == null) 
               root.right = new Tree(0);
            //this farm ^ makes all nulls become 0's if they are still within the level limit
            return new Tree(root.data, makePerfect(root.left, levels-1), makePerfect(root.right, levels-1));
         }
         else {
            //outside the levels there is nothing but nulls
            return null;
         }
      }
      else {
         //this makes sure that all levels that didn't have null would be repeated until the end
         if(levels >= 0) 
            return new Tree(root.data, makePerfect(root.left, levels-1), makePerfect(root.right, levels-1));
         return null; 
         //has null so it can end
      }
   }
   

}