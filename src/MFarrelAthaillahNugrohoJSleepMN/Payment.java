package MFarrelAthaillahNugrohoJSleepMN;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Ini adalah class Payment
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 3
 */
public class Payment extends Invoice {
    public Date to;
    public Date from;
    private int roomId;

    public Payment(int id, int buyerId, int renterId, int roomId, Date from, Date to) {
        super(id, buyerId, renterId);
        this.from = from;
        this.to = to;
        this.roomId = roomId;
    }
    
    public Payment(int id, Account buyer, Renter renter, int roomId, Date from, Date to) {
        super(id, buyer, renter);
        this.from = from;
        this.to = to;
        this.roomId = roomId;
    }
    
    public static boolean availability(Date from, Date to, Room room){
        for(Object booked : room.booked){
            if(from.equals(booked) == true || to.equals(booked) == true){
                return false;
            }
        }
        return true;
    }
    
    
    public static boolean makeBooking(Date from, Date to, Room room){
        if(to.before(from) == true){
            return false;
        }
        if(availability(from, to, room) == true){
            room.booked.add(from);
            room.booked.add(to);
            return true;
        }else
            return false;
    }
    
    public String print() {
        String print = "\nPayment Id : " + super.id + "\nBuyer Id : " + this.buyerId +  
        "\nRenter Id : " + this.renterId + "\nRoom Id : " + this.roomId + 
        "\nTime : " + this.time + "\nFrom : " + this.from + "\nTo : " + this.to;
        return print;
    }
    
    public int getRoomId() {
        return this.roomId;
    }
    
    /*public String getDuration() {
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMMM yyyy");
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        String from_date = SDFormat.format(from.getTime());
        to.add(Calendar.DATE, 2);
        String to_date = SDFormat.format(to.getTime());
        return from_date + "-" + to_date;
        
    }*/
    
    public String getTime(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("'Formatted Date = 'dd MMMMM yyyy");
        String curr_date = SDFormat.format(this.from.getTime());
        return curr_date;
    }
}

