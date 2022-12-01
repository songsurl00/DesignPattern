import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class LoadHudDisplays implements LoadDisplayInterface{
    private ArrayList<String> list = new ArrayList<>();
    public LoadHudDisplays(String filename) {
        try {
            FileReader f = new FileReader(filename);
            BufferedReader br = new BufferedReader(f);
            String line = br.readLine();
            while (line != null) {
                line = line.trim();
                if (!line.equals("")) {
                    list.add(line);
                }
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public ArrayList<String> load() {
        return list;
    }
}
