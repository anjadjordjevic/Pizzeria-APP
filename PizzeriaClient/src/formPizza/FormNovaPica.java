/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formPizza;

import controller.ClientController;
import domain.Sastojak;
import domain.Pizza;
import domain.VrstaPizze;
import forme.MainForm;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.TableModelSastojci;

/**
 *
 * @author Korisnik
 */
public class FormNovaPica extends javax.swing.JDialog {

    public FormNovaPica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Unos pice");
        popuniVrstePice();
        tblSastojci.setModel(new TableModelSastojci());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbVrstaPizze = new javax.swing.JComboBox();
        txtNazivPice = new javax.swing.JTextField();
        txtCenaPoKomadu = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOpis = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbSastojak = new javax.swing.JComboBox();
        btnDodajSastojak = new javax.swing.JButton();
        btnObrisiSastojak = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSastojci = new javax.swing.JTable();
        btnOtkazi = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unos pice", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 16))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel1.setText("Vrsta pice:");

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel4.setText("Naziv pice:");

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel5.setText("Cena po komadu:");

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel6.setText("Opis:");

        cmbVrstaPizze.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        cmbVrstaPizze.setForeground(new java.awt.Color(255, 102, 0));
        cmbVrstaPizze.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtNazivPice.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        txtNazivPice.setForeground(new java.awt.Color(255, 102, 0));
        txtNazivPice.setText("Pica 1");

        txtCenaPoKomadu.setForeground(new java.awt.Color(255, 102, 0));
        txtCenaPoKomadu.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtCenaPoKomadu.setText("200");
        txtCenaPoKomadu.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        txtCenaPoKomadu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCenaPoKomaduActionPerformed(evt);
            }
        });

        txtOpis.setColumns(20);
        txtOpis.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        txtOpis.setForeground(new java.awt.Color(255, 102, 0));
        txtOpis.setRows(5);
        txtOpis.setText("Sjajna!");
        jScrollPane1.setViewportView(txtOpis);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unos sastojaka", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 0, 16))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel2.setText("Sastojak:");

        cmbSastojak.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        cmbSastojak.setForeground(new java.awt.Color(255, 102, 0));
        cmbSastojak.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Šunka", "Pelat", "Kulen", "Pečurke", "Kačkavalj", "Kečap", "Sir", "Jaje", "Paprika", "Masline", "Pavlaka", "Pesto sos", "Pančeta", "Slanina", "Majonez" }));

        btnDodajSastojak.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnDodajSastojak.setForeground(new java.awt.Color(255, 102, 0));
        btnDodajSastojak.setText("Dodaj sastojak");
        btnDodajSastojak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajSastojakActionPerformed(evt);
            }
        });

        btnObrisiSastojak.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnObrisiSastojak.setForeground(new java.awt.Color(255, 102, 0));
        btnObrisiSastojak.setText("Obriši sastojak");
        btnObrisiSastojak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiSastojakActionPerformed(evt);
            }
        });

        tblSastojci.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        tblSastojci.setForeground(new java.awt.Color(255, 102, 0));
        tblSastojci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblSastojci);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnDodajSastojak, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnObrisiSastojak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(cmbSastojak, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbSastojak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajSastojak)
                    .addComponent(btnObrisiSastojak))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnOtkazi.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btnOtkazi.setForeground(new java.awt.Color(255, 102, 0));
        btnOtkazi.setText("Otkaži");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnDodaj.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        btnDodaj.setForeground(new java.awt.Color(255, 102, 0));
        btnDodaj.setText("Dodaj picu");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNazivPice)
                            .addComponent(txtCenaPoKomadu)
                            .addComponent(jScrollPane1)
                            .addComponent(cmbVrstaPizze, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnOtkazi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbVrstaPizze, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNazivPice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCenaPoKomadu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOtkazi)
                    .addComponent(btnDodaj))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        try {
            if (txtNazivPice.getText().isEmpty() || txtCenaPoKomadu.getText().isEmpty()
                    || txtOpis.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!");
                return;
            }

            VrstaPizze vrstaPice = (VrstaPizze) cmbVrstaPizze.getSelectedItem();
            String nazivPice = txtNazivPice.getText();
            double cenaPoKomadu = Double.parseDouble(txtCenaPoKomadu.getText());
            String opis = txtOpis.getText();
            
            TableModelSastojci tm = (TableModelSastojci) tblSastojci.getModel();
            
            Pizza s = new Pizza(null, nazivPice, cenaPoKomadu, opis, vrstaPice, tm.getLista());
            
            ClientController.getInstance().addPizza(s);
            MainForm mf = (MainForm) getParent();
            mf.popuniPizze();
            JOptionPane.showMessageDialog(this, "Uspešno dodata pica.");
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void txtCenaPoKomaduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCenaPoKomaduActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCenaPoKomaduActionPerformed

    private void btnDodajSastojakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajSastojakActionPerformed

        String nazivSastojka = (String) cmbSastojak.getSelectedItem();
        
        Sastojak s = new Sastojak(null, -1, nazivSastojka);
        
        TableModelSastojci tm = (TableModelSastojci) tblSastojci.getModel();
        
        if(tm.postojiSastojak(s)){
            JOptionPane.showMessageDialog(this, "Već ste uneli ovaj sastojak!");
            return;
        }
        
        tm.dodajSastojak(s);

    }//GEN-LAST:event_btnDodajSastojakActionPerformed

    private void btnObrisiSastojakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiSastojakActionPerformed
        
        int row = tblSastojci.getSelectedRow();
        
        if(row >= 0){
            TableModelSastojci tm = (TableModelSastojci) tblSastojci.getModel();
            tm.obrisiSastojak(row);
        }
        
    }//GEN-LAST:event_btnObrisiSastojakActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnDodajSastojak;
    private javax.swing.JButton btnObrisiSastojak;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JComboBox cmbSastojak;
    private javax.swing.JComboBox cmbVrstaPizze;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblSastojci;
    private javax.swing.JFormattedTextField txtCenaPoKomadu;
    private javax.swing.JTextField txtNazivPice;
    private javax.swing.JTextArea txtOpis;
    // End of variables declaration//GEN-END:variables

    private void popuniVrstePice() {
        try {
            ArrayList<VrstaPizze> vrstePice = ClientController.getInstance().getAllVrstaPizze();

            cmbVrstaPizze.removeAllItems();

            for (VrstaPizze vrsta : vrstePice) {
                cmbVrstaPizze.addItem(vrsta);
            }

        } catch (Exception ex) {
            Logger.getLogger(FormNovaPica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}