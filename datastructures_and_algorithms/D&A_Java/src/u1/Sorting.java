package u1;

import java.util.ArrayList;
import java.util.Random;

public class Sorting {
  
  public static void arrayListToString(ArrayList<Integer> some_list) {
    for (int i = 0; i < some_list.size(); i++) {
      System.out.print(some_list.get(i) + " ");
    }
    System.out.println("");
  }

  public static int createRandomNumber(int n) {
    Random randomIntegerGenerator = new Random();
    return randomIntegerGenerator.nextInt(n);
  }

  public static ArrayList<Integer> geneareRandomIntegerArrayList(int n) {
    
    System.out.println("creating array list");
    ArrayList<Integer> list_1 = new ArrayList<Integer>();

    for (int i = 0; i < n; i++) {
      int test = createRandomNumber(n);
      if (!list_1.contains(test)) {
        list_1.add(test);
      } 
    }
    System.out.println("list size: " + list_1.size());
    return list_1;
  }

  public static void main(String[] args) {
    
    int n = 100000; // unique numbers to generate
    
    // Fill ArrayList
    ArrayList<Integer> random_list = geneareRandomIntegerArrayList(n);
//    arrayListToString(random_list);
    
    // BubbleSort
    System.out.print("BubbleSort, ");
    BubbleSort bub = new BubbleSort();
    // ...benchmark
    long startTime = System.currentTimeMillis();
    ArrayList<Integer> sorted_list_1 = bub.sort(random_list);
    long endTime = System.currentTimeMillis();
    System.out.println("Total execution time: " + (endTime-startTime) + "ms"); 
//    arrayListToString(sorted_list_1);

    // SimpleSort
    System.out.print("SimpleSort, ");
    SimpleSort simpleSort = new SimpleSort();
    startTime = System.currentTimeMillis();
    ArrayList<Integer> sorted_list_2 = simpleSort.sort(random_list);
    endTime = System.currentTimeMillis();
    System.out.println("Total execution time: " + (endTime-startTime) + "ms"); 
//    arrayListToString(sorted_list_2);
    
  }
}
