/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class DaoInMemImpl implements Dao {

    private Map< Integer, Product> productMap = new HashMap();

    public DaoInMemImpl() {
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Snickers");
        product1.setPrice(new BigDecimal("1.85"));
        product1.setQuantity(9);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("M&M's");
        product2.setPrice(new BigDecimal("1.50"));
        product2.setQuantity(2);

        Product product3 = new Product();
        product3.setId(3);
        product3.setName("Pringles");
        product3.setPrice(new BigDecimal("2.10"));
        product3.setQuantity(5);

        Product product4 = new Product();
        product4.setId(4);
        product4.setName("Reese's");
        product4.setPrice(new BigDecimal("1.85"));
        product4.setQuantity(4);

        Product product5 = new Product();
        product5.setId(5);
        product5.setName("Pretzels");
        product5.setPrice(new BigDecimal("1.25"));
        product5.setQuantity(9);

        Product product6 = new Product();
        product6.setId(6);
        product6.setName("Twinkies");
        product6.setPrice(new BigDecimal("1.95"));
        product6.setQuantity(3);

        Product product7 = new Product();
        product7.setId(7);
        product7.setName("Doritos");
        product7.setPrice(new BigDecimal("1.75"));
        product7.setQuantity(11);

        Product product8 = new Product();
        product8.setId(8);
        product8.setName("Almond Joy");
        product8.setPrice(new BigDecimal("1.75"));
        product8.setQuantity(1);

        Product product9 = new Product();
        product9.setId(9);
        product9.setName("Trident");
        product9.setPrice(new BigDecimal("1.95"));
        product9.setQuantity(6);

        productMap.put(product1.getId(), product1);
        productMap.put(product2.getId(), product2);
        productMap.put(product3.getId(), product3);
        productMap.put(product4.getId(), product4);
        productMap.put(product5.getId(), product5);
        productMap.put(product6.getId(), product6);
        productMap.put(product7.getId(), product7);
        productMap.put(product8.getId(), product8);
        productMap.put(product9.getId(), product9);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<Product>(productMap.values());
    }

    @Override
    public Product getProduct(int id) {
        return productMap.get(id);
    }
}
