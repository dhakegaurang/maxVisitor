package maxKVisitors.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import maxKVisitors.util.MyLogger.DebugLevel;

/**
* Results program is responsible for storing results
*
* @author  Gaurang Dhake
* @version 1.0
* @since   07-21-2018
*/
public class Results implements FileDisplayInterface,StdoutDisplayInterface{
	private String resultStr;
	private String outputFilePath;
	private DebugLevel debugLevel;
	
	public Results() {
		this.debugLevel = DebugLevel.RESULTS;
		resultStr = "";	
	}
	/**
	   * This writeToStdout method writes result to std output
	   * @param s this parameter stores all result strings
	   * @return None since return type is void
	   */
	@Override
	public void writeToStdout(String s) {
		MyLogger.writeMessage("in Results class, writeToStdout method", debugLevel);
		System.out.println(s);
 		
	}

	/**
	   * This writeToFile method writes result to output file
	   * @param s this parameter stores all result strings
	   * @return None since return type is void
	   */
	@Override
	public void writeToFile(String s) {
		
	}
	
	/**
	   * This storeNewResult method keeps appending new result string in main string
	   * @param newResult this parameter brings new string result
	   * @return None since return type is void
	   */
	public void storeNewResult(String newResult) {
		resultStr += newResult;
	}

	@Override
	public String toString() {
		return resultStr;
	}

	public String getResultStr() {
		return resultStr;
	}

	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}
	
}
