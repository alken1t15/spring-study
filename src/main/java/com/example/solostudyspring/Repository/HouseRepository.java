package com.example.solostudyspring.Repository;

import com.example.solostudyspring.Entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House,Long> {
}
