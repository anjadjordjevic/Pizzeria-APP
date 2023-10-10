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
public class StavkaRacuna extends AbstractDomainObject {

    private Racun racun;
    private int rbStavke;
    private int kolicinaStavke;
    private double cenaStavke;
    private Pizza pizza;

    public StavkaRacuna(Racun racun, int rbStavke, int kolicinaStavke, double cenaStavke, Pizza pizza) {
        this.racun = racun;
        this.rbStavke = rbStavke;
        this.kolicinaStavke = kolicinaStavke;
        this.cenaStavke = cenaStavke;
        this.pizza = pizza;
    }

    public StavkaRacuna() {
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    public int getKolicinaStavke() {
        return kolicinaStavke;
    }

    public void setKolicinaStavke(int kolicinaStavke) {
        this.kolicinaStavke = kolicinaStavke;
    }

    public double getCenaStavke() {
        return cenaStavke;
    }

    public void setCenaStavke(double cenaStavke) {
        this.cenaStavke = cenaStavke;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String nazivTabele() {
        return " stavkaRacuna ";
    }

    @Override
    public String alijas() {
        return " sr ";
    }

    @Override
    public String join() {
        return " JOIN RACUN R USING (RACUNID) "
                + "JOIN PIZZA P USING (PIZZAID) "
                + "JOIN VRSTAPIZZE VP ON (VP.VRSTAPIZZEID = P.VRSTAPIZZEID) "
                + "JOIN ADMIN A ON (A.ADMINID = R.ADMINID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Admin a = new Admin(rs.getLong("AdminID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));
            
            Racun r = new Racun(rs.getLong("RacunID"), rs.getTimestamp("Vreme"), 
                    rs.getDouble("Cena"), rs.getDouble("KolicinskiRabat"), 
                    rs.getDouble("KonacnaCena"), a, null);
            
            VrstaPizze ts = new VrstaPizze(rs.getLong("VrstaPizzeID"),
                    rs.getString("NazivVrste"));

            Pizza sl = new Pizza(rs.getLong("PizzaID"), rs.getString("Naziv"),
                    rs.getDouble("CenaPoKomadu"), rs.getString("Opis"), ts, null);
            
            StavkaRacuna sr = new StavkaRacuna(r, rs.getInt("RB"), 
                    rs.getInt("Kolicina"), rs.getDouble("Cena"), sl);

            lista.add(sr);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (racunID, rb, kolicina, cena, pizzaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " racunID = " + racun.getRacunID();
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + racun.getRacunID() + ", " + rbStavke + ", "
                + kolicinaStavke + ", " + cenaStavke + ", " + pizza.getPizzaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return " WHERE R.RACUNID = " + racun.getRacunID();
    }

}
