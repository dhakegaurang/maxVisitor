package maxKVisitors.util;

import java.util.ArrayList;
import java.util.List;

public class MyArray implements DataTypesI{
	
	private List<Integer> array;
	
	public MyArray() {
		array = new ArrayList<>();
	}

	@Override
	public void add(int number) {
		array.add(number);
	}
	
    public void accept(VisitorI visitor) {
        visitor.visit(this);
    }

	public List<Integer> getArray() {
		return array;
	}

	public void setArray(List<Integer> array) {
		this.array = array;
	}
    
}
