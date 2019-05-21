/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qaant.udemy.product.bo;

import com.qaant.udemy.product.dto.Product;

/**
 *
 * @author pauli
 */
public interface ProductBO {
        public void create(Product product);
	public Product findProduct(int id);
}
