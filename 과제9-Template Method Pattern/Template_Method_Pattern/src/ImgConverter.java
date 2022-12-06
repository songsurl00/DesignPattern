import java.awt.image.*;
//import java.awt.Image.BufferedImage;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public abstract class ImgConverter {
    public void convert(String filename, String prefix) {
        try {       
            BufferedImage image = ImageIO.read(new File(filename));

            for(int y = 0; y < image.getHeight(); y++) {
               for(int x = 0; x < image.getWidth(); x++) {
                   Color color = new Color(image.getRGB(x, y));
                   Color newColor = convertPixel(color);
                   image.setRGB(x, y, newColor.getRGB());
               }
            }
            ImageIO.write(image, "png", new File(prefix + filename));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract Color convertPixel(Color color);
}
