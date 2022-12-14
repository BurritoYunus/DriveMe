package modules;

import java.io.*;
import java.util.ArrayList;

public class CarRepository {
    private String repositoryName;
    private ArrayList<CarRegistration> carList = new ArrayList<>();

    public CarRepository(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public ArrayList<CarRegistration> getCarArrayList() {
        return carList;
    }

    public String getRepositoryName() {
        return this.repositoryName;
    }

    public void addCar(CarRegistration car) {
        boolean exists = false;
        for (CarRegistration i : carList) {
            if (car.getRegistrationNumber().equals(i.getRegistrationNumber())) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            System.out.println("Adding car " + car.getRegistrationNumber());
            this.carList.add(car);
        } else {
            System.out.println("The car with the registration number: " + car.getRegistrationNumber() + " already exists");
        }
    }

    public void removeCar(CarRegistration car) {
        if (carList.contains(car)) {
            System.out.println("Removed car " + car.getRegistrationNumber());
            carList.remove(car);
        } else {
            System.out.println("Could not find the car with the registration number " + car.getRegistrationNumber() + " in the car database.");
        }
    }

    public ArrayList<CarRegistration> getAllAvailableCars() {
        ArrayList<CarRegistration> allAvailableCars = new ArrayList<>();
        for (CarRegistration i : carList) {
            if (!i.isRented()) {
                allAvailableCars.add(i);
            }
        }
        return allAvailableCars;
    }

    public void writeToJson(String json) {
        try {
            FileWriter writer = new FileWriter(repositoryName);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
