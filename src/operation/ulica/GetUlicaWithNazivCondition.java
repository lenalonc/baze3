/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.ulica;

import entity.Mesto;
import entity.Ulica;
import java.util.List;
import operation.AbstractGenericOperation;
import validator.IValidator;
import validator.RegularValidator;

/**
 *
 * @author user
 */
public class GetUlicaWithNazivCondition extends AbstractGenericOperation {

    List<Ulica> ulica;
    IValidator validator;

    @Override
    protected void preconditions(Object param) throws Exception {
        validator = new RegularValidator();
        validator.validateGetUlicaWithNazivCondition((Ulica) param);
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Mesto mesto = ((Ulica) param).getMesto();
        ulica = repository.getWithCondition(param, new Ulica().getWhereClause(mesto, (Ulica) param));
    }

    public Ulica getUlica() {
        if (ulica != null && !ulica.isEmpty()) {
            return ulica.get(0);
        }
        return null;
    }
}
