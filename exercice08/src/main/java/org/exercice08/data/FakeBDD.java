package org.exercice08.data;

import org.exercice08.entity.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FakeBDD {
    public static List<Car> carList = new ArrayList<>();

    public static Car addCar(String brand, String model, String color, int year) {
        Car car = new Car(brand, model, color, year);
        carList.add(car);
        return car;
    }
    public static List<Car> getCarList() {
        if (carList.isEmpty()) {
            return new ArrayList<>();
        }
        return carList;
    }
    public static Car getOne() {
        Random random = new Random();
        if (carList.isEmpty()) {
            return null;
        }
        return carList.get(random.nextInt(carList.size()));
    }
}
