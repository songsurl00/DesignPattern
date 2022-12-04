public abstract class BaseExternalDevice extends AbstractExternalDevice{
    private AbstractNotebookComputer abstractNotebookComputer;
    public BaseExternalDevice(String deviceType, AbstractNotebookComputer abstractNotebookComputer) {
        super(deviceType);
        this.abstractNotebookComputer = abstractNotebookComputer;
    }

    public String toString() {
        return abstractNotebookComputer.toString() + ", " + super.toString();
    }

    public double requiredSpace() {
        return abstractNotebookComputer.requiredSpace() + getRequiredSpace();

    }
    public abstract double getRequiredSpace();
}
