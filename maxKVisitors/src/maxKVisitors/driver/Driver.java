package maxKVisitors.driver;

import maxKVisitors.util.FileProcessor;
import maxKVisitors.util.MyArray;
import maxKVisitors.util.MyVector;
import maxKVisitors.util.PopulateVisitor;

public class Driver {

	public static void main(String[] args) {
		
		MyVector myVectorObj = new MyVector();
		MyArray myArrayObj = new MyArray();
		
		FileProcessor fp = new FileProcessor("input.txt");
		PopulateVisitor populateVisitorObj = new PopulateVisitor(fp);
		populateVisitorObj.populateMyArray(myArrayObj);
		
		fp = new FileProcessor("input.txt");
		populateVisitorObj = new PopulateVisitor(fp);
		populateVisitorObj.populateMyVector(myVectorObj);
		
	}

}
