import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

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
		int excl = 0, incl = weights[node];
		List<Integer> children = new ArrayList<>(adjList.get(node));
		for(int i = 0; i < children.size(); i++) {
			int child = children.get(i);
			excl += computeSum(child);
			List<Integer> grandChildren = new ArrayList<>(adjList.get(child));
			for (int j = 0; j < grandChildren.size(); j++) {
				incl += computeSum(grandChildren.get(j));
			}
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
		// Do we make excl and incl class variables????
	}

	private void computeSetHelper(int node, int parent) { // complete this function
	}
}
