package org.domiot.entities;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

/**
 * Test for {@link UserEntity}.
 */
@DataJpaTest
@ActiveProfiles("h2") // or "mariadb"
@ContextConfiguration(classes = TestDataApplicationConfig.class)
class UserEntityTest {
    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testPersist() {
        var user = new UserEntity();
        user.setUserName("john");
        user.setEmail("john.doe@gmail.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setSiteEntity(null);
        entityManager.persist(user);
        entityManager.flush();

        UserEntity found = entityManager.find(UserEntity.class, user.getId());
        assertThat(found).isNotNull();
    }
}

