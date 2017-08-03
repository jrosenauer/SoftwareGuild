/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author apprentice
 */
public class Order {

    private int orderNumber;
    private LocalDate date;
    private String customerName;
    private String state;
    private BigDecimal taxRate;
    private String productType;
    private BigDecimal area;
    private BigDecimal costPerSquareFoot;
    private BigDecimal laborCostPerSquareFoot;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal tax;
    private BigDecimal total;

    public Order(LocalDate date,
            String customerName,
            String state,
            String productType,
            BigDecimal area,
            BigDecimal cost,
            BigDecimal labor,
            BigDecimal materialCost,
            BigDecimal laborCost,
            BigDecimal tax,
            BigDecimal taxRate,
            BigDecimal total) {
        // replace these with the this.date = date style
        setDate(date);
        setCustomerName(customerName);
        setState(state);
        setTaxRate(taxRate); //taxdaoimpl getTaxRate(state)
        setProductType(productType);
        setArea(area);
        setCostPerSquareFoot(cost); //productdaoimpl getProductInfo(productType)
        setLaborCostPerSquareFoot(labor); //productdaoimpl getProductInfo(productType)
        setMaterialCost(materialCost); //service getMaterialCosts(area, costPerSquareFoot);
        setLaborCost(laborCost); //service getLaborCosts(area, laborCostPerSquareFoot);
        setTax(tax); //service getTax(insertedTax,  calculatedmaterialcost,  calculatedlaborcost);
        setTaxRate(taxRate);
        setTotal(total); //service getTotal( taxtotal,  calculatedlaborcost,  calculatedmaterialcost);
    }
    
    public Order(int orderNumber,
            LocalDate date,
            String customerName,
            String state,
            String productType,
            BigDecimal area,
            BigDecimal cost,
            BigDecimal labor,
            BigDecimal materialCost,
            BigDecimal laborCost,
            BigDecimal tax,
            BigDecimal taxRate,
            BigDecimal total) {
        // replace these with the this.date = date style
        setOrderNumber(orderNumber);
        setDate(date);
        setCustomerName(customerName);
        setState(state);
        setTaxRate(taxRate); //taxdaoimpl getTaxRate(state)
        setProductType(productType);
        setArea(area);
        setCostPerSquareFoot(cost); //productdaoimpl getProductInfo(productType)
        setLaborCostPerSquareFoot(labor); //productdaoimpl getProductInfo(productType)
        setMaterialCost(materialCost); //service getMaterialCosts(area, costPerSquareFoot);
        setLaborCost(laborCost); //service getLaborCosts(area, laborCostPerSquareFoot);
        setTax(tax); //service getTax(insertedTax,  calculatedmaterialcost,  calculatedlaborcost);
        setTaxRate(taxRate);
        setTotal(total); //service getTotal( taxtotal,  calculatedlaborcost,  calculatedmaterialcost);
    }
    

    public Order() {
    }

    public Order(LocalDate date) {
    }

    public Order(LocalDate date,
            String customerName,
            String state,
            String productType,
            BigDecimal area) {
        setDate(date);
        setCustomerName(customerName);
        setState(state);
        setTaxRate(taxRate); //taxdaoimpl getTaxRate(state)
        setProductType(productType);
        setArea(area);
    }


    /**
     * order.getOrderNumber()
     *
     * @return the orderNumber
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber the orderNumber to set
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * @param date the date to order.getOrderNumber()set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the taxRate
     */
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    /**
     * @param taxRate the taxRate to set
     */
    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the area
     */
    public BigDecimal getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(BigDecimal area) {
        this.area = area;
    }

    /**
     * @return the costPerSquareFoot
     */
    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    /**
     * @param costPerSquareFoot the costPerSquareFoot to set
     */
    public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

    /**
     * @return the laborCostPerSquareFoot
     */
    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    /**
     * @param laborCostPerSquareFoot the laborCostPerSquareFoot to set
     */
    public void setLaborCostPerSquareFoot(BigDecimal laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    /**
     * @return the materialCost
     */
    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    /**
     * @param materialCost the materialCost to set
     */
    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    /**
     * @return the laborCost
     */
    public BigDecimal getLaborCost() {
        return laborCost;
    }

    /**
     * @param laborCost the laborCost to set
     */
    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    /**
     * @return the tax
     */
    public BigDecimal getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    /**
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String toString() {
        return orderNumber + " " + date.toString() + " " + customerName + " " + state + " " + productType + " " + area;
    }

}
