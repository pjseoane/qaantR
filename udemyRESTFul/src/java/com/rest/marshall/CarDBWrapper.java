/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.marshall;

import com.rest.dto.Car;
import java.util.HashMap;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pauli
 */

@XmlRootElement
public class CarDBWrapper {
    private HashMap <Integer, Car> cars;

    public HashMap<Integer, Car> getCars() {
        return cars;
    }

    public void setCars(HashMap<Integer, Car> cars) {
        this.cars = cars;
    }
}
