package edu.temple.tutrucks;
// Generated Feb 15, 2016 6:30:46 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Item generated by hbm2java
 * 
 * This class represents individual food items on a truck's menu(s). Its mapping file is Item.hbm.xml 
 * 
 * @author Nick Dell'Osa
 * @version %PROJECT_VERSION%
 */
public class Item implements java.io.Serializable, Reviewable, Taggable, Searchable {


     private int id;
     private String itemName;
     private double price;
     private Menu menu;
     private List<ItemReview> itemReviews = new ArrayList();
     private Set<Tag> tags = new TreeSet();

     /**
     * Required empty constructor.
     */
    public Item() {
        
    }

    /**
    Constructor required by Hibernate
    * @param itemName The name of this item
    * @param price The price of this item
    */
    public Item(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }
   
    /**
     * Returns this items ID. Required by Hibernate
     * @return the item's ID
     */
    public int getId() {
        return this.id;
    }
    /**
     * Sets an item's ID. Required by Hibernate
     * @param id The item's ID
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Returns the item's name. Required by Hibernate
     * @return the item's name
     */
    public String getItemName() {
        return this.itemName;
    }
    /**
     * Sets an item's name. Required by Hibernate
     * @param itemName the item's name
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    /**
     * Returns an item's price. Required by Hibernate
     * @return the price of an item
     */
    public double getPrice() {
        return this.price;
    }
    /**
     * Sets an item's price. Required by Hibernate
     * @param price the price of the item
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Returns the menu this item belongs to. Required by Hibernate
     * @return the menu this item belongs to
     */
    public Menu getMenu() {
        return menu;
    }
    /**
     * Sets the menu this item belongs to. Required by Hibernate
     * @param menu the menu this item belongs to
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    /**
     * Returns a list of reviews of the item. Required by Hibernate
     * @return a list of the item's reviews.
     */
    public List getItemReviews() {
        return this.itemReviews;
    }
    /**
     * Adds a review to the item's list of reviews. 
     * @param r The review to be added to this item's list of reviews
     */
    @Override
    public void addReview(Review r) {
        if (!r.getReviewed().equals(this)) {
            //error handling
            return;
        }
        itemReviews.add((ItemReview)r);
    }
    /**
     * Returns a set of tags associated with this item. Required by Hibernate
     * @return the set of tags associated with the item
     */
    @Override
    public Set getTags() {
        return this.tags;
    }
    /**
     * Associates one or more tags with an item
     * @param t The tag(s) to be associated with the item
     */
    @Override
    public void addTags(Tag... t) {
        for (Tag x : t) {
            if (!x.getItems().contains(this)) x.addEntity(this);
            tags.add(x);
        }
    }
    /**
     * Sets the list of reviews for this item. Required by Hibernate
     * @param itemReviews the list of reviews for this item
     */
    public void setItemReviews(List<ItemReview> itemReviews) {
        this.itemReviews.clear();
        this.itemReviews.addAll(itemReviews);
    }
    /**
     * Sets the set of tags associated with this item. Required by Hibernate
     * @param tags the set of tags associated with this item.
     */
    public void setTags(Set tags) {
        this.tags.addAll(tags);
    }

    @Override
    public String getSearchName() {
        return this.itemName;
    }

    public static List<Item> searchItems(String terms) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery(
                "from Item where itemName like '%" + terms + "%'"
        );
        List l = q.list();
        session.close();
        ArrayList<Item> results = new ArrayList<>(l.size());
        for (Searchable s : Searchable.SearchOrganizer.organize(l, terms)) results.add((Item)s);
        return results;
    }

    @Override
    public int getScore() {
        if (itemReviews.isEmpty())
            return 0;
        double score = 0.0;
        for (ItemReview ir : itemReviews) {
            score += (double)ir.getReviewStars();
        }
        score /= (double)itemReviews.size();
        return (int) Math.round(score);
    }

    @Override
    public List<ItemReview> loadReviews() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery(
                "from ItemReview where item.id=" + this.id + " order by reviewDate desc"
        );
        List l = q.list();
        session.close();
        ArrayList<ItemReview> revs = new ArrayList<>(l.size());
        for (Object o : l) revs.add((ItemReview)o);
        this.setItemReviews(revs);
        return this.itemReviews;
    }

    @Override
    public Set<Tag> loadTags() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Tag t join t.items it where it.id = :id");
        List l = q.list();
        session.close();
        for (Object o : l) this.addTags((Tag)o);
        return this.tags;
    }

}


