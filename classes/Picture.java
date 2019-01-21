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

  public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int value = (pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen())/3;
        pixelObj.setRed(value);
        pixelObj.setGreen(value);
        pixelObj.setBlue(value);
      }
    }
  }

  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(255-pixelObj.getRed());
        pixelObj.setGreen(255-pixelObj.getGreen());
        pixelObj.setBlue(255-pixelObj.getBlue());
      }
    }
  }

  public void fixUnderwater()
  {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels)
      {
          for (Pixel pixelObj : rowArray)
          {
              if (pixelObj.getBlue() > pixelObj.getGreen() && pixelObj.getBlue() > pixelObj.getRed())
                  {

                  } else
              {
                  pixelObj.setBlue(255);
                  pixelObj.setRed(255);
                  pixelObj.setGreen(255);
              }


          }
      }
  }

  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel rightPixel = null;
    Pixel leftPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }

  public void mirrorHorizontal()
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel cuurentPixel = null;
      Pixel  mirroredPixel = null;
      int length = pixels.length;
      for (int i = length/2; i < pixels.length; i++)
      {
        for(int n=0; n < pixels[i].length; n++)
        {
            mirroredPixel = pixels[(length-1)-i][n];
            cuurentPixel = pixels[i][n];
            cuurentPixel.setColor(mirroredPixel.getColor());
        }
      }
  }

    public void mirrorHorizontalBotToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel cuurentPixel = null;
        Pixel  mirroredPixel = null;
        int length = pixels.length;
        for (int i = 0; i < length/2; i++)
        {
            for(int n=0; n < pixels[i].length; n++)
            {
                mirroredPixel = pixels[(length-1)-i][n];
                cuurentPixel = pixels[i][n];
                cuurentPixel.setColor(mirroredPixel.getColor());
            }
        }
    }

    public void mirrorArms()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel mirroredPixel = null;
        Pixel currentPixel = null;

        for (int i=167; i < 195; i++)
        {
            for (int n= 235; n < 294; n++)
            {
                currentPixel = pixels[i+50][n];
                mirroredPixel = pixels[i][n];
                currentPixel.setColor(mirroredPixel.getColor());

            }
        }
        for (int i=161; i < 189; i++)
        {
            for (int n= 103; n < 170; n++)
            {
                currentPixel = pixels[i+50][n];
                mirroredPixel = pixels[i][n];
                currentPixel.setColor(mirroredPixel.getColor());

            }
        }
    }

    public void mirrorGull()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel mirroredPixel = null;
        Pixel currentPixel = null;

        for (int i=233; i < 322; i++)
        {
            for (int n= 232; n < 343; n++)
            {
                currentPixel = pixels[i][n+120];
                mirroredPixel = pixels[i][n];
                currentPixel.setColor(mirroredPixel.getColor());

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

  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
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
      }
    }
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

    public void secondCopy(Picture pic, int startRow, int startCol, int fromRowStart, int fromRowEnd, int fromColStart, int fromColEnd)
    {

        Pixel[][] canvass = this.getPixels2D();
        Pixel[][] fromPixels = pic.getPixels2D();

        Pixel pixelOne = null;
        Pixel pixelTwo = null;

        for (int i = fromRowStart, j = startRow; i < fromRowEnd && j < canvass.length; i++, j++)
        {
            for (int m = fromColStart, n = startCol; m < fromColEnd && n < canvass[0].length; m++, n++)
            {
                pixelOne = fromPixels[i][m];
                pixelTwo = canvass[j][n];
                pixelTwo.setColor(pixelOne.getColor());
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

  public void myCollage()
  {
      Picture x = new Picture("xxxtentacion.jpg");
      Picture sixNine = new Picture("6ix9ine.jpg");

      this.secondCopy(x,0,1, 1,150,1,150);
      this.mirrorVertical();
      this.zeroBlue();
      this.secondCopy(sixNine,200,150,150,350,150,350);
      this.negate();
      this.secondCopy(x,500,300,300,500,400,450);
      this.negate();
      this.mirrorHorizontalBotToTop();
      this.write("myCollage.jpg");
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

  public void edgeDetection2(int edgeDist)
  {
      Pixel leftPixel = null;
      Pixel rightPixel = null;
      Pixel botPixel = null;
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

      for (int i=0; i < pixels.length-1; i++)
      {
          for (int n = 0; n < pixels[i].length-1; n++)
          {
              botPixel = pixels[i+1][n];
              if (pixels[i][n].colorDistance(botPixel.getColor()) > edgeDist)
              {
                  pixels[i][n].setColor(Color.BLACK);
              } else
              {
                  pixels[i][n].setColor(Color.WHITE);
              }
          }
      }
  }

  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("smallMyPicture.jpg");
    beach.explore();
    beach.createCollage();
    beach.explore();
  }


  
}
