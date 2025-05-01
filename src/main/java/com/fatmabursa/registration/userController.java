package com.fatmabursa.registration;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api")
public class userController {//Kullanıcıyı frontend tarafından gelen verilerle kaydedecek endpointi oluşturuyoruz

    private userService userService;

    public userController(userService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        return userService.registerUser(user) +" kayıt başarılı";
    }



}
