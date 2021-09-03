package com.bisbali.demo.repositories;

import com.bisbali.demo.models.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
