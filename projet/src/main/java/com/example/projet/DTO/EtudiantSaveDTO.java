package com.example.projet.DTO;

import com.example.projet.Enums.Genre;

public class EtudiantSaveDTO {

    private String nom;
    private String prenom;
    private String matricule;
    private Genre genre;

    public EtudiantSaveDTO() {
    }

    public EtudiantSaveDTO(String nom, String prenom, String matricule, Genre genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.genre = genre;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
