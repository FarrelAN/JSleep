package controller;

import com.MFarrelAthaillahNugrohoJSleepMN.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController
{
    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        return new Account(name, email, password);
    }

    @GetMapping("/{id}")
    String getById(@PathVariable int id) { return "account id " + id + " not found!"; }
}
