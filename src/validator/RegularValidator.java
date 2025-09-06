/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import entity.Broj;
import entity.Delegat;
import entity.Ulica;

/**
 *
 * @author user
 */
public class RegularValidator implements IValidator {

    @Override
    public void validateCreateDelegat(Delegat delegat) throws ValidatorException {
        if (delegat.getImePrezime() == null || delegat.getImePrezime().isBlank()) {
            throw new ValidatorException("Unesite ime i prezime delegata");
        }
        if (delegat.getJmbg() == null || delegat.getJmbg().length() != 13 || !delegat.getJmbg().chars().allMatch(Character::isDigit)) {
            throw new ValidatorException("JMBG delegata mora da sadrzi 13 cifara");
        }
        if (delegat.getZaposlenostStatus() == null) {
            throw new ValidatorException("Unesite status zaposlenja delegata");
        }

        if (delegat.getBroj() == null || delegat.getBroj().getIdBroj() == null || delegat.getBroj().getUlica() == null
                || delegat.getBroj().getUlica().getIdUlica() == null || delegat.getBroj().getUlica().getMesto() == null
                || delegat.getBroj().getUlica().getMesto().getIdMesto() == null || delegat.getBroj().getUlica().getMesto().getOpstina() == null
                || delegat.getBroj().getUlica().getMesto().getOpstina().getIdOpstina() == null) {
            throw new ValidatorException("Unesite adresu delegata");
        }

    }

    @Override
    public void validateGetUlicaWIthMestoCondition(Ulica ulica) throws ValidatorException {
        if (ulica == null || ulica.getMesto() == null || ulica.getMesto().getIdMesto() == null) {
            throw new ValidatorException("Unesite validan grad");
        } else if (ulica.getMesto().getOpstina() == null || ulica.getMesto().getOpstina().getIdOpstina() == null) {
            throw new ValidatorException("Opstina nije registrovna");
        }
    }

    @Override
    public void validateGetBrojByNaziv(String naziv) throws ValidatorException {
        if (naziv == null || naziv.equals("")) {
            throw new ValidatorException("Vrednost broja ne sme biti prazna");
        }
    }

    @Override
    public void validateCreateBroj(Broj broj) throws ValidatorException {
        if (broj == null || broj.getVrednost() == null || broj.getVrednost().isEmpty() || !broj.getVrednost().chars().allMatch(Character::isDigit)) {
            throw new ValidatorException("Upsite validan broj");
        } else if (broj.getUlica() == null || broj.getUlica().getIdUlica() == null) {
            throw new ValidatorException("Izaberite validnu ulicu");
        } else if (broj.getUlica().getMesto() == null || broj.getUlica().getMesto().getIdMesto() == null) {
            throw new ValidatorException("Izaberite validni grad");
        } else if (broj.getUlica().getMesto().getOpstina() == null || broj.getUlica().getMesto().getOpstina().getIdOpstina() == null) {
            throw new ValidatorException("Izaberite validnu opstinu");
        }
    }

    @Override
    public void validateGetUlicaWithNazivCondition(Ulica ulica) throws ValidatorException {
        if (ulica == null || ulica.getNaziv() == null || ulica.getNaziv().isEmpty()) {
            throw new ValidatorException("Unesite naziv ulice");
        } else if (ulica.getMesto() == null || ulica.getMesto().getIdMesto() == null) {
            throw new ValidatorException("Unesite validan grad");
        } else if (ulica.getMesto().getOpstina() == null || ulica.getMesto().getOpstina().getIdOpstina() == null) {
            throw new ValidatorException("Opstina nije registrovna");
        }
    }

    @Override
    public void validateCreateUlica(Ulica ulica) throws ValidatorException {
        if (ulica == null || ulica.getNaziv() == null || ulica.getNaziv().isEmpty()) {
            throw new ValidatorException("Unesite naziv ulice");
        } else if (ulica.getMesto() == null || ulica.getMesto().getIdMesto() == null) {
            throw new ValidatorException("Unesite validan grad");
        } else if (ulica.getMesto().getOpstina() == null || ulica.getMesto().getOpstina().getIdOpstina() == null) {
            throw new ValidatorException("Opstina nije registrovna");
        }
    }

}
