/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.marshall;

import com.rest.dto.Car;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author pauli
 */
public class HashMapWriter implements MessageBodyWriter<HashMap<Integer,Car>>{

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return genericType.equals(HashMap.class );
    }

    @Override
    public void writeTo(HashMap<Integer, Car> t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        try {
            JAXBContext context= JAXBContext.newInstance(CarDBWrapper.class);
            Marshaller marshaller= context.createMarshaller();
            CarDBWrapper wrapper = new CarDBWrapper();
            wrapper.setCars(t);
            marshaller.marshal(wrapper, entityStream);
        
            
        }catch(JAXBException e){
            throw new RuntimeException(e);}    
    }
    
}
