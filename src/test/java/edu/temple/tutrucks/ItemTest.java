/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.temple.tutrucks;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Set;
import java.util.TreeSet;
import org.hibernate.Query;
import org.hibernate.Session;
import static org.mockito.Mockito.*;
/**
 *
 * @author michn_000
 */
public class ItemTest {
    private ItemReview review;
    private Tag tag;
    private Item item;
    private Set<Item> itemSet;
    private List<Tag> tagList;
    
    @Before
    public void setUpMock() {
        review = mock(ItemReview.class);   
        tag = mock(Tag.class);
        item = new Item();
        itemSet = new HashSet();       
        tagList = new ArrayList();
        for (int i =0; i < 5; i++) {
            Tag tempTag = mock(Tag.class);
            tagList.add(tempTag);
        }
    }
    
    @Test
    public void testMockCreation(){
        assertNotNull(review);
        assertNotNull(tag);
        assertNotNull(item);
        assertNotNull(itemSet);
        assertNotNull(tagList);
    }

    @Test
    public void testAddReview() {
        when(review.getReviewed()).thenReturn(item);  
        item.addReview(review);
        System.out.println("Verifying review called getReviewed");
        verify(review).getReviewed();
        System.out.println("Verifying if condition was false");
        assertEquals(true, review.getReviewed().equals(item));
        System.out.println("Verifying that the review was added to the list");
        assertEquals(item.getItemReviews().get(0), review);
    }
    
    @Test
    public void testAddReviewFailed() {
        Item i = new Item();
        i.setId(1);
        when(review.getReviewed()).thenReturn(i);  
        item.addReview(review);
        System.out.println("Verifying review called getReviewed");
        verify(review).getReviewed();
        System.out.println("Verifying if condition was true");
        assertEquals(false, review.getReviewed().equals(item));
        System.out.println("Verifying that the review was not added to the list");
        assertNotEquals(item.getItemReviews().contains(review), review);        
    }

   @Test
    public void testAddTagItemInTagSet() { 
        itemSet.add(item);
        when(tag.getItems()).thenReturn(itemSet);
        item.addTags(tag);
        System.out.println("Verifying tag called get items");
        verify(tag).getItems();
        System.out.println("Verifying tag was added to item");
        assertEquals(item.getTags().contains(tag), true);
    }
    
    @Test
    public void testAddTagItemNotInTagSet() { 
        when(tag.getItems()).thenReturn(itemSet);
        item.addTags(tag);
        System.out.println("Verifying tag called get items");
        verify(tag).getItems();
        System.out.println("Verifying item added to tag");
        verify(tag).addEntity(item);
        System.out.println("Verifying tag added the item");
        assertEquals(item.getTags().contains(tag), true);
    }
    
    @Test
    public void testAddMultipleTags() { 
        itemSet.add(item);
        for (int i = 0; i < tagList.size(); i++) {
            when(tagList.get(i).getItems()).thenReturn(itemSet);
        }
        item.addTags(tagList.get(0), tagList.get(1), tagList.get(2), tagList.get(3), tagList.get(4));
        System.out.println("Verifying all tags called get items");
         for (int i = 0; i < tagList.size(); i++) {
             verify(tagList.get(i)).getItems();
        }
        System.out.println("Verifying all tags were added to item");
        for (int i = 0; i < tagList.size(); i++) {
             assertTrue(item.getTags().contains(tagList.get(i)));
        } 
    }
    
    @Test
    public void testSearchItems() {
        String searchTerms = "cheesesteak";
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery(
                "from Item where itemName like '%" + searchTerms + "%'"
        );
        List l = q.list();
        session.close();
        List<Searchable> testResults = Searchable.SearchOrganizer.organize(l, searchTerms);
        List<Item> results = Item.searchItems(searchTerms);
        for (int i = 0; i < testResults.size(); i++) {
            assertEquals(testResults.get(i).getSearchName(), results.get(i).getSearchName());
        }
    }
    /*
    @Test
    public void testLoadReviews() {
        Item i;
        List<ItemReview> reviews;
        i = Item.searchItems("chicken").get(0);
        reviews = i.loadReviews();
        assertTrue(reviews.size() > 0);
        for (ItemReview r : reviews) {
            if (r != null) System.out.println(r.reviewText);
            else System.out.println("null entry");
        }
    } */
}

