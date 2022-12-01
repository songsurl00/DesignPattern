public class PreprocessorImpl implements Preprocessor{
    @Override
    public SourceCode preprocess(SourceCode sourceCode) {
        String fileName = sourceCode.getFilename();
        System.out.println("PreProcessing C code: " + fileName);

        SourceCode newSourceCode = new SourceCode("preprocessed_" + fileName);
        System.out.println("Generating a new C code: " + newSourceCode.getFilename());

        return newSourceCode;
    }
}
