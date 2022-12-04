import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends FrameWindow {
    private static final String MAIN_TITLE = "Main Window";
    private static final String LABEL_WINDOW_TITLE = "Label Window";
    private static final int X = 250;
    private static final int Y = 100;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 200;
    private static final int GAP = 50;

    private TimeObservableThread primeThread;
    private LabelWindow labelWindow1;
    private LabelWindow labelWindow2;

    public MainWindow(String title) {
        super(title, X, Y, WIDTH, HEIGHT);
        labelWindow1 = new LabelWindow(LABEL_WINDOW_TITLE, X, Y + HEIGHT + GAP, WIDTH, HEIGHT);
        labelWindow2 = new LabelWindow(LABEL_WINDOW_TITLE, X, Y + (HEIGHT + GAP) * 2, WIDTH, HEIGHT);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                primeThread.stopRunning();
                labelWindow1.closeWindow();
                labelWindow2.closeWindow();
                System.exit(0);
            }
        });

        primeThread = new TimeObservableThread(); // 객체 생성
        primeThread.registerObserver(labelWindow1);  // labelWindow1 를 옵저버로 추가
        primeThread.registerObserver(labelWindow2);  // labelWindow2 를 옵저버로 추가

        primeThread.run();  // 소수 생성 시작. 이 함수가 실행된 후에는 stopButton이 눌리기 전까지 무한 반복됨
    }

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(width, height));
        return panel;
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow(MainWindow.MAIN_TITLE);
    }
}
