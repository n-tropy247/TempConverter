/*
 * Copyright (C) 2018 castellir
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
