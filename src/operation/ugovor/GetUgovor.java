/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.ugovor;

import entity.Ugovor;
import java.util.List;
import operation.AbstractGenericOperation;

/**
 *
 * @author user
 */
public class GetUgovor extends AbstractGenericOperation {

    List<Ugovor> ugovori;

    @Override
    protected void preconditions(Object param) throws Exception {
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        ugovori = repository.get((Ugovor) param);
    }

    public List<Ugovor> getUgovori() {
        return ugovori;
    }

}
