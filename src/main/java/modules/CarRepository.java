package modules;

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

    public void setCarArrayList(ArrayList<CarRegistration> carArrayList) {
        this.carList = carArrayList;
    }

    public void addCar(CarRegistration car){
        boolean exists = false;
        for (CarRegistration i : carList){
            if (car.getRegistrationNumber().equals(i.getRegistrationNumber())){
                exists = true;
                break;
            }
        }
        if (!exists){
            System.out.println("Adding car " + car.getRegistrationNumber());
            this.carList.add(car);
        }
        else{
            System.out.println("Car " + car.getRegistrationNumber() + " Already exists");
        }
    }

    public void removeCar(CarRegistration car){
        if (carList.contains(car)){
            System.out.println("Removed car " + car.getRegistrationNumber());
            carList.remove(car);
        }
        else{
            System.out.println("Could not find car " + car.getRegistrationNumber() + " in CarArrayList");
        }
    }

}
