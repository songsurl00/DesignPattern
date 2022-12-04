public class NotebookComputer extends AbstractNotebookComputer{
    private String owner;
    public NotebookComputer(String owner) {
        this.owner = owner;
    }
    public String toString() {
        return owner + "'s Notebook computer";
    }
    @Override
    public double requiredSpace() {
        return 250;
    }
}
