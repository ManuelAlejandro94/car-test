package com.demo.rest.demorest.service;

import com.demo.rest.demorest.model.CarModel;
import com.demo.rest.demorest.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CarModelService {
    @Autowired
    CarRepository carRepository;

    public ArrayList<CarModel> getAllCarModel(){
        return (ArrayList<CarModel>) carRepository.findAll();
    }

    public CarModel saveCar(CarModel carModel){
        return carRepository.insert(carModel);
    }

    public Optional<CarModel> findById(Long id){
        return carRepository.findById(id);
    }

    public Boolean deleteCar(Long id){
        try{
            carRepository.deleteById(id);
            return true;
        }
        catch (Exception exception){
            return false;
        }
    }
}
