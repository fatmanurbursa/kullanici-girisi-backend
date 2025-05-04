package com.fatmabursa.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api")
public class userController {//Kullanıcıyı frontend tarafından gelen verilerle kaydedecek endpointi oluşturuyoruz

    @Autowired
    private UserRepository userRepository;
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



    //login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequestDTO){
        Optional<User> user = userRepository.findByUsername(loginRequestDTO.getUserName());
        if(user.isPresent()){
            if(user.get().getPassword().equals(loginRequestDTO.getPasswrd())){
                return ResponseEntity.ok("Giriş başarılı");
            }else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Şifre yanlış");
            }
        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kullanıcı bulunamadı");
        }
    }




}
