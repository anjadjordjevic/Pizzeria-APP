/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Admin;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class TableModelAdmin extends AbstractTableModel implements Runnable {

    private ArrayList<Admin> lista;
    private String[] kolone = {"ID", "Ime", "Prezime", "Username"};
    private String parametar = "";

    public TableModelAdmin() {
        try {
            lista = ClientController.getInstance().getAllAdmin();
        } catch (Exception ex) {
            Logger.getLogger(TableModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
        Admin a = lista.get(row);

        switch (column) {
            case 0:
                return a.getAdminID();
            case 1:
                return a.getIme();
            case 2:
                return a.getPrezime();
            case 3:
                return a.getUsername();

            default:
                return null;
        }
    }

    public Admin getSelectedAdmin(int row) {
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
            Logger.getLogger(TableModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllAdmin();
            if (!parametar.equals("")) {
                ArrayList<Admin> novaLista = new ArrayList<>();
                for (Admin a : lista) {
                    if (a.getIme().toLowerCase().contains(parametar.toLowerCase())
                            || a.getPrezime().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(a);
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
