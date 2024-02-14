package com.example.phonebook.repository;

import com.example.phonebook.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContactRepository extends JpaRepository<Contact, UUID> {
    @Query("SELECT c.phoneNumber from Contact c where c.name = :name")
    Optional<String> findPhoneNumberByName(@Param("name") String name);
}
