package com.example.addressbook;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PersonTest {

    @Test
    public void create() {
        Person person = new Person(1, "jen", "cho");

        Assertions.assertThat(person).isNotNull();
        Assertions.assertThat(person.getId()).isEqualTo(1);
        Assertions.assertThat(person.getFirstName()).isEqualTo("jen");
        Assertions.assertThat(person.getLastName()).isEqualTo("cho");
    }

}
