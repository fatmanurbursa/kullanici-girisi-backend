package com.fatmabursa.registration;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api")
public class userController {//Kullanıcıyı frontend tarafından gelen verilerle kaydedecek endpointi oluşturuyoruz

    private userService userService;

    public userController(userService userService){
        this.userService=userService;
    }


    //CREATE
    @PostMapping("/register")
    public String register(@RequestBody User user){

        return userService.saveUser(user) +" Kayıt başarılı";
    }

//READ
    @GetMapping("/register")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    //UPDATE

    @PutMapping("/register/{id}")
    public User updateUser(@PathVariable Long id,
                           @RequestBody User user){
        return userService.updateUser(id,user);
    }


    //DELETE

    @DeleteMapping("/register/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
