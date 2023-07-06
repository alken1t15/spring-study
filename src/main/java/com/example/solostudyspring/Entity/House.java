package com.example.solostudyspring.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "house")
@Getter
@Setter
@NoArgsConstructor
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "house")
    List<User> userList;

    private String name;

    private String address;

    public House(String name, String address) {
        this.name = name;
        this.address = address;
    }
}