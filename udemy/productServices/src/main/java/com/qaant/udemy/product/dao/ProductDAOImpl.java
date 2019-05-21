/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qaant.udemy.product.dao;

import com.qaant.udemy.product.dto.Product;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pauli
 */
public class ProductDAOImpl implements ProductDAO{
    Map<Integer,Product> products=new HashMap<>();
    @Override
    public void create(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product read(int id) {
        return products.get(id);  
    }

    @Override
    public void update(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
