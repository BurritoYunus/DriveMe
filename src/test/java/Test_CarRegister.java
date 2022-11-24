import modules.CarRegistration;
import org.junit.jupiter.api.Test;
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
}
