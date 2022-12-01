import java.util.ArrayList;
import java.util.List;

public class IDE implements Builder{
    private PreprocessorImpl preprocessor;
    private CompilerImpl compiler;
    private LinkerImpl linker;

    private String projectName;

    public IDE(String projectName, PreprocessorImpl preprocessor, CompilerImpl compiler, LinkerImpl linker) {
        createProject(projectName);
        this.preprocessor = preprocessor;
        this.compiler = compiler;
        this.linker = linker;
    }

    @Override
    public void createProject(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public Executable build(SourceCode[] sourceCodes) {
        System.out.println("\nIDE에서 소스 코드 배열을 이용해서 빌드 후 실행");
        ObjectCode[] objectCodes = new ObjectCode[sourceCodes.length];
        for (int i = 0; i < sourceCodes.length; i++) {
            objectCodes[i] = compiler.compile(preprocessor.preprocess(sourceCodes[i]));
        }
        Executable executable = linker.link(projectName, objectCodes);
        executable.execute();

        return executable;
    }

    @Override
    public Executable build(List<SourceCode> sourceCodes) {
        System.out.println("\nIDE에서 소스 코드 배열을 이용해서 빌드 후 실행");
        List<ObjectCode> objectCodes = new ArrayList<>();
        for (int i = 0; i < sourceCodes.size(); i++) {
            objectCodes.add(compiler.compile(preprocessor.preprocess(sourceCodes.get(i))));
        }
        Executable executable = linker.link(projectName, objectCodes);
        executable.execute();

        return executable;
    }
}
