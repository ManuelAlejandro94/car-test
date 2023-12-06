package com.demo.rest.demorest.controller;

import com.demo.rest.demorest.model.CarModel;
import com.demo.rest.demorest.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "/car")
public class CarModelController {
    @Autowired
    CarModelService carModelService;

    @GetMapping()
    public ArrayList<CarModel> getCars(){
        ArrayList<CarModel> carModels = this.carModelService.getAllCarModel();
        return carModels;
    }

    @PostMapping()
    public CarModel saveCar(@RequestBody CarModel carModel){
        CarModel carModel1 = carModelService.saveCar(carModel);
        return carModel;
    }

    @GetMapping(path = "/{id}")
    public Optional<CarModel> getCarById(@PathVariable("id") Long id){
        return this.carModelService.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCar(@PathVariable("id") Long id){
        Boolean answer = this.carModelService.deleteCar(id);
        if(answer){
            return "Delete OK";
        }
        else{
            return "Failed id: " + id;
        }
    }

}
