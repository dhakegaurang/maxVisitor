package maxKVisitors.util;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ModifiedBubbleSortVisitor implements VisitorI {
	private int K;
	private Results resultObj;
	
	public ModifiedBubbleSortVisitor(int kin, Results resultObj) { 
		K = kin;
		this.resultObj = resultObj;
	}

	@Override
	public void visit(MyVector vectorObj) {
		Vector<Integer> vector = vectorObj.getVector();
		StringBuilder sb = new StringBuilder();
		sb.append("Modified BubbleSort Vector: ");
		
		for(int i=0;i<vector.size();i++) {
			for(int j=0;j<vector.size();j++) {
				if(vector.get(i) > vector.get(j)) {
					int temp = vector.get(i);
					vector.set(i, vector.get(j));
					vector.set(j, temp);
				}
			}
		}
		
		for(int count = 0;count < K && count < vector.size(); count++) {
			sb.append(vector.get(count)+" ");
		}
		resultObj.storeNewResult(sb.toString()+"\n");
	}

	@Override
	public void visit(MyArray arrayObj) {
		List<Integer> array = arrayObj.getArray();
		StringBuilder sb = new StringBuilder();
		sb.append("Modified BubbleSort Array: ");
		
		for(int i=0;i<array.size();i++) {
			for(int j=0;j<array.size();j++) {
				if(array.get(i) > array.get(j)) {
					int temp = array.get(i);
					array.set(i, array.get(j));
					array.set(j, temp);
				}
			}
		}
		for(int count = 0;count < K && count < array.size(); count++) {
			sb.append(array.get(count)+" ");
		}
		System.out.println(sb.toString());
		
	}
	
}
