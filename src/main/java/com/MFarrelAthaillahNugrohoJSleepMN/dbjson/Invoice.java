package com.MFarrelAthaillahNugrohoJSleepMN.dbjson;

/**
 * Ini adalah class Invoice
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 7
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

    
    protected Invoice(int buyerId, int renterId)
    {
       this.buyerId = buyerId;
       this.renterId = renterId;
       this.rating = RoomRating.NONE;
       this.status = PaymentStatus.WAITING;
    }

    public Invoice(Account buyer, Renter renter)
    {
       this.buyerId = buyer.id;
       this.renterId = renter.id;
       this.rating = RoomRating.NONE;
       this.status = PaymentStatus.WAITING;
    }
    
    public String print()
    {
        return "Invoice Id : " + super.id + "Buyer Id : " + buyerId + 
               "\nRenter Id : " + renterId + "\nRoom Rating: " + rating +
                "\nPayment Status: " + status;
    }
}
