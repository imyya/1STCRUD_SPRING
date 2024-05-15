package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Data permet de creer les getters et setters pr tous les fields

public class Profil {

    public Profil(String libelle, String code){
        this.libelle=libelle;
        this.code=code;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String libelle;

    @Getter
    @Setter
    private String code;




}
