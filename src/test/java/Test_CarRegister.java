import com.google.gson.Gson;
import modules.CarRegistration;
import modules.CarRepository;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_CarRegister {
    @Test
    public void creating_car_without_rented_parameter_is_not_rented_on_default(){
        CarRegistration notRentedCar = new CarRegistration("EG5345", "4", "Manual", "Diesel");
        assertFalse(notRentedCar.isRented());
    }

    @Test
    public void creating_car_and_renting_it_out(){
        CarRegistration rentedCar = new CarRegistration("PG46886", "2", "Auto", "Petrol");
        rentedCar.setRented(true);
        assertTrue(rentedCar.isRented());
    }

    @Test
    public void create_repository_with_cars(){
        CarRepository testRepository = new CarRepository("test_repository.json");
        CarRegistration car1 = new CarRegistration("PG46886", "2", "Auto", "Petrol");
        testRepository.addCar(car1);
        assertTrue(testRepository.getCarArrayList().contains(car1));
    }

    @Test
    public void remove_car_from_repository(){
        CarRepository testRepository = new CarRepository("test_repository.json");
        CarRegistration car1 = new CarRegistration("PG46886", "2", "Auto", "Petrol");
        testRepository.addCar(car1);
        assertTrue(testRepository.getCarArrayList().contains(car1));
        testRepository.removeCar(car1);
        assertFalse(testRepository.getCarArrayList().contains(car1));
    }


    @Test
    public void writing_and_reading_to_json_and_checking_if_still_same_class(){
        CarRepository testRepository = new CarRepository("test_repository.json");
        CarRegistration car1 = new CarRegistration("PG46886", "2", "Auto", "Petrol");
        CarRegistration car2 = new CarRegistration("65GHDG3", "6", "Manual", "Diesel");
        testRepository.addCar(car1);
        testRepository.addCar(car2);

        Gson gson = new Gson();
        String json = gson.toJson(testRepository);
        try {
            FileWriter writer = new FileWriter("test_repository.json");
            writer.write(json);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        CarRepository testRepostory2 = new CarRepository("test_repository2.json");
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("test_repository.json"));
            testRepostory2 = gson.fromJson(br, CarRepository.class);
        } catch (FileNotFoundException e) {
            System.out.println("No save file to read from. Please make sure you're trying to read an existing file.");
        }catch (IOException e) {
            e.printStackTrace();
        }
        assertFalse(testRepostory2.getCarArrayList().isEmpty());
        assertSame(testRepostory2.getCarArrayList().get(0).getClass(), CarRegistration.class);

    }

    @Test
    public void repository_does_not_accept_identical_registration_numbers(){
        CarRepository testRepository = new CarRepository("test_repository.json");
        CarRegistration car1 = new CarRegistration("PG46886", "2", "Auto", "Petrol");
        CarRegistration car2 = new CarRegistration("PG46886", "6", "Manual", "Diesel");
        testRepository.addCar(car1);
        testRepository.addCar(car2);
        assertFalse(testRepository.getCarArrayList().contains(car2));
    }

    @Test
    public void available_list_only_contains_available_cars(){
        CarRepository testRepository = new CarRepository("test_repository.json");
        CarRegistration car1 = new CarRegistration("PG46886", "2", "Auto", "Petrol");
        CarRegistration car2 = new CarRegistration("65GHDG3", "6", "Manual", "Diesel");
        car1.setRented(true);
        testRepository.addCar(car1);
        testRepository.addCar(car2);
        assertFalse(testRepository.getAllAvailableCars().contains(car1));
        assertTrue(testRepository.getAllAvailableCars().contains(car2));
    }

}
