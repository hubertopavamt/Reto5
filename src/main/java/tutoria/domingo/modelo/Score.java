/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "score")
public class Score implements Serializable{
        @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer score;
    private String messageText;
    
    @OneToOne
    @JoinColumn(name="id")    
    @JsonIgnoreProperties({"scores","reservations"})
    private Reservacion reservation;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Reservacion getReservation() {
        return reservation;
    }

    public void setReservation(Reservacion reservation) {
        this.reservation = reservation;
    }
    
    
}
