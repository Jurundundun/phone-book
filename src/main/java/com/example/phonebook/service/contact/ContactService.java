package com.example.phonebook.service.contact;

import java.util.Optional;

public interface ContactService {
    Optional<String> getPhoneNumberByName(String name);
    String getPhoneNumberByNameWithException(String name);
    String getPhoneNumberByNameWithLogInfo(String name);
    String getPhoneNumberByNameOrGetMessage(String name);
}
