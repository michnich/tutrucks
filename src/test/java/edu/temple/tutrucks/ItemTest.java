/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.temple.tutrucks;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Set;
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
    private static User realUser;
    private static Tag realTag;
    private static ItemReview realReview;

    @BeforeClass
    public static void setup() {
        realUser = User.createUser("itemtest@test.com", "password", false, null, null, null);
        realTag = Tag.retrieveTag("item test tag", true);
        realReview = new ItemReview();
        realReview.setReviewText("test review");
        realReview.setUser(realUser);
        realReview.setReviewStars(3);
        realReview.setReviewDate(new Date());
    }

    @AfterClass
    public static void tearDown() {
        realReview.delete();
        realUser.delete();
        realTag.delete();
    }

    @Before
    public void setUpMock() {
        review = mock(ItemReview.class);
        tag = mock(Tag.class);
        item = new Item();
        itemSet = new HashSet();
        tagList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            Tag tempTag = mock(Tag.class);
            tagList.add(tempTag);
        }
    }

    @Test
    public void testMockCreation() {
        assertNotNull(review);
        assertNotNull(tag);
        assertNotNull(item);
        assertNotNull(itemSet);
        assertNotNull(tagList);
    }

    @Test
    public void testGetScore() {
        ItemReview ir1 = new ItemReview();
        ItemReview ir2 = new ItemReview();
        ir1.setReviewStars(10);
        ir2.setReviewStars(0);
        ir1.setItem(item);
        ir2.setItem(item);
        List<ItemReview> reviewList = new ArrayList<>(2);
        reviewList.add(ir1);
        reviewList.add(ir2);
        item.setItemReviews(reviewList);
        assertEquals(5, item.getScore());
    }

    @Test
    public void testAddTagIntegration() {
        Item realItem = Item.getItemByID(1);
        realItem.addTags(realTag);
        realTag.save();
        assertTrue(realItem.loadTags().getTags().contains(realTag));
    }

    @Test
    public void testAddReviewIntegration() {
        Item realItem = Item.getItemByID(1);
        realReview.setReviewed(realItem);
        realItem.addReview(realReview);
        realReview.save();
        assertTrue(realItem.loadReviews().getItemReviews().contains(realReview));
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

    @Test
    public void testLoadReviews() {
        Item realItem = Item.getItemByID(1, false, false);
        ItemReview realFakeReview = new ItemReview();
        realFakeReview.setItem(realItem);
        realFakeReview.setUser(realUser);
        realFakeReview.setReviewDate(new Date());
        realFakeReview.setReviewStars(5);
        realFakeReview.setReviewText("fake review");
        realFakeReview.save();
        assertTrue(realItem.loadReviews().getItemReviews().contains(realFakeReview));
        realFakeReview.delete();
    }

    @Test
    public void testEqualsIntegration() {
        Item realItem = Item.getItemByID(1);
        assertTrue(realItem.equals(Item.getItemByID(1)));
        assertFalse(realItem.equals(Item.getItemByID(2)));
        Object testObject = new Object();
        assertFalse(realItem.equals(testObject));
    }
}
