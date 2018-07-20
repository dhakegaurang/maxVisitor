package maxKVisitors.util;

import java.util.Vector;

public class MyVector implements DataTypesI {
	
	private Vector<Integer> vector;
	
	public MyVector() {
		vector = new Vector<>();
	}
	
	@Override
	public void add(int number) {
		vector.add(number);
	}
	
    public void accept(VisitorI visitor) {
        visitor.visit(this);
    }

	public Vector<Integer> getVector() {
		return vector;
	}

	public void setVector(Vector<Integer> vector) {
		this.vector = vector;
	}
    
}
