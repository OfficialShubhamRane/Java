package com.example.application.backend.repository;

import com.example.application.backend.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long > {
}
