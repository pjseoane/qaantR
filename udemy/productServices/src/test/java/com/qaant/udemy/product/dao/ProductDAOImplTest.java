/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qaant.udemy.product.dao;

import com.qaant.udemy.product.dto.Product;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pauli
 */
public class ProductDAOImplTest {
    
    public ProductDAOImplTest() {
    }

    @Test
    public void testCreate() {
                ProductDAO doo=new ProductDAOImpl();
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone");
		product.setDescription("description");
		product.setPrice(800);
		doo.create(product);
                
                Product result = doo.read(1);
		assertNotNull(result);
		assertEquals("Iphone",result.getName());
    }

    @Test
    public void testRead() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testDelete() {
    }
    
}
