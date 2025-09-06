/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.mesto;

import entity.Mesto;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author user
 */
public class GetMesto extends AbstractGenericOperation {

    List<Mesto> mesta;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        mesta = repository.get(param);
    }

    public List<Mesto> getMesta() {
        return mesta;
    }
    
}
