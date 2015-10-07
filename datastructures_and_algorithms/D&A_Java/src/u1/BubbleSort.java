package u1;

import java.util.ArrayList;
/**
 * This is the well known bubble sort algorithm, extended with an iterator count
 * to avoid checking the last number in the list after swapping.
 * 
 * @date 10/07/2015
 * @author Georg Kasper
 *
 */
public class BubbleSort {
  
  public ArrayList<Integer> sort(ArrayList<Integer> integer_list) {
    
    int size = integer_list.size();
    
    for (int i = 0; i < size - 1; i++) {
      boolean swapped = false;
      int iterator = 0;
      for (int j = 0; j < size - 1 - iterator; j++) {
        int tmp = integer_list.get(j);
        int tmp_plus = integer_list.get(j + 1);

        if (tmp > tmp_plus) {
          // switch
          integer_list.set(j, tmp_plus);
          integer_list.set(j + 1, tmp);
          swapped = true;
        }
      }
      iterator += 1;
      if (swapped == false) {
        break;
      }
    }
    return integer_list;
  }
}
