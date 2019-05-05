/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author pauli
 */

@Path("headerinformation")
public class HeaderResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHeaders(@Context HttpHeaders headers){
        return Response.ok(headers.getRequestHeaders()).build();
       
        
    }
    
}
