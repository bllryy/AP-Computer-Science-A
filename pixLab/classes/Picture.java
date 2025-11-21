import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method to keep only the blue values */
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }

  /** Method to negate all the pixels in the picture */
  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel p : rowArray)
      {
        p.setRed(255 - p.getRed());
        p.setGreen(255 - p.getGreen());
        p.setBlue(255 - p.getBlue());
      }
    }
  }

  /** Method to convert the picture to gray */
  public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel p : rowArray)
      {
        int avg = (p.getRed() + p.getGreen() + p.getBlue()) / 3;
        p.setRed(avg);
        p.setGreen(avg);
        p.setBlue(avg);
      }
    }
  }

  /** Method to fix underwater pictures to make fish easier to see */
  public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel p : rowArray)
      {
        int r = p.getRed();
        int g = p.getGreen();
        int b = p.getBlue();
        // boost red/green and reduce blue
        if (b > r && b > g)
        {
          int newR = Math.min(255, (int)(r * 1.6));
          int newG = Math.min(255, (int)(g * 1.6));
          int newB = Math.max(0, (int)(b * 0.6));
          p.setRed(newR);
          p.setGreen(newG);
          p.setBlue(newB);
        }
      }
    }
  }

  /** Method that mirrors the picture around a
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  /** Method that mirrors the picture around a
    * vertical mirror in the center of the picture
    * from right to left */
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        // copy right->left
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }

  /** Method that mirrors the picture around a
    * horizontal mirror in the center of the picture
    * from top to bottom */
  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    int height = pixels.length;
    int width = pixels[0].length;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    for (int row = 0; row < height / 2; row++)
    {
      for (int col = 0; col < width; col++)
      {
        topPixel = pixels[row][col];
        // copy top pixel color to bottom to mirror top->bottom
        bottomPixel = pixels[height - 1 - row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0; // count how many pixels are copied
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println("mirrorTemple count: " + count);
  }

  /** Mirror the snowman's arms to make 4 arms (snowman.jpg) */
  public void mirrorArms()
  {
    Pixel[][] pixels = this.getPixels2D();
    // These coordinates are chosen to capture the snowman's arms region
    int startRow = 160;
    int endRow = 190; // mirror point is endRow
    int startCol = 100;
    int endCol = 170;
    int mirrorPoint = endRow;
    int count = 0;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    for (int row = startRow; row < mirrorPoint; row++)
    {
      for (int col = startCol; col < endCol; col++)
      {
        topPixel = pixels[row][col];
        int bottomRow = mirrorPoint * 2 - row;
        if (bottomRow >= 0 && bottomRow < pixels.length)
        {
          bottomPixel = pixels[bottomRow][col];
          bottomPixel.setColor(topPixel.getColor());
          count++;
        }
      }
    }
    System.out.println("mirrorArms copied pixels: " + count);
  }

  /** Mirror the seagull to the right so there are two seagulls (seagull.jpg) */
  public void mirrorGull()
  {
    Pixel[][] pixels = this.getPixels2D();
    // Coordinates chosen to capture the gull region on the left
    int startRow = 230;
    int endRow = 320;
    int startCol = 230;
    int mirrorPoint = 345; // vertical mirror column
    int count = 0;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    for (int row = startRow; row < endRow; row++)
    {
      for (int col = startCol; col < mirrorPoint; col++)
      {
        leftPixel = pixels[row][col];
        int rightCol = mirrorPoint * 2 - col;
        if (rightCol >= 0 && rightCol < pixels[0].length)
        {
          rightPixel = pixels[row][rightCol];
          rightPixel.setColor(leftPixel.getColor());
          count++;
        }
      }
    }
    System.out.println("mirrorGull copied pixels: " + count);
  }

  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** copy a rectangular region from fromPic into this picture
    *  @param fromPic the picture to copy from
    *  @param startRow the start row in this picture to copy to
    *  @param startCol the start column in this picture to copy to
    *  @param fromStartRow the start row in fromPic to copy from (inclusive)
    *  @param fromEndRow the end row in fromPic to copy from (inclusive)
    *  @param fromStartCol the start col in fromPic to copy from (inclusive)
    *  @param fromEndCol the end col in fromPic to copy from (inclusive)
    */
  public void copy(Picture fromPic, int startRow, int startCol, int fromStartRow, int fromEndRow, int fromStartCol, int fromEndCol)
  {
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    // clamp source bounds
    int srcRows = fromPixels.length;
    int srcCols = fromPixels[0].length;
    int srcStartR = Math.max(0, fromStartRow);
    int srcEndR = Math.min(fromEndRow, srcRows - 1);
    int srcStartC = Math.max(0, fromStartCol);
    int srcEndC = Math.min(fromEndCol, srcCols - 1);

    int toRow = startRow;
    for (int fromR = srcStartR; fromR <= srcEndR && toRow < toPixels.length; fromR++, toRow++)
    {
      int toCol = startCol;
      for (int fromC = srcStartC; fromC <= srcEndC && toCol < toPixels[0].length; fromC++, toCol++)
      {
        toPixels[toRow][toCol].setColor(fromPixels[fromR][fromC].getColor());
      }
    }
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Create a custom collage using at least three pictures and manipulations
    *  Saves the result to images/out_myCollage.jpg and prints a confirmation
    */
  public void myCollage()
  {
    // base pictures
    Picture p1 = new Picture("flower1.jpg");
    Picture p2 = new Picture("flower2.jpg");
    Picture p3 = new Picture("seagull.jpg");

    // variants
    Picture p1copy = new Picture(p1);
    p1copy.zeroBlue();

    Picture p2copy = new Picture(p2);
    p2copy.negate();

    Picture p3copy = new Picture(p3);
    p3copy.grayscale();

    // place three manipulated pictures on the canvas
    this.copy(p1copy, 0, 0);
    this.copy(p2copy, 100, 0);
    this.copy(p3copy, 200, 0);

    // copy a partial region from p1 to create variety
    // example: copy rows 10..80 and cols 10..80 of p1 into the canvas at (300,0)
    this.copy(p1, 300, 0, 10, 80, 10, 80);

    // mirror the canvas vertically to add a mirrored effect
    this.mirrorVertical();

    // save and report
    this.write("images/out_myCollage.jpg");
    System.out.println("myCollage: saved images/out_myCollage.jpg");
  }

  /** Method to show large changes in color
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
