/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vrstaPizze;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.VrstaPizze;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Korisnik
 */
public class SOGetAllVrstaPizze extends AbstractSO {

    private ArrayList<VrstaPizze> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof VrstaPizze)) {
            throw new Exception("Prosleđeni objekat nije instanca klase VrstaPizze!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> vrstePica = DBBroker.getInstance().select(ado);
        lista = (ArrayList<VrstaPizze>) (ArrayList<?>) vrstePica;
    }

    public ArrayList<VrstaPizze> getLista() {
        return lista;
    }

}
