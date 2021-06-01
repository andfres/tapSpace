
package org.andfres.db;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

import org.andfres.models.SolarSystem;
import org.andfres.models.Planet;


public class SolarSystemDB {
  



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


    public void createDB(){
        System.out.println("Creating DB");

        try {

            Connection conn = this.connect();

            Statement stmt = conn.createStatement();


            String sql = 
                "CREATE TABLE IF NOT EXISTS SolarSystem (" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    x INTEGER," +
                "    y INTEGER," +
                "    name TEXT NOT NULL," +
                "    UNIQUE(x,y) " +

                ");";

            stmt.executeUpdate(sql);

            conn.close();

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }


    public SolarSystem load(int x, int y){

        System.out.println("Loading (" + x + ',' + y + ')');

        SolarSystem ss = null;

        try {

            Connection conn = this.connect();


            String sql = "select * from SolarSystem where x = ? and y = ?;"; 
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, x);
            stmt.setInt(2, y);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("id");
                int x2 = rs.getInt("x");
                int y2 = rs.getInt("y");
                String name = rs.getString("name");

                ss = new SolarSystem(id, x2, y2, name);
        
            }
            conn.close();   

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return ss;


    }





    public void save(SolarSystem ss){


        try {

            Connection conn = this.connect();

            String sql; 

            if(ss.getId() == null){
                sql = "insert into SolarSystem(x,y,name) values(?,?,?);"; 
            } else {
                sql = "update SolarSystem set x=?, y=?, name=? where id=?;"; 
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
