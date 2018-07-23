package maxKVisitors.driver;

import java.io.File;
import java.io.FileNotFoundException;

import maxKVisitors.util.MyLogger.DebugLevel;
import maxKVisitors.util.FileProcessor;
import maxKVisitors.util.MaxHeapVisitor;
import maxKVisitors.util.ModifiedBubbleSortVisitor;
import maxKVisitors.util.MyArray;
import maxKVisitors.util.MyLogger;
import maxKVisitors.util.MyVector;
import maxKVisitors.util.PopulateVisitor;
import maxKVisitors.util.Results;
/**
* Driver program creates instances of fileProcessor,two instances of each ADTs, Results and prints output on std output
*
* @author  Gaurang Dhake
* @version 1.0
* @since   07/21/2018 
*/
public class Driver {
	/**
	   * This is main method which verifies cmd parameters and responsible for creating instances and calling respective methods
	   * @param args this parameter stores all cmd parameters
	   * @return None since return type is void
	   */
	public static void main(String[] args) {
		int K = 0;
		DebugLevel debugLevel = null;
		try {
			// Check if there are exactly three arguments i.e input and output file paths and debugLevel
			if(args.length != 3) {
				throw new IllegalArgumentException("Exception: Three arguments are needed !!");
			}
			// Checking if input file actually exists
			if(!new File(args[0]).exists()) {
				throw new FileNotFoundException("Exception: input file not found!!");
			}
			// Checks third parameters exists and if it does, then checks if it is integer or not
			if(args[1] != null) {
				try {
					K = Integer.parseInt(args[1]);
				}	
				catch(NumberFormatException e) {// if debugLevel is non-integer
					System.err.println("Exception: Please enter only integers as second argument!!");
					System.out.println("Exiting...");
					System.exit(0);
				}
			}
			if(args[2] != null) {
				try {
					MyLogger.setDebugValue(Integer.parseInt(args[2]));
				}	
				catch(NumberFormatException e) {// if debugLevel is non-integer
					System.err.println("Exception: Please enter only integers as third argument!!");
					System.out.println("Exiting...");
					System.exit(0);
				}
			}
			else {
				MyLogger.setDebugValue(2); // default debug Level is 2
			}
			// Creating result instances
			Results resultObj = new Results();
			
			// Creating two instances of each ADTs
			MyVector myVectorObj1 = new MyVector();
			MyArray myArrayObj1 = new MyArray();
			MyVector myVectorObj2 = new MyVector();
			MyArray myArrayObj2 = new MyArray();
			
			// Creating fileprocessor Object and populating each instance of ADT in populateVisitor object
			FileProcessor fp = new FileProcessor("input.txt");
			PopulateVisitor populateVisitorObj = new PopulateVisitor(fp);
			populateVisitorObj.populate(myArrayObj1,myArrayObj2,myVectorObj1,myVectorObj2);
			
			// Creating MaxHeapVisitor object and passing maxK Length into it along with result object
			MaxHeapVisitor maxHeapObj = new MaxHeapVisitor(K,resultObj);
			
			// Creating modifiedBubbleSort object and passing maxK Length into it along with result object
			ModifiedBubbleSortVisitor bubbleSortObj = new ModifiedBubbleSortVisitor(K,resultObj);
			
			// Applying principle of visitor pattern by passing object of maxheap and bubblesort into instances of ADTs
			myArrayObj1.accept(maxHeapObj);
			myVectorObj1.accept(maxHeapObj);
			myArrayObj2.accept(bubbleSortObj);
			myVectorObj2.accept(bubbleSortObj);
			
			// Writing final output into std out
			MyLogger.write();
			resultObj.writeToStdout(resultObj.getResultStr());
		}
		catch(IllegalArgumentException e) { // catching in case of incorrect number of arguments
			System.err.println(e.getMessage());
			System.out.println("Exiting...");
			System.exit(0);
		}
		catch(FileNotFoundException e) { // if incorrect input file path
			System.err.println(e.getMessage());
			System.out.println("Exiting...");
			System.exit(0);
		}
		catch(Exception e) { // For any other exceptions to be caught
			System.err.println("Exception: "+e.getMessage());
			System.out.println("Exiting...");
			System.exit(0);
		}
		
	}

}
