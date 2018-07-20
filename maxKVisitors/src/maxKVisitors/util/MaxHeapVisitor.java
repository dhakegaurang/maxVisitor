package maxKVisitors.util;

import java.util.List;
import java.util.Vector;

public class MaxHeapVisitor implements VisitorI{
	int K = 0;

	public MaxHeapVisitor(int kin) {
		K = kin;
	}

	@Override
	public void visit(MyVector vectorObj) {
		int n = vectorObj.getVector().size();
		Vector<Integer> vector = vectorObj.getVector();
		 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(vector, n, i);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            
            // call max heapify on the reduced heap
            heapify(vector, i, 0);
            System.out.println(vector.get(0)); 
        }

        System.out.println(vector);
	}

	@Override
	public void visit(MyArray arrayObj) {
		int n = arrayObj.getArray().size();
		List<Integer> array = arrayObj.getArray();
		 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            
            // call max heapify on the reduced heap
            heapify(array, i, 0);
            System.out.println(array.get(0)); 
        }
        System.out.println(array);
	}
	
	void heapify(Vector<Integer> vector, int n, int i)
    {	
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && vector.get(l) > vector.get(largest)) 
            largest = l;
        
        // If right child is larger than largest so far
        if (r < n && vector.get(l) > vector.get(largest))
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            int swap = vector.get(i);
            vector.set(i, vector.get(largest));
            vector.set(largest, swap);
            
        }
    }
	
	void heapify(List<Integer> array, int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && array.get(l) > array.get(largest)) 
            largest = l;
        
        // If right child is larger than largest so far
        if (r < n && array.get(l) > array.get(largest))
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            int swap = array.get(i);
            array.set(i, array.get(largest));
            array.set(largest, swap);
            
        }
    }
}
