/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.delegat;

import entity.Delegat;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author user
 */
public class GetDelegat extends AbstractGenericOperation {

    List<Delegat> delegati;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        delegati = repository.get(param);
    }

    public List<Delegat> getDelegati() {
        return delegati;
    }

}
