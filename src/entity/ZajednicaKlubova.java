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
public class ZajednicaKlubova implements GenericEntity {

    private Long sifraZK;

    private String naziv;

    private String liga;

    private Broj broj;

    public ZajednicaKlubova(Long sifraZk, String naziv){
        this.sifraZK = sifraZk;
        this.naziv = naziv;
    }
    
    public ZajednicaKlubova(Long sifraZK, String naziv, String liga, Broj broj) {
        this.sifraZK = sifraZK;
        this.naziv = naziv;
        this.liga = liga;
        this.broj = broj;
    }

    public Long getSifraZK() {
        return sifraZK;
    }

    public void setSifraZK(Long sifraZK) {
        this.sifraZK = sifraZK;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public Broj getBroj() {
        return broj;
    }

    public void setBroj(Broj broj) {
        this.broj = broj;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.sifraZK);
        hash = 83 * hash + Objects.hashCode(this.naziv);
        hash = 83 * hash + Objects.hashCode(this.liga);
        hash = 83 * hash + Objects.hashCode(this.broj);
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
        final ZajednicaKlubova other = (ZajednicaKlubova) obj;
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.liga, other.liga)) {
            return false;
        }
        if (!Objects.equals(this.sifraZK, other.sifraZK)) {
            return false;
        }
        return Objects.equals(this.broj, other.broj);
    }

    @Override
    public String toString() {
        return "ZajednicaKlubova{" + "sifraZK=" + sifraZK + ", naziv=" + naziv + ", liga=" + liga + ", broj=" + broj + '}';
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
