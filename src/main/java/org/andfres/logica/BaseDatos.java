package org.andfres.logica;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class BaseDatos {


    private Connection connect(){

        Connection conn = null;

        try {
            String url = "jdbc:sqlite:./SolarSystem.db";
            conn = DriverManager.getConnection(url);


        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return conn;
    }



    public void crearTablas(){

        System.out.println("Creando Tablas");

        try {

            Connection conn = this.connect();
            Statement stmt = conn.createStatement();

            String sql = """
                    CREATE TABLE IF NOT EXISTS SolarSystem (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        x INTEGER,
                        y INTEGER,
                        name TEXT NOT NULL,
                        UNIQUE(x,y));
                        
                    CREATE TABLE IF NOT EXISTS Prueba (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        x INTEGER,
                        y INTEGER);
              
                    """;

            stmt.executeUpdate(sql);
            conn.close();

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }


    public void borrarTablas(){

        System.out.println("borrando tablas");

        try {

            Connection conn = this.connect();
            Statement stmt = conn.createStatement();

            String sql = """
                    
                    DROP TABLE IF EXISTS SolarSystem;
                    DROP TABLE IF EXISTS Prueba;
                       
                    """;

            stmt.executeUpdate(sql);
            conn.close();

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }


}

