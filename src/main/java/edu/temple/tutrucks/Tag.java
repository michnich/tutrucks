package edu.temple.tutrucks;
// Generated Feb 15, 2016 6:30:46 PM by Hibernate Tools 4.3.1

import java.util.Set;
import java.util.HashSet;




/**
 * Tags generated by hbm2java
 */
public class Tag implements java.io.Serializable, java.lang.Comparable {


     private int id;
     private String tagName;
     private Set<Item> items;
     private Set<Truck> trucks;

    public Tag() {
    }

    public Tag(String tagName) {
       this.tagName = tagName;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTagName() {
        return this.tagName;
    }
    
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    
    public Set getItems() {
        return this.items;
    }
    
    public void setItems(Set<Item> items) {
        this.items = items;
    }
    
    public void addEntity(Taggable t) {
        if (!t.getTags().contains(this)) t.addTags(this);
        if (t.getClass() == Item.class)
            items.add((Item)t);
        else
            trucks.add((Truck)t);
    }
    
    public Set getTrucks() {
        return this.trucks;
    }
    
    public void setTrucks(Set<Truck> trucks) {
        this.trucks = trucks;
    }
    
    public Set<Taggable> getAllTaggedEntities() {
        Set<Taggable> retval = new HashSet();
        retval.addAll(items);
        retval.addAll(trucks);
        return retval;
    }
    
    public int numEntities() {
        return items.size() + trucks.size();
    }

    @Override
    public int compareTo(Object o) {
        try {
            Tag t = (Tag) o;
            if (this.numEntities() == t.numEntities())
                return this.getTagName().compareTo(t.getTagName());
            return Integer.compare(this.numEntities(), t.numEntities());
        } catch (ClassCastException cce) {
            return 1;
        }
    }


}


