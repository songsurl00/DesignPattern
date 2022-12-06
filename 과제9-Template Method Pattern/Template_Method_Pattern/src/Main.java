public class Main {
    public static void main(String[] args) {
        final String HOUSE = "house.png";
        String[] prefixes = {"g_", "i_", "s_"};

        ImgConverter[] converters = {new GreyImageConverter(), new InverseImageConverter(), new SepiaImageConverter()};
        for (int i = 0; i < converters.length; i++) {
            converters[i].convert(HOUSE, prefixes[i]);
        }
    }
}
