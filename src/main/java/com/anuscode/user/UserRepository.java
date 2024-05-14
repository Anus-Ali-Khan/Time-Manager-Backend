package com.anuscode.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  //Checking user exist or not
    @Query("SELECT s FROM User s WHERE s.title = ?1")
    Optional<User> findUserByTitle(String title);
}
