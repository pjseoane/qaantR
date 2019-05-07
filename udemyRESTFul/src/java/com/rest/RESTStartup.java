/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;
import com.rest.dto.Car;
import com.rest.marshall.HashMapWriter;
import com.rest.resources.CarResource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
/**
 *
 * @author pauli
 */
@ApplicationPath ("reststart")
public class RESTStartup extends Application{
   //private static Map<Integer,Car> carDB;
    
   /*
   @Override
   public Set<Class<?>> getClasses(){
       return super.getClasses();
   }
   */
   
   @Override
   public Set<Object> getSingletons(){
       
       Set<Object> singletons= new HashSet<>();
       singletons.add(new CarResource());
       return singletons;
   } 
   @Override
   public Set<Class<?>> getClasses(){
       Set set =new HashSet();
       set.add(HashMapWriter.class);
       return set;
   }
   
   
   /*
   @Override
   public Map<String,Object> getProperties(){
       return super.getProperties();
   }
   */
   
    public RESTStartup(){
//            carDB=new HashMap<>();
    }

    /*
    public static Map<Integer, Car> getCarDB() {
        return carDB;
    }
     */
}
