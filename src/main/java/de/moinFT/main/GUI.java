package de.moinFT.main;

import de.moinFT.utils.Functions;
import de.moinFT.utils.GUIComponent;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public GUI() {
        this.setTitle("Logo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 535, 535);

        JPanel contentPane = GUIComponent.JPanel();
        this.setContentPane(contentPane);

        JPanel DrawPanel = GUIComponent.JPanel();
        DrawPanel.setBackground(new Color(255, 255, 255));
        DrawPanel.setBounds(10, 10, 500, 300);
        contentPane.add(DrawPanel);

        JLabel Lbl_Input = GUIComponent.Label(contentPane, Font.BOLD, 13);
        Lbl_Input.setText("Eingabe:");
        Lbl_Input.setBounds(10, 320, 500, 25);

        JTextField TF_Input = GUIComponent.TextField(contentPane);
        TF_Input.setBounds(10, 355, 500, 25);

        JButton Btn_Calculate = GUIComponent.Button(contentPane);
        Btn_Calculate.setText("Start");
        Btn_Calculate.setBounds(10, 390, 500, 25);

        JLabel Lbl_Output = GUIComponent.Label(contentPane, Font.BOLD, 13);
        Lbl_Output.setText("Ausgabe:");
        Lbl_Output.setBounds(10, 425, 500, 25);

        JTextField TF_Output = GUIComponent.TextField(contentPane);
        TF_Output.setBounds(10, 460, 500, 25);
        TF_Output.setEditable(false);

        this.setVisible(true);

        Btn_Calculate.addActionListener(event -> {
            String input = TF_Input.getText();

            input = Functions.format(input);
            TF_Input.setText(input);
            input = Functions.replaceNumbers(input);

            int status = Functions.parse(input);
        });
    }
}