/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.broj;

import entity.Broj;
import operation.AbstractGenericOperation;
import validator.IValidator;
import validator.RegularValidator;

/**
 *
 * @author user
 */
public class CreateBroj extends AbstractGenericOperation {

    private Broj broj;
    IValidator validator;

    @Override
    protected void preconditions(Object param) throws Exception {
        validator = new RegularValidator();
        validator.validateCreateBroj((Broj)param);
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        this.broj = (Broj) param;
        repository.create(broj);
    }

    public Broj getBroj() {
        return broj;
    }

}
