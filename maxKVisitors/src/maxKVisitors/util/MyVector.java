package maxKVisitors.util;

import java.util.Vector;

import maxKVisitors.util.MyLogger.DebugLevel;
/**
* MyVector program is one of the ADTs for implementing visitor pattern
*
* @author  Gaurang Dhake
* @version 1.0
* @since   07/21/2018
*/
public class MyVector implements DataTypesI {
	
	private Vector<Integer> vector;
	private DebugLevel debugLevel;
	
	public MyVector() {
		this.debugLevel = DebugLevel.MY_VECTOR;
		MyLogger.writeMessage("in MyVector constructor", debugLevel);
		vector = new Vector<>();
	}
	/**
	 * This method populates vector by adding elements one by one
	 * @param number This element is passed from populateVisitor class for populating vector
	 * @return None Since the return type is void
	 * */
	@Override
	public void add(int number) {
		MyLogger.writeMessage("in MyVector class, add method ", debugLevel);
		vector.add(number);
	}
	/**
	 * This method make visit each visitor for sorting purpose
	 * @param visitor this is either array or vector object being passed for sorting
	 * @return None Since the return type is void
	 * */
    public void accept(VisitorI visitor) {
    	MyLogger.writeMessage("in MyVector class, accept method ", debugLevel);
        visitor.visit(this);
    }

    // getter and setter methods
	public Vector<Integer> getVector() {
		return vector;
	}

	public void setVector(Vector<Integer> vector) {
		this.vector = vector;
	}
    
}
