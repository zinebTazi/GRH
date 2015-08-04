package Info_perso;

import Gestion.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zineb
 */
public class Nv_Enseignant_D extends javax.swing.JFrame {

    BD db;
    ResultSet Res, Res1;
    String numero;
    Date date;
    String diplome;
    String format = "yyyy/MM/dd";
    java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(format);
    int id_dip;

    public Nv_Enseignant_D(String num) {
        db = new BD(Parametre.Host,Parametre.username,Parametre.password,Parametre.IPHOST,Parametre.Port);

        initComponents();
        sortir.setEnabled(false);
        this.numero = num;
        doti.setText(numero);
        doti.setEnabled(false);
        date_ob.setEnabled(true);
        date_ob.getDateEditor().setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dip = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        doti = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        date_ob = new com.toedter.calendar.JDateChooser();
        clockFace1 = new org.edisoncor.gui.varios.ClockFace();
        jLabel2 = new javax.swing.JLabel();
        sortir = new org.edisoncor.gui.button.ButtonAction();
        inserer1 = new org.edisoncor.gui.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel10.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel10.setText("Diplôme:");

        jLabel9.setFont(new java.awt.Font("Serif", 3, 15)); // NOI18N
        jLabel9.setText("DOTI:");

        jLabel7.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel7.setText("Date d'Obtention:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 3, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(213, 99, 99));
        jLabel2.setText("Diplômes");

        sortir.setText("Sortir");
        sortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortirActionPerformed(evt);
            }
        });

        inserer1.setText("Insérer ");
        inserer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doti, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(date_ob, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dip, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(162, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inserer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sortir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)))
                .addComponent(jLabel2)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(date_ob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inserer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortirActionPerformed
        Principale x = new Principale();

        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);

        x.show();
        this.dispose();

    }//GEN-LAST:event_sortirActionPerformed

    private void inserer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserer1ActionPerformed
        diplome = dip.getText();
        date = date_ob.getDate();

        if (diplome.equals("") || date == null) {
            JOptionPane.showMessageDialog(this, "Remplissez tous les champs svp !!!");
        } else {

            Res = db.querySelectAll("Enseignant", "N_somme='" + numero + "'");
            Res1 = db.executionQuery("select count(*) from Diplomes");

            try {
                while (Res1.next()) {

                    id_dip = Integer.parseInt(Res1.getString("count(*)"));

                    id_dip++;
                    System.out.print(id_dip);
                }

                while (Res.next()) {

                    if (JOptionPane.showConfirmDialog(null, "êtes vous sûre d'avoir inserer les bonnes options ??") == 0) {
                        System.out.println("zz");
                        String tab[] = {"" + id_dip, diplome, formater.format(date)};
                        db.queryInsert("Diplomes", tab);

                        String tab1[] = {"" + id_dip, "" + Res.getString("id_Enseignant"), "" + numero};
                        db.queryInsert("obtient", tab1);
                        JOptionPane.showMessageDialog(this, "Vorte insertion est effectuée Avec Succés!!");
                        sortir.setEnabled(true);
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }

        }
    }//GEN-LAST:event_inserer1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.varios.ClockFace clockFace1;
    private com.toedter.calendar.JDateChooser date_ob;
    private javax.swing.JTextField dip;
    private javax.swing.JTextField doti;
    private org.edisoncor.gui.button.ButtonAction inserer1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private org.edisoncor.gui.button.ButtonAction sortir;
    // End of variables declaration//GEN-END:variables
}
