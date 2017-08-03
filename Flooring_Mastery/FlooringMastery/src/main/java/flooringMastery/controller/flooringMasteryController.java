/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.controller;

import flooringMastery.dao.flooringMasteryPersistenceException;
import flooringMastery.dao.orderDao;
import flooringMastery.dao.productDao;
import flooringMastery.dao.taxDao;
import flooringMastery.dto.Order;
import flooringMastery.service.flooringMasteryServiceLayer;
import flooringMastery.service.invalidProductTypeException;
import flooringMastery.service.invalidStateException;
import flooringMastery.ui.flooringMasteryView;
import flooringMastery2.AppSetting;
import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class flooringMasteryController {

    //private flooringMasteryIO io;
    flooringMasteryView view;
    orderDao dao;
    taxDao tax;
    productDao product;
    private flooringMasteryServiceLayer service;

    public flooringMasteryController(flooringMasteryServiceLayer service, flooringMasteryView view, orderDao dao, taxDao tax, productDao product) {
        this.service = service;
        this.view = view;
        this.product = product;
        this.tax = tax;
        this.dao = dao;
    }

    public flooringMasteryController() {
        this.service = service;
    }

    public flooringMasteryController(flooringMasteryServiceLayer service, flooringMasteryView view) {
        this.service = service;
        this.view = view;
    }

    public void run() throws flooringMasteryPersistenceException, invalidStateException, invalidProductTypeException {
        boolean keepGoing = true;
        int menuSelection;

        while (keepGoing) {

            menuSelection = view.printMenuAndGetSelection();

            switch (menuSelection) {
                case 1:
                    displayOrders();
                    break;
                case 2:
                    addOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    removeOrder();
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }

    public int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addOrder() throws flooringMasteryPersistenceException, invalidStateException, invalidProductTypeException {
        view.displayAddOrderBanner();
        Order order = view.getNewOrderInfo();
        service.addOrder(order);
        //dao.addOrder(order);        
        view.displayAddSuccessBanner();
    }

    private void removeOrder() throws flooringMasteryPersistenceException {

        view.displayRemoveOrderBanner();
        LocalDate date = view.getDateChoice();
        int orderNumber = view.getOrderNumber();
        HashMap<Integer, Order> order = service.getOrders(date);
        //Order order = dao.getOrder(date, orderNumber);
        //service.removeOrder(date, orderNumber, order);
        service.removeOrder(date, orderNumber);
        view.displayRemoveSuccessBanner();

    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void displayOrders() throws flooringMasteryPersistenceException {
        view.displaySearchBanner();
        LocalDate date = view.getDateChoice();
        HashMap< Integer, Order> enteredOrders = service.getOrders(date);
        view.displayOrders(enteredOrders);

    }

    private void save() throws flooringMasteryPersistenceException {
        service.save();
    }

    private void editOrder() throws flooringMasteryPersistenceException, invalidProductTypeException, invalidStateException {
        view.displayEditOrderBanner();
        LocalDate date = view.getDateChoice();
        //service.editOrder(order);
        int orderNumber = view.getOrderNumber();

        HashMap<Integer, Order> orders = service.getOrders(date);

        Order newOrder = view.editOrder(orders.get(orderNumber));
        service.editOrder(orders.get(orderNumber));
    }

}
