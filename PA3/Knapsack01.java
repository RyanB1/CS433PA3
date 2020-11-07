import java.util.Arrays;

public class Knapsack01 {
	
	public static int findOptimalProfit(final int profits[], final int weights[], int numElements, int capacity) { // complete this function
		int[] currentRow = new int[capacity + 1], prevRow = new int[capacity + 1];
		Arrays.fill(prevRow, 0);
		for (int i = 0; i < numElements; i++) {
			for (int j = capacity; j >= weights[i]; j--) {
				currentRow[j] = Math.max(prevRow[j], prevRow[j - weights[i]] + profits[i]);
			}
			prevRow = Arrays.copyOf(currentRow, currentRow.length);
		}
		return currentRow[capacity];
	}
}
