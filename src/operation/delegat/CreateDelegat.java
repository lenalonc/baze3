/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.delegat;

import entity.Delegat;
import operation.AbstractGenericOperation;
import validator.IValidator;
import validator.RegularValidator;

/**
 *
 * @author user
 */
public class CreateDelegat extends AbstractGenericOperation {

    private Delegat delegat;
    IValidator validator;

    public CreateDelegat(Delegat delegat) {
        this.delegat = delegat;
    }

    @Override
    protected void preconditions(Object param) throws Exception {
        validator = new RegularValidator();
        validator.validateCreateDelegat((Delegat) param);
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        delegat = (Delegat) repository.create(param);
    }

    public Delegat getDelegat() {
        return delegat;
    }

}
