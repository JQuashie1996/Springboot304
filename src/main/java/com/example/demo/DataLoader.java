package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CarRepo carRepo;

    @Override
    public void run(String... strings) throws Exception{
        Car car = new Car(1990, "Chevy", "Impala");
        carRepo.save(car);

        car = new Car(1800, "Ford", "One");
        carRepo.save(car);

        car = new Car(2019, "Ducatti", "500");
        carRepo.save(car);
    }
}
