/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qaant.udemy.product.dao;

import com.qaant.udemy.product.dto.Product;

/**
 *
 * @author pauli
 */
public interface ProductDAO {
    void create(Product product);
    Product read(int id);
    void update(Product product);
    void delete(int id);
}
