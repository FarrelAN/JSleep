package com.MFarrelAthaillahNugrohoJSleepMN.dbjson;
import com.MFarrelAthaillahNugrohoJSleepMN.BedType;
import com.MFarrelAthaillahNugrohoJSleepMN.City;
import com.MFarrelAthaillahNugrohoJSleepMN.Facility;
import com.MFarrelAthaillahNugrohoJSleepMN.Price;

import java.util.ArrayList;
import java.util.Date;

/**
 * Ini adalah class Room
 * @author M. Farrel Athaillah Nugroho
 * @version Modul 3
 */
public class Room extends Serializable
{
    public Price price;
    public String address;
    public int size;
    public Facility facility;

    public BedType bedType;
    public City city;
    public String name;
    public ArrayList <Date> booked = new ArrayList<Date>();

    public int accountId;
    
    public Room(int accountid, String name, int size, Price price, Facility facility, City city, String address)
    {
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
    }
    public String toString(){
        return "=====Room=====\n" + "\nName : " + name + "\nChecking Price. . . \n" + price +
                "\nFacility : " + facility + "\nCity : " + city + "\nAddress : " + address;
    }

    public Object write(){
        return 0;
    }
    public boolean read(String a){
        return true;
    }

}

