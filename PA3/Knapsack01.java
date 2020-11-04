import java.util.Arrays;

public class Knapsack01 {
	
	public static int findOptimalProfit(final int profits[], final int weights[], int numElements, int capacity) { // complete this function
		int[] currentRow = new int[capacity + 1], preRow = new int[capacity + 1];
		Arrays.fill(preRow, 0);
		for (int i = 0; i < numElements; i++) {
			if (weights[i] > capacity) {
				// assign currentRow[j] = prevRow[j], where O <= j < weights[i]
				for (int j = weights[i]; j <= capacity; j++) {
					currentRow[j] = Math.max(preRow[j], preRow[j - weights[i]] + profits[i]);
				}
			}
			preRow = Arrays.copyOf(currentRow, currentRow.length);
		}
		return currentRow[capacity];
	}
}
