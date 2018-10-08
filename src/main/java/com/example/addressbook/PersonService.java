package com.example.addressbook;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> getAll() {
        return StreamSupport.stream(personRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
