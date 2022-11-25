/*package modules;

import com.google.gson.Gson;
import interfaces.ListFileHandler;

import java.io.*;
import java.util.ArrayList;



public class CarListFileHandler implements ListFileHandler<CarRepository> {

    Gson gson = new Gson();

    @Override
    public void writeListToFile(ArrayList<CarRepository> arrayList, String file) {
        String json = gson.toJson(arrayList);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<CarRepository> readListFromFile(String file) {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(file));
            carRepository = gson.fromJson(br, CarRepository.class);
        } catch (FileNotFoundException e) {
            System.out.println("No save file to read from. It will be made when this application closes.");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/