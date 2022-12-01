import javax.swing.*;
import java.awt.event.WindowListener;

public abstract class FrameWindow { // 공통부분은 묶고 자세한 내용은 상속받는 자식이 하게함
    private JFrame frame;

    public FrameWindow(String title, int x, int y, int width, int height) {
        frame = createWindow(title, x, y, width, height);
    }

    public JFrame createWindow(String title, int x, int y, int width, int height) {
        JFrame frame;
        frame = new JFrame(title);
        frame.setBounds(x, y, width, height);
        JPanel panel = createPanel(width, height);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    public void closeWindow() { // 화면에 감추고 frame제거
        frame.setVisible(false);
        frame.dispose();
    }

    public void addWindowListener(WindowListener lis) { //
        frame.addWindowListener(lis);
    }

    public abstract JPanel createPanel(int width, int height);  // panel을 만드는 자세한 부분은 자식에게 위임
}
