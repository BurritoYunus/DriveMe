import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import forms.DriveMe;
import modules.CarRegistration;
import modules.CarRepository;

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


        CarRegistration car1 = new CarRegistration("EF23453", "5", "Manual", "Petrol");
        CarRegistration car2 = new CarRegistration("EFdgdfg", "4", "Auto", "Diesel");
        CarRegistration car3 = new CarRegistration("E341453", "6", "Manual", "Petrol");
        CarRegistration car4 = new CarRegistration("EGFDD53", "7", "Auto", "Petrol");
        CarRegistration car5 = new CarRegistration("EFDFGHD", "4", "Manual", "Diesel");
        CarRegistration car6 = new CarRegistration("E234253", "2", "Auto", "Electric");
        CarRegistration car7 = new CarRegistration("GEH4253", "3", "Manual", "Petrol");

        CarRepository TestRepository = new CarRepository("testRepository.json");

        TestRepository.addCar(car1);
        TestRepository.addCar(car2);
        TestRepository.addCar(car3);
        TestRepository.addCar(car4);
        TestRepository.addCar(car5);
        TestRepository.addCar(car6);
        TestRepository.addCar(car7);

        //lager til en json
        Gson gson = new Gson();
        String json = gson.toJson(TestRepository);


        /*skriver til fil
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
            CarRepository testRepository2 = gson.fromJson(br, CarRepository.class);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
