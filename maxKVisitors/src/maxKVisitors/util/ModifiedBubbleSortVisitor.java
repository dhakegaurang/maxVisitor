package maxKVisitors.util;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import maxKVisitors.util.MyLogger.DebugLevel;
/**
* ModifiedBubbleSortVisitor program is responsible for sorting instance of vector and array using modified_bubblesort
*
* @author  Gaurang Dhake
* @version 1.0
* @since   07/21/2018
*/
public class ModifiedBubbleSortVisitor implements VisitorI {
	private int K;
	private Results resultObj;
	private DebugLevel debugLevel;
	
	public ModifiedBubbleSortVisitor(int kin, Results resultObj) { 
		this.debugLevel = DebugLevel.MODIFIED_BUBBLE_SORT_VISITOR;
		MyLogger.writeMessage("in ModifiedBubbleSortVisitor constructor", debugLevel);
		K = kin;
		this.resultObj = resultObj;
	}
	/**
	   * This visit method from VisitorI interface makes sure that vector is sorted by bubblesort algorithm
	   * @param vectorObj from driver for sorting
	   * @return None Since it is of type void
	   */
	@Override
	public void visit(MyVector vectorObj) {
		MyLogger.writeMessage("in ModifiedBubbleSortVisitor class, visit method of vector instance", debugLevel);
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
	/**
	   * This visit method from VisitorI interface makes sure that array is sorted by bubblesort algorithm
	   * @param arrayObj from driver for sorting by bubblesort
	   * @return None Since it is of type void
	   */
	@Override
	public void visit(MyArray arrayObj) {
		MyLogger.writeMessage("in ModifiedBubbleSortVisitor class, visit method of array instance", debugLevel);
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
		resultObj.storeNewResult(sb.toString()+"\n");
		
	}
	
}
