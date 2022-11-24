import modules.CarRegistration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_CarRegister {
    @Test
    public void creating_car_without_rented_parameter(){
        CarRegistration notRentedCar = new CarRegistration("EG5345", "4", "Manual", "Diesel");
        assertFalse(notRentedCar.isRented());
    }
}
