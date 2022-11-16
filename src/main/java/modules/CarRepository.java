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

}
