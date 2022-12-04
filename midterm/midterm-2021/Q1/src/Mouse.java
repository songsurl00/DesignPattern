public class Mouse extends BaseExternalDevice{
    public Mouse(String deviceType, AbstractNotebookComputer abstractNotebookComputer) {
        super(deviceType, abstractNotebookComputer);
    }
    @Override
    public double getRequiredSpace() {
        return 30;
    }
}