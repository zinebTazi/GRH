package Avancement;

import Gestion.*;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Avancement extends javax.swing.JFrame {

    String cadre;
    String grade;
    String type;
    Date date;

    String format = "yyyy-MM-dd";
    java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(format);

    public Avancement() {
        initComponents();

        DateAvanc.getDateEditor().setEnabled(false);

        jCheckBox1.setVisible(false);
        jCheckBox2.setVisible(false);
        jCheckBox3.setVisible(false);

        cadre = jComboBox1.getSelectedItem().toString();
        grade = jComboBox2.getSelectedItem().toString();
        type = jComboBox3.getSelectedItem().toString();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        DateAvanc = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        clockFace1 = new org.edisoncor.gui.varios.ClockFace();
        jLabel14 = new javax.swing.JLabel();
        buttonAction1 = new org.edisoncor.gui.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Professeur assistant", "Professeur habilité", "Professeur d Enseignement Supérieur" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(213, 99, 99));
        jLabel2.setText("Avancement");

        jLabel3.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel3.setText("selectionnez le type  ");

        jLabel4.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel4.setText("selectionnez un grade ");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressource/logoFso.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel5.setText("selectionnez un cadre ");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "echelon", "grade" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Exceptionnel");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Rapide");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Normal");

        jLabel7.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel7.setText("selectionnez une date ");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressource/back.png"))); // NOI18N
        jLabel14.setText("jLabel14");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        buttonAction1.setText("Afficher Proposition ");
        buttonAction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateAvanc, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox3, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148)
                .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(buttonAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DateAvanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jCheckBox2))
                            .addComponent(jCheckBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(buttonAction1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        cadre = jComboBox1.getSelectedItem().toString();

        if (type.equals("echelon")) {
            if (cadre.equalsIgnoreCase("Professeur assistant")) {
                if (jComboBox2.getItemCount() == 3) {
                    jComboBox2.addItem("D");
                }
            } else {

                if (jComboBox2.getItemCount() == 4) {
                    jComboBox2.removeItemAt(3);
                }

            }
        } else {
            if (cadre.equalsIgnoreCase("Professeur assistant")) {
                if (jComboBox2.getItemCount() == 4) {
                    jComboBox2.removeItemAt(3);
                }
                if (jComboBox2.getItemCount() == 2) {
                    jComboBox2.addItem("C");
                }

            } else {

                if (jComboBox2.getItemCount() == 4) {
                    jComboBox2.removeItemAt(3);
                    jComboBox2.removeItemAt(2);
                }

                if (jComboBox2.getItemCount() == 3) {
                    jComboBox2.removeItemAt(2);
                }

            }

        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        grade = jComboBox2.getSelectedItem().toString();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Principale x = new Principale();

        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);

        x.show();
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed

    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed

        type = jComboBox3.getSelectedItem().toString();

        if (type.equals("grade")) {
            jCheckBox1.setVisible(true);
            jCheckBox2.setVisible(true);
            jCheckBox3.setVisible(true);

            if (cadre.equalsIgnoreCase("Professeur assistant")) {
                if (jComboBox2.getItemCount() == 4) {
                    jComboBox2.removeItemAt(3);
                }
                if (jComboBox2.getItemCount() == 2) {
                    jComboBox2.addItem("C");
                }

            } else {

                if (jComboBox2.getItemCount() == 4) {
                    jComboBox2.removeItemAt(3);
                    jComboBox2.removeItemAt(2);
                }

                if (jComboBox2.getItemCount() == 3) {
                    jComboBox2.removeItemAt(2);
                }

            }

        } else {
            jCheckBox1.setVisible(false);
            jCheckBox2.setVisible(false);
            jCheckBox3.setVisible(false);

            if (cadre.equalsIgnoreCase("Professeur assistant")) {
                if (jComboBox2.getItemCount() == 2) {
                    jComboBox2.addItem("C");
                    jComboBox2.addItem("D");
                }
                
                if (jComboBox2.getItemCount() == 3) {
                    jComboBox2.addItem("D");
                }
                
            } else {

                if (jComboBox2.getItemCount() == 2) {
                    jComboBox2.addItem("C");

                }
                
                if (jComboBox2.getItemCount() == 3) {
                    jComboBox2.addItem("D");

                }
                

                if (jComboBox2.getItemCount() == 4) {
                    jComboBox2.removeItemAt(3);
                }

            }
        }


    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        Principale x = new Principale();

        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);

        x.show();
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void buttonAction1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction1ActionPerformed

        date = DateAvanc.getDate();

        if (type.equals("grade")) {
            if (!jCheckBox1.isSelected() && !jCheckBox2.isSelected() && !jCheckBox3.isSelected()) {
                JOptionPane.showMessageDialog(null, "Cochez au moins une case SVP !!");
            } else {
                if (jCheckBox3.isSelected()) {

                    try {
                        if (date == null) {
                            JOptionPane.showMessageDialog(null, "Choisissez une date SVP !!");
                        } else {
                            Prop_GradePdf a = new Prop_GradePdf(jCheckBox3.getText(), cadre, grade, date);
                        }
                    } catch (DocumentException ex) {
                        Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (jCheckBox2.isSelected()) {

                    try {
                        if (date == null) {
                            JOptionPane.showMessageDialog(null, "Choisissez une date SVP !!");
                        } else {
                            Prop_GradePdf a = new Prop_GradePdf(jCheckBox2.getText(), cadre, grade, date);
                        }
                    } catch (DocumentException ex) {
                        Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (jCheckBox1.isSelected()) {

                    try {
                        if (date == null) {
                            JOptionPane.showMessageDialog(null, "Choisissez une date SVP !!");
                        } else {
                            Prop_GradePdf a = new Prop_GradePdf(jCheckBox1.getText(), cadre, grade, date);
                        }
                    } catch (DocumentException ex) {
                        Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            try {
                if (date == null) {
                    JOptionPane.showMessageDialog(null, "Choisissez une date SVP !!");
                } else {
                    Prop_EchelonPdf a = new Prop_EchelonPdf(cadre, grade, date);
                }
            } catch (DocumentException ex) {
                Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_buttonAction1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateAvanc;
    private org.edisoncor.gui.button.ButtonAction buttonAction1;
    private org.edisoncor.gui.varios.ClockFace clockFace1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
/*  if (jCheckBox1.isSelected()) {
            
 try {
 Prop_GradePdf a = new Prop_GradePdf(jCheckBox1.getText(),cadre, grade);
 } catch (DocumentException ex) {
 Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
 } catch (FileNotFoundException ex) {
 Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
 } catch (IOException ex) {
 Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
 }
 }*/

/*  if (type.equals("echelon")) {
 try {
 Prop_EchelonPdf a = new Prop_EchelonPdf(cadre, grade);
 } catch (DocumentException ex) {
 Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
 } catch (IOException ex) {
 Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
 } catch (SQLException ex) {
 Logger.getLogger(Avancement.class.getName()).log(Level.SEVERE, null, ex);
 }
 }*/
