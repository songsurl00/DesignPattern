public class Keyboard extends BaseExternalDevice{
    public Keyboard(String deviceType, AbstractNotebookComputer abstractNotebookComputer) {
        super(deviceType, abstractNotebookComputer);
    }
    @Override
    public double getRequiredSpace() {
        return 80;
    }
}