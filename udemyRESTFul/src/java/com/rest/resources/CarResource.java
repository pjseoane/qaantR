/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.resources;


import com.rest.RESTStartup;
import com.rest.dto.Car;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
/**
 *
 * @author pauli
 */
@Path ("car")
public class CarResource {
    
    private Map<Integer,Car> carDB =new HashMap<>();
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addCar(@FormParam("licenceplate")String licencePlate,
                            @FormParam("color")String color){
        
        Map<Integer, Car> db =carDB;
        
        Double id = Math.random()*10000+1;
        Car car =new Car(licencePlate,color);
        db.put(id.intValue(), car);
        return Response.ok(db.get(id.intValue())).build();
       
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response getCars(){
        return Response.ok(carDB).build();
    }
    
    @PUT
    @Path("{carId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
 
    public Response updateCar(MultivaluedMap<String,String>formParams,
            @PathParam("carId") Integer carId){
        
        Map<Integer, Car> db =carDB;
        boolean carExists =db.containsKey(carId);
        
        if(!carExists){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"message\": \"Car id not found\"}")
                    .build();
        }
       
        String licenceplate = formParams.getFirst("licenceplate");
        String color = formParams.getFirst("color");
        
        Car car= db.get(carId);
        
        if(color != null)
            car.setColor(color);
        
        if(licenceplate!= null)
            car.setLicenceplate(licenceplate);
        
        db.replace(carId, car);
        
        return Response.ok(car).build();
    }
    
    @DELETE
    @Path("{carId}")
    
     public Response deleteCar (@PathParam("carId") Integer carId){
        
        Map<Integer, Car> db =carDB;
        boolean carExists =db.containsKey(carId);
        
        if(!carExists){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"message\": \"Car id not found\"}")
                    .build();
        }
        
        db.remove(carId);
            return Response.status(Response.Status.OK)
                    .entity("{\"message\": \"Car deleted.\"}")
                    .build();
        
        
     }
    
}
