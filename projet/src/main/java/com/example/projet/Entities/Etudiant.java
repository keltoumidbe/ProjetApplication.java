package com.example.projet.Entities;

import com.example.projet.Enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="etudiant")
public class Etudiant {
    @Id
    @Column(name= "etudiantid")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long etudiantid;
    @Column(name= "nom")
    private String nom;
    @Column(name= "prenom")
    private String prenom;
    @Column(name= "matricule")
    private String matricule;
    @Column(name= "genre")
    private Genre genre;

    public Etudiant() {

    }
    public Etudiant(Long etudiantid, String nom, String prenom, String matricule, Genre  genre) {
        this.etudiantid = etudiantid;
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.genre = genre;
    }

    public Etudiant(String nom, String prenom, String matricule, Genre  genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.genre = genre;
    }

}

