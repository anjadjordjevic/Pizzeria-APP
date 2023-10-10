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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOAddPizza extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pizza)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Pizza!");
        }

        Pizza s = (Pizza) ado;

        if (s.getCena() < 100 || s.getCena() > 15000) {
            throw new Exception("Cena pice mora biti između 100din i 15000din!");
        }

        if (s.getSastojci().isEmpty()) {
            throw new Exception("Pica mora imati barem jedan sastojak!");
        }

        ArrayList<Pizza> pice = (ArrayList<Pizza>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Pizza p : pice) {
            if (p.getNazivPizze().equals(s.getNazivPizze())) {
                throw new Exception("Već postoji pica sa ovim nazivom!");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        
        PreparedStatement ps = DBBroker.getInstance().insert(ado);

        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long pizza = tableKeys.getLong(1);

        Pizza s = (Pizza) ado;
        s.setPizzaID(pizza);

        for (Sastojak sastojak : s.getSastojci()) {
            sastojak.setPizza(s);
            DBBroker.getInstance().insert(sastojak);
        }

    }

}
