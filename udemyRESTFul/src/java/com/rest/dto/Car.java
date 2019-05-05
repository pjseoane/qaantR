/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.dto;

/**
 *
 * @author pauli
 */
public class Car {
    private String licenceplate;
    private String color;

    public Car() {
            
    }
    public Car(String licenceplate, String color) {
        this.licenceplate = licenceplate;
        this.color = color;
    }

    public String getLicenceplate() {
        return licenceplate;
    }

    public void setLicenceplate(String licenceplate) {
        this.licenceplate = licenceplate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
