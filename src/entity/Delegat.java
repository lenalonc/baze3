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
public class Delegat implements GenericEntity {

    private Long idDelegat;

    private String imePrezime;

    private Long jmbg;

    private ZaposlenostStatusEnum zaposlenostStatus;

    private Broj broj;

    public Delegat(Long idDelegat, String imePrezime) {
        this.idDelegat = idDelegat;
        this.imePrezime = imePrezime;
    }

    public Delegat(Long idDelegat, String imePrezime, Long jmbg, ZaposlenostStatusEnum zaposlenostStatus, Broj broj) {
        this.idDelegat = idDelegat;
        this.imePrezime = imePrezime;
        this.jmbg = jmbg;
        this.zaposlenostStatus = zaposlenostStatus;
        this.broj = broj;
    }

    public Long getIdDelegat() {
        return idDelegat;
    }

    public void setIdDelegat(Long IdDelegat) {
        this.idDelegat = idDelegat;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Long getJmbg() {
        return jmbg;
    }

    public void setJmbg(Long jmbg) {
        this.jmbg = jmbg;
    }

    public ZaposlenostStatusEnum getZaposlenostStatus() {
        return zaposlenostStatus;
    }

    public void setZaposlenostStatus(ZaposlenostStatusEnum zaposlenostStatus) {
        this.zaposlenostStatus = zaposlenostStatus;
    }

    public Broj getBroj() {
        return broj;
    }

    public void setBroj(Broj broj) {
        this.broj = broj;
    }

    @Override
    public String toString() {
        return "Delegat{" + "idDelegat=" + idDelegat + ", imePrezime=" + imePrezime + ", jmbg=" + jmbg + ", zaposlenostStatus=" + zaposlenostStatus + ", broj=" + broj + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idDelegat);
        hash = 97 * hash + Objects.hashCode(this.imePrezime);
        hash = 97 * hash + Objects.hashCode(this.jmbg);
        hash = 97 * hash + Objects.hashCode(this.zaposlenostStatus);
        hash = 97 * hash + Objects.hashCode(this.broj);
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
        final Delegat other = (Delegat) obj;
        if (!Objects.equals(this.imePrezime, other.imePrezime)) {
            return false;
        }
        if (!Objects.equals(this.idDelegat, other.idDelegat)) {
            return false;
        }
        if (!Objects.equals(this.jmbg, other.jmbg)) {
            return false;
        }
        if (this.zaposlenostStatus != other.zaposlenostStatus) {
            return false;
        }
        return Objects.equals(this.broj, other.broj);
    }

    @Override
    public String getTableName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getColumnNamesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInsertValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSelectedValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
