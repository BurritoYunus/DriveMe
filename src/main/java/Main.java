import forms.DriveMe;

import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) {
        DriveMe createPersonGUI = new DriveMe("DriveMe");
        createPersonGUI.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        createPersonGUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
        System.out.println(width+" "+height);
        createPersonGUI.setLocationRelativeTo(null);
        createPersonGUI.setResizable(false);
        createPersonGUI.setVisible(true);

    }
}
