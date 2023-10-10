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
public class Admin extends AbstractDomainObject {

    private Long adminID;
    private String ime;
    private String prezime;
    private String username;
    private String password;

    public Admin() {
    }

    public Admin(Long adminID, String ime, String prezime, String username, String password) {
        this.adminID = adminID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    public Long getAdminID() {
        return adminID;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String nazivTabele() {
        return " admin ";
    }

    @Override
    public String alijas() {
        return " a ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Admin a = new Admin(rs.getLong("AdminID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            lista.add(a);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Ime, Prezime, Username, Password) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " AdminID = " + adminID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', "
                + "'" + username + "', '" + password + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " Ime = '" + ime + "', Prezime = '" + prezime + "', "
                + "Username = '" + username + "', Password = '" + password + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }

}
