package com.example.projet.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="matiere")
public class Matiere {
    @Id
    @Column(name = "id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name ="nom" ,length =50 )
    private String nom;


    public Matiere(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    public Matiere( String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Matiere() {
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
