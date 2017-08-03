



/*
 * To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary2;

import com.sg.dvdlibrary.controller.DVDLibraryController;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author apprentice
 */
public class App {
    
    public static void main (String [] args) {
        UserIO myIO = new UserIOConsoleImpl(); //source from IO
        DVDLibraryView myView = new DVDLibraryView(myIO); //source from view
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl(); //source from dao
        DVDLibraryController controller = new DVDLibraryController (myDao, myView); //source from controller
        controller.run(); 
    }
}
