/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class VrstaPizze extends AbstractDomainObject {
    
    private Long vrstaPizzeID;
    private String nazivVrstePizze;
    
    @Override
    public String toString() {
        return nazivVrstePizze;
    }

    public VrstaPizze(Long vrstaPizzeID, String nazivVrstePizze) {
        this.vrstaPizzeID = vrstaPizzeID;
        this.nazivVrstePizze = nazivVrstePizze;
    }
    
    
    public VrstaPizze() {
    }
    
    @Override
    public String nazivTabele() {
        return " VrstaPizze ";
    }
    
    @Override
    public String alijas() {
        return " vp ";
    }
    
    @Override
    public String join() {
        return "";
    }
    
    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        
        while (rs.next()) {
            VrstaPizze p = new VrstaPizze(rs.getLong("VrstaPizzeID"),
                    rs.getString("NazivVrste"));

            lista.add(p);
        }
        
        rs.close();
        return lista;
    }
    
    @Override
    public String koloneZaInsert() {
        return "";
    }
    
    @Override
    public String vrednostZaPrimarniKljuc() {
        return " vrstaPizzeID = " + vrstaPizzeID;
    }
    
    @Override
    public String vrednostiZaInsert() {
        return "";
    }
    
    @Override
    public String vrednostiZaUpdate() {
        return "";
    }
    
    @Override
    public String uslov() {
        return "";
    }
    
    public Long getVrstaPizzeID() {
        return vrstaPizzeID;
    }
    
    public void setVrstaPizzeID(Long vrstaPizzeID) {
        this.vrstaPizzeID = vrstaPizzeID;
    }
    
    public String getNazivVrstePizze() {
        return nazivVrstePizze;
    }
    
    public void setNazivVrstePizze(String nazivVrstePizze) {
        this.nazivVrstePizze = nazivVrstePizze;
    }
    
}
