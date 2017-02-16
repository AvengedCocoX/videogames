/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicacionesweb.videogames.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AvengedCocoX
 */
@Entity
@Table(name = "valoration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoration.findAll", query = "SELECT v FROM Valoration v"),
    @NamedQuery(name = "Valoration.findByIdValoration", query = "SELECT v FROM Valoration v WHERE v.idValoration = :idValoration"),
    @NamedQuery(name = "Valoration.findByScore", query = "SELECT v FROM Valoration v WHERE v.score = :score"),
    @NamedQuery(name = "Valoration.findByValorationDate", query = "SELECT v FROM Valoration v WHERE v.valorationDate = :valorationDate")})
public class Valoration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_valoration")
    private Integer idValoration;
    @Basic(optional = false)
    @NotNull
    @Column(name = "score")
    private double score;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valoration_date")
    @Temporal(TemporalType.DATE)
    private Date valorationDate;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;
    @JoinColumn(name = "id_game", referencedColumnName = "id_game")
    @ManyToOne(optional = false)
    private Game idGame;

    public Valoration() {
    }

    public Valoration(Integer idValoration) {
        this.idValoration = idValoration;
    }

    public Valoration(Integer idValoration, double score, String comment, Date valorationDate) {
        this.idValoration = idValoration;
        this.score = score;
        this.comment = comment;
        this.valorationDate = valorationDate;
    }

    public Integer getIdValoration() {
        return idValoration;
    }

    public void setIdValoration(Integer idValoration) {
        this.idValoration = idValoration;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getValorationDate() {
        return valorationDate;
    }

    public void setValorationDate(Date valorationDate) {
        this.valorationDate = valorationDate;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Game getIdGame() {
        return idGame;
    }

    public void setIdGame(Game idGame) {
        this.idGame = idGame;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValoration != null ? idValoration.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoration)) {
            return false;
        }
        Valoration other = (Valoration) object;
        if ((this.idValoration == null && other.idValoration != null) || (this.idValoration != null && !this.idValoration.equals(other.idValoration))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aplicacionesweb.videogames.Valoration[ idValoration=" + idValoration + " ]";
    }
    
}
