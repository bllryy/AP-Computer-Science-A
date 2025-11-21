/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test keepOnlyBlue */
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }

  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  /** Method to test mirrorVerticalRightToLeft */
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }

  /** Method to test mirrorHorizontal */
  public static void testMirrorHorizontal()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorHorizontal();
    beach.explore();
  }

  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    System.out.println("TEST: start");
    Picture temple = new Picture("temple.jpg");
    temple.mirrorTemple();
    temple.write("images/out_mirrorTemple.jpg");
    System.out.println("TEST: saved images/out_mirrorTemple.jpg");
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  /** Method to test negate */
  public static void testNegate()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }

  /** Method to test grayscale */
  public static void testGrayscale()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.grayscale();
    beach.explore();
  }

  /** Method to test fixUnderwater */
  public static void testFixUnderwater()
  {
    Picture water = new Picture("water.jpg");
    water.explore();
    water.fixUnderwater();
    water.explore();
  }

  /** Method to test mirrorArms */
  public static void testMirrorArms()
  {
    Picture snowman = new Picture("snowman.jpg");
    snowman.mirrorArms();
    snowman.write("images/out_mirrorArms.jpg");
    System.out.println("TEST: saved images/out_mirrorArms.jpg");
  }

  /** Method to test mirrorGull */
  public static void testMirrorGull()
  {
    Picture gull = new Picture("seagull.jpg");
    gull.mirrorGull();
    gull.write("images/out_mirrorGull.jpg");
    System.out.println("TEST: saved images/out_mirrorGull.jpg");
  }

   /** Method to test copying a partial region from one picture to another */
  public static void testCopyPartial()
  {
    Picture canvas = new Picture("640x480.jpg");
    Picture source = new Picture("flower1.jpg");
    // copy a 70x70 area from source (rows 10..79, cols 10..79) into canvas at (50,50)
    canvas.copy(source, 50, 50, 10, 79, 10, 79);
    canvas.write("images/out_copyPartial.jpg");
  }

  /** Method to test myCollage (custom collage) */
  public static void testMyCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.myCollage();
    // myCollage already saves out_myCollage.jpg, but save again on canvas for clarity
    canvas.write("images/out_myCollage_canvas.jpg");
    System.out.println("TEST: saved images/out_myCollage.jpg and images/out_myCollage_canvas.jpg");
  }

  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    testKeepOnlyBlue();
    testNegate();
    testGrayscale();
    testFixUnderwater();
    testMirrorHorizontal();
    testMirrorTemple();
    testMirrorArms();
    testMirrorGull();
    testCopyPartial();
    testMyCollage();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalRightToLeft();
    //testMirrorHorizontal();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}