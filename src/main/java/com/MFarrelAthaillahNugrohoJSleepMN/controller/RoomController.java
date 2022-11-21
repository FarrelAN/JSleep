package com.MFarrelAthaillahNugrohoJSleepMN.controller;

import com.MFarrelAthaillahNugrohoJSleepMN.*;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.*;
import com.MFarrelAthaillahNugrohoJSleepMN.controller.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/room")

public class RoomController implements BasicGetController<Room>{
    @JsonAutowired(value = Room.class, filepath = "D:\\Kuliah\\kelas semm 3\\Praktikum OOP\\JSleep\\src\\main\\java\\com\\MFarrelAthaillahNugrohoJSleepMN\\json\\room.json")

    public static JsonTable<Room> roomTable;
    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }

    @GetMapping("/{id}/renter")
    List<Room> getRoombyRenter(
            @PathVariable int id,
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
    }

    @GetMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam int size,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam int price,
            @RequestParam Facility facility,
            @RequestParam City city
    ){
        Account account = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId);
        if(account == null){
            return null;
        }
        else{
            Room room = new Room(accountId, name, size, new Price(price), facility, city, address);
            //room.id = roomTable.size() + 1;
            room.accountId = accountId;
            room.size = size;
            room.name = name;
            room.address = address;
            //room.price = price;
            room.facility = facility;
            room.city = city;
            roomTable.add(room);
            return room;
        }
    }
}
