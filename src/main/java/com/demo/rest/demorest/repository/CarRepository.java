package com.demo.rest.demorest.repository;
import com.demo.rest.demorest.model.CarModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<CarModel, Long> {

    @Query("{}")
    List<CarModel> updateCarModel();
}
