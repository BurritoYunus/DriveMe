package modules;

public class CarRegistration {
    private String registrationNumber;
    private String seats;
    private String transmissionType;
    private String engineType;
    private boolean isRented = false;

    public CarRegistration(String registrationNumber, String seats, String transmissionType, String engineType){
        this.registrationNumber = registrationNumber;
        this.seats = seats;
        this.transmissionType = transmissionType;
        this.engineType = engineType;
    }


    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Override
    public String toString() {
        return "Registration Number: " + getRegistrationNumber() + ", Seats: " + getSeats() + ", Transmission: " + getTransmissionType() + ", Engine: " + getEngineType() + ", is rented: " + isRented();
    }
}
