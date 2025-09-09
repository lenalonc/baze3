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

    private String jmbg;

    private ZaposlenostStatusEnum zaposlenostStatus;

    private Broj broj;

    public Delegat() {

    }

    public Delegat(Long idDelegat, String imePrezime) {
        this.idDelegat = idDelegat;
        this.imePrezime = imePrezime;
    }

    public Delegat(Long idDelegat, String imePrezime, String jmbg, ZaposlenostStatusEnum zaposlenostStatus, Broj broj) {
        this.idDelegat = idDelegat;
        this.imePrezime = imePrezime;
        this.jmbg = jmbg;
        this.zaposlenostStatus = zaposlenostStatus;
        this.broj = broj;
    }

    public Long getIdDelegat() {
        return idDelegat;
    }

    public void setIdDelegat(Long idDelegat) {
        this.idDelegat = idDelegat;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
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
        return "delegat";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "(iddelegat, imeprezime, jmbg, zaposlenoststatus, idbroj, idulica, idmesto, idopstina)";
    }

    @Override
    public String getInsertValues() {
        String[] ime_prezime = imePrezime.split(" ");
        String ime = ime_prezime[0];
        String prezime = ime_prezime[1];
        StringBuilder sb = new StringBuilder();
        sb.append("(")
                .append("delegat_pk_seq.nextval,")
                .append("imeprezime('").append(ime).append("','").append(prezime).append("'),")
                .append("jmbg_id('").append(jmbg).append("'),")
                .append("'").append(zaposlenostStatus.name()).append("',")
                .append(broj.getIdBroj()).append(",")
                .append(broj.getUlica().getIdUlica()).append(",")
                .append(broj.getUlica().getMesto().getIdMesto()).append(",")
                .append(broj.getUlica().getMesto().getOpstina().getIdOpstina())
                .append(") ")
                .append("returning iddelegat into ?");
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        this.idDelegat = id;
    }

    @Override
    public String getSelectedValues() {
        return "select d.iddelegat, d.imeprezime.puno_ime() as d_imeprezime, d.zaposlenoststatus, d.jmbg.value as jmbg, b.idbroj, b.vrednost as b_vrednost, u.idulica, u.naziv as u_naziv, "
                + "m.idmesto, m.naziv as m_naziv, o.idopstina, o.naziv as o_naziv from delegat d left join broj b on b.idbroj = d.idbroj and b.idulica = d.idulica and b.idmesto = d.idmesto and b.idopstina = d.idopstina left join ulica u on u.idulica = d.idulica "
                + "and u.idmesto = d.idmesto and u.idopstina = d.idopstina "
                + "left join mesto m on m.idmesto = d.idmesto and m.idopstina = d.idopstina left join opstina o on o.idopstina = d.idopstina";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        String zaposlenost = rs.getString("zaposlenoststatus");
        ZaposlenostStatusEnum zEnum;

        if (zaposlenost.toUpperCase().equals(ZaposlenostStatusEnum.ZAPOSLEN.name())) {
            zEnum = ZaposlenostStatusEnum.ZAPOSLEN;
        } else if (zaposlenost.toUpperCase().equals(ZaposlenostStatusEnum.STUDENT.name())) {
            zEnum = ZaposlenostStatusEnum.STUDENT;
        } else if (zaposlenost.toUpperCase().equals(ZaposlenostStatusEnum.PENZIONER.name())) {
            zEnum = ZaposlenostStatusEnum.PENZIONER;
        } else {
            zEnum = ZaposlenostStatusEnum.NEZAPOSLEN;
        }

        return new Delegat(rs.getLong("iddelegat"), rs.getString("d_imeprezime"), rs.getString("jmbg"), zEnum,
                new Broj(rs.getLong("idbroj"), rs.getString("b_vrednost"), new Ulica(rs.getLong("idulica"),
                        new Mesto(rs.getLong("idmesto"),
                                new Opstina(rs.getLong("idopstina"), rs.getString("o_naziv")), rs.getString("m_naziv")), rs.getString("u_naziv"))));
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "iddelegat=" + ((Delegat) object).getIdDelegat();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Delegat delegat = (Delegat) object;
        String[] ime_prezime = imePrezime.split(" ");
        String ime = ime_prezime[0];
        String prezime = ime_prezime[1];
        StringBuilder sb = new StringBuilder();
        sb.append("imeprezime = imeprezime('").append(ime).append("','").append(prezime).append("'),")
                .append("jmbg = jmbg_id('").append(jmbg).append("'),")
                .append("zaposlenoststatus = '").append(delegat.getZaposlenostStatus().name()).append("',")
                .append("idbroj = ").append(delegat.getBroj().getIdBroj()).append(",")
                .append("idulica = ").append(delegat.getBroj().getUlica().getIdUlica()).append(",")
                .append("idmesto = ").append(delegat.getBroj().getUlica().getMesto().getIdMesto()).append(",")
                .append("idopstina = ").append(delegat.getBroj().getUlica().getMesto().getOpstina().getIdOpstina());
        return sb.toString();
    }

}
