package com.bisbali.demo;

import com.bisbali.demo.models.Patient;
import com.bisbali.demo.models.Treatment;
import com.bisbali.demo.repositories.PatientRepository;
import com.bisbali.demo.repositories.TreatmentRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api")
public class GenericController {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private TreatmentRepository treatmentRepository;

    @GetMapping(value="/patienten", produces = "application/hal+json")
    @CrossOrigin
    List<Patient> getPatients(){
        List<Patient> patients = Lists.newArrayList(patientRepository.findAll());
        for (Patient patient : patients
        ) {
            patient.add(linkTo(GenericController.class).slash("patients").slash(patient.getId()).withSelfRel());
        }
        return patients;
    }

    @GetMapping(value="/Treatmenten", produces = "application/hal+json")
    @CrossOrigin
    List<Treatment> getTreatments(){
        List<Treatment> treatments = Lists.newArrayList(treatmentRepository.findAll());
        for (Treatment treatment : treatments
        ) {
            treatment.add(linkTo(GenericController.class).slash("treatment").slash(treatment.getId()).withSelfRel());
            treatment.add(linkTo(GenericController.class).slash("patients").slash(treatment.getPatient().getId()).withRel("patient"));
        }
        return treatments;
    }
}
