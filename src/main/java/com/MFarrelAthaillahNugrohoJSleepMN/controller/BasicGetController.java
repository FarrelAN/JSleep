package com.MFarrelAthaillahNugrohoJSleepMN.controller;

import com.MFarrelAthaillahNugrohoJSleepMN.Algorithm;
import com.MFarrelAthaillahNugrohoJSleepMN.Predicate;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.JsonTable;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.Serializable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public interface BasicGetController<T extends Serializable>{
    public abstract JsonTable<T> getJsonTable();
    @GetMapping("/{id}")
    public default T getById(
            @PathVariable int id
    )
    {
        T object = (T) Algorithm.<T>find(getJsonTable(), pred->pred.id == id);
        return object;
    }
    @GetMapping ("/page")
    public default List<T> getPage(
            @RequestParam int page,
            @RequestParam int size
    )
    {
        return Algorithm.<T>paginate(getJsonTable(), page, size, pred -> true);
    }
}
