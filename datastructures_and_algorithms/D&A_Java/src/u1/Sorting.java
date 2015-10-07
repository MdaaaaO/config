package u1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Sorting {
	
	/**
	 * 
	 * @param list_1
	 */
	public static void bubbleSort(ArrayList<Integer> list_1) {
		System.out.print("before: ");
		for (int i = 0; i < list_1.size(); i++) {
			System.out.print(list_1.get(i) + " ");
		}

		int size = list_1.size();
		for (int i = 0; i < size-1; i++) {
			int iterater = 0;
			for (int j = 0; j < size-1-iterater; j++) {
				int tmp = list_1.get(j);
				int tmp_plus = list_1.get(j+1);
				
				if (tmp > tmp_plus) {
					// switch
					list_1.set(j, tmp_plus);
					list_1.set(j+1, tmp);
				}
			}
			iterater+=1;
		}
		
		System.out.print("\nafter: ");
		for (int i = 0; i < list_1.size(); i++) {
			System.out.print(list_1.get(i) + " ");
		}

	}
	
	/**
	 * 
	 * @param list_1
	 */
//	public static void bucketSort(ArrayList<Integer> list_1) {
//		int sorted_array[] = new int[list_1.size()];
//		for (int i : list_1) {
//			
//		}
//	}
	
	/**
	 * This method will create an Integer between 0 and 99
	 * @return Integer 0 - 99
	 */
	public static int createRandomNumber() {
		Random randomIntegerGenerator = new Random();
		return randomIntegerGenerator.nextInt(100);
	}
	
	public static void main(String[] args) {
		
		int n = 10;
		ArrayList<Integer> list_1 = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			int test = createRandomNumber();
			if (!list_1.contains(test)) {
				list_1.add(test);
			} else {
				System.out.println("Double: " + test + " ");
			}
		}
		
		bubbleSort(list_1);
//		for (int i : list_1) {
//			System.out.println(i);
//		}
//
//		Collections.sort(list_1);
//		
//		for (int i : list_1) {
//			System.out.println(i);
//		}
	}
}
