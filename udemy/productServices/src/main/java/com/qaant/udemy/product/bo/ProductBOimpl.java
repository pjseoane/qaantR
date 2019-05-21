/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qaant.udemy.product.bo;

import com.qaant.udemy.product.dao.ProductDAO;
import com.qaant.udemy.product.dto.Product;

/**
 *
 * @author pauli
 */
public class ProductBOimpl implements ProductBO{
    
    private ProductDAO dao;

    public ProductDAO getDao() {
        return dao;
    }

    public void setDao(ProductDAO dao) {
        this.dao = dao;
    }

    @Override
    public void create(Product product) {
        dao.create(product);
    }

    @Override
    public Product findProduct(int id) {
        return dao.read(id);    
    }
    
}
