import TurtleGraphics.*;
import java.awt.Color;
import java.util.ArrayList;

import BreezySwing.*;

// TODO: array list holding all the shapes, for ecch loop to travers

public class TestShapes {
   public static void main (String[] args) {

      ArrayList<Integer> .= new ArrayList<Integer>();

      // Declare and instantiate a pen, a circle and a rectangle
      Pen p = new StandardPen();
      Shape s1 = new Circle (20, 20, 20);
      Shape s2 = new Rect (-20, -20, 10, 20);
      Shape s3 = new ConcreteTriangle(40, 60, 30, 40);
      Shape s4 = new Wheel(10, 40, 90, 8);
      
      // Draw the circle and rectangle
      s1.draw (p);
      s2.draw (p);
      s3.draw (p);
      s4.draw (p);
      
      // Display a description of the circle and rectangle
      System.out.println (s1);  // toString method called implicitly
      System.out.println (s2);
      System.out.println (s3);
      System.out.println(s4);

      // Pause until the user is ready to continue
      KeyboardReader reader = new KeyboardReader();
      reader.pause();
      
      // Erase the circle and rectangle
      p.setColor (Color.white);
      s1.draw (p);
      s2.draw (p);
      p.setColor (Color.red);
      s3.draw (p);
      //p.setColor(Color.cyan);
      p.setColor(Color.ORANGE);
      s4.draw (p);
      
      // Move the circle and rectangle, change their size, and redraw
      s1.move (30, 30);           s2.move (-30, -30);
      s1.stretchBy (2);           s2.stretchBy (2);
      s1.draw (p);                s2.draw (p);
   }
}

