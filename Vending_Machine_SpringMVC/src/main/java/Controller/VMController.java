/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Dao;
import Model.Product;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class VMController {

    Dao dao;
    BigDecimal amount = BigDecimal.valueOf(0.00);
    String message;
    int productId;
    BigDecimal changeAmount = BigDecimal.valueOf(0.00);
    String coins;

    @Inject
    public VMController(Dao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayProducts(Model model) {
        List< Product> productList = dao.getAllProducts();

        model.addAttribute("productList", productList);
        model.addAttribute("amount", amount);
        model.addAttribute("productId", productId);
        model.addAttribute("message", message);
        model.addAttribute("change", changeAmount);
        model.addAttribute("coins", coins);

        return "index";
    }

    @RequestMapping(value = "/addMoney", method = RequestMethod.POST)
    public String addMoney(HttpServletRequest request) {
        String buttonValue = request.getParameter("hidden-value");
        BigDecimal moneyValue = new BigDecimal(buttonValue);

        amount = (amount).add(moneyValue);
        return "redirect:/";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(HttpServletRequest request, Model model) throws InsufficientFundsException, NoItemInventoryException {
        String productSelection = request.getParameter("product");
        productId = Integer.parseInt(productSelection);

        return "redirect:/";
    }

    @RequestMapping(value = "/makePurchase", method = RequestMethod.POST)
    public String makePurchase(HttpServletRequest request, Model model) throws InsufficientFundsException, NoItemInventoryException {
        List< Product> productList = dao.getAllProducts();
        String productSelection = request.getParameter("product");

        String purchaseButton = request.getParameter("purchase-button");

        Product currentProduct = dao.getProduct(productId);

        if (currentProduct.getQuantity() < 1) {
            message = "Sold out! Pick another item";
        } else {
            if (amount.compareTo(currentProduct.getPrice()) < 0) {
                changeAmount = currentProduct.getPrice().subtract(amount);
                message = "Please deposit: $" + changeAmount;
            } else {
                currentProduct.setQuantity(currentProduct.getQuantity() - 1);
                changeAmount = amount.subtract(currentProduct.getPrice());

                int Quarter = 0;
                int Dime = 0;
                int Nickel = 0;
                int Penny = 0;

                BigDecimal quarter = new BigDecimal(".25");
                BigDecimal dime = new BigDecimal(".10");
                BigDecimal nickel = new BigDecimal(".05");
                BigDecimal penny = new BigDecimal(".01");

                while (changeAmount.compareTo(quarter) >= 0) {
                    Quarter++;
                    changeAmount = changeAmount.subtract(quarter);
                }
                while (changeAmount.compareTo(dime) >= 0) {
                    Dime++;
                    changeAmount = changeAmount.subtract(dime);
                }
                while (changeAmount.compareTo(nickel) >= 0) {
                    Nickel++;
                    changeAmount = changeAmount.subtract(nickel);
                }
                while (changeAmount.compareTo(penny) >= 0) {
                    Penny++;
                    changeAmount = changeAmount.subtract(penny);
                }
                coins = Quarter + " quarters | " + Dime + " dimes | " + Nickel + " nickels | " + Penny + " pennies";
                message = "Thank You!";

                amount = BigDecimal.valueOf(0.00);

            }
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/returnChange", method = RequestMethod.POST)
    public String returnChange(HttpServletRequest request) {
        String purchaseButton = request.getParameter("change-return");
        message = "";

        int Quarter = 0;
        int Dime = 0;
        int Nickel = 0;
        int Penny = 0;

        BigDecimal quarter = new BigDecimal(".25");
        BigDecimal dime = new BigDecimal(".10");
        BigDecimal nickel = new BigDecimal(".05");
        BigDecimal penny = new BigDecimal(".01");

        while (amount.compareTo(quarter) >= 0) {
            Quarter++;
            amount = amount.subtract(quarter);
        }
        while (amount.compareTo(dime) >= 0) {
            Dime++;
            amount = amount.subtract(dime);
        }
        while (amount.compareTo(nickel) >= 0) {
            Nickel++;
            amount = amount.subtract(nickel);
        }
        while (amount.compareTo(penny) >= 0) {
            Penny++;
            amount = amount.subtract(penny);
        }
        coins = Quarter + " quarters | " + Dime + " dimes | " + Nickel + " nickels | " + Penny + " pennies";
        BigDecimal amount = BigDecimal.valueOf(0.00);
        return "redirect:/";
    }
}
