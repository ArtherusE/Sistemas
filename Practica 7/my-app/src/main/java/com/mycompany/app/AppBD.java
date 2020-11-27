package com.mycompany.app;

import com.google.gson.Gson;

import static spark.Spark.*;

import java.util.PrepareStatement;

public class AppDB {
    private static Gson gson = new Gson();

    public static void main(String[] args){
        before((req, res) -> res.type("application/json") );
        get("/usuarios", (req, res) -> gson.toJson(DA.dameUsuarios()));

        post("/usuarios", (req, res) -> {
            String query = req.body();
            System.out.println( "Petición: " + query);
            Usuarios u = gson.fromJson(query, Usuarios.class);
            String id = UUID.randomUUID().toString();
            u.setId(id);
            usuarios.put(id, u);
            return  DAO..crearUsuario(u);
        });

    }

}
