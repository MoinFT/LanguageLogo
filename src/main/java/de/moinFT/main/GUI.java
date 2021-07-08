package de.moinFT.main;

import de.moinFT.utils.Functions;
import de.moinFT.utils.GUIComponent;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public static boolean init = false;
    public static double X = 0;
    public static double Y = 0;
    public static double Angle = 0;
    public static boolean pencilDraw = false;

    public static double[] X_Turtle = new double[4];
    public static double[] Y_Turtle = new double[4];

    public GUI() {
        this.setTitle("Logo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 535, 465);

        JPanel contentPane = GUIComponent.JPanel();
        this.setContentPane(contentPane);

        JPanel DrawPanel = GUIComponent.JPanel();
        DrawPanel.setBackground(new Color(255, 255, 255));
        DrawPanel.setBounds(10, 10, 500, 300);
        contentPane.add(DrawPanel);

        JLabel Lbl_Input = GUIComponent.Label(contentPane, Font.BOLD, 13);
        Lbl_Input.setText("Eingabe:");
        Lbl_Input.setBounds(10, 320, 75, 25);

        JTextField TF_Input = GUIComponent.TextField(contentPane);
        TF_Input.setBounds(80, 320, 430, 25);

        JLabel Lbl_Output = GUIComponent.Label(contentPane, Font.BOLD, 13);
        Lbl_Output.setText("Ausgabe:");
        Lbl_Output.setBounds(10, 355, 75, 25);

        JTextField TF_Output = GUIComponent.TextField(contentPane);
        TF_Output.setBounds(80, 355, 430, 25);
        TF_Output.setEditable(false);

        JButton Btn_Calculate = GUIComponent.Button(contentPane);
        Btn_Calculate.setText("Start");
        Btn_Calculate.setBounds(265, 390, 245, 25);

        JButton Btn_Clear = GUIComponent.Button(contentPane);
        Btn_Clear.setText("Loeschen");
        Btn_Clear.setBounds(10, 390, 245, 25);

        this.setVisible(true);

        Btn_Clear.addActionListener(event -> {
            Graphics g = DrawPanel.getGraphics();
            g.setColor(Color.white);
            g.fillRect(0, 0, DrawPanel.getWidth(), DrawPanel.getHeight());
            g.setColor(Color.black);

            TF_Output.setText("Kein Backup? Kein Mitleid!");
        });

        Btn_Calculate.addActionListener(event -> {
            String input = TF_Input.getText();

            input = Functions.format(input);
            TF_Input.setText(input);
            String inputNumbers = Functions.replaceNumbers(input);

            int[] ArrReturn = Functions.parse(inputNumbers);

            int status = ArrReturn[0];
            int space = ArrReturn[1];

            if (status == 90) {
                Draw.draw(DrawPanel, TF_Input.getText());

                TF_Output.setText("");
            } else {
                String ErrorMessage = "Unerwarteter Fehler!";

                switch (status) {
                    case 101:
                        ErrorMessage = "Hier ist keine Zahl erlaubt!";
                        break;
                    case 102:
                        ErrorMessage = "Hier ist keine Klammer erlaubt!";
                        break;
                    case 103:
                        ErrorMessage = "Hier ist kein Semikolon erlaubt!";
                        break;
                    case 104:
                        ErrorMessage = "Semikolon erwartet!";
                        break;
                    case 105:
                        ErrorMessage = "Ziffer erwartet!";
                        break;
                    case 106:
                        ErrorMessage = "Ziffer oder Semikolon erwartet!";
                        break;
                    case 107:
                        ErrorMessage = "Ziffer oder öffnende Klammer erwartet!";
                        break;
                    case 108:
                        ErrorMessage = "Keine geschatelten Schleifen erlaubt!";
                        break;
                    case 109:
                        ErrorMessage = "Schließende Klammer erwartet!";
                        break;
                }

                ErrorMessage = "^ " + ErrorMessage;

                TF_Output.setText(" ".repeat(space) + ErrorMessage);
            }
        });
    }
}