import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MWIS extends Tree {

	public int computedSum[];
	boolean isIncludedSumLarger[];
	boolean isInSet[];

	public MWIS(final String filePath) throws FileNotFoundException {
		super(filePath);
		computedSum = new int[numNodes];
		isIncludedSumLarger = new boolean[numNodes];
		isInSet = new boolean[numNodes];
		for (int i = 0; i < numNodes; i++) {
			computedSum[i] = Integer.MIN_VALUE;
			isIncludedSumLarger[i] = false;
			isInSet[i] = false;
		}
	}

	public int computeSum(int node) { 
		if(computedSum[node] != Integer.MIN_VALUE) {
			return computedSum[node];
		}
		int excl = 0;
		int incl = weights[node];
		ArrayList<Integer> children = new ArrayList<Integer>(adjList.get(node));
		for(int i = 0; i < children.size(); i++) {
			int child = children.get(i);
			excl += computeSum(child);
			//Not finished
		}
		if(incl > excl) {
			computedSum[node] = incl;
			isIncludedSumLarger[node] = true;
		}else {
			computedSum[node] = excl;
		}
		return computedSum[node];
	}

	public void computeSet(int root) { // complete this function
	}

	private void computeSetHelper(int node, int parent) { // complete this function
	}
}
