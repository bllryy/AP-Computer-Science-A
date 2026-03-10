import TurtleGraphics.Pen;

public class Circle implements Shape {

   public double xPos, yPos;
   public double radius;

   public Circle() {
      xPos = 0;
      yPos = 0;
      radius = 1;
   }

   public Circle (double xLoc, double yLoc, double r) {
      xPos = xLoc;
      yPos = yLoc;
      radius = r;
   }
 
   public double area() {
      return Math.PI * radius * radius;
   }

 public double perimeter() {
      return 2*Math.PI * radius;
   }

   public void draw (Pen p) {
      double side = 2.0 * Math.PI * radius / 120.0;
      p.up();
      p.move (xPos + radius, yPos - side / 2.0);
      p.setDirection (90);
      p.down();
      for (int i = 0; i < 120; i++){
         p.move (side);
         p.turn (3);
      }
   }

   public double getXPos() {
      return xPos;
   }

   public double getYPos() {
      return yPos;
   }

   public void move (double xLoc, double yLoc) {
      xPos = xLoc;
      yPos = yLoc;
   }

   public void stretchBy (double factor) {
      radius *= factor;
   }

//   public void drawSpokes(Pen p, int spokes)
//   {
//      for (int i = 1; i <= spokes; i++)
//      {
//          p.up();
//          p.move (xPos, yPos);
//          p.setDirection (i * 360.0 / spokes);
//          p.down();
//          p.move (radius);
//      }
//   }

   public String toString() {
      String str = "CIRCLE\n"
                 + "Radius: " + radius + "\n"
                 + "(X,Y) Position: (" + xPos + "," + yPos + ")\n" 
                 + "Area: " + area()+"\n"
					   + "Perimeter: " + perimeter();
      return str;
   }
}

