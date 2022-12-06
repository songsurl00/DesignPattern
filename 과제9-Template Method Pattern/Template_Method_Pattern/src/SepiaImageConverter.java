import java.awt.Color;

class SepiaImageConverter extends ImgConverter{
    public Color convertPixel(Color color) {
        int grey = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
        int outputRed = 230 * grey / 255;
        int outputGreen = 180 * grey / 255;
        int outputBlue =  150 * grey / 255;
        return new Color(outputRed, outputGreen, outputBlue);
    }
}