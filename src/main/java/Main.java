import com.google.gson.Gson;
import forms.DriveMe;
import modules.CarRegistration;

import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) {
        DriveMe createAppGUI = new DriveMe("DriveMe");
        createAppGUI.setSize(800, 600);
        createAppGUI.setVisible(true);

        String registrationNumber = "HF53344";
        String seats = "2";
        String transmissionType = "hey";
        String engineType = "hey";

        CarRegistration registeredCar = new CarRegistration(registrationNumber, seats, transmissionType, engineType);

        Gson gson = new Gson();
        String json = gson.toJson(registeredCar);


        System.out.println(registeredCar);
    }
}
