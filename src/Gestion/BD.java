package Gestion;


import java.net.Socket;
import java.sql.*;

public class BD {

    Connection connection;
    Statement statement;
    String SQL;
    String url;
    String username;
    String password;
    Socket client;
    int Port;
    String Host;

    public BD(String url, String username, String password, String Host, int Port) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.Host = Host;
        this.Port = Port;

    }

    public Connection connexionDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return connection;
    }
    
    public Connection connexionDatabase(String uni) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url+uni, username, password);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return connection;
    }
    
    

    public Connection closeconnexion() {
        try {
            connection.close();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }

    public ResultSet executionQuery(String sql) {
        connexionDatabase();
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            System.out.println(sql);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return resultSet;
    }

    public String executionUpdate(String sql) {
        connexionDatabase();
        String result = "";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            result = sql;
            System.out.println(sql);

        } catch (SQLException e) {
            result = e.toString();
        }
        return result;
    }

    public ResultSet querySelectAll(String nomTable) {
        connexionDatabase();
        SQL = "SELECT * FROM " + nomTable;
        System.out.println(SQL);
        return this.executionQuery(SQL);

    }

    public ResultSet querySelectAll(String nomTable, String etat) {
        connexionDatabase();
        SQL = "SELECT * FROM " + nomTable + " WHERE " + etat;

        return this.executionQuery(SQL);

    }

    public ResultSet querySelect(String[] nomColonne, String nomTable) {
        connexionDatabase();
        int i;
        SQL = "SELECT";
        for (i = 0; i <= nomColonne.length - 1; i++) {
            SQL += nomColonne[i];
            if (i < nomColonne.length - 1) {
                SQL += ",";
            }
        }
        SQL += " FROM " + nomTable;
        return this.executionQuery(SQL);
    }

    public ResultSet fcSelectCommand(String[] nomColonne, String nomTable, String etat) {

        connexionDatabase();
        int i;
        SQL = "SELECT";
        for (i = 0; i <= nomColonne.length - 1; i++) {
            SQL += nomColonne[i];
            if (i < nomColonne.length - 1) {
                SQL += ",";
            }
        }
        SQL += " FROM " + nomTable + " WHERE " + etat;
        return this.executionQuery(SQL);
    }

    public String queryInsert(String nomTable, String[] contenuTab) {

        connexionDatabase();
        int i;
        SQL = "INSERT INTO " + nomTable + " VALUES(";
        for (i = 0; i <= contenuTab.length - 1; i++) {
            SQL += "'" + contenuTab[i] + "'";
            if (i < contenuTab.length - 1) {
                SQL += ",";
            }

        }
        SQL += ")";
        
        return this.executionUpdate(SQL);
    }

    public String queryUpdate(String nomTable, String[] nomColonne, String[] contenuTab, String etat) {

        connexionDatabase();
        int i;
        SQL = "UPDATE " + nomTable + " SET ";
        for (i = 0; i <= nomColonne.length - 1; i++) {
            SQL += nomColonne[i] + "='" + contenuTab[i] + "'";
            if (i < nomColonne.length - 1) {
                SQL += ",";
            }

        }
        SQL += " WHERE " + etat;
        return this.executionUpdate(SQL);
    }

    public String queryDelete(String nomTable) {
        connexionDatabase();
        SQL = "DELETE FROM " + nomTable;
        return this.executionUpdate(SQL);
    }

    public String queryDelete(String nomTable, String etat) {
        connexionDatabase();
        SQL = "DELETE FROM " + nomTable + " WHERE " + etat;
        return this.executionUpdate(SQL);
    }

}
