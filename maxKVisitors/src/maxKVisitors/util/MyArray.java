package maxKVisitors.util;

import java.util.ArrayList;
import java.util.List;

import maxKVisitors.util.MyLogger.DebugLevel;
/**
* MyArray program is one of the ADTs for implementing visitor pattern
*
* @author  Gaurang Dhake
* @version 1.0
* @since   07/21/2018
*/
public class MyArray implements DataTypesI{
	
	private List<Integer> array;
	private DebugLevel debugLevel;
	
	public MyArray() {
		this.debugLevel = DebugLevel.MY_ARRAY;
		MyLogger.writeMessage("in MyArray constructor", debugLevel);
		array = new ArrayList<>();
	}
	/**
	 * This method populates array by adding elements one by one
	 * @param number This element is passed from populateVisitor class for populating array
	 * @return None Since the return type is void
	 * */
	@Override
	public void add(int number) {
		MyLogger.writeMessage("in MyArray class, add method ", debugLevel);
		array.add(number);
	}
	/**
	 * This method make visit each visitor for sorting purpose
	 * @param visitor this is either array or array object being passed for sorting
	 * @return None Since the return type is void
	 * */
    public void accept(VisitorI visitor) {
    	MyLogger.writeMessage("in MyArray class, accept method ", debugLevel);
        visitor.visit(this);
    }

    // getters and setters
	public List<Integer> getArray() {
		return array;
	}

	public void setArray(List<Integer> array) {
		this.array = array;
	}
    
}
