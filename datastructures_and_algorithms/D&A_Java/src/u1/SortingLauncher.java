package u1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Data Structures and Algorithms Lecture HFT.
 * 
 * This is the main function, responsible for generation of a random array and
 * calling different sorting algorithms to test the benchmark.
 * 
 * Just for fun! ;-)
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
	 * @param Integer
	 *            n (The range for the random number)
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
	 * @param n
	 *            (size for the array list)
	 * @return Integer ArrayList
	 */
	public static ArrayList<Integer> geneareRandomIntegerArrayList(int n) {

		ArrayList<Integer> list_1 = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			int test = createRandomNumber(n);
			list_1.add(test);
		}
		return list_1;
	}

	public static void benchmark(int iterations) {

		int n = 5000;
		for (int i = 0; i < iterations; i++) {
			// sample size
			System.out.println(">> starting benchmark tests [" + i + "] with "
					+ "n=" + n);
			// Create random ArrayList
			ArrayList<Integer> random_list = geneareRandomIntegerArrayList(n);
			ArrayList<Integer> random_list_2 = geneareRandomIntegerArrayList(n);
			ArrayList<Integer> random_list_3 = geneareRandomIntegerArrayList(n);
			ArrayList<Integer> random_list_4 = geneareRandomIntegerArrayList(n);

			// BubbleSort by Georg
			BubbleSort bub = new BubbleSort();
			@SuppressWarnings("unused")
			ArrayList<Integer> sorted_list_1 = bub.sort(random_list);

			// BubbleSort by Julian
			BubbleSortTwo bub_two = new BubbleSortTwo();
			@SuppressWarnings("unused")
			ArrayList<Integer> sorted_list_2 = bub_two.sort(random_list_2);

			// SimpleSort by Georg
			SimpleSort simpleSort = new SimpleSort();
			@SuppressWarnings("unused")
			ArrayList<Integer> sorted_list_3 = simpleSort.sort(random_list_3);

			// SimpleSortTwo by Julian
			SimpleSortTwo simpleSortTwo = new SimpleSortTwo();
			@SuppressWarnings("unused")
			ArrayList<Integer> sorted_list_4 = simpleSortTwo.sort(random_list_4);
			System.out.println(">> done!");
			n+=5000;
		}

	}

	public static void main(String[] args) {
		benchmark(10);
	}
}
