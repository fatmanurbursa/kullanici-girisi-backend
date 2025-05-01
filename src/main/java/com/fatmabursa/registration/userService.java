package com.fatmabursa.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class userService { //veritabanına kayıt işlemini yapacağımız servisi yazıyoruz. //

    @Autowired
private UserRepository userRepository;

    public String registerUser(User user){
        userRepository.save(user);
        return "Kayıt başarılı "+user.getUsername();
    }





}
