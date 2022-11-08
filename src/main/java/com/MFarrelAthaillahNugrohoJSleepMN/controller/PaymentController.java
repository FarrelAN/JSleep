package com.MFarrelAthaillahNugrohoJSleepMN.controller;

import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.JsonAutowired;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.JsonTable;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.Payment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class, filepath = "D:\\Kuliah\\kelas semm 3\\Praktikum OOP\\JSleep\\src\\main\\java\\json")
    public JsonTable<Payment> paymentTable;

    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ){
        return null;
    }
    @PostMapping("/{id}/accept")
    public boolean accept(@RequestParam int id){
        return false;
    }

    @PostMapping("/{id}/cancel")
    public  boolean cancel(@RequestParam int id){
        return false;
    }
}
