public abstract class AbstractExternalDevice extends AbstractNotebookComputer{
    private String deviceType;
    public AbstractExternalDevice(String deviceType) {
        this.deviceType = deviceType;
    }
    public String toString() {
        return deviceType;
    }
    @Override
    public abstract double requiredSpace();
}
