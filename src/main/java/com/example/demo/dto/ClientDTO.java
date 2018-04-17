package com.example.demo.dto;


/**
 * Created by Kayne on 09/04/2018.
 */
public class ClientDTO {

    private String prenom;

    private String nom;
    
    private int age;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
