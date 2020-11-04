
public class Knapsack01 {
	
	public static int findOptimalProfit(final int profits[], final int weights[], int numElements, int capacity) { // complete this function
		int[] currentRow = new int[capacity + 1], preRow = new int[capacity + 1];
		for (int i = 0; i < preRow.length; i++) {
			preRow[i] = 0;
		}
		for (int i = 0; i < numElements; i++) {
			if (weights[i] > capacity) {
				// assign currentRow[j] = prevRow[j], where O <= j < weights[i]
				for (int j = weights[i]; j <= capacity; j++) {
					currentRow[j] = Math.max(preRow[j], preRow[j - weights[i]] + profits[i]);
				}
			}
			for (int j = 0; i < currentRow.length; i++) {
				currentRow[j] = preRow[j];
			}
		}
		return currentRow[capacity];
	}
}
