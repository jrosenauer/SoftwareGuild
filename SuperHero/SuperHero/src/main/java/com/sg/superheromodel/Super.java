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
public class Super {

    private int superID;
    private String superName;
    private String superDescription;
    private String superPower;
    private List< Integer> organizationID;
    //private List< Organization> organizations = new ArrayList<>();
    private List< Location> locations = new ArrayList<>();
    private List< Sighting> sightings = new ArrayList<>();

    /**
     * @return the superID
     */
    public int getSuperID() {
        return superID;
    }

    /**
     * @param superID the superID to set
     */
    public void setSuperID(int superID) {
        this.superID = superID;
    }

    /**
     * @return the superName
     */
    public String getSuperName() {
        return superName;
    }

    /**
     * @param superName the superName to set
     */
    public void setSuperName(String superName) {
        this.superName = superName;
    }

    /**
     * @return the superDescription
     */
    public String getSuperDescription() {
        return superDescription;
    }

    /**
     * @param superDescription the superDescription to set
     */
    public void setSuperDescription(String superDescription) {
        this.superDescription = superDescription;
    }

    /**
     * @return the superPower
     */
    public String getSuperPower() {
        return superPower;
    }

    /**
     * @param superPower the superPower to set
     */
    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    /**
     * @return the organizationID
     */
    public List< Integer> getOrganizationID() {
        return organizationID;
    }

    /**
     * @param organizationID the organizationID to set
     */
    public void setOrganizationID(List< Integer> organizationID) {
        this.organizationID = organizationID;
    }

    /**
     * @return the locations
     */
    public List< Location> getLocations() {
        return locations;
    }

    /**
     * @param locations the locations to set
     */
    public void setLocations(List< Location> locations) {
        this.locations = locations;
    }

    /**
     * @return the sightings
     */
    public List< Sighting> getSightings() {
        return sightings;
    }

    /**
     * @param sightings the sightings to set
     */
    public void setSightings(List< Sighting> sightings) {
        this.sightings = sightings;
    }
}
