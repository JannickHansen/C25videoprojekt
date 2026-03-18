package org.example.c25videoproject.controller;

import org.example.c25videoproject.config.InitData;
import org.example.c25videoproject.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class PageController {

    @Autowired
    InitData initData;

    @GetMapping("/")
    public String mainPage(Model model) {

        ArrayList<Car> carList = new ArrayList<>();
        carList.addAll(initData.getCarList());
        model.addAttribute("carList", carList);

        return "index";
    }
}
