/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
@Table
public class Poder {
    @Id
    @GeneratedValue
    Integer idPoder;
    
    @Column
    String tipus;
    
    @Column
    String caracteristiques;
    
    @ManyToMany(
            fetch=FetchType.LAZY,
            mappedBy="poders")
    Set <Especie> especies=new HashSet <Especie>();

    public Poder() {
    }

    public Poder(Integer idPoder, String tipus, String caracteristiques) {
        this.idPoder = idPoder;
        this.tipus = tipus;
        this.caracteristiques = caracteristiques;
    }

    public Integer getIdPoder() {
        return idPoder;
    }

    public void setIdPoder(Integer idPoder) {
        this.idPoder = idPoder;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(String caracteristiques) {
        this.caracteristiques = caracteristiques;
    }
    
    
}
