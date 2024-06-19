package org.exercice08_09.data;

import org.exercice08_09.entity.Car;

import java.util.ArrayList;
import java.util.List;

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
    public static Car getCar(int id) {
        if (carList.isEmpty()) {
            return null;
        }
        return carList.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
    }
    public static Car updateCar(int id, String brand, String model, String color, int year) {
        Car car = getCar(id);
        if (car != null) {
            car.setBrand(brand);
            car.setModel(model);
            car.setColor(color);
            car.setYear(year);
            carList.set(carList.indexOf(car), car);
        }
        return car;
    }
    public static boolean deleteCar(int id) {
        boolean result = false;
        Car car = getCar(id);
        if (car != null) {
            if (carList.remove(car)) {
                result = true;
            }
        }
        return result;
    }
}
