public class HardDrive extends BaseExternalDevice{
    public HardDrive(String deviceType, AbstractNotebookComputer abstractNotebookComputer) {
        super(deviceType, abstractNotebookComputer);
    }
    @Override
    public double getRequiredSpace() {
        return 40;
    }
}