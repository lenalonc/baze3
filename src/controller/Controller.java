/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Broj;
import entity.Delegat;
import entity.Mesto;
import entity.Ugovor;
import entity.Ulica;
import java.util.List;
import operation.AbstractGenericOperation;
import operation.broj.CreateBroj;
import operation.broj.GetBrojByVrednost;
import operation.delegat.CreateDelegat;
import operation.delegat.DeleteDelegat;
import operation.delegat.GetDelegat;
import operation.delegat.GetDelegatById;
import operation.delegat.UpdateDelegat;
import operation.mesto.GetMesto;
import operation.ugovor.GetUgovor;
import operation.ulica.CreateUlica;
import operation.ulica.GetUlicaWithMestoCondition;
import operation.ulica.GetUlicaWithNazivCondition;

/**
 *
 * @author user
 */
public class Controller {

    private static Controller instance;
    private AbstractGenericOperation operation;

    public Controller() {

    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public List<Ugovor> getUgovor(Object object) throws Exception {
        operation = new GetUgovor();
        operation.execute(object);
        return ((GetUgovor) operation).getUgovori();
    }

    public List<Delegat> getDelegat(Object object) throws Exception {
        operation = new GetDelegat();
        operation.execute(object);
        return ((GetDelegat) operation).getDelegati();
    }

    public List<Mesto> getMesto(Object object) throws Exception {
        operation = new GetMesto();
        operation.execute(object);
        return ((GetMesto) operation).getMesta();
    }

    public List<Ulica> getUlicaWithMestoCondition(Object object) throws Exception {
        operation = new GetUlicaWithMestoCondition();
        operation.execute(object);
        return ((GetUlicaWithMestoCondition) operation).getUlice();
    }

    public Ulica getUlicaWithNazivCondition(Ulica object) throws Exception {
        operation = new GetUlicaWithNazivCondition();
        operation.execute(object);
        return ((GetUlicaWithNazivCondition) operation).getUlica();
    }

    public Broj getBrojByVrednost(Broj broj) throws Exception {
        operation = new GetBrojByVrednost();
        operation.execute(broj);
        return ((GetBrojByVrednost) operation).getBroj();
    }

    public Delegat getDelegatById(Delegat delegat) throws Exception {
        operation = new GetDelegatById();
        operation.execute(delegat);
        return ((GetDelegatById) operation).getDelegat();
    }

    public Broj createBroj(Broj broj) throws Exception {
        operation = new CreateBroj();
        operation.execute(broj);
        return ((CreateBroj) operation).getBroj();
    }

    public Delegat createDelegat(Delegat delegat) throws Exception {
        operation = new CreateDelegat(delegat);
        operation.execute(delegat);
        return ((CreateDelegat) operation).getDelegat();
    }

    public Ulica createUlica(Ulica ulica) throws Exception {
        operation = new CreateUlica();
        operation.execute(ulica);
        return ((CreateUlica) operation).getUlica();
    }

    public boolean deleteDelegat(Delegat delegat) throws Exception {
        operation = new DeleteDelegat();
        operation.execute(delegat);
        return ((DeleteDelegat) operation).isFlag();
    }

    public Delegat updateDelegat(Delegat delegat) throws Exception {
        operation = new UpdateDelegat();
        operation.execute(delegat);
        return ((UpdateDelegat) operation).getDelegat();
    }
}
