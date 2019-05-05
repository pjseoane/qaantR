/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.resources;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
/**
 *
 * @author pauli
 */
@Path("resttest")
public class testREST {
    
    @GET
    @Produces ("text/html")
    public String test(){
        return "<html><body><h1> Test succesful </h1></body></html>";
    }
    
}
