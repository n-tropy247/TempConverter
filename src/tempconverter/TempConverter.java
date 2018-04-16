/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempconverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author castellir
 */
public class TempConverter {

    private JButton convert;
    private double temp;
    
    public String display = "";
    
    public static JTextField textInput;
    public static JTextField textOutput;
    
    public JButton convButton = new JButton("Convert");
    
    public static void main(String[] args) {
        JFrame panel = new JFrame("Temperature Converter");
        
        panel.setSize(300,200);
        
        panel.setLocationRelativeTo(null);
        
        panel.getContentPane().setLayout(new FlowLayout());
        
        textInput = new JTextField("Input Here", 15);
        textOutput = new JTextField(15);
        textOutput.setEditable(false);
        
        JButton farButton = new JButton("To Fahrenheit");
        JButton celButton = new JButton("To Celsius");
        
        panel.add(textInput);
        panel.add(farButton);
        panel.add(celButton);
        panel.add(textOutput);
        
        farButton.addActionListener(new FarListen());
        celButton.addActionListener(new CelListen());
        
        
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setVisible(true);
    }
    
    public static double toCel(double x) {
        x = (x-32) * 5/9;
        return x;
    }
    
    public static double toFar(double x) {
        x = x*(9/5) + 32;
        return x;
    }
    
    static class FarListen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double operand = Double.valueOf(textInput.getText());
            
            textOutput.setText(Double.toString(toFar(operand)));
                
            textInput.setText("");
        }
    }
    
    static class CelListen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double operand = Double.valueOf(textInput.getText());
            
            textOutput.setText(Double.toString(toCel(operand)));
            
            textInput.setText("");
        }
    }
}
