import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class Document implements Printable {
  
  @Override
  public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
    if (pageIndex == 0) {
      try {
        int width = (int) (8.5 * 72);
        int height = 72;

        // create a yellow bufferedimage
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D biG = bi.createGraphics();
        biG.setColor(Color.yellow);
        biG.fillRect(0, 0, width, height);

        // print the buffered image to the print graphic
        Graphics2D g2Print = (Graphics2D) graphics;
        g2Print.drawImage(bi, 0, 144, null);
        
        Font font = new Font("Serif", Font.PLAIN, 12);
        g2Print.setFont(font);
        g2Print.setColor(Color.black);
        
        for (int i=0; i<500; i+=12)
          g2Print.drawString("(" + i + ", " + i + ")", i, i);

        return Printable.PAGE_EXISTS;
      }
      catch (Throwable t) {
        t.printStackTrace();
      }
    }

    return Printable.NO_SUCH_PAGE;
  }
}