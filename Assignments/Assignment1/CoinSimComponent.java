//Name: Yutao Ren
//USC NetID: yutaoren
//CS 455 PA1
//Fall 2017

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.Math;


/**
 * class CoinSimComponent
 * 
 * Extend the JComponent class, draw and display the bars in the frame.
 *
 */
public class CoinSimComponent extends JComponent{
	
	//Name constants for fixed values.
	private static final int VERTICAL_BUFFER = 40;
	private static final int BAR_WIDTH = 50;
	private static final Color TWO_HEADS_COLOR = Color.RED;
	private static final Color TWO_TAILS_COLOR = Color.BLUE;
	private static final Color HEAD_TAIL_COLOR = Color.GREEN;
	
	private int getNumTrials;
	private int getTwoHeads;
	private int getTwoTails;
	private int getHeadTails;
	
	/**
	 * CoinSimComponent constructor receives the number of trials from the user,
	 * then runs the CoinTossSimulator to simulate the tossing. 
	 * 
	 * @param numTrials	 the number of trials that the user inputs
	 */
	public CoinSimComponent(int numTrials) {
		
		getNumTrials = numTrials;
		CoinTossSimulator tossCoin = new CoinTossSimulator();
		tossCoin.run(getNumTrials);
		
		//Get the result number from CoinTossSimulator. 
		getTwoHeads = tossCoin.getTwoHeads();
		getTwoTails = tossCoin.getTwoTails();
		getHeadTails = tossCoin.getHeadTails();
		
	}
	
	/**
	 * Draw the bar graph.
	 * Automatically called whenever the component needs to be repainted.
	 * @param g	 the graphics context 
	 */
	public void paintComponent(Graphics g) {
		
		//Recover Graphics2D. 
		Graphics2D g2 = (Graphics2D) g;
		
		//Calculate the location of the bottom of the label.
		int bottom = getHeight() - VERTICAL_BUFFER;
		
		//Define the width between each bar to be the 1/5 width of window.  
		int width = getWidth() / 5;
		
		//Get the barHeight of 3 kinds of results respectively.
		int twoHeadsBarHeight = getTwoHeads; 
		int twoTailsBarHeight = getTwoTails;
		int headTailsBarHeight = getHeadTails;
		
		//Calculate pixels per application unit.
		double scale = (double)(getHeight() - 2 * VERTICAL_BUFFER) / getNumTrials;
		
		//Calculate the percentage of trials respectively.
		double perTwoHeads = Math.round(getTwoHeads * 100 / (double)getNumTrials);
		double perHeadTails = Math.round(getHeadTails * 100 / (double)getNumTrials);
		
		//Create the label of the bar respectively.
		String twoHeadsLabel = "Two Heads: " + getTwoHeads + " (" + 
								(int)perTwoHeads + "%)";
		String headTailsLabel = "A Head and a Tail: " + getHeadTails + " (" + 
								(int)perHeadTails + "%)";
		String twoTailsLabel = "Two Tails: " + getTwoTails + " (" + 
							    (int)(100 - perTwoHeads - perHeadTails) + "%)";
		
		//Create three bar objects respectively. 
		Bar twoHeadsBar = new Bar(bottom, width, BAR_WIDTH, twoHeadsBarHeight, 
								  scale, TWO_HEADS_COLOR, twoHeadsLabel);
		
		Bar HeadTailsBar = new Bar(bottom, 2 * width + BAR_WIDTH, BAR_WIDTH, 
								   headTailsBarHeight, scale, HEAD_TAIL_COLOR, 
								   headTailsLabel);
		
		Bar twoTailsBar = new Bar(bottom, 3 * width + 2 * BAR_WIDTH, BAR_WIDTH,
				          		  twoTailsBarHeight, scale, TWO_TAILS_COLOR,
				          		  twoTailsLabel);
		
		//Draw the graphics.
		twoHeadsBar.draw(g2);
		HeadTailsBar.draw(g2);
		twoTailsBar.draw(g2);
		
	}

}
