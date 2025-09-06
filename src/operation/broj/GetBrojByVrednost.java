/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.broj;

import entity.Broj;
import java.util.List;
import operation.AbstractGenericOperation;
import validator.IValidator;
import validator.RegularValidator;

/**
 *
 * @author user
 */
public class GetBrojByVrednost extends AbstractGenericOperation {

    List<Broj> broj;
    IValidator validator;

    @Override
    protected void preconditions(Object param) throws Exception {
        validator = new RegularValidator();
        validator.validateGetBrojByNaziv(((Broj)param).getVrednost());
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        broj = repository.getWithCondition(param, ((Broj) param).getWhereClause((Broj) param));
    }

    public Broj getBroj() {
        return (broj != null && broj.size() > 0) ? broj.get(0) : null;
    }

}
