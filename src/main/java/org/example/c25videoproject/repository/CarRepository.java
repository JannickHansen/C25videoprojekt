package org.example.c25videoproject.repository;

import org.example.c25videoproject.config.InitData;
import org.example.c25videoproject.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class CarRepository {

    @Autowired
    InitData initData;

    public Car getCarById(int id) {
        ArrayList<Car> carList = initData.getCarList();
        for (Car car : carList) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    public void save(Car car) {
        int id;

        if (initData.getCarList().isEmpty()) {
            id = 1;
        } else {
            id = initData.getCarList().getLast().getId() + 1;
        }
        car.setId(id);

        initData.getCarList().add(car);
    }

    public void delete(int id) {
        Car car = getCarById(id);
        initData.getCarList().remove(car);
    }
}
