package org.example.c25videoproject.controller;

import org.example.c25videoproject.model.Car;
import org.example.c25videoproject.repository.CarRepository;
import org.example.c25videoproject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    @Autowired
    CarRepository carRepo;
    @Autowired
    CarService carService;


    @GetMapping("/showCar")
    public String showCar(@RequestParam("id") int id, Model model) {
        Car car = carRepo.getCarById(id);
        if (car == null) {return "ServerErrorPage";}
        model.addAttribute("car", car);
        return "showCar";
    }

    @PostMapping("deleteCar")
    public String deleteCar(@RequestParam("id") int id) {
        carRepo.delete(id);
        return "redirect:/";
    }

    @PostMapping("/saveCreateCar")
    public String postCreateCar(@RequestParam("brand") String brand,
                                @RequestParam("modelyear") int modelyear,
                                @RequestParam("type") String type,
                                @RequestParam("colour") String colour,
                                @RequestParam("licenseplate") String licenseplate) {

        String img = carService.getImg(brand, colour);

        Car car = new Car(brand, modelyear, type, colour, licenseplate, img);
        carRepo.save(car);

        return "redirect:/";
    }

    @GetMapping("/createCar")
    public String getCreateCar() {
        return "createCar";
    }
}













