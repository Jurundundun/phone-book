package com.example.phonebook.service.contact.impl;

import com.example.phonebook.repository.ContactRepository;
import com.example.phonebook.service.contact.ContactService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Override
    public Optional<String> getPhoneNumberByName(String name){
        return contactRepository.findPhoneNumberByName(name);
    }
    @Override
    public String getPhoneNumberByNameWithException(String name){
        return contactRepository.findPhoneNumberByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Номер не найден"));
    }
    @Override
    public String getPhoneNumberByNameWithLogInfo(String name){
        return contactRepository.findPhoneNumberByName(name).orElseGet(() -> {
                    System.out.println("Номер не найден");
                    return "";
                }
        );
    }
    @Override
    public String getPhoneNumberByNameOrGetMessage(String name){
        return contactRepository.findPhoneNumberByName(name).orElse("Номер не найден");
    }
}
