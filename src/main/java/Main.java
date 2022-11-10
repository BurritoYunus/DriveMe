import com.google.gson.Gson;
import forms.DriveMe;
import modules.CarRegistration;

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
        createPersonGUI.setLocationRelativeTo(null);
        createPersonGUI.setResizable(false);
        createPersonGUI.setVisible(true);

        int registrationNumber = 444;
        int seats = 2;
        String transmissionType = "hey";
        String engineType = "hey";

        CarRegistration registeredCar = new CarRegistration(registrationNumber, seats, transmissionType, engineType);

        Gson gson = new Gson();
        String json = gson.toJson(registeredCar);


        System.out.println(registeredCar);
    }
}
