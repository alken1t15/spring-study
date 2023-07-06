package com.example.solostudyspring.Repository;

import com.example.solostudyspring.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.id = ?1")
    User getUseByTop(long id);

    @Modifying
    @Transactional
    @Query("update User u set u.email  = ?2 where u.id = ?1")
    void updateUserByName(long id,String email);
}