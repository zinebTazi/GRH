package Gestion;

import Gestion.*;
import Attestation.*;
import Avancement.*;
import Info_perso.*;
import Ordre_de_mission.*;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author ouissam
 */
public class Principale extends javax.swing.JFrame {

    /**
     * Creates new form Principale
     */
    public Principale() {
        initComponents();

        deconnexion.setText("<html><body><font size=\"5\"<u>Deconnexion<u></font></body></html>");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        deconnexion = new javax.swing.JLabel();
        buttonColoredAction2 = new org.edisoncor.gui.button.ButtonColoredAction();
        buttonColoredAction3 = new org.edisoncor.gui.button.ButtonColoredAction();
        buttonColoredAction4 = new org.edisoncor.gui.button.ButtonColoredAction();
        buttonColoredAction5 = new org.edisoncor.gui.button.ButtonColoredAction();
        buttonColoredAction6 = new org.edisoncor.gui.button.ButtonColoredAction();
        clockFace1 = new org.edisoncor.gui.varios.ClockFace();
        buttonColoredAction7 = new org.edisoncor.gui.button.ButtonColoredAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("gargi", 2, 50)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(218, 90, 90));
        jLabel1.setText("  ACCUEIL");

        jLabel7.setForeground(new java.awt.Color(218, 90, 90));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressource/logoFso.jpg"))); // NOI18N
        jLabel7.setText("jLabel6");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        deconnexion.setForeground(java.awt.Color.darkGray);
        deconnexion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deconnexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deconnexionMouseClicked(evt);
            }
        });

        buttonColoredAction2.setBackground(new java.awt.Color(37, 90, 100));
        buttonColoredAction2.setText("Attestion de Travail ");
        buttonColoredAction2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonColoredAction2ActionPerformed(evt);
            }
        });

        buttonColoredAction3.setBackground(new java.awt.Color(37, 90, 100));
        buttonColoredAction3.setText("Ordre de Mission ");
        buttonColoredAction3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonColoredAction3ActionPerformed(evt);
            }
        });

        buttonColoredAction4.setBackground(new java.awt.Color(37, 90, 100));
        buttonColoredAction4.setText("Les Informations Personnelles");
        buttonColoredAction4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonColoredAction4ActionPerformed(evt);
            }
        });

        buttonColoredAction5.setBackground(new java.awt.Color(37, 90, 100));
        buttonColoredAction5.setText("Modifier Situation Administrative");
        buttonColoredAction5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonColoredAction5ActionPerformed(evt);
            }
        });

        buttonColoredAction6.setBackground(new java.awt.Color(37, 90, 100));
        buttonColoredAction6.setText("Proposition des Avancements");
        buttonColoredAction6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonColoredAction6ActionPerformed(evt);
            }
        });

        buttonColoredAction7.setBackground(new java.awt.Color(37, 90, 100));
        buttonColoredAction7.setText("Nouveau Enseignant");
        buttonColoredAction7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonColoredAction7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145)
                        .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(deconnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonColoredAction5, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(buttonColoredAction4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonColoredAction6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonColoredAction7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonColoredAction2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonColoredAction3, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(buttonColoredAction7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(buttonColoredAction4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonColoredAction6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(buttonColoredAction5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(buttonColoredAction2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonColoredAction3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deconnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Principale x = new Principale();
        x.setLocationRelativeTo(x.getParent());
        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);

        x.show();
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void deconnexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deconnexionMouseClicked
        Utilisateur x = new Utilisateur();
        x.setLocationRelativeTo(x.getParent());
        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);

        x.show();
        this.dispose();
    }//GEN-LAST:event_deconnexionMouseClicked

    private void buttonColoredAction2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonColoredAction2ActionPerformed
        Att j = new Att();
        j.setLocationRelativeTo(j.getParent());
        j.setLocationRelativeTo(j.getGlassPane());
        j.setResizable(false);
        j.show();
        this.dispose();
    }//GEN-LAST:event_buttonColoredAction2ActionPerformed

    private void buttonColoredAction3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonColoredAction3ActionPerformed
        Remplir_Ordre a = new Remplir_Ordre();
        a.setLocationRelativeTo(a.getParent());
        a.setLocationRelativeTo(a.getGlassPane());
        a.setResizable(false);
        a.show();
        this.dispose();

    }//GEN-LAST:event_buttonColoredAction3ActionPerformed

    private void buttonColoredAction4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonColoredAction4ActionPerformed
        EnseignantNum x = new EnseignantNum();
        x.setLocationRelativeTo(x.getParent());
        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);

        x.show();
        this.dispose();
    }//GEN-LAST:event_buttonColoredAction4ActionPerformed

    private void buttonColoredAction5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonColoredAction5ActionPerformed
        ModifierSituation x = new ModifierSituation();
        x.setLocationRelativeTo(x.getParent());
        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);
        x.show();
        this.dispose();
    }//GEN-LAST:event_buttonColoredAction5ActionPerformed

    private void buttonColoredAction6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonColoredAction6ActionPerformed
        Avancement j = new Avancement();
        j.setLocationRelativeTo(j.getParent());
        j.setLocationRelativeTo(j.getGlassPane());
        j.setResizable(false);
        j.show();
        this.dispose();
    }//GEN-LAST:event_buttonColoredAction6ActionPerformed

    private void buttonColoredAction7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonColoredAction7ActionPerformed
        Nv_Enseignant j = new Nv_Enseignant();
        j.setLocationRelativeTo(j.getParent());
        j.setLocationRelativeTo(j.getGlassPane());
        j.setResizable(false);
        j.show();
        this.dispose();
    }//GEN-LAST:event_buttonColoredAction7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonColoredAction buttonColoredAction2;
    private org.edisoncor.gui.button.ButtonColoredAction buttonColoredAction3;
    private org.edisoncor.gui.button.ButtonColoredAction buttonColoredAction4;
    private org.edisoncor.gui.button.ButtonColoredAction buttonColoredAction5;
    private org.edisoncor.gui.button.ButtonColoredAction buttonColoredAction6;
    private org.edisoncor.gui.button.ButtonColoredAction buttonColoredAction7;
    private org.edisoncor.gui.varios.ClockFace clockFace1;
    private javax.swing.JLabel deconnexion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables

}
