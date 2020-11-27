package com.mycompany.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private static Conexion conexion = new Conexion();

    public static List<Usuarios> dameUsuarios(){
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        List<Usuarios> resultado =new ArrayList<>();

        con = conexion.getConexion();
        try{
            String sql = "SELECT * from usuarios";
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                Usuarios u = new Usuarios(rs.getString("id"), rs.getString("email"), rs.getString("password"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(rs !=null){
                try{
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                rs = null;
            }
            if(stm !=null){
                try{
                    stm.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                rs = null;
            }
            try{
                con.close();
                System.out.println("Closed connection");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return resultado;
    }

    public static List<Usuarios> crearUsuarios(Usuarios u){
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        List<Usuarios> resultado =new ArrayList<>();
        String msj = "";

        con = conexion.getConexion();
        try{
            String sql = "INSERT INTO usuarios (ide, email, password) VALUES (', ', '')";
            stm = con.preparedStatement(sql);
            stm.setString(1, u.getId());
            stm.setString(1, u.getEmail());
            stm.setString(1, u.getPassword());
            if(stm.executeUpdate() > 0)
                msj = "El usuario se agregó correctamente.";
            else
                msj = "No se pudo agregar el usuario.";
            rs = stm.executeQuery(sql);
            while(rs.next()){
                Usuarios u = new Usuarios(rs.getString("id"), rs.getString("email"), rs.getString("password"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(rs !=null){
                try{
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                rs = null;
            }
            if(stm !=null){
                try{
                    stm.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                rs = null;
            }
            try{
                con.close();
                System.out.println("Closed connection");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return msj;
    }
}
