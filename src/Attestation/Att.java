package Attestation;

import Gestion.*;
import com.itextpdf.text.DocumentException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.IOException;
import static java.lang.System.exit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Att extends javax.swing.JFrame {

    String DOTI, text2, text3;
    ResultSet Res;
    BD db;
    String prenom, nom, nomP;
    int i = 0, num;
    ActionEvent event;

    public Att() {

        db = new BD(Parametre.Host, Parametre.username, Parametre.password, Parametre.IPHOST, Parametre.Port);
        initComponents();

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        text_n = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        envoyer = new javax.swing.JButton();
        raffraichir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        txt_prenom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        clockFace1 = new org.edisoncor.gui.varios.ClockFace();
        jLabel14 = new javax.swing.JLabel();
        Annuler = new org.edisoncor.gui.button.ButtonAction();
        A_Att = new org.edisoncor.gui.button.ButtonAction();
        G_Att = new org.edisoncor.gui.button.ButtonAction();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(400, 0, 0, 0));

        text_n.setToolTipText("<html><font color=\"blue\"><i>Saisissez votre DOTI</i></font></html>");
        text_n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_nActionPerformed(evt);
            }
        });
        text_n.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                text_nKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel1.setText("DOTI :");

        envoyer.setFont(new java.awt.Font("Liberation Mono", 1, 12)); // NOI18N
        envoyer.setText("Lister");
        envoyer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        envoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                envoyerActionPerformed(evt);
            }
        });

        raffraichir.setFont(new java.awt.Font("Liberation Mono", 1, 12)); // NOI18N
        raffraichir.setText("raffraichir");
        raffraichir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        raffraichir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raffraichirActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel3.setText("Nom :");

        txt_nom.setToolTipText("<html><font color=\"blue\"><i>Saisissez votre Nom</i></font></html>");
        txt_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomActionPerformed(evt);
            }
        });
        txt_nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nomKeyPressed(evt);
            }
        });

        txt_prenom.setToolTipText("<html><font color=\"blue\"><i>Saisissez votre Prénom</i></font></html>");
        txt_prenom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_prenomKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel5.setText("Prénom :");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(218, 90, 90));
        jLabel2.setText("Attestation de Travail ");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° de Some", "Nom", "Prenom", "CIN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jScrollPane3.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setResizable(false);
            Table.getColumnModel().getColumn(1).setResizable(false);
            Table.getColumnModel().getColumn(2).setResizable(false);
            Table.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(234, 5, 5));
        jLabel7.setText("** Ce champ est pour la vérification  en cas d'oublie du DOTI");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressource/logoFso.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.red);
        jLabel9.setText("*");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel10.setForeground(java.awt.Color.red);
        jLabel10.setText("**");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel11.setForeground(java.awt.Color.red);
        jLabel11.setText("**");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(234, 5, 5));
        jLabel12.setText("* Ce champ est obligatiore pour générer l'Attestation ");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressource/back.png"))); // NOI18N
        jLabel14.setText("jLabel14");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });

        A_Att.setText("Afficher Attestation");
        A_Att.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                A_AttActionPerformed(evt);
            }
        });

        G_Att.setText("Générer Attestation");
        G_Att.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G_AttActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178)
                .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(A_Att, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Annuler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(envoyer, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(147, 147, 147)
                                .addComponent(raffraichir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(text_n, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(G_Att, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(text_n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(raffraichir)
                    .addComponent(envoyer))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Annuler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A_Att, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(G_Att, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void envoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_envoyerActionPerformed

        DOTI = text_n.getText();
        text2 = txt_nom.getText();
        text3 = txt_prenom.getText();

        Object[] data = new Object[4];

        text_n.setText("");
        txt_nom.setText("");
        txt_prenom.setText("");

        if (DOTI.equals("")) {
            if ((text2.equals("") && text3.equals(""))) {

                JOptionPane.showMessageDialog(this, "Remplissez tous les champs svp!");

            } else {

                if (text3.equals("")) {
                    Res = db.querySelectAll("Enseignant", "nom='" + text2 + "'");

                    DefaultTableModel model = (DefaultTableModel) Table.getModel();
                    if (model.getRowCount() == 1) {
                        model.removeRow(0);
                    }

                    try {
                        while (Res.next()) {

                            prenom = Res.getString("prenom");
                            nom = Res.getString("nom");

                            data[0] = Res.getString("N_somme");
                            data[1] = Res.getString("nom");
                            data[2] = Res.getString("prenom");
                            data[3] = Res.getString("CIN");

                            model.addRow(data);
                        }

                        if (prenom == null) {
                            JOptionPane.showMessageDialog(this, "Le Nom  est incorrecte");

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Att.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    Res = db.querySelectAll("Enseignant", "nom='" + text2 + "' AND prenom='" + text3 + "'");
                    DefaultTableModel model = (DefaultTableModel) Table.getModel();
                    if (model.getRowCount() == 1) {
                        model.removeRow(0);
                    }

                    try {
                        while (Res.next()) {
                            prenom = Res.getString("prenom");
                            nom = Res.getString("nom");

                            data[0] = Res.getString("N_somme");
                            data[1] = Res.getString("nom");
                            data[2] = Res.getString("prenom");
                            data[3] = Res.getString("CIN");

                            model.addRow(data);
                        }

                        if (prenom == null) {
                            JOptionPane.showMessageDialog(this, "Le Nom ou le Prenom est incorrecte");

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Att.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        } else {
            Res = db.querySelectAll("Enseignant", "N_somme='"
                    + DOTI + "'");

            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            if(model.getRowCount()==1){
             model.removeRow(0);   
            }

            try {
                while (Res.next()) {

                    prenom = Res.getString("prenom");
                    nom = Res.getString("nom");

                    data[0] = Res.getString("N_somme");
                    data[1] = Res.getString("nom");
                    data[2] = Res.getString("prenom");
                    data[3] = Res.getString("CIN");
                    model.addRow(data);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Att.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (prenom == null) {
                JOptionPane.showMessageDialog(this, "Le N° de Some est incorrecte");

            }

        }

    }//GEN-LAST:event_envoyerActionPerformed

    private void raffraichirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raffraichirActionPerformed
        Att j = new Att();
        j.setLocationRelativeTo(j.getParent());
        j.show();
        this.dispose();
    }//GEN-LAST:event_raffraichirActionPerformed

    private void text_nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_nActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_nActionPerformed

    private void txt_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Principale x = new Principale();

        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);

        x.show();
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void text_nKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_nKeyPressed
        if (evt.getKeyCode() == 10) {
            envoyerActionPerformed(event);
        }
    }//GEN-LAST:event_text_nKeyPressed

    private void txt_nomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomKeyPressed
        if (evt.getKeyCode() == 10) {
            envoyerActionPerformed(event);
        }
    }//GEN-LAST:event_txt_nomKeyPressed

    private void txt_prenomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_prenomKeyPressed
        DOTI = text_n.getText();
        text2 = txt_nom.getText();
        text3 = txt_prenom.getText();

        if (text2.equalsIgnoreCase("")) {
            if (evt.getKeyCode() != 8) {
                JOptionPane.showMessageDialog(this, "Remplissez d'abord le nom SVP !!");
            }
        } else {
            if (evt.getKeyCode() == 10) {
                envoyerActionPerformed(event);
            }
        }

    }//GEN-LAST:event_txt_prenomKeyPressed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int ligne = Table.getSelectedRow();
        Object numeroSOM = Table.getValueAt(ligne, 0);

        Verif_Attestation a;
        try {
            a = new Verif_Attestation((String) numeroSOM);
            a.show();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Att.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_TableMouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        Principale x = new Principale();

        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);

        x.show();
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        Principale x = new Principale();

        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);

        x.show();
        this.dispose();
    }//GEN-LAST:event_AnnulerActionPerformed

    private void A_AttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_A_AttActionPerformed
        DOTI = text_n.getText();
        text_n.setText("");
        if (DOTI.equals("")) {
            JOptionPane.showMessageDialog(this, "vous n'avez pas enter le N° de Some ! saisissez le svp");
        } else {
            Res = db.querySelectAll("Enseignant", "N_somme='"
                    + DOTI + "'");
            try {
                while (Res.next()) {
                    prenom = Res.getString("prenom");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Att.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (prenom == null) {
                JOptionPane.showMessageDialog(this, "Vérifier votre N° de Some SVP !!");
            } else {
                Verif_Attestation a;
                try {
                    a = new Verif_Attestation(DOTI);
                    a.setLocationRelativeTo(a.getParent());
                    a.setLocationRelativeTo(a.getGlassPane());

                    a.show();

                } catch (SQLException ex) {
                    Logger.getLogger(Att.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }//GEN-LAST:event_A_AttActionPerformed

    private void G_AttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G_AttActionPerformed
        prenom = null;
        DOTI = text_n.getText();

        if (DOTI.equals("")) {
            JOptionPane.showMessageDialog(this, "vous n'avez pas enter le N° de Some ! saisissez le svp");
        } else {
            Res = db.querySelectAll("Enseignant", "N_somme='"
                    + DOTI + "'");

            try {
                while (Res.next()) {

                    prenom = Res.getString("prenom");
                    nom = Res.getString("nom");

                }
                if (prenom == null) {
                    JOptionPane.showMessageDialog(this, "Vérifier votre N° de Some SVP !!");
                } else {
                    nomP = "" + upperFirst(prenom) + " " + upper(nom);
                    if (JOptionPane.showConfirmDialog(null, "êtes vous sûre d'avoir générer l'Attestation de " + nomP + " ?") == 0) {

                        try {
                            AttestationPdf a = new AttestationPdf(DOTI);
                        } catch (DocumentException ex) {
                            Logger.getLogger(Att.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Att.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Att.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Att.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_G_AttActionPerformed

    String upper(String x) {
        return x.toUpperCase();
    }

    String upperFirst(String x) {
        return x.substring(0, 1).toUpperCase() + x.substring(1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction A_Att;
    private org.edisoncor.gui.button.ButtonAction Annuler;
    private org.edisoncor.gui.button.ButtonAction G_Att;
    private javax.swing.JTable Table;
    private org.edisoncor.gui.varios.ClockFace clockFace1;
    private javax.swing.JButton envoyer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton raffraichir;
    private javax.swing.JTextField text_n;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_prenom;
    // End of variables declaration//GEN-END:variables

}
