package u1;

import java.util.ArrayList;

/**
 * This is the method whitch a human would use to sort numbers. 
 * We will start with looking for the smalles number and then switching it to 
 * the front of our ArrayList!
 * 
 * @author Kasper
 *
 */
public class SimpleSort {

  public ArrayList<Integer> sort(ArrayList<Integer> integer_list) {
    int minNumber;
    int indexMinNumber = 0;

    for (int n = 0; n < integer_list.size(); n++) {
      minNumber = integer_list.get(n);
      for (int i = n; i < integer_list.size(); i++) {
        if (minNumber > integer_list.get(i)) {
          minNumber = integer_list.get(i);
          indexMinNumber = i;
        }
      }
//      System.out.println("minNumber=" + minNumber + " with index=" 
//          + indexMinNumber);
      // at this point you want to put the minNumber at position n
      int tmp_swap_high = integer_list.get(indexMinNumber);
      integer_list.set(n, minNumber);
      integer_list.set(indexMinNumber, tmp_swap_high);
    }
    return integer_list;
  }
}
