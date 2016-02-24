package edu.temple.tutrucks;
// Generated Feb 15, 2016 6:30:46 PM by Hibernate Tools 4.3.1

import java.util.Set;
import java.util.TreeSet;

/**
 * Item generated by hbm2java
 */
public class Item implements java.io.Serializable, Reviewable, Taggable {


     private int id;
     private String itemName;
     private double price;
     private Set<ItemReview> itemReviews = new TreeSet();
     private Set<Tag> tags = new TreeSet();

    public Item() {
        
    }

	
    public Item(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getItemName() {
        return this.itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    public Set getItemReviews() {
        return this.itemReviews;
    }
    
    @Override
    public void addReview(Review r) {
        if (!r.getReviewed().equals(this)) {
            //error handling
            return;
        }
        itemReviews.add((ItemReview)r);
    }
    
    @Override
    public Set getTags() {
        return this.tags;
    }
    
    @Override
    public void addTags(Tag... t) {
        for (Tag x : t) {
            if (!x.getItems().contains(this)) x.addItem(this);
            tags.add(x);
        }
    }




}


