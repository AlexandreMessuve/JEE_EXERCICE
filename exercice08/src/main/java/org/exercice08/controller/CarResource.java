package org.exercice08.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.exercice08.data.FakeBDD;
import org.exercice08.entity.Car;

import java.util.List;
import java.util.Random;

@Path("/cars")
public class CarResource {

    @GET
    @Path("/one")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCar() {
        return FakeBDD.getOne();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getAllCars() {
        return FakeBDD.getCarList();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Car addCar(@QueryParam("brand") String brand,@QueryParam("model") String model, @QueryParam("color") String color, @QueryParam("year") int price) {
        return FakeBDD.addCar(brand,model, color, price);
    }
}