/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.admin;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Admin;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SODeleteAdmin extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Admin)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Admin!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }

}
