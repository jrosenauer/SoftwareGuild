/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superheromodel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class Location {

    public int locationID;
    public String locationName;
    public String locationDescription;
    public String locationAddress;
    public double locationLatitude;
    public double locationLongitude;
    public List< Super> supers = new ArrayList<>();

    /**
     * @return the locationID
     */
    public int getLocationID() {
        return locationID;
    }

    /**
     * @param locationID the locationID to set
     */
    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    /**
     * @return the locationName
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * @param locationName the locationName to set
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * @return the locationDescription
     */
    public String getLocationDescription() {
        return locationDescription;
    }

    /**
     * @param locationDescription the locationDescription to set
     */
    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    /**
     * @return the locationAddress
     */
    public String getLocationAddress() {
        return locationAddress;
    }

    /**
     * @param locationAddress the locationAddress to set
     */
    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    /**
     * @return the locationLatitude
     */
    public double getLocationLatitude() {
        return locationLatitude;
    }

    /**
     * @param locationLatitude the locationLatitude to set
     */
    public void setLocationLatitude(double locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    /**
     * @return the locationLongitude
     */
    public double getLocationLongitude() {
        return locationLongitude;
    }

    /**
     * @param locationLongitude the locationLongitude to set
     */
    public void setLocationLongitude(double locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    /**
     * @return the supers
     */
    public List< Super> getSupers() {
        return supers;
    }

    /**
     * @param supers the supers to set
     */
    public void setSupers(List< Super> supers) {
        this.supers = supers;
    }
}
