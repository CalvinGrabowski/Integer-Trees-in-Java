//Advanced Topics
//Chapter 17 Exercise # 3, 7, 8, 15, & 20

public class TreeUser {
   
   public static void main(String[] args) {
   
      //these are the methods that the book made me write throughout chapter 17
      IntTree tree = new IntTree(17);
      tree.printSideways();
      tree.printPreorder();
      tree.printInorder();
      tree.printPostorder();
      System.out.println(tree.sum());
      System.out.println(tree.countLevels());
      System.out.println(tree.countLeaves());
      
      //these are the three reference trees and this allowed me to make sure my code worked for anything that I could throw at it
      IntTree tree1 = new IntTree(3, new Tree(5, new Tree(1), null), new Tree(2, new Tree(4), new Tree(6)));
      tree1.printSideways();
      IntTree tree2 = new IntTree(2, new Tree(8, new Tree(0), null), new Tree(1, new Tree(7, new Tree(4), null), new Tree(6, null, new Tree(9))));
      tree2.printSideways();
      IntTree tree3 = new IntTree(2, new Tree(3, new Tree(8), new Tree(7)), new Tree(1));
      tree3.printSideways();
      
      // #3
      System.out.println(tree1.depthSum());
      // #7
      System.out.println(tree1.isFull());
      System.out.println(tree2.isFull());
      System.out.println(tree3.isFull());
      System.out.println(tree.isFull());
      // #8
      System.out.println(tree1);
      System.out.println(tree2);
      System.out.println(tree3);
      // #15
      System.out.println(tree.trim(2,5)); //this method requires the tree to be sorted so I used the tree builder
      System.out.println(tree.trim(1,3));
      System.out.println(tree.trim(1,5));
      // #20
      tree.makePerfect().printSideways();
      tree1.makePerfect().printSideways();
      tree2.makePerfect().printSideways();
      tree3.makePerfect().printSideways();
   }

}