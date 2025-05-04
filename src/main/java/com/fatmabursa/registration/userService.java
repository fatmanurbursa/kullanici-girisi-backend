package com.fatmabursa.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class userService { //veritabanına kayıt işlemini yapacağımız servisi yazıyoruz. //

    @Autowired
private UserRepository userRepository;


    //CREATE

    public User saveUser(User user){
        return userRepository.save(user);
    }

    //READ

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    //UPDATE

    public User updateUser(Long id, User newUserData){
        return userRepository.findById(id).map(user->{
            user.setUsername(newUserData.getUsername());
            user.setPassword(newUserData.getPassword());
            return userRepository.save(user);
        }).orElseThrow(()->new RuntimeException("User not found"));
    }


    ///DELETE

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }









}
