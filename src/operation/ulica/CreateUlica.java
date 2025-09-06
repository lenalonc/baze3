/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.ulica;

import entity.Ulica;
import operation.AbstractGenericOperation;
import validator.IValidator;
import validator.RegularValidator;

/**
 *
 * @author user
 */
public class CreateUlica extends AbstractGenericOperation {

    private Ulica ulica;
    IValidator validator;

    @Override
    protected void preconditions(Object param) throws Exception {
        validator = new RegularValidator();
        validator.validateCreateUlica((Ulica) param);
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        ulica = (Ulica) repository.create(param);
    }

    public Ulica getUlica() {
        return ulica;
    }

}
