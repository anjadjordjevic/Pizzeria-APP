/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.pizza;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Sastojak;
import domain.Pizza;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOUpdatePizza extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pizza)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Pizza!");
        }

        Pizza s = (Pizza) ado;

        if (s.getCena() < 100 || s.getCena() > 15000) {
            throw new Exception("Cena pice mora biti izmedju 100din i 15000din!");
        }

        if (s.getSastojci().isEmpty()) {
            throw new Exception("Pica mora imati barem jedan sastojak!");
        }

        ArrayList<Pizza> pice = (ArrayList<Pizza>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Pizza pp : pice) {
            if (!pp.getPizzaID().equals(s.getPizzaID())) {
                if (pp.getNazivPizze().equals(s.getNazivPizze())) {
                    throw new Exception("Već postoji pica s ovim nazivom!");
                }
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        DBBroker.getInstance().update(ado);

        Pizza s = (Pizza) ado;
        
        DBBroker.getInstance().delete(s.getSastojci().get(0));
      
        for (Sastojak sastojak : s.getSastojci()) {
            DBBroker.getInstance().insert(sastojak);
        }

    }

}
