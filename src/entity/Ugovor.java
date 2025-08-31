/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.sql.Struct;

/**
 *
 * @author user
 */
public class Ugovor implements GenericEntity {

    private Long sifraUgovora;

    private LocalDate datum;

    private String liga;

    private Mesto mesto;

    private Delegat delegat;

    private ZajednicaKlubova zk;
    
    public Ugovor(){
        
    }

    public Ugovor(Long sifraUgovora, LocalDate datum, String liga, Mesto mesto, Delegat delegat, ZajednicaKlubova zk) {
        this.sifraUgovora = sifraUgovora;
        this.datum = datum;
        this.liga = liga;
        this.mesto = mesto;
        this.delegat = delegat;
        this.zk = zk;
    }

    public Long getSifraUgovora() {
        return sifraUgovora;
    }

    public void setSifraUgovora(Long sifraUgovora) {
        this.sifraUgovora = sifraUgovora;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public Delegat getDelegat() {
        return delegat;
    }

    public void setDelegat(Delegat delegat) {
        this.delegat = delegat;
    }

    public ZajednicaKlubova getZk() {
        return zk;
    }

    public void setZk(ZajednicaKlubova zk) {
        this.zk = zk;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    @Override
    public String toString() {
        return "Ugovor{" + "sifraUgovora=" + sifraUgovora + ", datum=" + datum + ", liga=" + liga + ", mesto=" + mesto + ", delegat=" + delegat + ", zk=" + zk + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.sifraUgovora);
        hash = 97 * hash + Objects.hashCode(this.datum);
        hash = 97 * hash + Objects.hashCode(this.liga);
        hash = 97 * hash + Objects.hashCode(this.mesto);
        hash = 97 * hash + Objects.hashCode(this.delegat);
        hash = 97 * hash + Objects.hashCode(this.zk);
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
        final Ugovor other = (Ugovor) obj;
        if (!Objects.equals(this.liga, other.liga)) {
            return false;
        }
        if (!Objects.equals(this.sifraUgovora, other.sifraUgovora)) {
            return false;
        }
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        if (!Objects.equals(this.mesto, other.mesto)) {
            return false;
        }
        if (!Objects.equals(this.delegat, other.delegat)) {
            return false;
        }
        return Objects.equals(this.zk, other.zk);
    }

    public String getTableName() {
        return "ugovor";
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
        return "select u.sifra_ugovora, u.datum, u.liga, zk.sifra_zk, zk.naziv as zk_naziv, d.iddelegat, d.imeprezime.puno_ime() as d_imeprezime, m.idmesto, m.naziv as m_naziv, o.idopstina, o.naziv as o_naziv "
                + "from ugovor u left join delegat d on d.iddelegat = u.iddelegat left join zajednica_klubova zk on zk.sifra_zk = u.sifra_zk left join mesto m on m.idmesto = u.idmesto and m.idopstina = u.idopstina left join "
                + "opstina o on o.idopstina = u.idopstina";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {

        
        String punoIme = rs.getString("d_imeprezime");
        
        return new Ugovor(rs.getLong("sifra_ugovora"), rs.getDate("datum").toLocalDate(), rs.getString("liga"), 
                new Mesto(rs.getLong("idmesto"), new Opstina(rs.getLong("idopstina"), rs.getString("o_naziv")), rs.getString("m_naziv")), 
                new Delegat(rs.getLong("iddelegat"), punoIme), 
                new ZajednicaKlubova(rs.getLong("sifra_zk"), rs.getString("zk_naziv")));
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
