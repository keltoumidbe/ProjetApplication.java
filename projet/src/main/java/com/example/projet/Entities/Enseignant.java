package com.example.projet.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "enseignant")
public class Enseignant {
    @Id
    @Column(name="id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    @Column(name = "nom_enseignant",length = 50)
    private String nom;

    @Column(name = "prenom_enseignant",length = 50)
    private String prenom;
    @Column(name = "email_enseignant",length = 80)
    private String email;
    public Enseignant(){
        super();
    }

    @Override
    public String toString() {
        return "Enseignant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    public Enseignant(int id,String nom, String prenom, String email) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
    public Enseignant(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

}
