package org.example;

import java.sql.*;

public class Database {
    private Connection connection = null;
    private static Database instance = null;

    private Database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:database.db");
    }
    public static Database getInstance() throws SQLException {
        if (instance == null)
            instance = new Database();
        return instance;
    }
    public void insertPiatto(String nomePiatto, double prezzo, int quantita){
        //prova la connessione
        if(!testConnection()){
            throw new RuntimeException("Impossibile collegarsi al Database");
        }
        //preparazione query?
        String query ="INSERT INTO sushi_menu (nome_piatto,prezzo,quantita) VALUES ('" + nomePiatto + "'," + prezzo + "," + quantita + ");";
        //esecuzione query
        try {
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(query);
            stmt.setString(1, nomePiatto);
            stmt.setDouble(2, prezzo);
            stmt.setInt(3, quantita);
            stmt.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean testConnection()
    {
        try {
            return connection.isValid(5);
        } catch (SQLException e) {
            return false;
        }
    }
}
