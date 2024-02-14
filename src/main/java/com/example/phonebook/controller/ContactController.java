package com.example.phonebook.controller;

import com.example.phonebook.service.contact.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/api/v1/contact")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;


    @GetMapping
    @ResponseBody
    public Optional<String> getPhoneNumberByName(@RequestParam String name) {
        return contactService.getPhoneNumberByName(name);
    }

    @GetMapping("/exception")
    public String getPhoneNumberByNameWithException(@RequestParam String name) {
        return contactService.getPhoneNumberByNameWithException(name);
    }

    @GetMapping("/log")
    public String getPhoneNumberByNameWithLogInfo(@RequestParam String name){
        return contactService.getPhoneNumberByNameWithLogInfo(name);
    }

    @GetMapping("/message")
    public String getPhoneNumberByNameOrGetMessage(@RequestParam String name) {
        return contactService.getPhoneNumberByNameOrGetMessage(name);
    }
}

