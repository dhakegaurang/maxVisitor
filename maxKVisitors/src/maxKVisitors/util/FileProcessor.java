package maxKVisitors.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
	private String inputFilePath;
	private BufferedReader bReaderObj;
	
	public FileProcessor(String inputFilePath) {
		this.inputFilePath = inputFilePath;
		try {
			bReaderObj = new BufferedReader(new FileReader(inputFilePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int nextInt() {
		try{
		    String line;
		    while ((line = bReaderObj.readLine()) != null) {
		       return Integer.parseInt(line);
		    }
		}
		catch(IOException  e) { //handling in case of bufferedReader goes wrong
			System.err.println("Exception: while reading input file");
			System.err.println("Exiting...");
			System.exit(0);
		}
		catch(NumberFormatException e) {
			System.err.println("Exception: Please enter only integers in the input file");
			System.err.println("Exiting...");
			System.exit(0);
		}
		return -1;
	}
}
