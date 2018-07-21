package maxKVisitors.util;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ModifiedBubbleSortVisitor implements VisitorI {
	int K = 0;

	public ModifiedBubbleSortVisitor(int kin) {
		K = kin;
	}

	@Override
	public void visit(MyVector vectorObj) {
		Vector<Integer> vector = vectorObj.getVector();
		
		for(int i=0;i<vector.size();i++) {
			for(int j=0;j<vector.size();j++) {
				if(vector.get(i) < vector.get(j)) {
					int temp = vector.get(i);
					vector.set(i, vector.get(j));
					vector.set(j, temp);
				}
			}
		}
	}

	@Override
	public void visit(MyArray arrayObj) {
		List<Integer> array = arrayObj.getArray();

		for(int i=0;i<array.size();i++) {
			for(int j=0;j<array.size();j++) {
				if(array.get(i) < array.get(j)) {
					int temp = array.get(i);
					array.set(i, array.get(j));
					array.set(j, temp);
				}
			}
		}
	}
	
}
