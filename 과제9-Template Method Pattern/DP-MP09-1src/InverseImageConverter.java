import java.awt.image.*;
//import java.awt.Image.BufferedImage;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

//import java.imageio.*;

class InverseImageConverter extends ImageConverter {
    public Color convertPixel(Color color) {
        // RGB 값을 각각 읽어서 컬러 변환(여기서는 흑백으로 변환)
        int outputRed = 255 - color.getRed();
        int outputGreen = 255 - color.getGreen();
        int outputBlue = 255 - color.getBlue();
        return new Color(outputRed, outputGreen, outputBlue);
    }
}
