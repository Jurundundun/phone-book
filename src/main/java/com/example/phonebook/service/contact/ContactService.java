package com.example.phonebook.service.contact;

import java.util.Optional;

public interface ContactService {
    Optional<String> findPhoneNumberByName(String name);
    String getPhoneNumberByName(String name);
    String getPhoneNumberByNameWithLogInfo(String name);
    String getPhoneNumberByNameOrGetMessage(String name);
}
