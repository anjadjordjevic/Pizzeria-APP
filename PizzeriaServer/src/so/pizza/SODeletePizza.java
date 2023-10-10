/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.pizza;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Pizza;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SODeletePizza extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pizza)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Pizza!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }

}
