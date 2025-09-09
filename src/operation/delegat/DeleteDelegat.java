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
public class DeleteDelegat extends AbstractGenericOperation {

    boolean flag = false;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (((Delegat) param).getIdDelegat() == null) {
            throw new Exception("Delegat nema id");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        flag = repository.delete(param);
    }

    public boolean isFlag() {
        return flag;
    }

}
