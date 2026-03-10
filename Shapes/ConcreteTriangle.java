import TurtleGraphics.Pen;

public class ConcreteTriangle extends AbstractShape
{
    private double base;
    private double height;

    public ConcreteTriangle(double xLoc, double yLoc, double base, double height)
    {
        super(xLoc, yLoc);
        this.base = base;
        this.height = height;
    }

    @Override
    public double area()
    {
        return (base * height) / 2.0;
    }

    @Override
    public double perimeter() {
        // Vertices are (x,y), (x+base,y), and (x+base/2,y+height), so the two equal sides use pythag theorem
        double side = Math.sqrt((base / 2.0) * (base / 2.0) + height * height);
        return base + 2.0 * side;
    }

    @Override
    public void draw(Pen p)
    {
        p.up();
        p.move(xPos, yPos);
        p.down();
        p.move(xPos + base, yPos);
        p.move(xPos + (base / 2.0), yPos + height);
        p.move(xPos, yPos);
    }

    @Override
    public void stretchBy(double factor)
    {
        base *= factor;
        height *= factor;
    }

    @Override
    public String toString()
    {
        String str = "TRIANGLE\n"
                   + "Base & Height: " + base + " & " + height + "\n"
                   + "(X,Y) Position: (" + xPos + "," + yPos + ")\n"
                   + "Area: " + area() + "\n"
                   + "Perimeter: " + perimeter();
        return str;
    }
}
