package modules;

public class CarRegistration {
    private int registrationNumber;
    private int seats;
    private String transmissionType;
    private String engineType;
    public CarRegistration(int registrationNumber, int seats, String transmissionType, String engineType){
        this.registrationNumber = registrationNumber;
        this.seats = seats;
        this.transmissionType = transmissionType;
        this.engineType = engineType;
    }


    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
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
        return "Registration Number: " + getRegistrationNumber() + ", Seats: " + getSeats() + ", Transmission: " + getTransmissionType() + ", Engine: " + getEngineType();
    }
}
