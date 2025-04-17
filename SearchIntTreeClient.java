//more classes that the book gives

import java.util.*;

public class SearchIntTreeClient {
   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      IntTreeSearch numbers = new IntTreeSearch();

      System.out.print("Next int (0 to quit)? ");
      int number = sc.nextInt();

      while (number != 0) {
         numbers.add(number);
         System.out.print("Next int (0 to quit)? ");
         number = sc.nextInt();
      }
      System.out.println();

      System.out.println("Tree structure: ");
      numbers.printSideways();
      System.out.println("Sorted list: ");
      numbers.print();

      while (true) {
         System.out.print("Search for number (0 to quit): ");
         number = sc.nextInt();
         if (number == 0) {
            break;
         } else {
            System.out.println(numbers.contains(number));
         }
      }
   }

}