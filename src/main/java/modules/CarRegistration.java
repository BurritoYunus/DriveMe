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

}
