package com.lankheet.iot.datatypes.entities;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for {@link DomoticsUser}.
 *
 */
public class DomoticsUserTest {

    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;
    private static final String PERSISTENCE_UNIT = "measurements-pu";
    
    @Before
    public void testSetup() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    @Test
    public void test() {
        List<Location> locations = new ArrayList<Location>() {{
            add(new Location("main home"));
        }};
        DomoticsUser domoticsUser = new DomoticsUser("user1", "password1");
        domoticsUser.setLocations(locations);
        locations.get(0).setUserList(Arrays.asList(domoticsUser));
        
        entityManager.getTransaction().begin();
        entityManager.persist(locations.get(0));
        entityManager.persist(domoticsUser);
        entityManager.getTransaction().commit();

        TypedQuery<DomoticsUser> query = entityManager.createQuery("SELECT u FROM users u", DomoticsUser.class);
        List<DomoticsUser> userList = query.getResultList();
        
        assertThat(userList.size(), is(1));
        System.out.println(userList);
        assertThat(userList.get(0).getPassword(), is("password1"));
    }
    
    @After
    public void doCleanup() {
        entityManager.close();
        entityManagerFactory.close();
    }
}

