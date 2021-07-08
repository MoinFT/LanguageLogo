package de.moinFT.main;

import javax.swing.*;
import java.awt.*;

public class Draw {
    public static void draw(JPanel DrawPanel, String program) {
        Graphics g = DrawPanel.getGraphics();
        g.setColor(Color.black);

        int[] xTurtle_Temp = new int[4];
        int[] yTurtle_Temp = new int[4];

        if (!GUI.init) {
            GUI.X = DrawPanel.getWidth() / 2;
            GUI.Y = DrawPanel.getHeight() / 2;
            GUI.init = true;

            GUI.X_Turtle[0] = GUI.X;
            GUI.X_Turtle[1] = GUI.X + 8;
            GUI.X_Turtle[2] = GUI.X;
            GUI.X_Turtle[3] = GUI.X - 8;

            GUI.Y_Turtle[0] = GUI.Y;
            GUI.Y_Turtle[1] = GUI.Y + 8;
            GUI.Y_Turtle[2] = GUI.Y - 16;
            GUI.Y_Turtle[3] = GUI.Y + 8;

            for (int i = 0; i < 4; i++) {
                xTurtle_Temp[i] = (int) GUI.X_Turtle[i];
                yTurtle_Temp[i] = (int) GUI.Y_Turtle[i];
            }
            g.setColor(Color.red);
            g.setPaintMode();
            g.fillPolygon(xTurtle_Temp, yTurtle_Temp, 4);
        }

        char c;
        while (program.length() > 0) {
            StringBuilder StrNumber;
            char z;
            c = program.charAt(0);

            if (program.length() > 1) {
                program = program.substring(1);
            } else {
                program = "";
            }

            switch (c) {
                case 'R':
                    GUI.pencilDraw = true;
                    break;
                case 'H':
                    GUI.pencilDraw = false;
                    break;
                case 'V':
                    StrNumber = new StringBuilder();
                    z = program.charAt(0);

                    while (z != ';') {
                        z = program.charAt(0);
                        program = program.substring(1);
                        if (z != ';') {
                            StrNumber.append(z);
                        }
                    }
                    double distance = Double.parseDouble(StrNumber.toString());
                    double XTemp = distance * Math.sin(Math.toRadians(GUI.Angle));
                    double YTemp = distance * Math.cos(Math.toRadians(GUI.Angle));

                    if (GUI.pencilDraw) {
                        for (int i = 0; i < 4; i++) {
                            xTurtle_Temp[i] = (int) GUI.X_Turtle[i];
                            yTurtle_Temp[i] = (int) GUI.Y_Turtle[i];
                        }
                        //Remove turtle at the actual position
                        g.setXORMode(Color.white);
                        g.setColor(Color.red);
                        g.fillPolygon(xTurtle_Temp, yTurtle_Temp, 4);

                        //Draw line
                        g.setPaintMode();
                        g.setColor(Color.black);
                        g.drawLine((int) GUI.X, (int) GUI.Y, (int) (GUI.X + XTemp), (int) (GUI.Y - YTemp));

                        GUI.X = GUI.X + XTemp;
                        GUI.Y = GUI.Y - YTemp;

                        //Draw turtle at new position
                        GUI.X_Turtle[0] = GUI.X;
                        GUI.X_Turtle[1] = GUI.X + Math.sqrt(128) * Math.cos(Math.toRadians(45 - GUI.Angle));
                        GUI.X_Turtle[2] = GUI.X + 16 * Math.sin(Math.toRadians(GUI.Angle));
                        GUI.X_Turtle[3] = GUI.X - Math.sqrt(128) * Math.sin(Math.toRadians(45 - GUI.Angle));

                        GUI.Y_Turtle[0] = GUI.Y;
                        GUI.Y_Turtle[1] = GUI.Y + Math.sqrt(128) * Math.sin(Math.toRadians(45 - GUI.Angle));
                        GUI.Y_Turtle[2] = GUI.Y - 16 * Math.cos(Math.toRadians(GUI.Angle));
                        GUI.Y_Turtle[3] = GUI.Y + Math.sqrt(128) * Math.cos(Math.toRadians(45 - GUI.Angle));

                        g.setXORMode(Color.red);
                        g.setColor(Color.red);
                        for (int i = 0; i < 4; i++) {
                            xTurtle_Temp[i] = (int) GUI.X_Turtle[i];
                            yTurtle_Temp[i] = (int) GUI.Y_Turtle[i];
                        }
                        g.fillPolygon(xTurtle_Temp, yTurtle_Temp, 4);
                    } else {
                        GUI.X = GUI.X + XTemp;
                        GUI.Y = GUI.Y - YTemp;
                    }
                    break;
                case 'D':
                    StrNumber = new StringBuilder();
                    z = program.charAt(0);

                    while (z != ';') {
                        z = program.charAt(0);
                        program = program.substring(1);
                        if (z != ';') {
                            StrNumber.append(z);
                        }
                    }
                    GUI.Angle = GUI.Angle - Double.parseDouble(StrNumber.toString());
                    while (GUI.Angle > 360) {
                        GUI.Angle = GUI.Angle - 360;
                    }
                    while (GUI.Angle < 0) {
                        GUI.Angle = GUI.Angle + 360;
                    }
                    break;
                case 'W':
                    StrNumber = new StringBuilder();
                    z = program.charAt(0);

                    while (z != '{') {
                        z = program.charAt(0);
                        program = program.substring(1);
                        if (z != '{') {
                            StrNumber.append(z);
                        }
                    }

                    StringBuilder StrTemp = new StringBuilder();

                    while (z != '}') {
                        z = program.charAt(0);
                        program = program.substring(1);
                        if (z != '}') {
                            StrTemp.append(z);
                        }
                    }

                    for (int i = 0; i < Integer.parseInt(StrNumber.toString()); i++) {
                        draw(DrawPanel, StrTemp.toString());
                    }
                    break;
            }
        }
    }
}
