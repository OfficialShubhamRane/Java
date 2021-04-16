package com.example.application.backend.repository;

import com.example.application.backend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {



}
