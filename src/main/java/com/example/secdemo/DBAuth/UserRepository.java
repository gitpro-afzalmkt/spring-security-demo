package com.example.secdemo.DBAuth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    public Optional<User> findByUsername(String username);
    @Query(nativeQuery = true, value = "select role_id from users where username like ?")
    Long findRoleByUsername(String username);
}
