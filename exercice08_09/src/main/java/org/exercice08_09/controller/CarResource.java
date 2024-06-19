package org.exercice08_09.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.exercice08_09.data.FakeBDD;
import org.exercice08_09.entity.Car;

import java.util.List;

@Path("/cars")
public class CarResource {

    //Exercice08
    @GET
    @Path("/one")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getOneCar() {
        return new Car("Renault", "Clio", "Jaune", 2006);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getAllCars() {

        //Exercice08

//        List<Car> carList = new ArrayList<>();
//        carList.add(new Car("Renault", "Clio", "Jaune", 2006));
//        carList.add(new Car("Peugeot", "306", "Noir", 2012));
//        carList.add(new Car("Nissan", "Supra", "Blanc", 2002));
//        return  carList;

        //Exercice 09
        return FakeBDD.getCarList();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCar(@PathParam("id") int id) {
        return FakeBDD.getCar(id);
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Car addCar(@QueryParam("brand") String brand,@QueryParam("model") String model, @QueryParam("color") String color, @QueryParam("year") int year) {
        return FakeBDD.addCar(brand,model, color, year);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car updateCar(@PathParam("id") int id,@QueryParam("brand") String brand,@QueryParam("model") String model, @QueryParam("color") String color, @QueryParam("year") int year){
        return FakeBDD.updateCar(id, brand, model, color, year);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCar(@PathParam("id") int id) {
        if (FakeBDD.deleteCar(id)) {
            return "Car deleted successfully";
        }else {
            return "Car could not be deleted";
        }
    }

}