package maxKVisitors.util;

/**
* Logger program helps in keeping track of program run
*
* @author  Gaurang Dhake
* @version 1.0
* @since   07/19/18 
*/
public class MyLogger{
    // These are debugLevel values which represents states or classes
    public static enum DebugLevel { FILE_PROCESSOR, NONE, MAX_HEAP_VISITOR, MODIFIED_BUBBLE_SORT_VISITOR,
    								RESULTS, MY_ARRAY, MY_VECTOR, POPULATE_VISITOR
                                   };
    
    private static DebugLevel debugLevel; // static current debugLevel for the program
    
    private static String messageStr = "";
    
    /**
	   * This is method which assigns current debugLevel using command line argument
	   * @param levelIn this parameter decides which debugLevel to set from cmd
	   * @return DebugLevel returns debugLevel which was set here
	   */
    public static void setDebugValue (int levelIn) {
		switch (levelIn) {
			case 1: debugLevel = DebugLevel.FILE_PROCESSOR; break;
			case 2: debugLevel = DebugLevel.MAX_HEAP_VISITOR; break;
			case 3: debugLevel = DebugLevel.MODIFIED_BUBBLE_SORT_VISITOR; break;
			case 4: debugLevel = DebugLevel.RESULTS; break;
			case 5: debugLevel = DebugLevel.MY_ARRAY; break;
			case 6: debugLevel = DebugLevel.MY_VECTOR; break;
			case 7: debugLevel = DebugLevel.POPULATE_VISITOR; break;
			default: debugLevel = DebugLevel.NONE; break;
		}
		
    }
    
    /**
	   * This is method which stores message incoming from respective class
	   * @param message this is the message to be printed
	   * @param levelIn to check whether current level is the level being passed
	   * @return None since return type is void
	   */
    public static void writeMessage (String message, DebugLevel levelIn ) {
		if (levelIn == debugLevel)
		    messageStr += message+"\n";			
    }
    /**
	   * This is method which writes message on console
	   * @return None since return type is void
	   */
    public static void write() {
    	System.out.println(messageStr);
    }
    /**
	   * This is method returns string containing debugLevel
	   * @return String it returns string for debugLevel
	   */
    public String toString() {
    	return "The debug level has been set to the following " + debugLevel;
    }
}