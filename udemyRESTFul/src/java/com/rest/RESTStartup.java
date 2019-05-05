/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;
import com.rest.dto.Car;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
/**
 *
 * @author pauli
 */
@ApplicationPath ("reststart")
public class RESTStartup extends Application{
   private static Map<Integer,Car> carDB;
    
    public RESTStartup(){
            carDB=new HashMap<>();
    }

    public static Map<Integer, Car> getCarDB() {
        return carDB;
    }
     
}
