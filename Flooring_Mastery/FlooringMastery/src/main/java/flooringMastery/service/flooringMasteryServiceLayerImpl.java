/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.service;

import flooringMastery.controller.flooringMasteryController;
import flooringMastery.dao.flooringMasteryPersistenceException;
import flooringMastery.dao.orderDao;
import flooringMastery.dao.productDao;
import flooringMastery.dao.taxDao;
import flooringMastery.dto.Order;
import flooringMastery.dto.Product;
import flooringMastery.dto.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class flooringMasteryServiceLayerImpl implements flooringMasteryServiceLayer {

    private orderDao orderDao;
    private productDao product;
    private taxDao taxdao;
    private Map< Date, Order> purchases = new HashMap< Date, Order>();
    //flooringMasteryController controller = new flooringMasteryController();

    public flooringMasteryServiceLayerImpl(orderDao orderDao, productDao product, taxDao taxdao) {
        this.orderDao = orderDao;
        this.product = product;
        this.taxdao = taxdao;
        //this.controller = controller;
    }

    flooringMasteryServiceLayerImpl() {
    }

    @Override
    public void save() throws flooringMasteryPersistenceException {
        //orderDao.save( orderedDate, order);
    }

    @Override
    public BigDecimal getMaterialCosts(BigDecimal area, BigDecimal costPerSquareFoot) throws invalidProductTypeException, flooringMasteryPersistenceException {
        BigDecimal xmat = (area).multiply(costPerSquareFoot);
        return xmat;
    }

    @Override
    public BigDecimal getLaborCosts(BigDecimal area, BigDecimal laborCostPerSquareFoot) throws flooringMasteryPersistenceException {
        BigDecimal ylabor = (area).multiply(laborCostPerSquareFoot);
        return ylabor;
    }

    @Override
    public BigDecimal getTax(BigDecimal insertedTax, BigDecimal xmat, BigDecimal ylabor) throws flooringMasteryPersistenceException, invalidStateException {
        BigDecimal taxtotal = ((insertedTax).divide(new BigDecimal(100))).multiply((ylabor.add(xmat)));
        return taxtotal;
    }

    @Override
    public BigDecimal getTotal(BigDecimal taxtotal, BigDecimal ylabor, BigDecimal xmat) throws flooringMasteryPersistenceException {
        BigDecimal totaltotal = (taxtotal).add(xmat.add(ylabor));
        return totaltotal;
    }

    @Override
    public void addOrder(Order order) throws invalidStateException, invalidProductTypeException, flooringMasteryPersistenceException {

        boolean valid = true;

        if (taxdao.getTaxRate(order.getState()) == null) {
            System.out.println("There is no tax rate for that state.");
            valid = false;
        }

        if (product.getProductInfo(order.getProductType()) == null) {
            System.out.println("There is no product.");
            valid = false;
        }

        if (valid) {
            BigDecimal validTax = taxdao.getTaxRate(order.getState());
            order.setTaxRate(validTax);
            Product validProduct = product.getProductInfo(order.getProductType());
            order.setCostPerSquareFoot(validProduct.getCostPerSquareFoot());
            order.setLaborCostPerSquareFoot(validProduct.getLaborCostPerSquareFoot());
            getCalculations(order);
            orderDao.addOrder(order);
        }
    }

    private Order getCalculations(Order order) throws flooringMasteryPersistenceException, invalidProductTypeException, invalidStateException {

        Product insertedProduct = product.getProductInfo(order.getProductType());
        BigDecimal insertedTax = taxdao.getTaxRate(order.getState());

        BigDecimal area = order.getArea();
        BigDecimal costSqFt = order.getCostPerSquareFoot();
        BigDecimal laborSqFt = order.getLaborCostPerSquareFoot();

        BigDecimal calculatedmaterialcosts = getMaterialCosts(area, costSqFt);
        BigDecimal calculatedlaborcosts = getLaborCosts(area, laborSqFt);
        BigDecimal taxtotal = getTax(insertedTax, calculatedmaterialcosts, calculatedlaborcosts);
        BigDecimal totaltotal = getTotal(insertedTax, calculatedlaborcosts, calculatedmaterialcosts);

        order.setMaterialCost(getMaterialCosts(area, costSqFt));
        order.setLaborCost(getLaborCosts(area, laborSqFt));
        order.setTax(getTax(insertedTax, calculatedmaterialcosts, calculatedlaborcosts));
        order.setTotal(getTotal(insertedTax, calculatedlaborcosts, calculatedmaterialcosts));

        return order;
    }

    /*
    public Order getOrder(String date, int orderNumber) throws flooringMasteryPersistenceException {
        boolean valid = true;

        if (date == null) {
            valid = false;
            System.out.println("No orders were made on this date. Make sure you entered the correct date in the right format.");
        }

        if (orderNumber <= 0) {
            valid = false;
            System.out.println("Not a valid entry.");
        }

        if (valid) {
            valid = true;
            Order getorder = orderDao.getOrder(LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy")), orderNumber);
            return getorder;
        }

        return null;
    }
*/

    public HashMap< Integer, Order> getOrders(LocalDate date) {
        return orderDao.getOrders(date);
    }

    
    public void removeOrder(LocalDate date, int orderNumber) throws flooringMasteryPersistenceException {
        boolean valid = true;

        if (date == null) {
            valid = false;
            System.out.println("No orders were made on this date. Make sure you entered the correct date in the right format.");
        }

        if (orderNumber <= 0) {
            valid = false;
            System.out.println("Not a valid entry.");
        }

        if (valid) {
            valid = true;
            orderDao.getOrders(date);
        }

        orderDao.removeOrder(date, orderNumber);
    }

    @Override
    public Order editOrder(Order order) throws flooringMasteryPersistenceException, invalidProductTypeException, invalidStateException {
        Order newCalculatedOrder = getCalculations(order);
        return orderDao.editOrder(newCalculatedOrder);
    }  
}
