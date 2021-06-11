package org.andfres.database;


import org.andfres.logica.Coordenada;
import org.andfres.logica.CuerpoCeleste;
import org.andfres.logica.CuerpoCelestePlaneta;
import org.andfres.logica.SistemaSolar;

import java.awt.*;
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
                        name TEXT NOT NULL
                        );
                        
            
                    CREATE TABLE IF NOT EXISTS Planeta (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        x INTEGER,
                        y INTEGER,
                        nombre TEXT,
                        imagen TEXT,
                        id_SS INTEGER REFERENCES SistemaSolar (id)
                        );
                        
                   
                    CREATE TABLE IF NOT EXISTS Asteroide (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        x INTEGER,
                        y INTEGER,
                        id_SS INTEGER REFERENCES SistemaSolar (id));
                        
                        
                    CREATE TABLE IF NOT EXISTS Vacio (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        x INTEGER,
                        y INTEGER,
                        id_SS INTEGER REFERENCES SistemaSolar (id));
              
                            
                    """;

            stmt.executeUpdate(sql);
            conn.close();

        } catch(SQLException e){
            System.err.println("ha petado en crear");
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
            System.err.println("ha petado en borrar");
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

                System.out.println("id: " +id + "x: " + x + "y: " + y);

                ss = new SistemaSolar(id, x2, y2, name);
                
                // Cargar los planetas
                this.loadPlanetas(conn, ss);

            }
            conn.close();

        } catch(SQLException e){
            e.printStackTrace();
            System.err.println("Error al cargar sistema solar");


            System.err.println(e.getMessage());

        }

        return ss;


    }





    public void save(SistemaSolar ss){


        try {

            Connection conn = this.connect();
            String sql;
            //Si sistema solar no tiene ID
            if(ss.getId() == null){
                sql = "insert into SistemaSolar(x,y,name) values( ?,?,?);";
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


            ResultSet rs = stmt.getGeneratedKeys();

//            int newId;
//            if (rs.next()) {
//                newId =  rs.getInt(1);
//                ss.setId(newId);
//                System.err.println("Nuevo id " + newId);
//
//            }
//



            int newId = stmt.executeUpdate();
            ss.setId(newId);
            System.err.println("Nuevo id " + newId);



            // Guardar los cuerpos celestes

            for (CuerpoCeleste cc: ss.cuerpoCelestes) {
                if(cc instanceof CuerpoCelestePlaneta){
                    savePlaneta(conn, (CuerpoCelestePlaneta) cc);
                }
            }

            conn.close();

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }


    }// fin load ss
    
    
    public void savePlaneta(Connection conn, CuerpoCelestePlaneta planeta) throws SQLException {

        //System.out.println ("info "+ planeta.toString());

        String sql = "insert into Planeta(x,y,nombre,imagen,id_SS) values(?,?,?,?,?);";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, planeta.getCoordenada().getX() );
        stmt.setInt(2, planeta.getCoordenada().getY());
        stmt.setString(3, planeta.getNombre());
        stmt.setString(4, planeta.getNombreImagen());
        stmt.setInt(5, planeta.getSistemaSolar().getId() );


        stmt.executeUpdate();


    }


}

