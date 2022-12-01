import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EqaulCommand extends CommandButton implements Command{
    Calculator calculator;
    JLabel display;

    public EqaulCommand(String text, ActionListener listener, Dimension buttonDimension, Calculator calculator, JLabel display) {
        super(text, listener, buttonDimension);
        this.calculator = calculator;
        this.display = display;
    }

    @Override
    public void execute() {
        int result = 0;
        if (calculator.isOperand1Set() && calculator.isOperand2Set() && calculator.isOperatorSet()) {
            if (calculator.getOperator() == '+') {
                result = calculator.getOperand1() + calculator.getOperand2();
            }
            else if (calculator.getOperator() == '-') {
                result = calculator.getOperand1() - calculator.getOperand2();
            }
            else if (calculator.getOperator() == '*') {
                result = calculator.getOperand1() * calculator.getOperand2();
            }
            else if (calculator.getOperator() == '/') {
                result = calculator.getOperand1() / calculator.getOperand2();
            }
        }
        display.setText("" + result);
        calculator.clearFlags();
    }
}
