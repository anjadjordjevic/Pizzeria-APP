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
public class Pizza extends AbstractDomainObject {

    private Long pizzaID;
    private String nazivPizze;
    private double cena;
    private String opis;
    private VrstaPizze vrstaPizze;
    private ArrayList<Sastojak> sastojci;

    @Override
    public String toString() {
        return nazivPizze + " (Cena po komadu: " + cena + "din)";
    }

    public Pizza(Long pizzaID, String nazivPizze, double cena, String opis, VrstaPizze vrstaPizze, ArrayList<Sastojak> sastojci) {
        this.pizzaID = pizzaID;
        this.nazivPizze = nazivPizze;
        this.cena = cena;
        this.opis = opis;
        this.vrstaPizze = vrstaPizze;
        this.sastojci = sastojci;
    }

    public Pizza() {
    }

    @Override
    public String nazivTabele() {
        return " pizza ";
    }

    @Override
    public String alijas() {
        return " p ";
    }

    @Override
    public String join() {
        return " JOIN VRSTAPIZZE VP ON (VP.VRSTAPIZZEID = P.VRSTAPIZZEID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {

            VrstaPizze ts = new VrstaPizze(rs.getLong("VrstaPizzeID"),
                    rs.getString("NazivVrste"));

            Pizza sl = new Pizza(rs.getLong("PizzaID"), rs.getString("Naziv"),
                    rs.getDouble("CenaPoKomadu"), rs.getString("Opis"), ts, null);

            lista.add(sl);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (naziv, cenaPoKomadu, opis, vrstaPizzeID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " pizzaID = " + pizzaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivPizze + "', " + cena + ", "
                + "'" + opis + "', " + vrstaPizze.getVrstaPizzeID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " naziv = '" + nazivPizze + "', "
                + "cenaPoKomadu = " + cena + ", opis = '" + opis + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getPizzaID() {
        return pizzaID;
    }

    public void setPizzaID(Long pizzaID) {
        this.pizzaID = pizzaID;
    }

    public String getNazivPizze() {
        return nazivPizze;
    }

    public void setNazivPizze(String nazivPizze) {
        this.nazivPizze = nazivPizze;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public VrstaPizze getVrstaPizze() {
        return vrstaPizze;
    }

    public void setVrstaPizze(VrstaPizze vrstaPizze) {
        this.vrstaPizze = vrstaPizze;
    }

    public ArrayList<Sastojak> getSastojci() {
        return sastojci;
    }

    public void setSastojci(ArrayList<Sastojak> sastojci) {
        this.sastojci = sastojci;
    }

}
