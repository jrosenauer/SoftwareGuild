/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Product;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface Dao {
    
    public List < Product > getAllProducts() ;
     
    public Product getProduct (int id) ;
}
