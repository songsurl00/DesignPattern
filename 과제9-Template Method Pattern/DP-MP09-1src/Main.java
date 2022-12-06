public class Main {
    public static void main(String[] args) {
        final String HOUSE = "house.png"; // 원본 영상 파일 이름
        final String ext = "png";
        String[] prefixes = { "g_", "i_", "s_" };

        ImageConverter[] converters = { new GreyImageConverter(),
                                        new InverseImageConverter(),
                                        new SepiaImageConverter() };
        for (int i = 0; i < converters.length; i++) {
            converters[i].convert(HOUSE, prefixes[i], ext);
        }
    }
}