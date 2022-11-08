package com.MFarrelAthaillahNugrohoJSleepMN.controller;

import com.MFarrelAthaillahNugrohoJSleepMN.Algorithm;
import com.MFarrelAthaillahNugrohoJSleepMN.Predicate;
import com.MFarrelAthaillahNugrohoJSleepMN.dbjson.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.regex.*;

@RestController
@RequestMapping("/account")

public class AccountController implements BasicGetController<Account> {
    @JsonAutowired(value = Account.class, filepath = "D:\\Kuliah\\kelas semm 3\\Praktikum OOP\\JSleep\\src\\main\\java\\json\\account.json")
    public final static String REGEX_EMAIL = "^[A-Za-z0-9]+@(.+)$";
    public final static String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    public static JsonTable<Account> accountTable;
    public final static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public final static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);;

    public JsonTable<Account> getJsonTable(){
        return accountTable;
    }
    public List<Account> getPage(int page, int pageSize){
        return null;
    }
    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    )
    {
        final Predicate<Account> emailPred = pred-> pred.email.equals(email);
        Account foundEmail = Algorithm.<Account>find(accountTable, emailPred);
        if (Algorithm.exists(accountTable, foundEmail)) {
            final Predicate<Account> passPred = pred-> pred.password.equals(password);
            Account foundPassword = Algorithm.<Account>find(accountTable, passPred);
            if (Algorithm.exists(accountTable, passPred)){
                return foundPassword;
            } else{
                return null;
            }
        } else{
            return null;
        }
    }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            ) throws IOException {
        Account testRegex = new Account(name, email, password);
        if (name.isBlank() && testRegex.validate()) {
            accountTable.writeJson(testRegex, accountTable.filepath);
            return new Account(name, email, password);
        }else
            return null;
    }

    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(
            @PathVariable int id,
            @RequestParam String username,
            @RequestParam String address,
            @RequestParam String phoneNumber
    )
    {

        return new Renter(username, phoneNumber, address);
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance)
    {
        final Predicate<Account> idFilter = pred -> (id == pred.id);
        if(Algorithm.exists(accountTable, idFilter)){
            Algorithm.find(accountTable, idFilter).balance += balance;
            return true;
        }else
            return false;
    }
}
