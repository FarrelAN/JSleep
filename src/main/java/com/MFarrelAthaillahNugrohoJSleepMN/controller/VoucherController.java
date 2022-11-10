package com.MFarrelAthaillahNugrohoJSleepMN.controller;

import com.MFarrelAthaillahNugrohoJSleepMN.*;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher>{
    @JsonAutowired(value = Voucher.class, filepath = "D:\\Kuliah\\kelas semm 3\\Praktikum OOP\\JSleep\\src\\main\\java\\json\\voucher.json")

    public JsonTable<Voucher> voucherTable;

    @Override
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }

    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id) {
        if(voucherTable == null) {
            return false;
        }
        return Algorithm.<Voucher>exists(getJsonTable(),pred -> pred.id == id);
    }

    @GetMapping("/{id}/canApply")
    boolean canApply(
            @PathVariable int id,
            @RequestParam double price
    ) {
        Price check = new Price(price);
        for(Voucher voucher : voucherTable) {
            if((voucher.id == id)) {
                return voucher.canApply(check);
            }
        }
        return false;
    }

    @GetMapping("/getAvailable")
    List<Voucher> getAvailable(
            @RequestParam int page,
            @RequestParam int pageSize
    ) {
        if(voucherTable == null) {
            return null;
        }
        return Algorithm.<Voucher>paginate(voucherTable,page,pageSize,pred -> pred.isUsed() == false);
    }
}
