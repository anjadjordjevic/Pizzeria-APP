/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Admin;
import domain.Racun;
import domain.Sastojak;
import domain.Pizza;
import domain.StavkaRacuna;
import domain.VrstaPizze;
import java.util.ArrayList;
import so.admin.SOAddAdmin;
import so.admin.SODeleteAdmin;
import so.admin.SOUpdateAdmin;
import so.admin.SOGetAllAdmin;
import so.login.SOLogin;
import so.racun.SOAddRacun;
import so.racun.SOGetAllRacun;
import so.sastojak.SOGetAllSastojak;
import so.pizza.SOAddPizza;
import so.pizza.SODeletePizza;
import so.pizza.SOGetAllPizza;
import so.pizza.SOUpdatePizza;
import so.stavkaRacuna.SOGetAllStavkaRacuna;
import so.vrstaPizze.SOGetAllVrstaPizze;

/**
 *
 * @author Korisnik
 */
public class ServerController {

    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public Admin login(Admin admin) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(admin);
        return so.getAdmin();
    }

    public void addAdmin(Admin admin) throws Exception {
        (new SOAddAdmin()).templateExecute(admin);
    }
  
    public void addRacun(Racun racun) throws Exception {
        (new SOAddRacun()).templateExecute(racun);
    }

    public void addPizza(Pizza pizza) throws Exception {
        (new SOAddPizza()).templateExecute(pizza);
    }

    public void deleteAdmin(Admin a) throws Exception {
        (new SODeleteAdmin()).templateExecute(a);
    }

  
    public void deletePizza(Pizza p) throws Exception {
        (new SODeletePizza()).templateExecute(p);
    }

    public void updateAdmin(Admin a) throws Exception {
        (new SOUpdateAdmin()).templateExecute(a);
    }

    public void updatePizza(Pizza p) throws Exception {
        (new SOUpdatePizza()).templateExecute(p);
    }


    public ArrayList<Admin> getAllAdmin() throws Exception {
        SOGetAllAdmin so = new SOGetAllAdmin();
        so.templateExecute(new Admin());
        return so.getLista();
    }

    public ArrayList<Pizza> getAllPizza() throws Exception {
        SOGetAllPizza so = new SOGetAllPizza();
        so.templateExecute(new Pizza());
        return so.getLista();
    }

 

    public ArrayList<Racun> getAllRacun() throws Exception {
        SOGetAllRacun so = new SOGetAllRacun();
        so.templateExecute(new Racun());
        return so.getLista();
    }

    public ArrayList<StavkaRacuna> getAllStavkaRacuna() throws Exception {
        SOGetAllStavkaRacuna so = new SOGetAllStavkaRacuna();
        so.templateExecute(new StavkaRacuna());
        return so.getLista();
    }

    public ArrayList<Sastojak> getAllSastojak(Pizza s) throws Exception {
        SOGetAllSastojak so = new SOGetAllSastojak();

        Sastojak sastojak = new Sastojak();
        sastojak.setPizza(s);

        so.templateExecute(sastojak);
        return so.getLista();
    }

    public ArrayList<VrstaPizze> getAllVrstaPizze() throws Exception {
        SOGetAllVrstaPizze so = new SOGetAllVrstaPizze();
        so.templateExecute(new VrstaPizze());
        return so.getLista();
    }

}
