import java.awt.Color;

// 흑백 영상으로 변환하는 코드
class GreyImageConverter extends ImgConverter{
    public Color convertPixel(Color color) {
        int outputRed = (color.getRed() + color.getGreen() + color.getBlue())  / 3;
        int outputGreen = (color.getRed() + color.getGreen() + color.getBlue())  / 3;
        int outputBlue = (color.getRed() + color.getGreen() + color.getBlue())  / 3;
        return new Color(outputRed, outputGreen, outputBlue);
    }
}