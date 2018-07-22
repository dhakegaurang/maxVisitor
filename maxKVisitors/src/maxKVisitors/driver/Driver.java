package maxKVisitors.driver;

import maxKVisitors.util.FileProcessor;
import maxKVisitors.util.MaxHeapVisitor;
import maxKVisitors.util.ModifiedBubbleSortVisitor;
import maxKVisitors.util.MyArray;
import maxKVisitors.util.MyVector;
import maxKVisitors.util.PopulateVisitor;
import maxKVisitors.util.Results;

public class Driver {

	public static void main(String[] args) {
		
		Results resultObj = new Results();
		
		MyVector myVectorObj1 = new MyVector();
		MyArray myArrayObj1 = new MyArray();
		MyVector myVectorObj2 = new MyVector();
		MyArray myArrayObj2 = new MyArray();
		
		FileProcessor fp = new FileProcessor("input.txt");
		PopulateVisitor populateVisitorObj = new PopulateVisitor(fp);
		populateVisitorObj.populate(myArrayObj1,myArrayObj2,myVectorObj1,myVectorObj2);
		
		MaxHeapVisitor maxHeapObj = new MaxHeapVisitor(12,resultObj);
		ModifiedBubbleSortVisitor bubbleSortObj = new ModifiedBubbleSortVisitor(12,resultObj);
		
		myArrayObj1.accept(maxHeapObj);
		myVectorObj1.accept(maxHeapObj);
		myArrayObj2.accept(bubbleSortObj);
		myVectorObj2.accept(bubbleSortObj);
		
		resultObj.writeToStdout(resultObj.getResultStr());
		
	}

}
