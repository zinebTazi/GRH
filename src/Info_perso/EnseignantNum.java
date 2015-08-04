package Info_perso;

import Gestion.*;

import com.itextpdf.text.DocumentException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EnseignantNum extends javax.swing.JFrame {

    BD db;
    ResultSet Res, Res1;
    private String prenom;
    private ActionEvent event;

    Vector Tab = new Vector();

    public EnseignantNum() {
        db = new BD(Parametre.Host, Parametre.username, Parametre.password, Parametre.IPHOST, Parametre.Port);
        initComponents();
        jLabel2.setText("<html><body align=\"center\"><i><u><b>Informations Personnelles</b></u></i></body></html>");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text_n = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        clockFace1 = new org.edisoncor.gui.varios.ClockFace();
        jLabel17 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jButton3.setBackground(new java.awt.Color(1, 168, 158));
        jButton3.setFont(new java.awt.Font("Liberation Mono", 1, 14)); // NOI18N
        jButton3.setForeground(java.awt.Color.white);
        jButton3.setText("Afficher ");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton4.setBackground(new java.awt.Color(1, 168, 158));
        jButton4.setFont(new java.awt.Font("Liberation Mono", 1, 14)); // NOI18N
        jButton4.setForeground(java.awt.Color.white);
        jButton4.setText("Modifier");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressource/back.png"))); // NOI18N
        jLabel17.setText("jLabel14");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(1, 168, 158));
        jButton5.setFont(new java.awt.Font("Liberation Mono", 1, 14)); // NOI18N
        jButton5.setForeground(java.awt.Color.white);
        jButton5.setText("Supprimer");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(151, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel1)
                .addGap(85, 85, 85)
                .addComponent(text_n, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_nActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_nActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        prenom = null;
        try {
            if (text_n.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Remplissez le champ SVP !!");
            } else {
                Res = db.querySelectAll("Enseignant", "N_somme='" + text_n.getText() + "'");
                while (Res.next()) {
                    prenom = Res.getString("prenom");
                }
                if (prenom == null) {
                    JOptionPane.showMessageDialog(null, "N° de some incorrecte");
                } else {

                    try {
                        EnseignantPdf x = new EnseignantPdf(text_n.getText());
                        //catch (Exception e) {
                        // JOptionPane.showMessageDialog(null, "L'Enseignant doit avoir tous les Informations afin de pouvoir afficher la fiche ");
                        //}
                    } catch (DocumentException ex) {
                        Logger.getLogger(EnseignantNum.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(EnseignantNum.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantNum.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void text_nKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_nKeyPressed
        if (evt.getKeyCode() == 10) {
            jButton3ActionPerformed(event);
        }
    }//GEN-LAST:event_text_nKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (text_n.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Remplissez le champ SVP !!");
        } else {
            Res = db.querySelectAll("Enseignant", "N_somme='" + text_n.getText() + "'");
            try {
                while (Res.next()) {
                    try {
                        prenom = Res.getString("prenom");

                    } catch (SQLException ex) {
                        Logger.getLogger(EnseignantNum.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(EnseignantNum.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            if (prenom == null) {
                JOptionPane.showMessageDialog(null, "N° de SOM incorrecte");
            } else {
                Modif_Enseignant a;
                try {
                    a = new Modif_Enseignant(text_n.getText());
                    a.setLocationRelativeTo(a.getParent());
                    this.dispose();
                    a.show();
                } catch (SQLException ex) {
                    Logger.getLogger(EnseignantNum.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        Principale x = new Principale();

        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);

        x.show();
        this.dispose();
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        prenom = null;
        String nom = null;
        if (text_n.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Remplissez le champ SVP !!");
        } else {

            Res = db.querySelectAll("Enseignant", "N_somme='" + text_n.getText() + "'");
            try {
                while (Res.next()) {
                    try {
                        prenom = Res.getString("prenom");

                    } catch (SQLException ex) {
                        Logger.getLogger(EnseignantNum.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(EnseignantNum.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            if (prenom == null) {
                JOptionPane.showMessageDialog(null, "N° de SOM incorrecte");
            } else {
                if (JOptionPane.showConfirmDialog(this, "êtes-vous sûre de vouloir supprimer cet enseignant ??") == 0) {
                    try {
                        Res = db.executionQuery("select effectuer.id_odm from Ordre_de_mission,effectuer where Ordre_de_mission.id_odm=effectuer.id_odm and N_somme='" + text_n.getText() + "'");

                        while (Res.next()) {
                            Tab.add(Res.getString("id_odm"));
                        }

                        db.queryDelete("situation_administrative", "id_sa in (Select id_sa from avoir where N_somme='" + text_n.getText() + "')");
                        db.queryDelete("Diplomes", "id_diplomes in (Select id_diplomes from obtient where N_somme='" + text_n.getText() + "')");

                        db.queryDelete("Date", "id_date in (Select id_date from effectuer where N_somme='" + text_n.getText() + "')");
                        db.queryDelete("Enseignant", "N_somme='" + text_n.getText() + "'");

                        for (int i = 0; i < Tab.size(); i++) {
                            System.out.println(i + "=>" + Tab.get(i));
                            db.queryDelete("Ordre_de_mission", "id_odm ='" + Tab.get(i) + "'");

                        }
                        int i = 1;
                        Res = db.querySelectAll("Ordre_de_mission");
                        Connection con = db.connexionDatabase();
                        PreparedStatement pre;
                        while (Res.next()) {
                            pre = con.prepareStatement("update Ordre_de_mission set id_odm=? where id_odm=?");
                            pre.setInt(1, i);
                            pre.setInt(2, Res.getInt("id_odm"));

                            pre.executeUpdate();
                            i++;
                        }

                        Res = db.querySelectAll("Date");
                        i = 1;
                        while (Res.next()) {
                            pre = con.prepareStatement("update Date set id_date=? where id_date=?");
                            pre.setInt(1, i);
                            pre.setInt(2, Res.getInt("id_date"));

                            pre.executeUpdate();
                            i++;
                        }

                        Res = db.querySelectAll("Diplomes");
                        i = 1;
                        while (Res.next()) {
                            pre = con.prepareStatement("update Diplomes set id_diplomes=? where id_diplomes=?");
                            pre.setInt(1, i);
                            pre.setInt(2, Res.getInt("id_diplomes"));

                            pre.executeUpdate();
                            i++;
                        }

                        Res = db.querySelectAll("situation_administrative");
                        i = 1;
                        while (Res.next()) {
                            pre = con.prepareStatement("update situation_administrative set id_sa=? where id_sa=?");
                            pre.setInt(1, i);
                            pre.setInt(2, Res.getInt("id_sa"));

                            pre.executeUpdate();
                            i++;
                        }

                        Res = db.querySelectAll("Enseignant");
                        i = 1;
                        while (Res.next()) {
                            pre = con.prepareStatement("update Enseignant set id_Enseignant=? where id_Enseignant=?");
                            pre.setInt(1, i);
                            pre.setInt(2, Res.getInt("id_Enseignant"));

                            pre.executeUpdate();
                            i++;
                        }

                        Res = db.querySelectAll("Enseignant", "N_somme='" + text_n.getText() + "'");
                        try {
                            while (Res.next()) {
                                nom = Res.getString("nom");

                            }
                            if (nom == null) {
                                JOptionPane.showMessageDialog(null, "l'Enseignant a été retiré de la Base de Donnée avec succès");
                                Principale x = new Principale();

                                x.setLocationRelativeTo(x.getGlassPane());
                                x.setResizable(false);

                                x.show();
                                this.dispose();
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(EnseignantNum.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(EnseignantNum.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.varios.ClockFace clockFace1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField text_n;
    // End of variables declaration//GEN-END:variables
}
