package com.example.solostudyspring.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fio;

    private Integer age;

    private String phone;

    private String email;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_house")
    private House house;
}