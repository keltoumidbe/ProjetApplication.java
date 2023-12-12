package com.example.projet.DTO;

public class MatiereSaveDTO {


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

    public MatiereSaveDTO( String nom) {
        this.nom = nom;
    }

    public MatiereSaveDTO() {
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}

