package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "\"user\"")

public class User {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long Id;

    @Getter
    @Setter
    private String prenom;
    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String username;

    @ManyToOne
    @JoinColumn(name="profil_id")
    @Setter
    @Getter
    private Profil profil;
}
