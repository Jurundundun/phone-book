package com.example.phonebook.controller;

import com.example.phonebook.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/contact")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;


    @GetMapping("/message")
    public String getContactByName(@RequestParam String name) {
        Optional<String> phoneNumber = contactService.getPhoneNumberByName(name);
        return phoneNumber.orElse("");
    }

    @GetMapping("/exception")
    public String getContactByNameOrElseThrowException(@RequestParam String name) {
        Optional<String> phoneNumber = contactService.getPhoneNumberByName(name);
        return phoneNumber.orElseThrow(() -> new NoSuchElementException("Номер не найден"));
    }

    @GetMapping("/log")
    public String getContactByNameOrElseLogInfo(@RequestParam String name) {
        Optional<String> phoneNumber = contactService.getPhoneNumberByName(name);
        return phoneNumber.orElseGet(() -> {
                    System.out.println("Номер не найден");
                    return "";
                }
        );
    }

    @GetMapping("/message")
    public String getContactByNameOrElseMessage(@RequestParam String name) {
        Optional<String> phoneNumber = contactService.getPhoneNumberByName(name);
        return phoneNumber.orElse("Номер не найден");
    }
}

