package com.example.solostudyspring.controller;

import com.example.solostudyspring.Entity.House;
import com.example.solostudyspring.Entity.User;
import com.example.solostudyspring.Repository.HouseRepository;
import com.example.solostudyspring.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    HouseRepository houseRepository;

    @GetMapping(path = "/first_resource")
    public  List<User> firstResource(){
        List<User> userList =userRepository.findAll();
        return userList;
    }

    @GetMapping(path = "/second_resource")
    public  List<User> secondResource(){
        Sort sort = Sort.by(
          Sort.Order.asc("age")
        );
        Pageable pageable = PageRequest.of(0,2,sort);

        Page<User> userPage = userRepository.findAll(pageable);
        List<User> userList = userPage.toList();
        return userList;
    }

    @GetMapping(path = "/third_resource")
    public  List<String> thirdResource(){
        Sort sort = Sort.by(
                Sort.Order.asc("age")
        );
        Pageable pageable = PageRequest.of(0,3);
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.stream().toList().stream().map(user -> user.getFio() + " Возраст: " + user.getAge()).toList();
    }

    @GetMapping(path = "/fourth_resource")
    public  List<String> fourthResource(@RequestParam int from) throws Exception{
        Pageable pageable = PageRequest.of(from,3);
        if (from==1){
            throw new Exception();
        }
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.stream().toList().stream().map(user -> user.getFio() + " Возраст: " + user.getAge()).toList();
    }


    @ExceptionHandler(Exception.class)
    public void exceptionHandler(){
        System.out.println("Была допущена ошибка");
    }

    @GetMapping(path = "/add_house")
    public void addHouse(){
        House house = new House();
        house.setName("BiGroup строй");
        house.setAddress("Тащенова 32");
        houseRepository.save(house);
    }

    @GetMapping(path = "/update_house")
    public void updateHouse(@RequestParam long id, @RequestParam String name){
        House house = houseRepository.findById(id).orElseThrow();
        house.setName(name);
        houseRepository.save(house);
    }

    @GetMapping(path = "/get_user")
    public void getUser(@RequestParam long id, @RequestParam String name){
        User user = userRepository.getUseByTop(id);
        System.out.println(user);
    }

    @GetMapping(path = "/update_user")
    public void updateUser(@RequestParam long id, @RequestParam String name){
        userRepository.updateUserByName(id,name);
    }
}