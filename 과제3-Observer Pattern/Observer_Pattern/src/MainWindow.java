import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends FrameWindow implements ActionListener {
    private static final String MAIN_TITLE = "Main Window";
    private static final String TEXTFIELD_WINDOW_TITLE = "TextField Window";
    private static final String LABEL_WINDOW_TITLE = "Label Window";
    private static final String REMOVE_TEXTFIELD_OBSERVER_BUTTON_TITLE = "Remove TextField Window Observer";
    private static final String ADD_TEXTFIELD_OBSERVER_BUTTON_TITLE = "ADD TextField Window Observer";
    private static final String REMOVE_LABEL_OBSERVER_BUTTON_TITLE = "Remove Label Window Observer";
    private static final String ADD_LABEL_OBSERVER_BUTTON_TITLE = "ADD Label Window Observer";
    private static final String STOP_THREAD_BUTTON_TITLE = "Stop Generating Prime Number";
    private static final int X = 250;
    private static final int Y = 100;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 200;
    private static final int GAP = 50;
    private static final int NUM_BUTTONS = 3;
    private boolean textFieldObserver = false;
    private boolean labelObserver = false;

    private JButton stopButton;
    private JButton updateTextFieldObserverButton;
    private JButton updateLabelObserverButton;
    private PrimeObservableThread primeThread;
    private TextFieldWindow textFieldWindow;
    private LabelWindow labelWindow;

    public MainWindow(String title) {
        super(title, X, Y, WIDTH, HEIGHT);
        textFieldWindow = new TextFieldWindow(TEXTFIELD_WINDOW_TITLE, X, Y + HEIGHT + GAP, WIDTH, HEIGHT);
        labelWindow = new LabelWindow(LABEL_WINDOW_TITLE, X, Y + (HEIGHT + GAP) * 2, WIDTH, HEIGHT);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                primeThread.stopRunning();
                textFieldWindow.closeWindow();
                labelWindow.closeWindow();
                System.exit(0);
            }
        });

        primeThread = new PrimeObservableThread(); // 객체 생성
        primeThread.registerObserver(textFieldWindow);  // textFiledWindow 를 옵저버로 추가
        textFieldObserver = true;   // textFiledWindow 가 옵저버로 추가됐으니 true
        primeThread.registerObserver(labelWindow);  // labelWindow 를 옵저버로 추가
        labelObserver = true;   // labelWidow 가 옵저버로 추가됐으니 true
        
        primeThread.run();  // 소수 생성 시작. 이 함수가 실행된 후에는 stopButton이 눌리기 전까지 무한 반복됨
    }

    public JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(width, height));
        updateTextFieldObserverButton = createButton(REMOVE_TEXTFIELD_OBSERVER_BUTTON_TITLE, this, width, height);
        panel.add(updateTextFieldObserverButton);
        updateLabelObserverButton = createButton(REMOVE_LABEL_OBSERVER_BUTTON_TITLE, this, width, height);
        panel.add(updateLabelObserverButton);
        stopButton = createButton(STOP_THREAD_BUTTON_TITLE, this, width, height);
        panel.add(stopButton);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateTextFieldObserverButton) {
            if (textFieldObserver) {    // textField 옵저버가 있다면 버튼을 바꾸고 옵저버를 제거
                updateTextFieldObserverButton.setText(ADD_TEXTFIELD_OBSERVER_BUTTON_TITLE);
                primeThread.unregisterObserver(textFieldWindow);
                textFieldObserver = false;
            } else {    // textField 옵저버가 없다면 버튼을 바꾸고 옵저버를 추가
                updateTextFieldObserverButton.setText(REMOVE_TEXTFIELD_OBSERVER_BUTTON_TITLE);
                primeThread.registerObserver(textFieldWindow);
                textFieldObserver = true;
            }
        }
        else if (e.getSource() == updateLabelObserverButton) {
            if (labelObserver) {    // label 옵저버가 있다면 버튼을 바꾸고 옵저버를 제거
                updateLabelObserverButton.setText(ADD_LABEL_OBSERVER_BUTTON_TITLE);
                primeThread.unregisterObserver(labelWindow);
                labelObserver = false;
            } else {    // label 옵저버가 없다면 버튼을 바꾸고 옵저버를 추가
                updateLabelObserverButton.setText(REMOVE_LABEL_OBSERVER_BUTTON_TITLE);
                primeThread.registerObserver(labelWindow);
                labelObserver = true;
            }
        }
        else if (e.getSource() == stopButton) {
            primeThread.stopRunning();
        }
    }

    private JButton createButton(String text, ActionListener listener, int width, int height) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        Dimension buttonDimension = new Dimension(width, height / NUM_BUTTONS);
        button.setMaximumSize(buttonDimension);
        button.setMinimumSize(buttonDimension);
        button.setPreferredSize(buttonDimension);
        return button;
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow(MainWindow.MAIN_TITLE);
    }
}
