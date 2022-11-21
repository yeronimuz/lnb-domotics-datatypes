package com.lankheet.iot.datatypes.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test for {@link DomoticsUser}.
 *
 */
public class DomoticsUserTest {

    private EntityManagerFactory entityManagerFactory;

    private              EntityManager entityManager;
    private static final String        PERSISTENCE_UNIT = "measurements-pu";
    
    @Before
    public void testSetup() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    @Test
    public void test(@Mock Site site) {
        List<Site> sites = new ArrayList<Site>() {{
            add(new Site("main home"));
        }};
        DomoticsUser domoticsUser = new DomoticsUser("user1", "password1", site);
        sites.get(0).setUserList(Arrays.asList(domoticsUser));
        
        entityManager.getTransaction().begin();
        entityManager.persist(sites.get(0));
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

