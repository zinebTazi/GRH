package Gestion;


import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    static BD db;
    static ResultSet Res;

    public static void main(String[] args) throws SQLException {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {

        }
        

        Parametre a = new Parametre("GRH", "pfe", "GRH");
        Utilisateur F = new Utilisateur();

        F.setLocationRelativeTo(F.getGlassPane());
        F.setResizable(false);

        F.show();
    }

}
