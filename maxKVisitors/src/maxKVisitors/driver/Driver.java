package maxKVisitors.driver;

import maxKVisitors.util.FileProcessor;

public class Driver {

	public static void main(String[] args) {
		
		FileProcessor fp = new FileProcessor("input.txt");
		int newNumber = -1;
		while((newNumber = fp.nextInt()) != -1) {
			System.out.println(newNumber);
		}

	}

}
