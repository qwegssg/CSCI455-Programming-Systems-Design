import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Finds frequency of each word in a file.
 * Unlike the lecture version of this code, this one is smarter
 * about what it considers a word.
 *
 * Version for the lab.
 */

public class ConcordDriver {


    public static void main(String[] args)  throws FileNotFoundException  {

	Concord concord = new Concord();
	
	//must throw an exception if use file input, or reading the file in argument, refer to MazeViewer.java
	File inputFile = new File("poe.txt");
		
	Scanner in = new Scanner(inputFile);
		
	concord.addData(in);		
	
	PrintStream out = new PrintStream("output.txt");
		
    //	concord.print(out);

    	concord.printSorted(out);
    	
    in.close(); 
    out.close();
		
    }

}
