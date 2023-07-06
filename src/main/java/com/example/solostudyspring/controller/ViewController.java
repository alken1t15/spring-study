package com.example.solostudyspring.controller;

import com.example.solostudyspring.Entity.House;
import com.example.solostudyspring.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/view_page")
public class ViewController {

    @GetMapping(path = "/main_page")
    public String mainPage(Model model){
        String world = "Hello world";
        model.addAttribute("world",world);
        return "main_page";
    }

    @GetMapping(path = "/second_page")
    public String secondPage(Model model){
        List<House> houseList = new ArrayList<>();
        houseList.add(new House("Дружба","Мира 54"));
        houseList.add(new House("Сектор","Кенесары 4"));
        houseList.add(new House("Миро согласие","Жумабаева 23"));
        model.addAttribute("houseList",houseList);
        return "second_page";
    }
}
