package Ordre_de_mission;

import Gestion.*;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ouissam
 */
public class Ordre extends javax.swing.JFrame {

    BD db;
    ResultSet Res,Res1;
    String n, nom, prenom;

    Object[] data = new Object[7];

    public Ordre(String n) {
        this.n = n;
        initComponents();

        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        db = new BD(Parametre.Host, Parametre.username, Parametre.password, Parametre.IPHOST, Parametre.Port);
        Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        Table.getColumnModel().getColumn(1).setPreferredWidth(100);
        Table.getColumnModel().getColumn(2).setPreferredWidth(100);
        Table.getColumnModel().getColumn(3).setPreferredWidth(100);
        Table.getColumnModel().getColumn(4).setPreferredWidth(100);
        Table.getColumnModel().getColumn(5).setPreferredWidth(100);
        Table.getColumnModel().getColumn(6).setPreferredWidth(400);

        Res1 = db.executionQuery("select DISTINCT effectuer.id_odm,nom,prenom,destination,date_depart,date_retour,motifs  from Enseignant , Ordre_de_mission , effectuer,Date,situation_administrative,cadre,avoir  "
                + "where Enseignant.N_somme=effectuer.N_somme "
                + " and Ordre_de_mission.id_odm=effectuer.id_odm "
                + " and effectuer.id_date=Date.id_date"
                + " and avoir.id_sa=situation_administrative.id_sa"
                + " and situation_administrative.id_cadre=cadre.id_cadre"
                + " and Enseignant.N_somme='" + n + "'");
        Res=db.querySelectAll("Enseignant", "N_somme='"+n+"'");
        try {

            while(Res.next()){
                    NOM.setText("" + upperFirst(Res.getString("prenom")) + "  " + upper(Res.getString("nom")));
            }
            while (Res1.next()) {

                prenom = Res1.getString("prenom");
                if (prenom == null) {
break;
                } else {
                    nom = Res1.getString("nom");
                    data[0] = Res1.getString("id_odm");
                    data[1] = Res1.getString("nom");
                    data[2] = Res1.getString("prenom");
                    data[3] = Res1.getString("destination");
                    data[4] = Res1.getString("date_depart");
                    data[5] = Res1.getString("date_retour");
                    data[6] = Res1.getString("motifs");

                    model.addRow(data);

                    
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Remplir_Ordre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        NOM = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        clockFace1 = new org.edisoncor.gui.varios.ClockFace();
        buttonAction1 = new org.edisoncor.gui.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(218, 90, 90));
        jLabel2.setText("       ARCHIVE");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "nom", "prenom", "destination", "du", "au", "motifs"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setResizable(false);
            Table.getColumnModel().getColumn(1).setResizable(false);
            Table.getColumnModel().getColumn(2).setResizable(false);
            Table.getColumnModel().getColumn(3).setResizable(false);
            Table.getColumnModel().getColumn(4).setResizable(false);
            Table.getColumnModel().getColumn(5).setResizable(false);
            Table.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Liberation Mono", 1, 18)); // NOI18N
        jLabel1.setText("liste des missions effectuées par : ");

        NOM.setFont(new java.awt.Font("Liberation Mono", 1, 21)); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressource/logoFso.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressource/back.png"))); // NOI18N
        jLabel14.setText("jLabel14");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        buttonAction1.setText("Annuler");
        buttonAction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(327, 327, 327))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300)
                .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(NOM, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(buttonAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(252, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(NOM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(buttonAction1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Principale x = new Principale();

        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);

        x.show();
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int ligne = Table.getSelectedRow();
        Object numeroOrdre = Table.getValueAt(ligne, 0);

        Res = db.executionQuery("select *  from Enseignant , Ordre_de_mission , effectuer,Date "
                + "where Enseignant.N_somme=effectuer.N_somme "
                + " and Ordre_de_mission.id_odm=effectuer.id_odm "
                + "and effectuer.id_date=Date.id_date"
                + " and Enseignant.N_somme='" + n
                + "' and Ordre_de_mission.id_odm='" + numeroOrdre + "'");

        try {
            Ordre_de_MissionPdf a = new Ordre_de_MissionPdf(n, Integer.parseInt((String) numeroOrdre));
        } catch (SQLException ex) {
            Logger.getLogger(Ordre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ordre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Ordre.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_TableMouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        Remplir_Ordre x = new Remplir_Ordre();

        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);

        x.show();
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void buttonAction1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction1ActionPerformed
        Remplir_Ordre x = new Remplir_Ordre();

        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);

        x.show();
        this.dispose();
    }//GEN-LAST:event_buttonAction1ActionPerformed
    String upper(String x) {
        return x.toUpperCase();
    }

    String upperFirst(String x) {
        return x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NOM;
    private javax.swing.JTable Table;
    private org.edisoncor.gui.button.ButtonAction buttonAction1;
    private org.edisoncor.gui.varios.ClockFace clockFace1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
