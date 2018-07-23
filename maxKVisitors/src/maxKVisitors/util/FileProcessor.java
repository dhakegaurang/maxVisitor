package maxKVisitors.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import maxKVisitors.util.MyLogger.DebugLevel;

/**
* InputProcessor program is responsible for parsing input line by line
*
* @author  Gaurang Dhake
* @version 1.0
* @since   07/21/2018 
*/
public class FileProcessor {
	private String inputFilePath;
	private BufferedReader bReaderObj;
	private DebugLevel debugLevel;
	
	public FileProcessor(String inputFilePath) {
		this.debugLevel = DebugLevel.FILE_PROCESSOR;
		MyLogger.writeMessage("in fileprocessor constructor", debugLevel);
		this.inputFilePath = inputFilePath;
		try {
			bReaderObj = new BufferedReader(new FileReader(inputFilePath));
		} 
		catch (FileNotFoundException e) {
			System.err.println("Exception: File not found!!");
			System.err.println("Exiting...");
			System.exit(0);
		}
	}
	/**
	   * This is nextInt method reads input file line by line
	   * @return int returns one integer per line each time
	   */
	public int nextInt() {
		MyLogger.writeMessage("in fileprocessor nextInt method", debugLevel);
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
		catch(NumberFormatException e) { //handling in case integer is not found in input
			System.err.println("Exception: Please enter only integers in the input file");
			System.err.println("Exiting...");
			System.exit(0);
		}
		return -1;
	}
}
