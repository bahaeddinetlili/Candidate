package com.microservices.candidate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Candidat implements Serializable {


    private static final long serialVersionUID = 6711457437559348053L;

    @Id
    @GeneratedValue
    private Integer id;

    private String nom;


    private String prenom;



    private String email;

    public Candidat() {
        super();
    }

    public Candidat(String nom) {

        this.nom = nom;

    }

    public Candidat(Integer id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
