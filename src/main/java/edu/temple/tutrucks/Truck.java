package edu.temple.tutrucks;
// Generated Feb 15, 2016 6:30:46 PM by Hibernate Tools 4.3.1

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Truck generated by hbm2java
 * 
 * This class represents a food truck. Its mapping file is Truck.hbm.xml
 * 
 * @author Nick Dell'Osa
 * @version %PROJECT_VERSION%
 */
public class Truck implements java.io.Serializable, Reviewable, Taggable, Searchable {

     private int id;
     private String truckName;
     private double latitude;
     private double longitude;
     private Time openingTime;
     private Time closingTime;
     private List<TruckReview> truckReviews = new ArrayList<>();
     private List<Menu> menus = new ArrayList<>();
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
    public Set<Tag> getTags() {
        return this.tags;
    }
    /**
     * Attaches one or more tags to this truck.
     * @param t the tag(s) to be attached to this truck
     */
    @Override
    public void addTags(Tag... t) {
        for (Tag x : t) {
            tags.add(x);
            if (!x.getTrucks().contains(this)) x.addEntity(this);
        }
    }
    /**
     * Sets the list of truck reviews for this truck. Required by Hibernate
     * @param truckReviews the list of truck reviews for this truck
     */
    public void setTruckReviews(List<TruckReview> truckReviews) {
        this.truckReviews.clear();
        this.truckReviews.addAll(truckReviews);
    }
    /**
     * Sets the list of menus for this truck. Required by Hibernate
     * @param menus the list of menus for this truck
     */
    public void setMenus(List<Menu> menus) {
        this.menus.clear();
        this.menus.addAll(menus);
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

    @Override
    public String getSearchName() {
        return this.truckName;
    }
    
    public static List<Truck> getAllTrucks() {
        return searchTrucks("");
    }
    
    public static List<String> getAllTruckNames() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("select truckName from Truck order by truckName ASC");
        List l = q.list();
        session.close();
        return l;
    }
    
    public static List<Truck> searchTrucks(String terms) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery(
                "from Truck" + (terms.isEmpty() ? "" : " where truckName like '%" + terms + "%'")
        );
        List l = q.list();
        session.close();
        ArrayList<Truck> results = new ArrayList<>(l.size());
        for (Searchable s : Searchable.SearchOrganizer.organize(l, terms)) results.add((Truck)s);
        return results;
    }
    
    public static Truck getTruckByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery(
                "from Truck where truckName='" + name + "'"
        );
        Truck retval = (Truck) q.uniqueResult();
        session.close();
        return retval;
    }
    
     public static List<Truck> openTrucks() {
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        //WHAT DID WE DO FOR WEEKENDS
        if (dayOfWeek == 1 || dayOfWeek == 7){
            return null;
        }
        int timeHour = c.get(Calendar.HOUR_OF_DAY);
        timeHour = 10;
        int timeMinute = c.get(Calendar.MINUTE);
        timeMinute = 0;
        Time current = new Time(timeHour, timeMinute, 0);
        Time end = new Time(11, 0, 0);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Query q = session.createQuery("from Truck t where t.openingTime <=:time and t.closingTime >:time");
        q.setParameter("time", current);
        List results = q.list();
        session.close();
        return results;
    }

    public static Truck getTruckByID(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery(
                "from Truck where id='" + id + "'"
        );
        Truck retval = (Truck) q.uniqueResult();
        session.close();
        return retval;
    }
    
    @Override
    public int getScore() {
        if (truckReviews.isEmpty())
            return 0;
        double score = 0.0;
        for (TruckReview tr : truckReviews) {
            if (tr!=null){
                //System.out.println(tr.reviewText);
                //System.out.println(tr.reviewStars);
                score += (double)(tr.getReviewStars());
            }
        }
        score /= (double)truckReviews.size();
        //System.out.println(score);
        return (int) Math.round(score);
    }

    @Override
    public List<TruckReview> loadReviews() {        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery(
                "from TruckReview tr where tr.truck.id=" + this.id + " order by tr.reviewDate desc"
        );
        List l = q.list();
        session.close();
        ArrayList<TruckReview> revs = new ArrayList<>(l.size());
        for (Object o : l) revs.add((TruckReview)o);
        this.setTruckReviews(revs);
        return this.truckReviews;
    }

    
    @Override
    public Set<Tag> loadTags() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Tag t join t.trucks tr where tr.id = " + this.getId());
        List l = q.list();
        session.close();        
        for (Object o : l) {
            if (o instanceof Tag) this.addTags((Tag)o); 
        }
        return this.tags;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o instanceof Truck) {
            Truck t = (Truck) o;
            return this.id == t.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.truckName);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.latitude) ^ (Double.doubleToLongBits(this.latitude) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.longitude) ^ (Double.doubleToLongBits(this.longitude) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.openingTime);
        hash = 41 * hash + Objects.hashCode(this.closingTime);
        return hash;
    }


}


