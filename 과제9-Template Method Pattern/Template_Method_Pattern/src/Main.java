public class Main {
    public static void main(String[] args) {
        final String HOUSE = "house.png";
        String[] prefixes = {"g_", "i_", "s_"};

        ImgConverter[] converters = new ImgConverter[3];
        converters[0] = new GreyImageConverter();
        converters[1] = new InverseImageConverter();
        converters[2] = new SepiaImageConverter();
        for (int i = 0; i < 3; i++) {
            converters[i].convert(HOUSE, prefixes[i]);
        }
    }
}
