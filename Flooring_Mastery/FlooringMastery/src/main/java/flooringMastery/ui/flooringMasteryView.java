/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.ui;

import flooringMastery.dto.Order;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class flooringMasteryView {

    LocalDate date;

    private flooringMasteryIO io;

    public flooringMasteryView(flooringMasteryIO io) {
        this.io = io;
    }

    public flooringMasteryView() {
    }

    public int printMenuAndGetSelection() {
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print("*  <<Flooring Program>>");
        io.print("* 1. Display Orders");
        io.print("* 2. Add an Order");
        io.print("* 3. Edit an Order");
        io.print("* 4. Remove an Order");
        io.print("* 5. Save Current Work");
        io.print("* 6. Quit");
        io.print("*");
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

        return io.readInt("Please select from the" + " above choices.", 1, 6);
    }

    public Order getNewOrderInfo() {
        String customerName = io.readString("Please enter the customer's name. ");
        String state = io.readString("Please enter the state ");
        String productType = io.readString("What type of product? ");
        String requestedarea = io.readString("Please provide the area amount. ");
        BigDecimal areadecimal = (new BigDecimal(requestedarea));
        Order currentOrder = new Order(LocalDate.now(), customerName, state, productType, areadecimal);
        return currentOrder;
    }

    public void displayAddOrderBanner() {
        io.print("=== Add Order ===");
    }

    public void displayAddSuccessBanner() {
        io.readString("Order successfully added.  Please hit enter to continue");
    }

    public void displayRemoveOrderBanner() {
        io.print("=== Remove Order ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Order successfully removed. Please hit enter to continue.");
    }

    public LocalDate getDateChoice() {
        //DateFormat format = new SimpleDateFormat("MMddyyyy");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMddyyyy");
        LocalDate date = LocalDate.parse(io.readString("Please enter the order date in the format MMddyyyy."), format);
        return date;
    }

    public void displaySearchBanner() {
        io.print("=== Search for Order(s) ===");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command");
    }

    public void displayExitBanner() {
        io.readString("Goodbye");
    }

    /*
    public String getDateToSearch() {
        String date = io.readString("Please provide a date in the format MM/dd/yyyy.");
        return date;
    }
     */
    public void displayOrderList(Map<String, Order> orders) {
        io.print(" === Here is a list of all orders on file ===");
        //something here
    }

    public void displayOrdersBanner() {
        io.print("=== Display Orders ===");
    }

    public boolean confirmOrder(String prompt) {
        String confirmInput = io.readString(prompt);

        if (confirmInput.equalsIgnoreCase("Y")) {
            io.readString("Sounds good. Please hit enter to continue.");
        } else {
            return false;
        }
        return false;
    }

    public void displayOrders(HashMap< Integer, Order> enteredOrders) {
        enteredOrders.forEach((key, value) -> {
            System.out.println(value);
            //System.out.println(orders.getKey() + "/" + orders.getValue());
            // Order order = orders.getValue();
            Order order = value;
            io.print("Order Number: " + order.getOrderNumber()
                    + "\nName:" + order.getCustomerName()
                    + "\nState:" + order.getState()
                    + "\nTax Rate" + order.getTaxRate() + "%"
                    + "\nProduct Type" + order.getProductType()
                    + "\nArea" + order.getArea()
                    + "\nMaterial Cost: $" + order.getCostPerSquareFoot() + "/ft^2"
                    + "\nLabor Cost: $" + order.getLaborCostPerSquareFoot() + "/ft^2"
                    + "\nMateria();l Cost: $" + order.getMaterialCost()
                    + "\nLabor Cost" + order.getLaborCost()
                    + "\nTax: $" + order.getTax()
                    + "\nTotal: $" + order.getTotal());
        });
        io.readString("\nPlease hit enter to continue.");

    }

    public int getOrderNumber() {
        int orderNumber = io.readInt("Order Number:");
        return orderNumber;
    }

    public void displayEditOrderBanner() {
        io.print("=== EDIT ORDER ===");
    }

    public String makeChange(String currentInfo, String infoField) {

        io.print("Current " + infoField + ": " + currentInfo);
        String input = io.readString(infoField);
        if (input.length() < 1) {
            return currentInfo;
        } else {
            return input;

        }
    }

    public Order editOrder(Order orderToEdit) {
        //String date = makeChange(orderToEdit.getDate().format(DateTimeFormatter.ofPattern("MMddyyyy")), "Date");
        //int orderNumber = Integer.parseInt(makeChange(Integer.toString(orderToEdit.getOrderNumber()), "Order Number"));
        String customerName = makeChange(orderToEdit.getCustomerName(), "Customer Name: ");
        String state = makeChange(orderToEdit.getState(), "State: ");
        String productType = makeChange(orderToEdit.getProductType(), "Product Type: ");
        BigDecimal area = new BigDecimal(makeChange(orderToEdit.getArea().toString(), "Area: "));
      
        orderToEdit.setCustomerName(customerName);
        orderToEdit.setState(state);
        orderToEdit.setProductType(productType);
        orderToEdit.setArea(area);

        return orderToEdit;
    }
}
