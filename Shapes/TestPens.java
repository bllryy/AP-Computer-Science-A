import TurtleGraphics.*;
import java.awt.Color;

public class TestPens {
   public static void main (String[] args){
      // Declare three variables of the interface type called Pen.
      Pen p1, p2, p3;

      // Instantiate three different types of pens and 
      // associate them with the Pen variables.
      p1 = new StandardPen();
      p2 = new WigglePen();
      p3 = new RainbowPen();

      // Draw a square with the standard pen.
      for (int i = 1; i <= 4; i++){
         p1.move(50);
         p1.turn(90);
      }
     
      // Draw a square with the wiggle pen.
      for (int i = 1; i <= 4; i++){
         p2.move(50);
         p2.turn(90);
      }
     
      // Draw a square with the rainbow pen.
      for (int i = 1; i <= 4; i++){
         p3.move(50);
         p3.turn(90);
      }
   }
}

