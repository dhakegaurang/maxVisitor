package maxKVisitors.driver;

import maxKVisitors.util.FileProcessor;
import maxKVisitors.util.MaxHeapVisitor;
import maxKVisitors.util.MyArray;
import maxKVisitors.util.MyVector;
import maxKVisitors.util.PopulateVisitor;

public class Driver {

	public static void main(String[] args) {
		
		MyVector myVectorObj1 = new MyVector();
		MyArray myArrayObj1 = new MyArray();
		MyVector myVectorObj2 = new MyVector();
		MyArray myArrayObj2 = new MyArray();
		
		FileProcessor fp = new FileProcessor("input.txt");
		PopulateVisitor populateVisitorObj = new PopulateVisitor(fp);
		populateVisitorObj.populateMyArray(myArrayObj1);
		
		fp = new FileProcessor("input.txt");
		populateVisitorObj = new PopulateVisitor(fp);
		populateVisitorObj.populateMyVector(myVectorObj1);
		
		MaxHeapVisitor maxHeapObj = new MaxHeapVisitor(5);
		System.out.println("Array=>");
		myArrayObj1.accept(maxHeapObj);
		
		System.out.println("Vector=>");
		myVectorObj1.accept(maxHeapObj);
		
	}

}
