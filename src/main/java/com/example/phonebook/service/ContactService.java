package com.example.phonebook.service;

import com.example.phonebook.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;

    public Optional<String> getPhoneNumberByName(String name){
        return contactRepository.findPhoneNumberByName(name);
    }
}
