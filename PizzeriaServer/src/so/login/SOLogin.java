/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.login;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Admin;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOLogin extends AbstractSO {
    
    Admin admin;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Admin)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Admin!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        Admin a = (Admin) ado;

        ArrayList<Admin> administratori
                = (ArrayList<Admin>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Admin administrator : administratori) {
            if (administrator.getUsername().equals(a.getUsername())
                    && administrator.getPassword().equals(a.getPassword())) {
                admin = administrator;
                return;
            }
        }

        throw new Exception("Ne postoji admin sa ovim korisnickim imenom ili lozinkom.");
        
    }

    public Admin getAdmin() {
        return admin;
    }
    
    

}
