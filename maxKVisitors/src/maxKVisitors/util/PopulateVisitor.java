package maxKVisitors.util;

import maxKVisitors.util.MyLogger.DebugLevel;

/**
* PopulateVisitor program is responsible for populating each instance of ADTs and make sure each instance is ready with input
*
* @author  Gaurang Dhake
* @version 1.0
* @since   07/21/2018
*/
public class PopulateVisitor {
	private FileProcessor fileProcessorObj;
	private DebugLevel debugLevel;
	
	public PopulateVisitor(FileProcessor fileProcessorObj) {
		this.debugLevel = DebugLevel.POPULATE_VISITOR;
		MyLogger.writeMessage("in PopulateVisitor constructor", debugLevel);
		this.fileProcessorObj = fileProcessorObj;
	}
	/**
	   * This populate method populates each instance of ADT reading and inputting each integer in them
	   * @param myArrayObj1,myArrayObj2,myVectorObj1,myVectorObj2 are instances of ADTs being passed from driver program for population purpose
	   * @return None Since it is of type void
	   */
	public void populate(MyArray myArrayObj1, MyArray myArrayObj2, MyVector myVectorObj1, MyVector myVectorObj2) {
		MyLogger.writeMessage("in PopulateVisitor class, add populate ", debugLevel);
		int newNumber = -1;
		while((newNumber = fileProcessorObj.nextInt()) != -1) { 
			myVectorObj1.add(newNumber);
			myVectorObj2.add(newNumber);
			myArrayObj1.add(newNumber);
			myArrayObj2.add(newNumber);
		}
	}
	
}
