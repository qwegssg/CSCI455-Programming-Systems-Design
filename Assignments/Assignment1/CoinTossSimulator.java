//Name: Yutao Ren	
//USC NetID: yutaoren
//CS 455 PA1
//Fall 2017

//Import the Random class to implement a random number generator.
import java.util.Random;


/**
* class CoinTossSimulator
* 
* Simulates trials of tossing two coins and allows the user to access the
* cumulative results.
* 
* NOTE: we have provided the public interface for this class.  Do not change
* the public interface.  You can add private instance variables, constants, 
* and private methods to the class.  You will also be completing the 
* implementation of the methods given. 
* 
* Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
* 
*/
public class CoinTossSimulator {
	
	//Define the value of head and tail.
	private static final int HEAD = 0;
	private static final int TAIL = 1;
	
	/*generator:		random number generator.
	 *twoHeads:		number of trials of two heads tossing.
	 *twoTails:		number of trials of two tails tossing.
	 *headTails:		number of trials of one-head one-tail tossing.
	 *trialNumber:	total number of trials .
	 */
	private Random generator;
	private int twoHeads;
	private int twoTails;
	private int headTails;
	private int trialNumber;

	
/**
   Creates a coin toss simulator with no trials done yet.
*/
public CoinTossSimulator() {
	
	generator = new Random();
	twoHeads = 0;
	twoTails = 0;
	headTails = 0;
	trialNumber = 0;
	
}


/**
   Runs the simulation for numTrials more trials. Multiple calls to this method
   without a reset() between them *add* these trials to the current simulation.
   
   @param numTrials  number of trials to for simulation; must be >= 1
 */
public void run(int numTrials) {	

	for(int i = 0; i < numTrials; i++) {
		
		//Use the random number generator to simulate tossing. 
		//Store the results of tossing a pair of coins respectively in two variables. 
		int firstToss = generator.nextInt(2);
		int secondToss = generator.nextInt(2);
		
		//Create coinValue variable to store the results of tossing a pair;
		int coinValue = firstToss + secondToss;
		
		if(coinValue == HEAD + HEAD) {
			twoHeads++;
		}
		else if(coinValue == HEAD + TAIL) {
			headTails++;
		}
		else {
			twoTails++;
		}
	}
	
	//Calculate the total number of trials since last reset. 
	trialNumber = trialNumber + numTrials;

}


/**
   Get number of trials performed since last reset.
*/
public int getNumTrials() {
    return trialNumber; 
}


/**
   Get number of trials that came up two heads since last reset.
*/
public int getTwoHeads() {
    return twoHeads; 
}


/**
  Get number of trials that came up two tails since last reset.
*/  
public int getTwoTails() {
    return twoTails; 
}


/**
  Get number of trials that came up one head and one tail since last reset.
*/
public int getHeadTails() {
    return headTails; 
}


/**
   Resets the simulation, so that subsequent runs start from 0 trials done.
 */
public void reset() {
	twoHeads = 0;
	twoTails = 0;
	headTails = 0;
	trialNumber = 0;
}

}
