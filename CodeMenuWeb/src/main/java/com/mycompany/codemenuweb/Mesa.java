/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codemenuweb;

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
 * @author macas
 */
@Entity
@Table(name = "mesa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesa.findAll", query = "SELECT m FROM Mesa m")
    , @NamedQuery(name = "Mesa.findById", query = "SELECT m FROM Mesa m WHERE m.id = :id")
    , @NamedQuery(name = "Mesa.findByIdentificacao", query = "SELECT m FROM Mesa m WHERE m.identificacao = :identificacao")
    , @NamedQuery(name = "Mesa.findByQrcode", query = "SELECT m FROM Mesa m WHERE m.qrcode = :qrcode")})
public class Mesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "identificacao")
    private String identificacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "qrcode")
    private String qrcode;
    @JoinColumn(name = "estabelecimento_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Estabelecimentos estabelecimentoId;

    public Mesa() {
    }

    public Mesa(Integer id) {
        this.id = id;
    }

    public Mesa(Integer id, String identificacao, String qrcode) {
        this.id = id;
        this.identificacao = identificacao;
        this.qrcode = qrcode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public Estabelecimentos getEstabelecimentoId() {
        return estabelecimentoId;
    }

    public void setEstabelecimentoId(Estabelecimentos estabelecimentoId) {
        this.estabelecimentoId = estabelecimentoId;
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
        if (!(object instanceof Mesa)) {
            return false;
        }
        Mesa other = (Mesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.codemenuweb.Mesa[ id=" + id + " ]";
    }
    
}
