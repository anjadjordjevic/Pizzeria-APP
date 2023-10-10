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
public class Sastojak extends AbstractDomainObject {

    private Pizza pizza;
    private int rbSastojka;
    private String nazivSastojka;

    public Sastojak(Pizza pizza, int rbSastojka, String nazivSastojka) {
        this.pizza = pizza;
        this.rbSastojka = rbSastojka;
        this.nazivSastojka = nazivSastojka;
    }

    public Sastojak() {
    }

    @Override
    public String nazivTabele() {
        return " sastojak ";
    }

    @Override
    public String alijas() {
        return " s ";
    }

    @Override
    public String join() {
        return " JOIN PIZZA P ON (P.PIZZAID = S.PIZZAID) "
                + "JOIN VRSTAPIZZE VP ON (VP.VRSTAPIZZEID = P.VRSTAPIZZEID)";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            
            VrstaPizze ts = new VrstaPizze(rs.getLong("VrstaPizzeID"),
                    rs.getString("NazivVrste"));

            Pizza sl = new Pizza(rs.getLong("PizzaID"), rs.getString("Naziv"),
                    rs.getDouble("CenaPoKomadu"), rs.getString("Opis"), ts, null);

            Sastojak s = new Sastojak(sl, rs.getInt("Rbr"), rs.getString("NazivSastojka"));
            
            lista.add(s);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (pizzaID, rbr, nazivSastojka) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " pizzaID = " + pizza.getPizzaID();
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + pizza.getPizzaID()+ ", " + rbSastojka + ", "
                + "'" + nazivSastojka + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return " WHERE P.PIZZAID = " + pizza.getPizzaID();
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getRbSastojka() {
        return rbSastojka;
    }

    public void setRbSastojka(int rbSastojka) {
        this.rbSastojka = rbSastojka;
    }

    public String getNazivSastojka() {
        return nazivSastojka;
    }

    public void setNazivSastojka(String nazivSastojka) {
        this.nazivSastojka = nazivSastojka;
    }

}
