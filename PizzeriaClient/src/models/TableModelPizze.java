/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Pizza;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelPizze extends AbstractTableModel implements Runnable {

    private ArrayList<Pizza> lista;
    private String[] kolone = {"ID", "Vrsta pice", "Naziv pice", "Cena po komadu"};
    private String parametar = "";

    public TableModelPizze() {
        try {
            lista = ClientController.getInstance().getAllPizza();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPizze.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Pizza s = lista.get(row);

        switch (column) {
            case 0:
                return s.getPizzaID();
            case 1:
                return s.getVrstaPizze();
            case 2:
                return s.getNazivPizze();
            case 3:
                return s.getCena() + "din";

            default:
                return null;
        }
    }

    public Pizza getSelectedPizza(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelPizze.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllPizza();
            if (!parametar.equals("")) {
                ArrayList<Pizza> novaLista = new ArrayList<>();
                for (Pizza s : lista) {
                    if (s.getNazivPizze().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(s);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
