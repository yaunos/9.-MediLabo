package com.preventDiabet.PatientMicroservice.repository;

import com.preventDiabet.PatientMicroservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String>
{
}