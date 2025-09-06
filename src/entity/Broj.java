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
public class Broj implements GenericEntity {

    private Long idBroj;

    private String vrednost;

    private Ulica ulica;

    public Broj() {

    }

    public Broj(Long idBroj, String vrednost, Ulica ulica) {
        this.idBroj = idBroj;
        this.vrednost = vrednost;
        this.ulica = ulica;
    }

    public Broj(Long idBroj, String vrednost) {
        this.idBroj = idBroj;
        this.vrednost = vrednost;
    }

    public Long getIdBroj() {
        return idBroj;
    }

    public void setIdBroj(Long idBroj) {
        this.idBroj = idBroj;
    }

    public String getVrednost() {
        return vrednost;
    }

    public void setVrednost(String vrednost) {
        this.vrednost = vrednost;
    }

    public Ulica getUlica() {
        return ulica;
    }

    public void setUlica(Ulica ulica) {
        this.ulica = ulica;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idBroj);
        hash = 41 * hash + Objects.hashCode(this.vrednost);
        hash = 41 * hash + Objects.hashCode(this.ulica);
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
        final Broj other = (Broj) obj;
        if (!Objects.equals(this.vrednost, other.vrednost)) {
            return false;
        }
        if (!Objects.equals(this.idBroj, other.idBroj)) {
            return false;
        }
        return Objects.equals(this.ulica, other.ulica);
    }

    @Override
    public String toString() {
        return vrednost;
    }

    @Override
    public String getTableName() {
        return "broj";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "(idbroj, vrednost, idulica, idmesto, idopstina)";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("(")
                .append("broj_pk_seq.nextval").append(",")
                .append("'").append(vrednost).append("'").append(",")
                .append(ulica.getIdUlica()).append(",")
                .append(ulica.getMesto().getIdMesto()).append(",")
                .append(ulica.getMesto().getOpstina().getIdOpstina())
                .append(") ")
                .append("returning idbroj into ?");
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        idBroj = id;
    }

    public String getWhereClause(Broj broj) {
        return "b.vrednost = '" + broj.getVrednost() + "' and idulica = " + broj.getUlica().getIdUlica() + " and idmesto = " + broj.getUlica().getMesto().getIdMesto() + " and idopstina = " + broj.getUlica().getMesto().getOpstina().getIdOpstina();
    }

    @Override
    public String getSelectedValues() {
        return "select b.idbroj, b.vrednost, b.idulica, b.idmesto, b.idopstina from broj b";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new Broj(rs.getLong("idbroj"), rs.getString("vrednost"), new Ulica(rs.getLong("idulica"), new Mesto(rs.getLong("idmesto"), new Opstina(rs.getLong("idopstina")))));
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
