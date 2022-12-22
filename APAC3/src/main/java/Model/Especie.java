/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Especie {
    @Id
    @GeneratedValue
    Integer idEspecie;
    
    @Column
    Integer puntsVida;
    
    @Column
    String tipus;
    
    @OneToMany(
            mappedBy="especie",
            fetch=FetchType.LAZY)
    Set <Personatge> personatges=new HashSet<Personatge>();
    
    @ManyToMany(
            fetch=FetchType.LAZY
    )
    @JoinTable(
            name="Controla",
            joinColumns = {@JoinColumn(
                name="especie",
                foreignKey = @ForeignKey(name = "FK_CON_ESP" ))},
            inverseJoinColumns = {@JoinColumn(
                name="poder",
                foreignKey = @ForeignKey(name = "FK_CON_POD" ))})
    Set <Poder> poders = new HashSet <Poder>();

    public Especie() {
    }

    public Especie(Integer idEspecie, Integer puntsDeVida, String tipus) {
        this.idEspecie = idEspecie;
        this.puntsVida = puntsDeVida;
        this.tipus = tipus;
    }

    public Integer getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Integer idEspecie) {
        this.idEspecie = idEspecie;
    }

    public Integer getPuntsDeVida() {
        return puntsVida;
    }

    public void setPuntsDeVida(Integer puntsDeVida) {
        this.puntsVida = puntsDeVida;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    
    
}
