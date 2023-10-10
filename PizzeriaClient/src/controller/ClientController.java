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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author Korisnik
 */
public class ClientController {

    private static ClientController instance;

    public ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Admin login(Admin admin) throws Exception {
        return (Admin) sendRequest(Operation.LOGIN, admin);
    }

    public void addAdministrator(Admin admin) throws Exception {
        sendRequest(Operation.ADD_ADMIN, admin);
    }

    public void addPizza(Pizza pizza) throws Exception {
        sendRequest(Operation.ADD_PIZZA, pizza);
    }

    public void addRacun(Racun racun) throws Exception {
        sendRequest(Operation.ADD_RACUN, racun);
    }

    public void deleteAdmin(Admin admin) throws Exception {
        sendRequest(Operation.DELETE_ADMIN, admin);
    }

    public void deletePizza(Pizza pizza) throws Exception {
        sendRequest(Operation.DELETE_PIZZA, pizza);
    }

    public void updateAdmin(Admin admin) throws Exception {
        sendRequest(Operation.UPDATE_ADMIN, admin);
    }


    public void updatePizza(Pizza pizza) throws Exception {
        sendRequest(Operation.UPDATE_PIZZA, pizza);
    }

    public ArrayList<Admin> getAllAdmin() throws Exception {
        return (ArrayList<Admin>) sendRequest(Operation.GET_ALL_ADMIN, null);
    }

    public ArrayList<Pizza> getAllPizza() throws Exception {
        return (ArrayList<Pizza>) sendRequest(Operation.GET_ALL_PIZZA, null);
    }

    public ArrayList<Racun> getAllRacun() throws Exception {
        return (ArrayList<Racun>) sendRequest(Operation.GET_ALL_RACUN, null);
    }

    public ArrayList<StavkaRacuna> getAllStavkaRacuna() throws Exception {
        return (ArrayList<StavkaRacuna>) sendRequest(Operation.GET_ALL_STAVKA_RACUNA, null);
    }

    public ArrayList<Sastojak> getAllSastojak(Pizza s) throws Exception {
        return (ArrayList<Sastojak>) sendRequest(Operation.GET_ALL_SASTOJAK, s);
    }

    public ArrayList<VrstaPizze> getAllVrstaPizze() throws Exception {
        return (ArrayList<VrstaPizze>) sendRequest(Operation.GET_ALL_VRSTA_PIZZE, null);
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        Request request = new Request(operation, data);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(request);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response response = (Response) in.readObject();

        if (response.getResponseStatus().equals(ResponseStatus.Error)) {
            throw response.getException();
        } else {
            return response.getData();
        }

    }
}
