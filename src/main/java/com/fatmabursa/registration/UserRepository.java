package com.fatmabursa.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User>findByUsername(String username);     //kullanıcıyı idsine göre bulabiliriz
}
