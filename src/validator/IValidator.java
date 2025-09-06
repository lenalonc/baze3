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
public interface IValidator {
    public void validateCreateDelegat(Delegat delegat) throws ValidatorException;
    
    public void validateGetUlicaWIthMestoCondition(Ulica ulica) throws ValidatorException;
    
    public void validateGetBrojByNaziv(String naziv) throws ValidatorException;
    
    public void validateCreateBroj(Broj broj) throws ValidatorException;
    
    public void validateGetUlicaWithNazivCondition(Ulica ulica) throws ValidatorException;
    
    public void validateCreateUlica(Ulica ulica) throws ValidatorException;
}
