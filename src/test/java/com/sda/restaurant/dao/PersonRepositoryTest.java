package com.sda.restaurant.dao;

import com.sda.restaurant.entity.Person;
import com.sda.restaurant.entity.Role;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest // disables full auto-configuration and instead apply only configuration relevant to JPA tests
            //By default, tests annotated with @DataJpaTest use an embedded in-memory database
//@ActiveProfiles("test") to use real db
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonRepositoryTest {
    private Person testPerson;

//    @Autowired // TestEntityManager used to setup some records in DB, to carry out some DB operations
//    private TestEntityManager entityManager;
    // TODO ?? TestEntityManager to persist OR just personRepository

    @Autowired
    private PersonRepository personRepository;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Before
    public void init(){
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1, Role.RoleTitle.EMPLOYEE));
//        Person alex = new Person(null, "alex", "guh", "kkk@kkk.com", "gfgf", "username", "pass", roles);
        testPerson = new Person(null, "ann", "lann", "ann@gmail.com", "Espo", "annusername", "pass", roles);
    }

    @Test
    public void savePerson(){
        System.out.println("-------------- activeProfile: " + activeProfile + "--------------");
        personRepository.save(testPerson);
        Person foundPerson = personRepository.findByUsername(testPerson.getUsername());
        assertNotNull(foundPerson.getPersonId());
    }

    @Test
    public void findByUsername() {
//        entityManager.persist(ann);
//        entityManager.flush();
        personRepository.save(testPerson);
        Person foundPerson = personRepository.findByUsername(testPerson.getUsername());
        assertEquals("Check person can be found by username ", testPerson.getUsername(), foundPerson.getUsername());
    }

    @Test
    public void whenFindByRoleTitle_thenReturnPersons() {
        personRepository.save(testPerson);
        List<Person> foundPersons = personRepository.findByRolesRoleTitle(Role.RoleTitle.EMPLOYEE);

        // TODO ?
        assertTrue(foundPersons.size() > 1);

//        assertEquals(3, foundPersons.size());
//        assertEquals("alex", foundPersons.get(0).getFirstName());
        //assertThat(foundPersons, hasItem(alex));

    }
}
