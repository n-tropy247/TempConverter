/*
 * Copyright (C) 2018 Ryan Castelli
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

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Simple temperature converter between Fahrenheit and Celsius.
 *
 * @author NTropy
 * @version 10/11/2018
 */
final class TempConverter {

    /**
     * Variables for conversion between standards. TEMP_DIFF the value
     * subtracted from or added to temperature to scale TEMP_FRAC the conversion
     * ratio
     */
    private static final double TEMP_DIFF = 32, TEMP_FRAC = 9. / 5.;

    /**
     * Length of input fields.
     */
    private static final int FIELD_LEN = 15;

    /**
     * Width and length for GUI Window.
     */
    private static final int SCREEN_W = 300, SCREEN_H = 200;

    /**
     * IO fields.
     */
    private static JTextField textInput, textOutput;

    /**
     * Utility class.
     */
    private TempConverter() {
    }

    /**
     * Initialize JFrame values.
     *
     * @param args command-line arguments; unused.
     */
    public static void main(final String[] args) {
        JFrame panel = new JFrame("Temperature Converter");

        panel.setSize(SCREEN_W, SCREEN_H);

        panel.setLocationRelativeTo(null);

        panel.getContentPane().setLayout(new FlowLayout());

        textInput = new JTextField("", FIELD_LEN);

        textOutput = new JTextField(FIELD_LEN);
        textOutput.setEditable(false);

        JButton farButton = new JButton("To Fahrenheit");
        JButton celButton = new JButton("To Celsius");

        panel.add(textInput);
        panel.add(farButton);
        panel.add(celButton);
        panel.add(textOutput);

        farButton.addActionListener(new Handler());
        celButton.addActionListener(new Handler());

        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setVisible(true);
    }

    /**
     * Convert to Celsius.
     *
     * @param x temperature to convert
     * @return temperature in Celsius
     */
    private static double toCel(final double x) {
        return (x - TEMP_DIFF) * 1 / TEMP_FRAC;
    }

    /**
     * Convert to Fahrenheit.
     *
     * @param x temperature to convert
     * @return temperature in Fahrenheit
     */
    private static double toFar(final double x) {
        return x * TEMP_FRAC + TEMP_DIFF;
    }

    /**
     * Listens for conversion to Fahrenheit.
     */
    static final class Handler implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent e) {
            if (e.getActionCommand().equals("To Fahrenheit")) {
                textOutput.setText(Double.toString(toFar(
                        Double.valueOf(textInput.getText()))));
                textInput.setText("");
            } else if (e.getActionCommand().equals("To Celsius")) {
                textOutput.setText(Double.toString(toCel(
                        Double.valueOf(textInput.getText()))));
                textInput.setText("");
            }
        }
    }
}
