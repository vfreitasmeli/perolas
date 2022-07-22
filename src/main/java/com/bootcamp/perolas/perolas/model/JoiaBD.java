package com.bootcamp.perolas.perolas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "joias")
public class JoiaBD {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long numero_id;

    @Column(length = 50, nullable = false)
    String material;

    @Column(nullable = false)
    double peso;

    @Column(nullable = false)
    int quilates;
}
