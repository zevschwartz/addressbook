package com.example.addressbook;


import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceTest {

    public static final Person PERSON_ONE = new Person(1, "Jen", "Cho");
    public static final Person PERSON_TWO = new Person(2, "first", "last");

    private final PersonRepository personRepositoryMock = Mockito.mock(PersonRepository.class);
    private PersonService personService = new PersonService(personRepositoryMock);

    @Before
    public void init(){
        BDDMockito.given(personRepositoryMock.findAll())
                .willReturn(new ArrayList<Person>(){{
                    add(PERSON_ONE);
                    add(PERSON_TWO);
                }});
    }

    @Test
    public void getPeople(){
        List<Person> people = personService.getAll();

        Assertions.assertThat(people)
                .isNotEmpty()
                .containsExactly(PERSON_ONE, PERSON_TWO);
    }

}
