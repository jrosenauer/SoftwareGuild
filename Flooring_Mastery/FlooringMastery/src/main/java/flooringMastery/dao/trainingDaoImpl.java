/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import flooringMastery.dto.Order;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class trainingDaoImpl implements trainingDao {

    private Map<LocalDate, HashMap<Integer, Order>> orders = new HashMap<>();
    public static final String Order_List = "DateToFile.txt";
    public static final String DELIMITER = ",";
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMddyyyy");
    private Integer orderNumber = 0;

    public trainingDaoImpl() {
    }

    public String DateToFile(LocalDate date) {
        Set<String> dates = new HashSet<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        return "Orders_" + date.format(formatter) + ".txt";
    }

    public Order addOrder(Order order) throws flooringMasteryPersistenceException {
        int orderNumber = getLargestOrderNumber();

        order.setOrderNumber(orderNumber);
        LocalDate enteredDate = order.getDate();
        if (!orders.containsKey(enteredDate)) {
            HashMap< Integer, Order> enteredOrders = new HashMap<>();
            enteredOrders.put(orderNumber, order);
            orders.put(enteredDate, enteredOrders);
        } else {
            HashMap< Integer, Order> enteredOrders = orders.get(enteredDate);
            enteredOrders.put(orderNumber, order);
        }

        save(enteredDate, order);

        return order;
    }

    public Order removeOrder(LocalDate date, int orderNumber) throws flooringMasteryPersistenceException {
        HashMap< Integer, Order> ords = getOrders(date);
        ords.remove(orderNumber);
//orders.remove(date, orderNumber);
        orders.put(date, ords);
        writeToOrder(date, ords);
        return null;
    }

    public Order editOrder(Order enteredOrders) throws flooringMasteryPersistenceException {
        LocalDate date = enteredOrders.getDate();
        HashMap< Integer, Order> ords = getOrders(date);
//        Order order = enteredOrders.get(orderNumber);
//        for (Order o : enteredOrders) {
//            if (o.getOrderNumber() == orderNumber) {
//                enteredOrders.remove(o);
//                enteredOrders.add(enteredOrder);

        int orderNumber = enteredOrders.getOrderNumber();
        ords.put(orderNumber, enteredOrders);
        writeToOrder(date, ords);

        return null;
    }

    public void save(LocalDate date, Order order) throws flooringMasteryPersistenceException {
        //writeToOrder(date, order);
    }

    public HashMap<Integer, Order> getOrders(LocalDate date) {
        // create order HashMap to hold the orders
        HashMap<Integer, Order> orders = new HashMap<>();

        // get the correct file name for the orders
        String dateString = date.toString();
        String[] dateInfo = dateString.split("-");

        // get year
        String year = dateInfo[0];
        // get month
        String month = dateInfo[1];
        // get day
        String day = dateInfo[2];

        String fileName = "Orders_" + month + day + year + ".txt";

        // parse the orders from the file structure
        try {
            File f = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(f));

            String line = "";

            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                //Order order = new Order();
                //5,2017-06-18,name,OH,6.25,Tile,200,3.50,4.15,700.00,830.00,95.625000,1536.25
                String[] orderInfo = line.split(DELIMITER);
                int orderNumber = Integer.parseInt(orderInfo[0]);
                String name = orderInfo[2];
                String state = orderInfo[3];
                BigDecimal taxRate = new BigDecimal(orderInfo[4]);

                String product = orderInfo[5];
                BigDecimal area = new BigDecimal(orderInfo[6]);
                BigDecimal materialCost = new BigDecimal(orderInfo[9]);
                BigDecimal laborCost = new BigDecimal(orderInfo[10]);
                BigDecimal labor = new BigDecimal(orderInfo[7]);
                BigDecimal cost = new BigDecimal(orderInfo[8]);
                BigDecimal tax = new BigDecimal(orderInfo[11]);
                BigDecimal total = new BigDecimal(orderInfo[12]);

                //create order and add to orders hash map
                Order order = new Order(orderNumber, date, name, state, product, area, cost, labor, materialCost, laborCost, tax, taxRate, total);
                orders.put(orderNumber, order);
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }

        //return orders.get(date);
        return orders;
    }

    public void writeToOrder(LocalDate entry, Order order) throws flooringMasteryPersistenceException {
//        PrintWriter out = null;
//        try {
//            out = new PrintWriter(new FileWriter(DateToFile(entry), true));
//        } catch (IOException ex) {
//            System.out.println("cannot write to file.");
//        }
//        //HashMap< Integer, Order> enteredOrders = orders.get(entry);
//
//        out.println(
//                +order.getOrderNumber()
//                + DELIMITER + order.getDate()
//                + DELIMITER + order.getCustomerName()
//                + DELIMITER + order.getState()
//                + DELIMITER + order.getTaxRate()
//                + DELIMITER + order.getProductType()
//                + DELIMITER + order.getArea()
//                + DELIMITER + order.getCostPerSquareFoot()
//                + DELIMITER + order.getLaborCostPerSquareFoot()
//                + DELIMITER + order.getMaterialCost()
//                + DELIMITER + order.getLaborCost()
//                + DELIMITER + order.getTax()
//                + DELIMITER + order.getTotal());
//        out.flush();
//
//        out.close();

    }

    public void writeToOrder(LocalDate entry, HashMap< Integer, Order> orders) throws flooringMasteryPersistenceException {
//        PrintWriter out = null;
//        try {
//            out = new PrintWriter(new FileWriter(DateToFile(entry)));
//        } catch (IOException ex) {
//            System.out.println("cannot write to file.");
//        }
//        //HashMap< Integer, Order> enteredOrders = orders.get(entry);
//
//        for (Map.Entry< Integer, Order> entryB : orders.entrySet()) {
//            Order order = entryB.getValue();
//            out.println(
//                    +order.getOrderNumber()
//                    + DELIMITER + order.getDate()
//                    + DELIMITER + order.getCustomerName()
//                    + DELIMITER + order.getState()
//                    + DELIMITER + order.getTaxRate()
//                    + DELIMITER + order.getProductType()
//                    + DELIMITER + order.getArea()
//                    + DELIMITER + order.getCostPerSquareFoot()
        //                    + DELIMITER + order.getLaborCostPerSquareFoot()
//                    + DELIMITER + order.getMaterialCost()
//                    + DELIMITER + order.getLaborCost()
//                    + DELIMITER + order.getTax()
//                    + DELIMITER + order.getTotal());
//        }
//        out.flush();
//
//        out.close();

    }

    private int getLargestOrderNumber() throws flooringMasteryPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new FileReader("OrderNumberFile.txt"));
        } catch (FileNotFoundException e) {
            throw new flooringMasteryPersistenceException("Could Could not load products.", e);
        }

        String currentLine;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            int currentOrderNumber = Integer.parseInt(currentLine);

            int newOrderNumber = currentOrderNumber + 1;
            PrintWriter out = null;
            try {
                out = new PrintWriter(new FileWriter("OrderNumberFile.txt"));
            } catch (IOException ex) {
                System.out.println("cannot write to file.");
            }

            out.println(newOrderNumber);
            out.flush();
            out.close();

            return newOrderNumber;
        }

        /*
@Override
    public Order getOrder(LocalDate date, int orderNumber) throws flooringMasteryPersistenceException {
        return orders.get(date).get(orderNumber);
    }
         
        return 0;
    }
         */
        return 0;
    }

    public int getNumberOfOrders(LocalDate date) {
        return orders.get(date).size();
    }
}
