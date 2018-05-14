//Name: Yutao Ren
//USC NetID: yutaoren
//CS 455 PA1
//Fall 2017

//Import the JFrame class to draw the frame window.
import javax.swing.JFrame;
import java.util.Scanner;


/**
 * class CoinSimViewer
 * 
 *Show the frame that contains CoinSimComponent.
 *Read the number of trials from the user, display the output onto the frame.
 *
 */
public class CoinSimViewer {
	
	public static void main(String[] args) {
		
		//Create a 500 tall by 800 wide pixel frame with the title of CoinSim.
		JFrame frame = new JFrame();
		frame.setSize(800,500);
		frame.setTitle("CoinSim");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Read the number of trials from the user.
		Scanner in = new Scanner(System.in);
		int numTrials = 0;
		
	    //Create a boolean variable to check error input.
		boolean validated = false;
		
		while (!validated) {
			
		    System.out.print("Enter number of trials: ");
			numTrials = in.nextInt();
			
			if (numTrials >= 1) {
		    		validated = true;
		    }
		    else {
		    		System.out.println("ERROR: Number entered must be greater than 0.");
		    }
		}
		
		//Pass the number of trials to CoinSimComponent class.
		CoinSimComponent component = new CoinSimComponent(numTrials);
		
		frame.add(component);
		
		frame.setVisible(true);
		
	}
}
