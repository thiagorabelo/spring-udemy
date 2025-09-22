package exp_01.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import exp_01.model.Person;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        logger.info("Findind all Persons");
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Na Rua dos Bobos Número zero");
        person.setGender(i % 2 == 0 ? "Male" : "Female");
        return person;
    }

    public Person findById(String id) {
        logger.info("Findind one Person");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Fulano");
        person.setLastName("De Tal");
        person.setAddress("Na Rua dos Bobos Número zero");
        person.setGender("Male");
        return person;
    }
}
