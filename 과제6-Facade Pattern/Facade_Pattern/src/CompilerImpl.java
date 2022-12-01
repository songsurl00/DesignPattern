public class CompilerImpl implements Compiler{
    @Override
    public ObjectCode compile(SourceCode sourceCode) {
        String codeFileName = sourceCode.getFilename();
        System.out.println("Compiling code: " + codeFileName);

        String objFileName = codeFileName.replace(".c", ".obj");
        ObjectCode objectCode = new ObjectCode(objFileName);
        System.out.println("Generating object code: " + objFileName);

        return objectCode;
    }
}
