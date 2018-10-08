package com.example.addressbook;


import antlr.ASTNULLType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressBookController {

    private final PersonService personService;

    @GetMapping("/people")
    public List<Person> getAllContacts(){
        return personService.getAll();
    }

}
