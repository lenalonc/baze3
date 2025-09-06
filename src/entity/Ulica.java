/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Ulica implements GenericEntity {

    private Long idUlica;

    private Mesto mesto;

    private String naziv;

    public Ulica() {

    }

    public Ulica(Long idUlica, Mesto mesto, String naziv) {
        this.idUlica = idUlica;
        this.mesto = mesto;
        this.naziv = naziv;
    }

    public Ulica(Long idUlica, Mesto mesto) {
        this.idUlica = idUlica;
        this.mesto = mesto;
    }

    public Long getIdUlica() {
        return idUlica;
    }

    public void setIdUlica(Long idUlica) {
        this.idUlica = idUlica;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idUlica);
        hash = 37 * hash + Objects.hashCode(this.mesto);
        hash = 37 * hash + Objects.hashCode(this.naziv);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ulica other = (Ulica) obj;
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.idUlica, other.idUlica)) {
            return false;
        }
        return Objects.equals(this.mesto, other.mesto);
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getTableName() {
        return "ulica";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "(idulica, naziv, idmesto, idopstina)";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("(")
                .append("ulica_pk_seq.nextval").append(",")
                .append("'").append(naziv).append("',")
                .append(mesto.getIdMesto()).append(",")
                .append(mesto.getOpstina().getIdOpstina())
                .append(") ")
                .append("returning idulica into ?");
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        idUlica = id;
    }

    public String getWhereClause(Mesto mesto, Ulica ulica) {
        StringBuilder sb = new StringBuilder();
        if (ulica != null && ulica.getNaziv() != null) {
            sb.append("u.naziv = '").append(ulica.getNaziv()).append("' and ");
        }
        sb.append("u.idmesto = ").append(mesto.getIdMesto()).append(" and u.idopstina = ").append(mesto.getOpstina().getIdOpstina());
        return sb.toString();
    }

    @Override
    public String getSelectedValues() {
        return "select u.idulica, u.naziv as u_naziv, m.idmesto, m.naziv as m_naziv, o.idopstina, o.naziv as o_naziv from ulica u inner join mesto m on u.idmesto = m.idmesto and u.idopstina = m.idopstina inner join opstina o"
                + " on o.idopstina = u.idopstina";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new Ulica(rs.getLong("idulica"),
                new Mesto(rs.getLong("idmesto"),
                        new Opstina(rs.getLong("idopstina"), rs.getString("o_naziv")), rs.getString("m_naziv")), rs.getString("u_naziv"));
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateSetValues(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
