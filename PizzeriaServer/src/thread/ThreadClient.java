/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import domain.Admin;
import domain.Racun;
import domain.Pizza;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Request;
import transfer.Response;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author Korisnik
 */
public class ThreadClient extends Thread {

    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            switch (request.getOperation()) {
                case Operation.ADD_ADMIN:
                    ServerController.getInstance().addAdmin((Admin) request.getData());
                    break;

                case Operation.ADD_PIZZA:
                    ServerController.getInstance().addPizza((Pizza) request.getData());
                    break;
                case Operation.ADD_RACUN:
                    ServerController.getInstance().addRacun((Racun) request.getData());
                    break;
                case Operation.DELETE_PIZZA:
                    ServerController.getInstance().deletePizza((Pizza) request.getData());
                    break;
                case Operation.DELETE_ADMIN:
                    ServerController.getInstance().deleteAdmin((Admin) request.getData());
                    break;
                case Operation.UPDATE_ADMIN:
                    ServerController.getInstance().updateAdmin((Admin) request.getData());
                    break;
                case Operation.UPDATE_PIZZA:
                    ServerController.getInstance().updatePizza((Pizza) request.getData());
                    break;
                case Operation.GET_ALL_ADMIN:
                    response.setData(ServerController.getInstance().getAllAdmin());
                    break;
                case Operation.GET_ALL_PIZZA:
                    response.setData(ServerController.getInstance().getAllPizza());
                    break;
                case Operation.GET_ALL_RACUN:
                    response.setData(ServerController.getInstance().getAllRacun());
                    break;
                case Operation.GET_ALL_STAVKA_RACUNA:
                    response.setData(ServerController.getInstance().getAllStavkaRacuna());
                    break;
                case Operation.GET_ALL_SASTOJAK:
                    response.setData(ServerController.getInstance().getAllSastojak((Pizza) request.getData()));
                    break;
                case Operation.GET_ALL_VRSTA_PIZZE:
                    response.setData(ServerController.getInstance().getAllVrstaPizze());
                    break;
                case Operation.LOGIN:
                    Admin admin = (Admin) request.getData();
                    Admin ulogovani = ServerController.getInstance().login(admin);
                    response.setData(ulogovani);
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(e);
        }
        return response;
    }

}
