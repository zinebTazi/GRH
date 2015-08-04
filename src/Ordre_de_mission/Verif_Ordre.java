package Ordre_de_mission;

import Gestion.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Verif_Ordre extends javax.swing.JFrame {

    ResultSet Res, Res1, Res2;
    BD db;
    String DOTI;
    String id_Ens;
    int Numero_date;
    int Numero_ordre;
    int ordre;

    String format = "yyyy-MM-dd";
    java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(format);

    public Verif_Ordre(String num, Remplir_Ordre a) {
        db = new BD(Parametre.Host, Parametre.username, Parametre.password, Parametre.IPHOST, Parametre.Port);
        initComponents();

        this.DOTI = num;
        jAu.setEnabled(false);
        jAu.getDateEditor().setEnabled(false);
        jDu.setEnabled(false);
        jDu.getDateEditor().setEnabled(false);

        jLabel1.setText("<html><body bgcolor=\"#FFB266\" align=\"center\"><i><u><b>ORDRE DE MISSION</b></u></i></body></html>");

        Res = db.executionQuery("select *,max(avoir.id_sa)  from Enseignant ,situation_administrative,cadre,avoir"
                + " where Enseignant.N_somme='" + num + "'"
                + " and  Enseignant.N_somme=avoir.N_somme"
                + " and avoir.id_sa=situation_administrative.id_sa"
                + " and situation_administrative.id_cadre=cadre.id_cadre");

        ville.setText(a.destination);
        ville.setEnabled(false);

        jDu.setDate(a.getDepart());
        jAu.setDate(a.getArrivee());

        motifs.setText(a.motif);
        motifs.setEnabled(false);

        try {

            while (Res.next()) {

                nomP.setText("" + upperFirst(Res.getString("prenom")) + " " + upper(Res.getString("nom")));

                somme.setText("" + Res.getString("N_somme"));

                cadre.setText("" + Res.getString("type"));

                grade.setText("" + upper(Res.getString("echelle")));

                departement.setText("" + upperFirst(Res.getString("departement")));

            }

        } catch (SQLException e) {
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomP = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cadre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        grade = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        somme = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ville = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        motifs = new javax.swing.JTextArea();
        departement = new javax.swing.JLabel();
        jDu = new com.toedter.calendar.JDateChooser();
        jAu = new com.toedter.calendar.JDateChooser();
        Attes = new org.edisoncor.gui.button.ButtonAction();
        Annuler = new org.edisoncor.gui.button.ButtonAction();
        clockFace1 = new org.edisoncor.gui.varios.ClockFace();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        jLabel2.setText("Le Doyen de la faculté des sciences d'Oujda autorise :");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        jLabel3.setText("Mr:");

        nomP.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        jLabel4.setText("Cadre :");

        cadre.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        jLabel5.setText(",Grade :<<");

        grade.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        jLabel6.setText(">>    S.O.M :");

        somme.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        jLabel7.setText("Département de :");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        jLabel8.setText("A se rendre à:");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        jLabel9.setText("Du:");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        jLabel10.setText("au");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        jLabel11.setText("Motifs :");

        ville.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        ville.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                villeActionPerformed(evt);
            }
        });
        ville.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                villeKeyTyped(evt);
            }
        });

        motifs.setColumns(20);
        motifs.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        motifs.setRows(5);
        jScrollPane1.setViewportView(motifs);

        departement.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        Attes.setText("Générer Attestation");
        Attes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttesActionPerformed(evt);
            }
        });

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(1, 168, 158));
        jButton2.setForeground(java.awt.Color.white);
        jButton2.setText("Modifier");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(departement, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(1, 1, 1)
                                        .addComponent(cadre, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addGap(12, 12, 12)
                                        .addComponent(somme, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(jLabel9))
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jDu, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(93, 93, 93)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jAu, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomP, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(Attes, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Annuler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(nomP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cadre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(somme, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departement, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jDu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jAu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Annuler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Attes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void villeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_villeKeyTyped

    }//GEN-LAST:event_villeKeyTyped

    private void villeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_villeActionPerformed

    }//GEN-LAST:event_villeActionPerformed

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        Remplir_Ordre a = new Remplir_Ordre();
        a.setLocationRelativeTo(a.getParent());
        a.setLocationRelativeTo(a.getGlassPane());
        this.dispose();
    }//GEN-LAST:event_AnnulerActionPerformed

    private void AttesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttesActionPerformed
        Date date = jDu.getDate();
        Date date1 = jAu.getDate();

        if (ville.equals("") || motifs.equals("") || date == null || date1 == null) {
            JOptionPane.showMessageDialog(this, "Remplissez tous les champs svp !!");
        } else {

            if (JOptionPane.showConfirmDialog(null, "êtes vous sûre d'avoir générer l'Attestation de " + nomP.getText() + " ?") == 0) {

                Res = db.executionQuery("select count(*) from Ordre_de_mission");
                Res1 = db.executionQuery("select count(*) from Date");
                Res2 = db.executionQuery("select id_Enseignant from Enseignant where N_somme='" + DOTI + "'");

                try {

                    while (Res2.next()) {

                        id_Ens = Res2.getString("id_Enseignant");

                    }
                    while (Res1.next()) {

                        Numero_date = Integer.parseInt(Res1.getString("count(*)"));

                        Numero_date++;

                    }

                    while (Res.next()) {

                        Numero_ordre = Integer.parseInt(Res.getString("count(*)"));

                        Numero_ordre++;
                        System.out.println(Numero_ordre);
                        ordre = Numero_ordre;
                        String tab[] = {"" + Numero_ordre, ville.getText(), motifs.getText()};
                        db.queryInsert("Ordre_de_mission", tab);

                        String tab1[] = {"" + Numero_date, "" + formater.format(jDu.getDate()), "" + formater.format(jAu.getDate())};
                        db.queryInsert("Date", tab1);

                        String tab2[] = {"" + Numero_ordre, "" + id_Ens, DOTI, "" + Numero_date};
                        db.queryInsert("effectuer", tab2);

                    }

                    Ordre_de_MissionPdf a = new Ordre_de_MissionPdf(DOTI, ordre);

                } catch (SQLException ex) {
                    Logger.getLogger(Remplir_Ordre.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Verif_Ordre.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Verif_Ordre.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_AttesActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ville.setEnabled(true);
        motifs.setEnabled(true);

        jDu.setEnabled(true);
        jDu.getDateEditor().setEnabled(false);

        jAu.setEnabled(true);
        jAu.getDateEditor().setEnabled(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    String upper(String x) {
        return x.toUpperCase();
    }

    String upperFirst(String x) {
        return x.substring(0, 1).toUpperCase() + x.substring(1);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonAction Annuler;
    private org.edisoncor.gui.button.ButtonAction Attes;
    private javax.swing.JLabel cadre;
    private org.edisoncor.gui.varios.ClockFace clockFace1;
    private javax.swing.JLabel departement;
    private javax.swing.JLabel grade;
    private com.toedter.calendar.JDateChooser jAu;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea motifs;
    private javax.swing.JLabel nomP;
    private javax.swing.JLabel somme;
    private javax.swing.JTextField ville;
    // End of variables declaration//GEN-END:variables
}
