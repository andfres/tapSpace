package org.andfres.database;


import org.andfres.logica.SistemaSolar;

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
                    CREATE TABLE IF NOT EXISTS SistemaSolar (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        x INTEGER,
                        y INTEGER,
                        name TEXT NOT NULL,
                        UNIQUE(x,y));
                        
                    CREATE TABLE IF NOT EXISTS Planeta (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        numCC INTEGER,
                        nombre TEXT,
                        imagen TEXT,
                        id_SS INTEGER );
                        
                   
                    CREATE TABLE IF NOT EXISTS Asteroide (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        numCC INTEGER);
                        
                        
                    CREATE TABLE IF NOT EXISTS Vacio (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        numCC INTEGER;
              
                            
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
                    
                    DROP TABLE IF EXISTS SistemaSolar;
                    DROP TABLE IF EXISTS Planeta;
                    DROP TABLE IF EXISTS Asteroide;
                    DROP TABLE IF EXISTS Vacio;
                    DROP TABLE IF EXISTS Prueba;
                       
                    """;
            stmt.executeUpdate(sql);
            conn.close();

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }//Fin borrarTablas



    public SistemaSolar load(int x, int y){

        System.out.println("Loading (" + x + ',' + y + ')');

        SistemaSolar ss = null;

        try {

            Connection conn = this.connect();

            String sql = "select * from SistemaSolar where x = ? and y = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, x);
            stmt.setInt(2, y);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("id");
                int x2 = rs.getInt("x");
                int y2 = rs.getInt("y");
                String name = rs.getString("name");

                ss = new SistemaSolar(id, x2, y2, name);

            }
            conn.close();

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return ss;


    }





    public void save(SistemaSolar ss){


        try {

            Connection conn = this.connect();

            String sql;

            //Si sistema solar no tiene ID
            if(ss.getId() == null){
                sql = "insert into SistemaSolar(x,y,name) values(?,?,?);";
            } else {
                sql = "update SistemaSolar set x=?, y=?, name=? where id=?;";
            }

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, ss.getX());
            stmt.setInt(2, ss.getY());
            stmt.setString(3, ss.getName());


            if(ss.getId() != null){
                stmt.setInt(4, ss.getId());
            }

            stmt.executeUpdate();
            conn.close();

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }


    }


}

