//Name: Yutao Ren
//USC NetID: yutaoren
//CS 455 PA1
//Fall 2017

//we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;


/**
* Bar class
* 
* A labeled bar that can serve as a single bar in a bar graph.
* The text for the label is centered under the bar.
* 
* NOTE: we have provided the public interface for this class. Do not change
* the public interface. You can add private instance variables, constants,
* and private methods to the class. You will also be completing the
* implementation of the methods given.
* 
*/
public class Bar {
	
    //Creat instant variables to store values.
	private int xLeft; 
	private int yBottom;
	private int yBarHeight;
	private int xWidth;
	private double barScale;
	private Color barColor;
	private String barLabel;
	
/**
   Creates a labeled bar.  You give the height of the bar in application
   units (e.g., population of a particular state), and then a scale for how
   tall to display it on the screen (parameter scale). 

   @param bottom  location of the bottom of the label
   @param left  location of the left side of the bar
   @param width  width of the bar (in pixels)
   @param barHeight  height of the bar in application units
   @param scale  how many pixels per application unit
   @param color  the color of the bar
   @param label  the label at the bottom of the bar
*/
public Bar(int bottom, int left, int width, int barHeight,
           double scale, Color color, String label) {
	
	yBottom = bottom;
	xLeft = left;
	xWidth = width;
	yBarHeight = barHeight;
	barScale = scale;
	barColor = color;
	barLabel = label;
	
}

/**
   Draw the labeled bar. 
   @param g2  the graphics context
*/
public void draw(Graphics2D g2) {
	
	//Calculate the width and height of the label.
	Font font = g2.getFont();
	FontRenderContext context = g2.getFontRenderContext();
	Rectangle2D labelBounds = font.getStringBounds(barLabel, context);
	int widthOfLabel = (int) labelBounds.getWidth();
	int heightOfLabel = (int) labelBounds.getHeight();
	
	//Calculate the height of the bar in pixels. 
	int barHeight_Pixels = (int)(yBarHeight * barScale);
	
	//Calculate the height location of the bar. 
	int yTall = yBottom - barHeight_Pixels; 
	
	Rectangle box = new Rectangle(xLeft, yTall, xWidth, 
								 barHeight_Pixels - heightOfLabel);	
	
	//Color the bar, then draw the bar. 
	g2.setColor(barColor);
	g2.fill(box);
	g2.draw(box);
	
	//Color the label, calculate the width and height location of label, 
	//then draw the label. 
	g2.setColor(Color.BLACK);
	g2.drawString(barLabel, xLeft + xWidth / 2 - widthOfLabel / 2, yBottom);
	
}
}
