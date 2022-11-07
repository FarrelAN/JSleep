package com.MFarrelAthaillahNugrohoJSleepMN;
import java.util.Calendar;
import java.util.Date;

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
    public Date time;
    Date now = new Date();
    
    protected Invoice(int buyerId, int renterId)
    {
       this.buyerId = buyerId;
       this.renterId = renterId;
       this.rating = RoomRating.NONE;
       this.status = PaymentStatus.WAITING;
       this.time = now;
    }

    public Invoice(Account buyer, Renter renter)
    {
       this.buyerId = buyer.id;
       this.renterId = renter.id;
       this.rating = RoomRating.NONE;
       this.status = PaymentStatus.WAITING;
       this.time = time;
    }
    
    public String print()
    {
        return "Invoice Id : " + super.id + "Buyer Id : " + buyerId + 
               "\nRenter Id : " + renterId + "\nTime : " + time + 
               "\nRoom Rating: " + rating + "\nPayment Status: " + status;
    }
}
