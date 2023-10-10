/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.admin;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Admin;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOAddAdmin extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Admin)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Admin!");
        }

        Admin a = (Admin) ado;

        ArrayList<Admin> admini
                = (ArrayList<Admin>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Admin aa : admini) {
            if (aa.getUsername().equals(a.getUsername())) {
                throw new Exception("Već postoji admin sa ovim korisničkim imenom!");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }

}
