/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Haadi
 */
@Entity
@Table(name = "meddelandet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meddelandet.findAll", query = "SELECT m FROM Meddelandet m")
    , @NamedQuery(name = "Meddelandet.findById", query = "SELECT m FROM Meddelandet m WHERE m.id = :id")
    , @NamedQuery(name = "Meddelandet.findBySubject", query = "SELECT m FROM Meddelandet m WHERE m.subject = :subject")
    , @NamedQuery(name = "Meddelandet.findByContent", query = "SELECT m FROM Meddelandet m WHERE m.content = :content")})
public class Meddelandet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "content")
    private String content;
    @JoinColumn(name = "reciever", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User reciever;
    @JoinColumn(name = "sender", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User sender;

    public Meddelandet() {
    }

    public Meddelandet(Integer id) {
        this.id = id;
    }

    public Meddelandet(Integer id, String subject, String content) {
        this.id = id;
        this.subject = subject;
        this.content = content;
    }
    
    public Meddelandet(String subject, String content, User sender, User reciever) {
        this.subject = subject;
        this.content = content;
        this.sender = sender;
        this.reciever = reciever;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getReciever() {
        return reciever;
    }

    public void setReciever(User reciever) {
        this.reciever = reciever;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meddelandet)) {
            return false;
        }
        Meddelandet other = (Meddelandet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Meddelandet[ id=" + id + " ]";
    }
    
}
