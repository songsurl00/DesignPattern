public class LEDMonitor extends BaseExternalDevice{
    public LEDMonitor(String deviceType, AbstractNotebookComputer abstractNotebookComputer) {
        super(deviceType, abstractNotebookComputer);
    }
    @Override
    public double getRequiredSpace() {
        return 150;
    }
}
