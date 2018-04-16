/**
 * MIT License
 * 
 * Copyright (c) 2017 Lankheet Software and System Solutions
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */


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

        TypedQuery<DomoticsUser> query = entityManager.createQuery("SELECT u FROM DomoticsUser u", DomoticsUser.class);
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

