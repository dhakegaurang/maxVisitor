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
		populateVisitorObj.populateMyArray(myArrayObj1);
		
		fp = new FileProcessor("input.txt");
		populateVisitorObj = new PopulateVisitor(fp);
		populateVisitorObj.populateMyArray(myArrayObj2);
		
		fp = new FileProcessor("input.txt");
		populateVisitorObj = new PopulateVisitor(fp);
		populateVisitorObj.populateMyVector(myVectorObj1);
		
		fp = new FileProcessor("input.txt");
		populateVisitorObj = new PopulateVisitor(fp);
		populateVisitorObj.populateMyVector(myVectorObj2);
		
		MaxHeapVisitor maxHeapObj = new MaxHeapVisitor(2,resultObj);
		ModifiedBubbleSortVisitor bubbleSortObj = new ModifiedBubbleSortVisitor(2,resultObj);
		
		myArrayObj1.accept(maxHeapObj);
		myVectorObj1.accept(maxHeapObj);
		myArrayObj2.accept(bubbleSortObj);
		myVectorObj2.accept(bubbleSortObj);
		
		resultObj.writeToStdout(resultObj.getResultStr());
		
	}

}
