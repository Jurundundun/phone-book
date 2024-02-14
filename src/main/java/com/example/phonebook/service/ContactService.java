package com.example.phonebook.service;

import com.example.phonebook.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;

    public String getPhoneNumberByName(String name){
        return contactRepository.findPhoneNumberByName(name).orElse("");
    }
    public String getPhoneNumberByNameWithException(String name){
        return contactRepository.findPhoneNumberByName(name)
                .orElseThrow(() -> new NoSuchElementException("Номер не найден"));
    }
    public String getPhoneNumberByNameWithLogInfo(String name){
        return contactRepository.findPhoneNumberByName(name).orElseGet(() -> {
                    System.out.println("Номер не найден");
                    return "";
                }
        );
    }
    public String getPhoneNumberByNameOrGetMessage(String name){
        return contactRepository.findPhoneNumberByName(name).orElse("Номер не найден");
    }
}
