package com.bisbali.demo.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TREATMENT")
public class Treatment extends RepresentationModel<Treatment> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "patient_id")
    private Patient patient;

    private String diagnos;
}
