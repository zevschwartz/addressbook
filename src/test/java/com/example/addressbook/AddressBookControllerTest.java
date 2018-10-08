package com.example.addressbook;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AddressBookControllerTest {

    public static final Person PERSSON = new Person(999, "Jen", "Passes");
    @Autowired AddressBookController addressBookController;

    @MockBean PersonService personService;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp() {
        BDDMockito.given(personService.getAll())
                .willReturn(Collections.singletonList(PERSSON));
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/people"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].id").value(999))
                .andExpect(jsonPath("$[0].firstName").value("Jen"))
                .andExpect(jsonPath("$[0].lastName").value("Passes"));
    }

}
