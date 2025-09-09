/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.delegat;

import entity.Delegat;
import operation.AbstractGenericOperation;

/**
 *
 * @author user
 */
public class GetDelegatById extends AbstractGenericOperation{

    private Delegat delegat;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if(((Delegat)param).getIdDelegat() == null){
            throw new Exception("Id delegata nije pronadjen");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        delegat = (Delegat) repository.getById(param);
    }

    public Delegat getDelegat() {
        return delegat;
    }
    
}
