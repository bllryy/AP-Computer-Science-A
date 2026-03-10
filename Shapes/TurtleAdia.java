//*Mark Adia
////////////////
import TurtleGraphics.RainbowPen;
import java.awt.Color;

public class TurtleAdia
{
	public static void main(String [] args)
	{
		RainbowPen pen = new RainbowPen();

		double sideStep, changeDegrees;

		sideStep = 8;

		for (changeDegrees = 0; changeDegrees <= 63*360; changeDegrees += 77)

		{
		sideStep++;
		pen.setColor(Color.green);
		pen.move(sideStep);
		pen.turn(46);
		}
		
	}

}
