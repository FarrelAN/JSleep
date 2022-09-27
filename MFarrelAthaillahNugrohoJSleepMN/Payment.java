package MFarrelAthaillahNugrohoJSleepMN;
/**
 * Ini adalah class Payment
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 3
 */
public class Payment extends Invoice {
    public String to;
    public String from;
    private int roomId;

    public Payment(int id, int buyerId, int renterId, String time, int roomId, 
    String from, String to) {
        super(id, buyerId, renterId, time);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }
    
    public Payment(int id, Account buyer, Renter renter, String time, int roomId, 
    String from, String to) {
        super(id, buyer, renter, time);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }
    
    public String print() {
        String print = "\nBuyer Id : " + buyerId +"\nRenter Id : " + renterId + "\nRoom Id : " + roomId + "\nTime : " + time 
        + "\nFrom : " + from + "\nTo : " + to;
        return print;
    }
    
    public int getRoomId() {
        return this.roomId;
    }
}

