public class SourceCode {
    private String codeFileName;

    SourceCode(String codeFileName) {
        this.codeFileName = codeFileName;
    }

    public String getFilename() {
        return codeFileName;
    }

    public void setFilename(String codeFileName) {
        this.codeFileName = codeFileName;
    }
}
