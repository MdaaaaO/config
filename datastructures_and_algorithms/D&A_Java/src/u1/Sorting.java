package u1;

import java.util.ArrayList;
import java.util.Random;

public class Sorting {

  public static int createRandomNumber() {
    Random randomIntegerGenerator = new Random();
    return randomIntegerGenerator.nextInt(100);
  }

  public static ArrayList<Integer> geneareRandomIntegerArrayList(int n) {
    
    ArrayList<Integer> list_1 = new ArrayList<Integer>();

    for (int i = 0; i < n; i++) {
      int test = createRandomNumber();
      if (!list_1.contains(test)) {
        list_1.add(test);
      } else {
        System.out.println("Double: " + test + " ");
      }
    }
    return list_1;
  }

  public static void main(String[] args) {
    
    int n = 10; // unique numbers to generate
    
    System.out.println("Creating random ArrayList with a lengh of " + n );
    ArrayList<Integer> random_list = geneareRandomIntegerArrayList(n);
    System.out.println("Done!");
    
    // BubbleSort
    System.out.println("Sorting ArrayList using BubbleSort Algorithm");
    BubbleSort bub = new BubbleSort();
    bub.sort(random_list);
  }
}
