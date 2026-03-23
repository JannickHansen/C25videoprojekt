package org.example.c25videoproject.service;

import org.springframework.stereotype.Service;

@Service
public class CarService {

    public String getImg(String brand, String colour) {
        String img = null;

        if (brand.contains("Volvo")) {
            img = "blåvolvostationcar.jpg";
        } else if (brand.contains("VW")) {
            if (colour.contains("Grøn")) {
                img = "GrønVWpolo.jpg";
            } else if (colour.contains("Gul")) {
                img = "GulVWBobbel.jpg";
            }
        } else {
            img = "generic.jpg";
        }
        return img;
    }
}
