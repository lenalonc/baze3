/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Ugovor;
import java.util.List;
import operation.AbstractGenericOperation;
import operation.ugovor.GetUgovor;

/**
 *
 * @author user
 */
public class Controller {

    public static Controller instance;
    private AbstractGenericOperation operation;

    public Controller() {

    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    
    public List<Ugovor> getUgovor(Object object)throws Exception{
        operation = new GetUgovor();
        operation.execute(object);
        return ((GetUgovor)operation).getUgovori();
    }
}
