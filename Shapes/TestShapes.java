import TurtleGraphics.*;
import java.awt.Color;
import java.util.ArrayList;

// TODO: array list holding all the shapes, for ecch loop to travers

public class TestShapes {
   public static void main (String[] args) {

      // Declare and instantiate a pen, a circle and a rectangle
      Pen p = new StandardPen();
      Shape s1 = new Circle (20, 20, 20);
      Shape s2 = new Rect (-20, -20, 10, 20);
      Shape s3 = new ConcreteTriangle(40, 60, 30, 40);
      Shape s4 = new Wheel(10, 40, 90, 8);

      ArrayList<Shape> Shapes = new ArrayList<>();
      Shapes.add(s1);
      Shapes.add(s2);
      Shapes.add(s3);
      Shapes.add(s4);

      for (Shape s : Shapes)
      {
         s.draw(p);
         System.out.println(s);
      }

      for (Shape s : Shapes)
      {
         System.out.println(s);
      }

      // Pause until the user is ready to continue
      KeyboardReader reader = new KeyboardReader();
      reader.pause();
      
      // Erase the circle and rectangle
      p.setColor (Color.white);
      for (Shape s : Shapes)
      {
         s.draw(p);
      }

      p.setColor (Color.red);
      for (Shape s : Shapes)
      {
         s.draw(p);
      }

      p.setColor(Color.ORANGE);
      for (Shape s : Shapes)
      {
         s.draw(p);
      }
      
      // Move the circle and rectangle, change their size, and redraw
      s1.move (30, 30);           s2.move (-30, -30);
      s1.stretchBy (2);           s2.stretchBy (2);
      s1.draw (p);                s2.draw (p);
   }
}

