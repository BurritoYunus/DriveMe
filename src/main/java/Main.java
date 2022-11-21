import com.google.gson.Gson;
import forms.DriveMe;
import modules.CarRegistration;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        DriveMe createAppGUI = new DriveMe("DriveMe");
        createAppGUI.setSize(800, 600);
        createAppGUI.setVisible(true);

        String registrationNumber = "HF53344";
        String seats = "2";
        String transmissionType = "Auto";
        String engineType = "Diesel";

        CarRegistration registeredCar = new CarRegistration(registrationNumber, seats, transmissionType, engineType);

        //lager til en json
        Gson gson = new Gson();
        String json = gson.toJson(registeredCar);


        //skriver til fil
        try {
            FileWriter writer = new FileWriter("test.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //leser fra fil
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("test.json"));
            CarRegistration registeredCar2 = gson.fromJson(br, CarRegistration.class);

            System.out.println("\n" + registeredCar2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
