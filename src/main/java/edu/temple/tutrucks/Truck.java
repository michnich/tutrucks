package edu.temple.tutrucks;
// Generated Feb 15, 2016 6:30:46 PM by Hibernate Tools 4.3.1

import java.sql.Time;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Truck generated by hbm2java
 * 
 * @author Nick Dell'Osa
 * @version %PROJECT_VERSION%
 * 
 * This class represents a food truck. Its mapping file is Truck.hbm.xml
 */
public class Truck implements java.io.Serializable, Reviewable, Taggable {

     private int id;
     private String truckName;
     private double latitude;
     private double longitude;
     private Time openingTime;
     private Time closingTime;
     private List<TruckReview> truckReviews;
     private List<Menu> menus;
     private Set<Tag> tags = new TreeSet();

     /**
      * Required empty constructor
      */
    public Truck() {
        
    }
    /**
     * Returns the ID of this truck. Required by Hibernate
     * @return the ID of this truck
     */
    public int getId() {
        return this.id;
    }
    /**
     * Sets the ID of this truck. Required by Hibernate
     * @param id the ID of this truck
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Returns the name of this truck. Required by Hibernate
     * @return the name of this truck
     */
    public String getTruckName() {
        return this.truckName;
    }
    /**
     * Sets the name of this truck. Required by Hibernate
     * @param truckName the name of this truck
     */
    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }
    /**
     * Returns the latitude of this truck. Required by Hibernate
     * @return the latitude of this truck
     */
    public double getLatitude() {
        return this.latitude;
    }
    /**
     * Sets the latitude of this truck. Required by Hibernate
     * @param latitude the latitude of this truck
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    /**
     * Returns the longitude of this truck. Required by Hibernate
     * @return the longitude of this truck
     */
    public double getLongitude() {
        return this.longitude;
    }
    /**
     * Sets the longitude of this truck. Required by Hibernate
     * @param longitude the longitude of this truck
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    /**
     * Returns the list of reviews for this truck. Required by Hibernate
     * @return the list of reviews for this truck
     */
    public List getTruckReviews() {
        return this.truckReviews;
    }
    /**
     * Returns the list of menus/food categories at this truck. Required by Hibernate
     * @return the list of menus for this truck.
     */
    public List getMenus() {
        return this.menus;
    }
    /**
     * Adds a review for this truck.
     * @param r the review for this truck
     */
    @Override
    public void addReview(Review r) {
        if (!r.getReviewed().equals(this)) {
            //error handling
            return;
        }
        truckReviews.add((TruckReview)r);
    }
    /**
     * Returns the set of tags attached to this truck. Required by Hibernate
     * @return the set of tags attached to this truck
     */
    @Override
    public Set getTags() {
        return this.tags;
    }
    /**
     * Attaches one or more tags to this truck.
     * @param t the tag(s) to be attached to this truck
     */
    @Override
    public void addTags(Tag... t) {
        for (Tag x : t) {
            if (!x.getTrucks().contains(this)) x.addEntity(this);
            tags.add(x);
        }
    }
    /**
     * Sets the list of truck reviews for this truck. Required by Hibernate
     * @param truckReviews the list of truck reviews for this truck
     */
    public void setTruckReviews(List<TruckReview> truckReviews) {
        this.truckReviews = truckReviews;
    }
    /**
     * Sets the list of menus for this truck. Required by Hibernate
     * @param menus the list of menus for this truck
     */
    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
    /**
     * Sets the set of tags attached to this truck. Required by Hibernate
     * @param tags the set of tags attached to this truck
     */
    public void setTags(Set<Tag> tags) {
        this.tags.addAll(tags);
    }
    /**
     * Returns the time this truck opens on normal weekdays. Required by Hibernate
     * @return the time this truck opens on normal weekdays
     */
    public Time getOpeningTime() {
        return openingTime;
    }
    /**
     * Sets the time this truck opens on normal weekdays. Required by Hibernate
     * @param openingTime the time this truck opens on normal weekdays
     */
    public void setOpeningTime(Time openingTime) {
        this.openingTime = openingTime;
    }
    /**
     * Returns the time this truck closes on normal weekdays. Required by Hibernate.
     * @return the time this truck closes on normal weekdays
     */
    public Time getClosingTime() {
        return closingTime;
    }
    /**
     * Sets the time this truck closes on normal weekdays. Required by Hibernate.
     * @param closingTime the time this truck closes on normal weekdays
     */
    public void setClosingTime(Time closingTime) {
        this.closingTime = closingTime;
    }

}


