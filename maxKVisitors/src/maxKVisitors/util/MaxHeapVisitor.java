package maxKVisitors.util;

import java.util.List;
import java.util.Vector;

public class MaxHeapVisitor implements VisitorI{
	private int K;
	private Results resultObj;
	public MaxHeapVisitor(int kin, Results resultObj) {
		K = kin; 
		this.resultObj = resultObj;
	}

	@Override
	public void visit(MyVector vectorObj) {
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
	
	@Override
	public void visit(MyArray arrayObj) {
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
	
	void heapify(Vector<Integer> vector, int n, int i){	
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
	
	void heapify(List<Integer> array, int n, int i){
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
