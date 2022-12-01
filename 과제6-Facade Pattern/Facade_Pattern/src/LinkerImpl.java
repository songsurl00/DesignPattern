import java.util.List;

public class LinkerImpl implements Linker{
    @Override
    public Executable link(String exeFileName, ObjectCode[] objFiles) {
        String objs = "";
        for (int i = 0; i < objFiles.length; i++) {
            objs += "\n" + objFiles[i].getFilename();
        }
        System.out.println("Linking" + objs);

        return new Executable(exeFileName, objs);
    }

    @Override
    public Executable link(String exeFileName, List<ObjectCode> objFiles) {
        String objs = "";
        for (int i = 0; i < objFiles.size(); i++) {
            objs += "\n" + objFiles.get(i).getFilename();
        }
        System.out.println("Linking" + objs);

        return new Executable(exeFileName, objs);
    }
}
