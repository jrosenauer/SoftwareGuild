/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import flooringMastery.dto.Tax;
import flooringMastery.service.invalidStateException;
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
public class taxDaoImpl implements taxDao {

    public static final String TAXES = "Taxes.txt";
    public static final String DELIMITER = ",";

    private Map< String, Tax> states = new HashMap<>();

    public taxDaoImpl() throws flooringMasteryPersistenceException {
        readFromTaxFile();
        for (Map.Entry< String, Tax> entry : states.entrySet()) {
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }
    }

    public void readFromTaxFile() throws flooringMasteryPersistenceException {

        Scanner scanner;

        try {
            scanner = new Scanner(new FileReader(TAXES));
        } catch (FileNotFoundException e) {
            throw new flooringMasteryPersistenceException("Could not load tax rates.", e);
        }
        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Tax currentTax = new Tax();
            currentTax.setState(currentTokens[0]);
            currentTax.setTaxRate(new BigDecimal(currentTokens[1]));

            states.put(currentTax.getState(), currentTax);
        }
        scanner.close();
    }

    @Override
    public BigDecimal getTaxRate(String state) {
       // Map< String, Tax> states = getAllTaxes();
        //for (String stateTax : states.keySet()); 
        Tax getTax = states.get(state);
        BigDecimal getTaxOut = getTax.getTaxRate();
//        
//        for (int i = 0; i < states.size(); i++) {
//            if (state.equalsIgnoreCase(states.get(i).getState())) {
//            getTaxOut = states.get(i).getTaxRate();
//        }
//    }

    return getTaxOut;
    }
    
    /*
    @Override
       public Map< String, Tax> getAllTaxes(String) {
           Map< String, Tax> taxesInList = new HashMap<>();
           taxesInList.put(state, value);
           return taxesInList;
       }
*/
        


}
