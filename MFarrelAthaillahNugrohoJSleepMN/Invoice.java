package MFarrelAthaillahNugrohoJSleepMN;
import java.util.Calendar;

/**
 * Ini adalah class Invoice yang merupakan subclass dari Serializable
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 3
 */
public class Invoice extends Serializable
{
    public enum RoomRating
    {
        NONE, BAD, NEUTRAL, GOOD
    }
    
    public enum PaymentStatus
    {
        FAILED, WAITING, SUCCESS
    }
    
    public PaymentStatus status;
    public int renterId;
    public RoomRating rating;
    public int buyerId;
    public Calendar time;
    
    protected Invoice(int id, int buyerId, int renterId)
    {
       super(id);
       this.buyerId = buyerId;
       this.renterId = renterId;
       this.rating = RoomRating.NONE;
       this.status = PaymentStatus.WAITING;
       this.time = Calendar.getInstance();
    }

    public Invoice(int id, Account buyer, Renter renter)
    {
       super(id);
       this.buyerId = buyer.id;
       this.renterId = renter.id;
       this.rating = RoomRating.NONE;
       this.status = PaymentStatus.WAITING;
        this.time = Calendar.getInstance();
    }
    
    public String print()
    {
        return "Invoice Id : " + super.id + "Buyer Id : " + this.buyerId + 
               "\nRenter Id : " + this.renterId + "\nTime : " + this.time + 
               "\nRoom Rating: " + this.rating + "\nPayment Status: " + this.status;
    }
}
