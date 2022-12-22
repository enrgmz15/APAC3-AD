/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Jugador {
    @Id
    @GeneratedValue
    private Integer idPlayer;
    @Column
    private String nom;
    @Column
    private Integer nivell;
    @OneToOne
    @JoinColumn(
            name="personatge",
            referencedColumnName = "idPersonatge",
            unique=true,
            foreignKey = @ForeignKey(name = "FK_PRS"))
    private Personatge personatge;

    public Jugador(Integer idPlayer, String nom, Integer nivell, Personatge personatge) {
        this.idPlayer = idPlayer;
        this.nom = nom;
        this.nivell = nivell;
        this.personatge = personatge;
    }

    public Jugador() {
    }
    
    
    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNivell() {
        return nivell;
    }

    public void setNivell(Integer nivell) {
        this.nivell = nivell;
    }

    public Personatge getPersonatge() {
        return personatge;
    }

    public void setPersonatge(Personatge personatge) {
        this.personatge = personatge;
    }

    @Override
    public String toString() {
        return "PlayerID:" + idPlayer + " Nickname:" + nom + " Level:" + nivell;
    }


    
    
}
