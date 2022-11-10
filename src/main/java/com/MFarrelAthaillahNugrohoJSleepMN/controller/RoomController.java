package com.MFarrelAthaillahNugrohoJSleepMN.controller;

import com.MFarrelAthaillahNugrohoJSleepMN.*;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {

    @JsonAutowired(value = Payment.class, filepath = "D:\\Kuliah\\kelas semm 3\\Praktikum OOP\\JSleep\\src\\main\\java\\json\\room.json")
    public static JsonTable<Room> roomTable;
    @Override
    public JsonTable<Room> getJsonTable(){
        return roomTable;
    }

    @GetMapping("{id}/renter")
    List<Room> getRoomByRenter(
            @PathVariable int id,
            @RequestParam int page,
            @RequestParam int pageSize
    ) {
        final Predicate<Room> ID = pred -> (id == pred.accountId);
        return Algorithm.paginate(roomTable, page, pageSize, ID);
    }

    @PostMapping("/create")
    Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam Price price,
            @RequestParam Facility facility,
            @RequestParam City city,
            @RequestParam String address
    ) {
        Room room = new Room(accountId, name, size, price, facility, city, address);
        final Predicate<Account> idFilter = pred -> (accountId == pred.id);
        if(Algorithm.exists(AccountController.accountTable, idFilter)) {
            if(Algorithm.find(AccountController.accountTable, idFilter).renter != null) {
                try {
                    roomTable.add(room);
                    roomTable.writeJson(roomTable, roomTable.filepath);
                }catch(Throwable t) {
                    t.printStackTrace();
                }
                return room;
            } else {
                return null;
            }
        }else {
            return null;
        }
    }

}
