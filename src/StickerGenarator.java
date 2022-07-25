import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class StickerGenarator {

   public void create(InputStream inputStream, String message, String title) throws Exception{
      
      // Read old image.
      BufferedImage original = ImageIO.read(inputStream);
      int width = original.getWidth();
      int height = original.getHeight();
      int newHeight = height + 200;

      // Make new image with translucid and bigger size.
      BufferedImage sticker = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

      // Write in new image.
      Graphics2D graphics = (Graphics2D) sticker.getGraphics(); 
      graphics.drawImage(original, 0, 0, null);

      // Write a sentence/frase on new inage.
      graphics.setColor(Color.YELLOW);
      graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));
      graphics.drawString(message, 150, newHeight -100);

      // Save new Image.
      ImageIO.write(sticker, "png", new File("output/" + title + ".png"));
   }
}