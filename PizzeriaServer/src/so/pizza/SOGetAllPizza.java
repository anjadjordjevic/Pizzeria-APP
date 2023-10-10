/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.pizza;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Pizza;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOGetAllPizza extends AbstractSO {

    private ArrayList<Pizza> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pizza)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Pizza!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> pice = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Pizza>) (ArrayList<?>) pice;
    }

    public ArrayList<Pizza> getLista() {
        return lista;
    }

}
