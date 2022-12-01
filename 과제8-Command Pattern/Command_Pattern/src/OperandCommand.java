import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OperandCommand extends CommandButton implements Command {
    Calculator calculator;
    JLabel display;

    OperandCommand(String text, ActionListener listener, Dimension buttonDimension, Calculator calculator, JLabel display) {
        super(text, listener, buttonDimension);
        this.calculator = calculator;
        this.display = display;
    }

    @Override
    public void execute() {
        if (!calculator.isOperand1Set()) {
            int num1 = Integer.parseInt(getText());
            display.setText("" + num1);
            calculator.setOperand1(num1);
            calculator.setOperand1Set(true);
        } else if (calculator.isOperand1Set() && calculator.isOperatorSet()) {
            int num2 = Integer.parseInt(getText());
            calculator.setOperand2(num2);
            display.setText("" + num2);
            calculator.setOperand2Set(true);
        }
    }
}
