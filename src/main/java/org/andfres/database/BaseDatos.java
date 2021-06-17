package org.andfres.database;


import org.andfres.logica.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
                        tipo INTEGER,
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



    public SistemaSolar cargar(int x, int y){

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

                ArrayList<CuerpoCeleste> cuerpos = new ArrayList<CuerpoCeleste>();

                // Cargar los planetas
                this.cargarPlanetas(conn, ss, cuerpos);
                this.cargarAsteroides(conn, ss, cuerpos);
                this.cargarVacios(conn, ss, cuerpos);


                // Ordenar los cuerpos Celestes
                cuerpos.sort(Comparator.comparing(CuerpoCeleste::getCoordenada));

                CuerpoCeleste [] cc = new CuerpoCeleste[cuerpos.size()];
                ss.cuerpoCelestes = cuerpos.toArray(cc);

            }
            conn.close();

        } catch(SQLException e){
            e.printStackTrace();
            System.err.println("Error al cargar sistema solar");


            System.err.println(e.getMessage());

        }

        return ss;


    }





    public void guardar(SistemaSolar ss){

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

            // Ejecutar el statement
            stmt.executeUpdate();

            // Leer el id auto-generado
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int newId =  rs.getInt(1);
                ss.setId(newId);
                System.err.println("Nuevo id " + newId);
            }


            // Guardar los cuerpos celestes
            for (CuerpoCeleste cc: ss.cuerpoCelestes) {
                if(cc instanceof CuerpoCelestePlaneta){
                    guardarPlaneta(conn, (CuerpoCelestePlaneta) cc);
                } else if(cc instanceof CuerpoCelesteAsteroide){
                    guardarAsteroide(conn, (CuerpoCelesteAsteroide) cc);
                } else if(cc instanceof CuerpoCelesteVacio){
                    guardarVacio(conn, (CuerpoCelesteVacio) cc);
                }
            }

            conn.close();

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }


    }// fin load ss
    
    
    public void guardarPlaneta(Connection conn, CuerpoCelestePlaneta planeta) throws SQLException {
        //System.out.println ("info "+ planeta.toString());
        String sql = "insert into Planeta(x,y,nombre, tipo, imagen,id_SS) values(?,?,?,?,?,?);";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, planeta.getCoordenada().getX() );
        stmt.setInt(2, planeta.getCoordenada().getY());
        stmt.setString(3, planeta.getNombre());
        stmt.setInt(4, planeta.getTipo());
        stmt.setString(5, planeta.getNombreImagen());
        stmt.setInt(6, planeta.getSistemaSolar().getId() );


        stmt.executeUpdate();
    }

    public void guardarAsteroide(Connection conn, CuerpoCelesteAsteroide asteroide) throws SQLException {

        String sql = "insert into Asteroide(x,y,id_SS) values(?,?,?);";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, asteroide.getCoordenada().getX() );
        stmt.setInt(2, asteroide.getCoordenada().getY());
        stmt.setInt(3, asteroide.getSistemaSolar().getId() );

        stmt.executeUpdate();

    }

    public void guardarVacio(Connection conn, CuerpoCelesteVacio vacio) throws SQLException {

        String sql = "insert into Vacio(x,y,id_SS) values(?,?,?);";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, vacio.getCoordenada().getX() );
        stmt.setInt(2, vacio.getCoordenada().getY());
        stmt.setInt(3, vacio.getSistemaSolar().getId() );


        stmt.executeUpdate();


    }

    public void cambiar_nombre( CuerpoCelestePlaneta planeta , String nombre) {

        try {

            Connection conn = this.connect();

            // String sql = "insert into Asteroide(x,y,nombre) values(?,?,?);";
            String sql =
                    """
                        UPDATE Planeta
                        SET nombre = ?
                        WHERE id_ss = ? 
                        and x = ? 
                        and y = ?;
                    """;

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, nombre);
            stmt.setInt(2, planeta.getSistemaSolar().getId() );
            stmt.setInt(3, planeta.getCoordenada().getX() );
            stmt.setInt(4, planeta.getCoordenada().getY());

            System.out.println("nombre cambiado");
            stmt.executeUpdate();

            conn.close();

        }catch (SQLException e){}

    }



}

