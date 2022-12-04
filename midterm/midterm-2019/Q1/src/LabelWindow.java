import javax.swing.*;
import java.awt.*;

public class LabelWindow extends FrameWindow implements Observer{
    private JLabel label;

    public LabelWindow(String title, int x, int y, int width, int height) {
        super(title, x, y, width, height);
    }

    public void updateText(String msg) {    // text를 바꾸도록 요청
        label.setText(msg);
        label.validate();
    }

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        label = new JLabel();
        panel.add(label);
        panel.setPreferredSize(new Dimension(width, height));
        return panel;
    }

    @Override
    public void update(String s) {
        updateText(s);
    }
}
