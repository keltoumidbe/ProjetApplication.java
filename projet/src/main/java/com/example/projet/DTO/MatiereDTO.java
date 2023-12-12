package com.example.projet.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class MatiereDTO {

    private int id;
    private String nom;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public MatiereDTO(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    public MatiereDTO( String nom) {
        this.id = id;
        this.nom = nom;
    }

    public MatiereDTO() {
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
