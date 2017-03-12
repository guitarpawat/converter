package converter;

import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * The Converter UI class to interact with user.
 * @author Pawat Nakpiphatkul
 */
public class ConverterUI {

    private UnitConverter converter;
    private Unit[] units;
    private JFrame frame;

    /**
     * Initialize ConvertUI.
     */
    public ConverterUI() {
        converter = new UnitConverter();
        units = converter.getUnits();
        initFrame();
    }

    /**
     * Initialize JFrame for the UI.
     */
    private void initFrame() {
        frame = new JFrame("Distance Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
        frame.setLayout(new FlowLayout());
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Initialize components for the UI.
     */
    private void initUI() {
        JTextField inputField = new JTextField(15);
        JComboBox inputUnit = new JComboBox<Unit>();
        for (Unit u : units) {
            inputUnit.addItem(u);
        }
        JLabel equalSign = new JLabel("=");
        equalSign.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
        JTextField outputField = new JTextField(15);
        outputField.setEditable(false);
        JComboBox outputUnit = new JComboBox<Unit>();
        for (Unit u : units) {
            outputUnit.addItem(u);
        }
        JButton convertButton = new JButton("Convert!");
        JButton clearButton = new JButton("Clear");
        frame.add(inputField);
        frame.add(inputUnit);
        frame.add(equalSign);
        frame.add(outputField);
        frame.add(outputUnit);
        frame.add(convertButton);
        frame.add(clearButton);
        final ActionListener convertListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String inputText = inputField.getText();
                try {
                    double inputDouble = Double.parseDouble(inputText);
                    if(inputDouble < 0) {
                        outputField.setText("Please enter positive number");
                        inputField.setText("");
                    }
                    else {
                        double outputText = converter.convert(inputDouble, (Unit)inputUnit.getSelectedItem(),(Unit)outputUnit.getSelectedItem());
                        outputField.setText(String.valueOf(outputText));
                    }
                }
                catch(NumberFormatException|NullPointerException e) {
                    outputField.setText("Please enter a number");
                    inputField.setText("");
                }
            }
        };
        convertButton.addActionListener(convertListener);
        inputField.addActionListener(convertListener);
        final ActionListener clearListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                outputField.setText("");
                inputField.setText("");
            }
        };
        clearButton.addActionListener(clearListener);
    }
}
