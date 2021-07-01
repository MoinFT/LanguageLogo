package de.moinFT.main;

import javax.swing.*;
import java.awt.*;

public class Draw {
    public static void draw(JPanel DrawPanel, String program) {
        Graphics g = DrawPanel.getGraphics();
        g.setColor(Color.black);

        if (!GUI.init) {
            GUI.X = DrawPanel.getWidth() / 2;
            GUI.Y = DrawPanel.getHeight() / 2;
            GUI.init = true;
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
                        g.drawLine((int) GUI.X, (int) GUI.Y, (int) (GUI.X + XTemp), (int) (GUI.Y - YTemp));
                    }

                    GUI.X = GUI.X + XTemp;
                    GUI.Y = GUI.Y - YTemp;
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
                    while (GUI.Angle > 360){
                        GUI.Angle = GUI.Angle - 360;
                    }
                    while (GUI.Angle < 0){
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

                    for (int i = 0; i < Integer.parseInt(StrNumber.toString()); i++){
                        draw(DrawPanel, StrTemp.toString());
                    }
                    break;
            }
        }
    }
}
