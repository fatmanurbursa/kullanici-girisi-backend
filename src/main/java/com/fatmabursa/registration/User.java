package com.fatmabursa.registration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="kullancılar")
public class User { //veri tabanında tutacağımız kullanıcı bilgilerini temsil edcek
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;


    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
