package Avancement;


import Gestion.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModifierSituation extends javax.swing.JFrame {

    BD db;
    ResultSet Res, Res3, Res1, Res2;

    String numero;
    String prenom;
    String cadre;
    int id_cadre;
    String grade;
    String echelon;

    String cadre_T;
    String grade_T;
    String echelon_T;
    Date anciennete;
    Date anciennete1;

    int Numero_situation;

    String format = "yyyy/MM/dd";
    java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(format);

    ActionEvent event;

    public ModifierSituation() {
        db = new BD(Parametre.Host, Parametre.username, Parametre.password, Parametre.IPHOST, Parametre.Port);
        initComponents();

        Modifier.setEnabled(false);
        Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        Table.getColumnModel().getColumn(0).setPreferredWidth(100);
        Table.getColumnModel().getColumn(1).setPreferredWidth(110);
        Table.getColumnModel().getColumn(2).setPreferredWidth(110);
        Table.getColumnModel().getColumn(4).setPreferredWidth(270);
        Table.getColumnModel().getColumn(7).setPreferredWidth(140);

        numero = text_numero.getText();
        cadre = ComboCadre.getSelectedItem().toString();
        grade = ComboGrade.getSelectedItem().toString();
        echelon = ComboEchelon.getSelectedItem().toString();
        anciennete = text_anciennete_E.getDate();

        ComboCadre.setEditable(false);
        ComboCadre.setEnabled(false);

        ComboGrade.setEditable(false);
        ComboGrade.setEnabled(false);

        ComboEchelon.setEditable(false);
        ComboEchelon.setEnabled(false);

        text_anciennete_E.setEnabled(false);
        text_anciennete_G.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text_numero = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ComboCadre = new javax.swing.JComboBox();
        ComboGrade = new javax.swing.JComboBox();
        ComboEchelon = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        text_anciennete_E = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        clockFace1 = new org.edisoncor.gui.varios.ClockFace();
        jLabel19 = new javax.swing.JLabel();
        buttonAction2 = new org.edisoncor.gui.button.ButtonAction();
        buttonAction3 = new org.edisoncor.gui.button.ButtonAction();
        Modifier = new javax.swing.JButton();
        text_anciennete_G = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        text_numero.setToolTipText("<html><font color=\"blue\"><i>Saisissez votre DOTI</i></font></html>");
        text_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_numeroActionPerformed(evt);
            }
        });
        text_numero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                text_numeroKeyPressed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(1, 168, 158));
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Vérifier");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel1.setText("DOTI :");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressource/logoFso.jpg"))); // NOI18N
        jLabel10.setText("jLabel6");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(218, 90, 90));
        jLabel2.setText("Nouvelle Situation");

        jLabel3.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel3.setText("cadre :");

        jLabel4.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel4.setText(" grade :");

        jLabel5.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel5.setText(" echelon :");

        ComboCadre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Professeur assistant", "Professeur habilité", "Professeur d Enseignement Supérieur" }));
        ComboCadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCadreActionPerformed(evt);
            }
        });

        ComboGrade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D" }));
        ComboGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboGradeActionPerformed(evt);
            }
        });

        ComboEchelon.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        ComboEchelon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboEchelonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel7.setText("Ancienneté Echelon:");

        jLabel6.setFont(new java.awt.Font("Ubuntu Light", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(50, 126, 147));
        jLabel6.setText("     Situation actuelle");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel11.setFont(new java.awt.Font("Ubuntu Light", 3, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(50, 126, 147));
        jLabel11.setText("     Nouvelle Situation");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° de Some", "nom", "prenom", "CIN", "cadre", "grade", "echelon", "anciennete"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setResizable(false);
            Table.getColumnModel().getColumn(1).setResizable(false);
            Table.getColumnModel().getColumn(2).setResizable(false);
            Table.getColumnModel().getColumn(3).setResizable(false);
            Table.getColumnModel().getColumn(4).setResizable(false);
            Table.getColumnModel().getColumn(5).setResizable(false);
            Table.getColumnModel().getColumn(6).setResizable(false);
            Table.getColumnModel().getColumn(7).setResizable(false);
        }

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ressource/back.png"))); // NOI18N
        jLabel19.setText("jLabel14");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        buttonAction2.setText("Valider");
        buttonAction2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction2ActionPerformed(evt);
            }
        });

        buttonAction3.setText("Annuler");
        buttonAction3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction3ActionPerformed(evt);
            }
        });

        Modifier.setBackground(new java.awt.Color(1, 168, 158));
        Modifier.setForeground(java.awt.Color.white);
        Modifier.setText("Modifier");
        Modifier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        jLabel8.setText("Ancienneté Grade:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ComboCadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ComboGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)
                                        .addComponent(ComboEchelon, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(text_anciennete_E, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(text_anciennete_G, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(183, 183, 183)
                                        .addComponent(Modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(117, 117, 117))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonAction2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonAction3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(198, 198, 198))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(386, 386, 386)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 24, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(clockFace1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(ComboEchelon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ComboCadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(ComboGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(text_anciennete_E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(text_anciennete_G, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(Modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAction3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAction2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        prenom = null;
        numero = text_numero.getText();
        Object[] data = new Object[8];
        Date d = null;

        if (numero.equals("")) {
            JOptionPane.showMessageDialog(this, "Saisissez le numero de somme svp !!");
        } else {

            try {
                Res = db.querySelectAll("Enseignant", "N_somme='" + numero + "'");

                while (Res.next()) {

                    prenom = Res.getString("prenom");
                }

                if (prenom == null) {
                    JOptionPane.showMessageDialog(this, "Ce numéro de SOM est incorrecte!!");
                    DefaultTableModel model = (DefaultTableModel) Table.getModel();
                    if (model.getRowCount() == 1) {
                        model.removeRow(0);
                    }

                    text_numero.setText("");
                    text_anciennete_E.setDate(d);
                    text_anciennete_G.setDate(d);

                    ComboCadre.setSelectedIndex(0);
                    ComboGrade.setSelectedIndex(0);
                    ComboEchelon.setSelectedIndex(0);

                    ComboCadre.setEditable(false);
                    ComboCadre.setEnabled(false);

                    ComboGrade.setEditable(false);
                    ComboGrade.setEnabled(false);

                    ComboEchelon.setEditable(false);
                    ComboEchelon.setEnabled(false);

                    text_anciennete_E.setEnabled(false);
                    text_anciennete_G.setEnabled(false);

                } else {

                    Res3 = db.executionQuery("select echelon,echelle,type from situation_administrative,avoir,cadre where situation_administrative.id_sa=avoir.id_sa and  situation_administrative.id_cadre=cadre.id_cadre and avoir.N_somme='" + numero + "'");

                    try {
                        while (Res3.next()) {

                            if (Res3.last()) {

                                echelon_T = Res3.getString("echelon");
                                grade_T = Res3.getString("echelle");
                                cadre_T = Res3.getString("type");

                                Res1 = db.executionQuery("select *,DATE_ADD(anciennete_E, INTERVAL 2 YEAR) from Enseignant , avoir , situation_administrative,cadre "
                                        + "where Enseignant.N_somme=avoir.N_somme "
                                        + "and avoir.id_sa=situation_administrative.id_sa "
                                        + "and situation_administrative.id_cadre=cadre.id_cadre "
                                        + "and cadre.type='" + cadre_T + "' "
                                        + "and Enseignant.N_somme='" + numero + "' "
                                        + "and situation_administrative.echelle= '" + grade_T + "' "
                                        + " and situation_administrative.echelon='" + echelon_T + "' ");

                                while (Res1.next()) {
                                    DefaultTableModel model = (DefaultTableModel) Table.getModel();
                                    if (model.getRowCount() == 1) {
                                        model.removeRow(0);
                                    }

                                    data[0] = Res1.getString("N_somme");
                                    data[1] = Res1.getString("nom");
                                    data[2] = Res1.getString("prenom");
                                    data[3] = Res1.getString("CIN");
                                    data[4] = Res1.getString("type");
                                    data[5] = Res1.getString("echelle");
                                    data[6] = Res1.getString("echelon");
                                    data[7] = Res1.getString("anciennete_E");
                                    Modifier.setEnabled(true);
                                    model.addRow(data);

                                    if (Integer.parseInt(Res1.getString("echelon")) < 4) {
                                        ComboCadre.setSelectedItem("" + cadre_T);

                                        ComboGrade.setSelectedItem("" + grade_T);
                                        ComboEchelon.setSelectedIndex(Integer.parseInt(Res1.getString("echelon")));
                                        text_anciennete_E.setDate(Res1.getDate("DATE_ADD(anciennete_E, INTERVAL 2 YEAR)"));
                                        text_anciennete_G.setDate(Res1.getDate("ancienete_G"));
                                    }
                                    if (Integer.parseInt(Res1.getString("echelon")) >= 4) {
                                        if (cadre_T.equalsIgnoreCase("Professeur d Enseignement Supérieur")) {
                                            if (grade_T.equals("C")) {
                                                ComboCadre.setSelectedItem("" + cadre_T);
                                                ComboGrade.setSelectedItem("" + grade_T);
                                                ComboEchelon.setSelectedIndex(4);

                                                text_anciennete_E.setDate(Res1.getDate("DATE_ADD(anciennete_E, INTERVAL 2 YEAR)"));
                                                text_anciennete_G.setDate(Res1.getDate("ancienete_G"));
                                            } else {

                                                ComboCadre.setSelectedItem("" + cadre_T);
                                                ComboEchelon.setSelectedIndex(0);
                                                ComboGrade.setSelectedItem("" + grade_T);
                                                ComboGrade.setSelectedIndex(ComboGrade.getSelectedIndex() + 1);
                                                text_anciennete_E.setDate(Res1.getDate("DATE_ADD(anciennete_E, INTERVAL 2 YEAR)"));
                                                text_anciennete_G.setDate(Res1.getDate("DATE_ADD(anciennete_E, INTERVAL 2 YEAR)"));
                                            }
                                        } else {
                                            if (grade_T.equals("A") || grade_T.equals("B") || grade_T.equals("C")) {

                                                ComboCadre.setSelectedItem("" + cadre_T);
                                                ComboEchelon.setSelectedIndex(0);
                                                ComboGrade.setSelectedItem("" + grade_T);
                                                ComboGrade.setSelectedIndex(ComboGrade.getSelectedIndex() + 1);
                                                text_anciennete_E.setDate(Res1.getDate("DATE_ADD(anciennete_E, INTERVAL 2 YEAR)"));
                                                text_anciennete_G.setDate(Res1.getDate("DATE_ADD(anciennete_E, INTERVAL 2 YEAR)"));
                                            } else {
                                                ComboCadre.setSelectedItem("" + cadre_T);
                                                ComboCadre.setSelectedIndex(ComboCadre.getSelectedIndex() + 1);
                                                ComboEchelon.setSelectedIndex(0);
                                                ComboGrade.setSelectedIndex(0);
                                                text_anciennete_E.setDate(Res1.getDate("DATE_ADD(anciennete_E, INTERVAL 2 YEAR)"));
                                                text_anciennete_G.setDate(Res1.getDate("DATE_ADD(anciennete_E, INTERVAL 2 YEAR)"));
                                            }

                                        }
                                    }
                                }
                            }
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(ModifierSituation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ModifierSituation.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        Principale x = new Principale();

        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);

        x.show();
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void ComboCadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCadreActionPerformed
        cadre = ComboCadre.getSelectedItem().toString();
        if (cadre.equalsIgnoreCase("Professeur assistant")) {
            if (ComboGrade.getItemCount() == 3) {
                ComboGrade.addItem("D");
            }
            if (ComboEchelon.getItemCount() == 5) {
                ComboEchelon.removeItemAt(4);

            }

        } else {

            if (ComboGrade.getItemCount() == 4) {
                ComboGrade.removeItemAt(3);
            }

            if (ComboGrade.getSelectedItem().equals("C") && ComboCadre.getSelectedIndex() == 2) {
                if (ComboEchelon.getItemCount() == 4) {
                    ComboEchelon.addItem("5");
                }

            }

            if (ComboEchelon.getItemCount() == 5) {
                ComboEchelon.removeItemAt(4);
            }
        }


    }//GEN-LAST:event_ComboCadreActionPerformed

    private void ComboGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboGradeActionPerformed
        grade = ComboGrade.getSelectedItem().toString();

        if (cadre.equalsIgnoreCase("Professeur assistant") || cadre.equalsIgnoreCase("Professeur habilité")) {
            if (ComboEchelon.getItemCount() == 5) {
                ComboEchelon.removeItemAt(4);

            }
        } else {

            if (ComboGrade.getSelectedItem().equals("C")) {
                if (ComboEchelon.getItemCount() == 4) {
                    ComboEchelon.addItem("5");
                }

            } else {

                if (ComboEchelon.getItemCount() == 5) {
                    ComboEchelon.removeItemAt(4);
                }
            }
        }
    }//GEN-LAST:event_ComboGradeActionPerformed

    private void ComboEchelonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboEchelonActionPerformed
        echelon = ComboEchelon.getSelectedItem().toString();


    }//GEN-LAST:event_ComboEchelonActionPerformed

    private void text_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_numeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_numeroActionPerformed

    private void text_numeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_numeroKeyPressed
        if (evt.getKeyCode() == 10) {
            jButton1ActionPerformed(event);
        }

    }//GEN-LAST:event_text_numeroKeyPressed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        Principale x = new Principale();

        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);

        x.show();
        this.dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void buttonAction3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction3ActionPerformed
        Principale x = new Principale();

        x.setLocationRelativeTo(x.getGlassPane());
        x.setResizable(false);

        x.show();
        this.dispose();
    }//GEN-LAST:event_buttonAction3ActionPerformed

    private void buttonAction2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction2ActionPerformed

        numero = text_numero.getText();
        anciennete = text_anciennete_E.getDate();
        anciennete1 = text_anciennete_G.getDate();

        if (cadre.equals("Professeur assistant")) {
            id_cadre = 1;
        }
        if (cadre.equals("Professeur habilité")) {
            id_cadre = 2;
        }
        if (cadre.equals("Professeur d Enseignement Supérieur")) {
            id_cadre = 3;
        }

        if (numero.equals("") || anciennete == null) {
            JOptionPane.showMessageDialog(this, "Remplissez tous les champs svp !!!");
        } else {

            Res3 = db.querySelectAll("Enseignant", "N_somme='"
                    + numero + "'");

            try {
                while (Res3.next()) {

                    prenom = Res3.getString("prenom");

                }

                if (prenom == null) {
                    JOptionPane.showMessageDialog(this, "Le N° de Somme est incorrecte");
                    text_numero.setText("");

                }
            } catch (SQLException ex) {
                Logger.getLogger(ModifierSituation.class.getName()).log(Level.SEVERE, null, ex);
            }

            Res3 = db.executionQuery("select *,Enseignant.id_Enseignant from situation_administrative,avoir,Enseignant "
                    + "where situation_administrative.id_sa=avoir.id_sa"
                    + " and avoir.N_somme=Enseignant.N_somme"
                    + " and avoir.N_somme='" + numero + "'");
            Res1 = db.executionQuery("select count(*) from situation_administrative ");

            try {
                while (Res1.next()) {

                    Numero_situation = Integer.parseInt(Res1.getString("count(*)"));

                    Numero_situation++;
                    System.out.print(Numero_situation);
                }

                while (Res3.next()) {
                    if (Res3.last()) {
                        if (JOptionPane.showConfirmDialog(null, "êtes vous sûre d'avoir inserer les bonnes options ??") == 0) {
                            System.out.println("zz");
                            String tab[] = {"" + Numero_situation, grade, echelon, formater.format(anciennete), formater.format(anciennete1), Res3.getString("fonction"), Res3.getString("departement"), "" + id_cadre};
                            db.queryInsert("situation_administrative", tab);

                            String tab1[] = {"" + Numero_situation, "" + Res3.getString("id_Enseignant"), "" + numero};
                            db.queryInsert("avoir", tab1);
                        }
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }

        }
    }//GEN-LAST:event_buttonAction2ActionPerformed

    private void ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierActionPerformed
        ComboCadre.setEditable(true);
        ComboCadre.setEnabled(true);

        ComboGrade.setEditable(true);
        ComboGrade.setEnabled(true);

        ComboEchelon.setEditable(true);
        ComboEchelon.setEnabled(true);

        text_anciennete_E.setEnabled(true);
        text_anciennete_E.getDateEditor().setEnabled(false);

        text_anciennete_G.setEnabled(true);
        text_anciennete_G.getDateEditor().setEnabled(false);
    }//GEN-LAST:event_ModifierActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboCadre;
    private javax.swing.JComboBox ComboEchelon;
    private javax.swing.JComboBox ComboGrade;
    private javax.swing.JButton Modifier;
    private javax.swing.JTable Table;
    private org.edisoncor.gui.button.ButtonAction buttonAction2;
    private org.edisoncor.gui.button.ButtonAction buttonAction3;
    private org.edisoncor.gui.varios.ClockFace clockFace1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser text_anciennete_E;
    private com.toedter.calendar.JDateChooser text_anciennete_G;
    private javax.swing.JTextField text_numero;
    // End of variables declaration//GEN-END:variables
}
