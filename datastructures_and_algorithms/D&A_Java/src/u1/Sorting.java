package u1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Data Structures and Algorithms Lecture HFT.
 * 
 * This is the main function, responsible for generation of a random array and
 * calling different sorting algorithms to test the benchmark. 
 *      
 *      Just for fun! ;-)
 * 
 * @date 10/07/2015
 * @author Georg Kasper
 *
 */
public class Sorting {
  
  /**
   * This method will generate a random number within the range. Be careful, 
   * this numbers are not unique!
   * 
   * @param Integer n (The range for the random number)
   * @return Integer 
   */
  public static int createRandomNumber(int n) {
    Random randomIntegerGenerator = new Random();
    return randomIntegerGenerator.nextInt(n);
  }
  
  /**
   * This method will generate an random Integer ArrayList with the size of n.
   * Be careful, the ArrayList is not filled with unique numbers!
   * 
   * @param n (size for the array list)
   * @return Integer ArrayList
   */
  public static ArrayList<Integer> geneareRandomIntegerArrayList(int n) {
    
    System.out.println("creating array list");
    ArrayList<Integer> list_1 = new ArrayList<Integer>();

    for (int i = 0; i < n; i++) {
      int test = createRandomNumber(n);
//      if (!list_1.contains(test)) {
        list_1.add(test);
//      } 
    }
    System.out.println("list size: " + list_1.size());
    return list_1;
  }

  public static void main(String[] args) {
    
    int n = 10000; // unique numbers to generate
    
    // Fill ArrayList
    ArrayList<Integer> random_list = geneareRandomIntegerArrayList(n);
    ArrayList<Integer> random_list_sorted = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      random_list_sorted.add(i);
    }
//    System.out.println("unsorted: " + random_list.toString());
//    System.out.println("sorted: " + random_list_sorted.toString());
    
    // BubbleSort unsorted array list
    System.out.print("(unsorted) BubbleSort, ");
    BubbleSort bub = new BubbleSort();
    long startTime = System.currentTimeMillis();
    @SuppressWarnings("unused")
    ArrayList<Integer> sorted_list_1 = bub.sort(random_list);
    long endTime = System.currentTimeMillis();
//    System.out.println("\n" + sorted_list_1.toString());
    System.out.println("Total execution time: " + (endTime-startTime) + "ms"); 

    // BubbleSort sorted array list
    System.out.print("(sorted) BubbleSort, ");
    startTime = System.currentTimeMillis();
    @SuppressWarnings("unused")
    ArrayList<Integer> sorted_list_3 = bub.sort(random_list_sorted);
    endTime = System.currentTimeMillis();
    System.out.println("Total execution time: " + (endTime-startTime) + "ms"); 

    // SimpleSort unsorted array list
    System.out.print("(unsorted) SimpleSort, ");
    SimpleSort simpleSort = new SimpleSort();
    startTime = System.currentTimeMillis();
    @SuppressWarnings("unused")
    ArrayList<Integer> sorted_list_2 = simpleSort.sort(random_list);
    endTime = System.currentTimeMillis();
//    System.out.println("\n" + sorted_list_2.toString());
    System.out.println("Total execution time: " + (endTime-startTime) + "ms"); 
    
    // SimpleSort sorted array list
    System.out.print("(sorted) SimpleSort, ");
    startTime = System.currentTimeMillis();
    @SuppressWarnings("unused")
    ArrayList<Integer> sorted_list_4 = simpleSort.sort(random_list);
    endTime = System.currentTimeMillis();
    System.out.println("Total execution time: " + (endTime-startTime) + "ms"); 
    
  }
}
