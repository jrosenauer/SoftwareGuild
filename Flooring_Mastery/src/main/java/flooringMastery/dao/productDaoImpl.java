/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import flooringMastery.dto.Product;
import flooringMastery.service.invalidProductTypeException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class productDaoImpl implements productDao {

    public static final String PRODUCTS = "Products.txt";
    public static final String DELIMITER = ",";

    private Map< String, Product> material = new HashMap<>();

    public productDaoImpl() throws flooringMasteryPersistenceException {
        readFromProductFile();
        for (Map.Entry< String, Product> entry : material.entrySet()) {
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }
    }

    void readFromProductFile() throws flooringMasteryPersistenceException {

        Scanner scanner;

        try {
            scanner = new Scanner(new FileReader(PRODUCTS));
        } catch (FileNotFoundException e) {
            throw new flooringMasteryPersistenceException("Could not load products.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Product currentProduct = new Product();
            currentProduct.setProductType(currentTokens[0]);
            currentProduct.setCostPerSquareFoot(new BigDecimal(currentTokens[1]));
            currentProduct.setLaborCostPerSquareFoot(new BigDecimal(currentTokens[2]));

            material.put(currentProduct.getProductType(), currentProduct);
        }
        scanner.close();
    }

    @Override
    public Product getProductInfo(String productType) {
        return material.get(productType);
    }

    @Override
    public Map<String, Product> getAllItems() throws flooringMasteryPersistenceException {
        return null;
    }

    @Override
    public BigDecimal getCostByProductType(String productType) throws flooringMasteryPersistenceException {
        BigDecimal costPerSquareFoot = new BigDecimal (productType);
        Map< String, Product> material = getAllItems();
        for (int i = 0; i < material.size(); i++) {
            if (productType.equalsIgnoreCase(material.get(i).getProductType())) {
                costPerSquareFoot = material.get(i).getCostPerSquareFoot();
            }
        }
        return costPerSquareFoot;

    }

    @Override
    public BigDecimal getLaborCostByProductType(String productType) throws flooringMasteryPersistenceException {
        BigDecimal laborCostPerSquareFoot = new BigDecimal (productType);
        Map< String, Product> material = getAllItems();
        for (int i = 0; i < material.size(); i++) {
            if (productType.equalsIgnoreCase(material.get(i).getProductType())) {
                laborCostPerSquareFoot = material.get(i).getLaborCostPerSquareFoot();
            }
        }
        return laborCostPerSquareFoot;
    }

   
}
