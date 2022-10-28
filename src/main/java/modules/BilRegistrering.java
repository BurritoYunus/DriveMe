package modules;

public class BilRegistrering {
    private int ID;
    private String bilMerke;
    private static int bilTeller;

    public BilRegistrering(int id, String bilMerke){
        this.ID = 100 + ++bilTeller;
        this.bilMerke = bilMerke;
    }

}
