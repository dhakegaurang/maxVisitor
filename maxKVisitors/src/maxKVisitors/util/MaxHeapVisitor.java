package maxKVisitors.util;

import java.util.List;
import java.util.Vector;

import maxKVisitors.util.MyLogger.DebugLevel;
/**
* MaxHeapVisitor program is responsible for sorting instance of vector and array using heapsort
*
* @author  Gaurang Dhake
* @version 1.0
* @since   07/21/2018
*/
public class MaxHeapVisitor implements VisitorI{
	private int K;
	private Results resultObj;
	private DebugLevel debugLevel;
	
	public MaxHeapVisitor(int kin, Results resultObj) {
		this.debugLevel = DebugLevel.MAX_HEAP_VISITOR;
		MyLogger.writeMessage("in MaxHeapVisitor constructor", debugLevel);
		K = kin; 
		this.resultObj = resultObj;
	}
	/**
	   * This visit method from VisitorI interface makes sure that vector is sorted by maxheap algorithm
	   * @param vectorObj from driver for sorting
	   * @return None Since it is of type void
	   */
	@Override
	public void visit(MyVector vectorObj) {
		MyLogger.writeMessage("in MaxHeapVisitor class, visit method of vector instance", debugLevel);
		Vector<Integer> vector = vectorObj.getVector();
		StringBuilder sb = new StringBuilder();
		sb.append("Max-Heap Vector: ");
		int length = vector.size();
		int count = K;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(vector, length, i);
        }
        
        for (int i=length-1; i>=0 && count > 0; i--,count--){
        	
        	int temp = vector.get(0);
        	vector.set(0, vector.get(i));
        	vector.set(i, temp);
            heapify(vector, i, 0);
            sb.append(vector.get(i)+" ");
        }
        resultObj.storeNewResult(sb.toString()+"\n");
	}
	
	/**
	   * This visit method from VisitorI interface makes sure that array is sorted by maxheap algorithm
	   * @param arrayObj from driver for sorting by heapsort
	   * @return None Since it is of type void
	   */
	@Override
	public void visit(MyArray arrayObj) {
		MyLogger.writeMessage("in MaxHeapVisitor class, visit method of array instance", debugLevel);
		List<Integer> array = arrayObj.getArray();
		StringBuilder sb = new StringBuilder();
		sb.append("Max-Heap Array: ");
		int length = array.size();
		int count = K;
		
        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(array, length, i);
        
        for (int i=length-1; i>=0 && count > 0; i--,count--)
        {
        	int temp = array.get(0);
        	array.set(0, array.get(i));
        	array.set(i, temp);
            heapify(array, i, 0);
            sb.append(array.get(i)+" ");
        }
        resultObj.storeNewResult(sb.toString()+"\n");
	}
	/**
	   * This heapify method is recursive method for sorting vector using maxheap technique
	   * @param vector populated vector
	   * @param n is the size of vector
	   * @param i is assumed to be the largest first element in vector
	   * @return None Since it is of type void
	   */
	void heapify(Vector<Integer> vector, int n, int i){	
		MyLogger.writeMessage("in MaxHeapVisitor class, heapify method of vector instance", debugLevel);
		int largest = i;
        int l = 2*i + 1;  
        int r = 2*i + 2;  
 
        if (l < n && vector.get(l) > vector.get(largest))
        	largest = l;
 
        if (r < n && vector.get(r) > vector.get(largest))
        	largest = r;
 
        if (largest != i){
        	int swap = vector.get(i);
        	vector.set(i, vector.get(largest));
        	vector.set(largest, swap);
        	
            heapify(vector, n, largest);
        }
    }
	/**
	   * This heapify method is recursive method for sorting array using maxheap technique
	   * @param vector populated vector
	   * @param n is the size of vector
	   * @param i is assumed to be the largest first element in array
	   * @return None Since it is of type void
	   */
	void heapify(List<Integer> array, int n, int i){
		MyLogger.writeMessage("in MaxHeapVisitor class, heapify method of array instance", debugLevel);
		int largest = i; 
        int l = 2*i + 1;  
        int r = 2*i + 2;  
 
        if (l < n && array.get(l) > array.get(largest))
        	largest = l;
        
        if (r < n && array.get(r) > array.get(largest))
        	largest = r;
 
        if (largest != i)
        {
        	int swap = array.get(i);
        	array.set(i, array.get(largest));
        	array.set(largest, swap);
            heapify(array, n, largest);
        }
    }
	
}
