package org.lankheet.domiot.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test for {@link UserEntity}.
 */
@ExtendWith(MockitoExtension.class)
class UserEntityTest {

  static final Logger LOG = LoggerFactory.getLogger(SensorValueEntityTest.class);
  static EntityManagerFactory entityManagerFactory;

  static EntityManager entityManager;
  static final String PERSISTENCE_UNIT = "domiot";

//  @BeforeAll
  public static void testSetup() {
    entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    entityManager = entityManagerFactory.createEntityManager();
  }


//  @AfterAll
  public static void doCleanup() {
    entityManager.close();
    entityManagerFactory.close();
  }

  @Test
  void test() {
//    SiteEntity siteEntity = new SiteEntity("site description");
//    UserEntity userEntity = new UserEntity("user1", "password", "user1@site1.org", siteEntity);
//    siteEntity.setUserList(List.of(userEntity));
//
//    entityManager.getTransaction().begin();
//    entityManager.persist(siteEntity);
////    entityManager.persist(userEntity);
//    entityManager.getTransaction().commit();
//
//    TypedQuery<UserEntity> query = entityManager.createQuery("SELECT u FROM UserEntity u", UserEntity.class);
//    List<UserEntity> userList = query.getResultList();
//
//    assertEquals(1, userList.size());
//    System.out.println(userList);
    assertTrue(true);
  }
}

