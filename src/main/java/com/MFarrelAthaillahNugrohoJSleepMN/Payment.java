package com.MFarrelAthaillahNugrohoJSleepMN;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Ini adalah class Payment
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 6
 */
public class Payment extends Invoice {

    private int roomId;
    public Date from;
    public Date to;



    public Payment(int buyerId, int renterId, int roomId, Date from, Date to) {
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to) {
        super(buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    public int getRoomId() {
        return roomId;
    }

    public static boolean makeBooking(Date from,Date to,Room room){
        if(availability(from, to, room)){
            Calendar start = Calendar.getInstance();
            start.setTime(from);
            Calendar end = Calendar.getInstance();
            end.setTime(to);
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                room.booked.add(date);
            }
            return true;
        }
        return false;
    }

    public static boolean availability(Date from,Date to,Room room){
        Calendar start = Calendar.getInstance();
        start.setTime(from);
        Calendar end = Calendar.getInstance();
        end.setTime(to);
        if(start.after(end) || start.equals(end)){
            return false;
        }
        for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
            if(room.booked.contains(date)){
                return false;
            }
        }
        return true;
    }

    public String getTime(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("'Formatted Date' = dd MMMM yyyy");
        String currTime = SDFormat.format(time.getTime());
        return currTime;
    }

    @Override
    public String print(){
        return "Payment{" +
                "roomId=" + roomId +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

}

