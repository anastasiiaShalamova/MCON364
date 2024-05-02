package Calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class MainProcessTest {
    private MainProcess mainProcess;

    @BeforeEach
    public void setUp() {
        mainProcess = new MainProcess();
        mainProcess.result = new Label();
    }

    @Test
    public void testProcessNumbers() {
        ActionEvent event = new ActionEvent(new Button(), null);
        ((Button)event.getSource()).setText("5");
        mainProcess.processNumbers(event);
        assertEquals("5", mainProcess.result.getText());
    }

    @Test
    public void testProcessOperators() {
        ActionEvent event = new ActionEvent(new Button(), null);
        ((Button)event.getSource()).setText("+");
        mainProcess.result.setText("10");
        mainProcess.processOperators(event);
        assertEquals("10", mainProcess.result.getText()); 
    }

    @Test
    public void testProcessOperatorsWithMinus() {
        ActionEvent event = new ActionEvent(new Button(), null);
        ((Button)event.getSource()).setText("-");
        mainProcess.result.setText("10");
        mainProcess.processOperators(event);
        assertEquals("", mainProcess.result.getText());
    }
}

