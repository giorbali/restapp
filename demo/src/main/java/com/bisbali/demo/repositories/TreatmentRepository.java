package com.bisbali.demo.repositories;

import com.bisbali.demo.models.Treatment;
import org.springframework.data.repository.CrudRepository;

public interface TreatmentRepository extends CrudRepository<Treatment, Long> {
}
