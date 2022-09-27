package MFarrelAthaillahNugrohoJSleepMN;
/**
 * Ini adalah class Invoice yang merupakan subclass dari Serializable
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 3
 */
public class Invoice extends Serializable {
    // instance variables - replace the example below with your own
    public int buyerId;
    public int renterId;
    public String time;

    public Invoice(int id, int buyerId, int renterId, String time) {
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
    }

    public Invoice(int id, Account buyer, Renter renter, String time) {
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = time;
    }
    
    public String print(){
        String print = "Id : " + super.id +
                       "\nBuyer Id : " + buyerId + 
                       "\nRenter Id : " + renterId +
                       "\ntime : " + time;
        return print;
    }
}
