/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface DVDLibraryDao {
    
    DVD addDVD (String title, DVD dvd); // obj for DVD with title identifier
    
    List<DVD>getAllDVDs(); //hashmap for getting all DVDs with method
        
    DVD getDVD (String title); //method to get single DVD with title identifier
    
    DVD removeDVD (String title); //method with title identifier
   
    /*DVD addUpdatedDVD(DVD dvd);*/
    
    DVD editDVDInfo (DVD dvd);
    
    DVD Search(String title);
    
}
