package com.mycompany.app;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
/**
 * Hello world!
 *
 */
public class App 
{
    private static Gson gson = new Gson();
    private static Map<String, Usuarios> usuarios = new HashMap<>();
    public static void main( String[] args )
    {
        get("/usuarios", (req, res) -> gson.tolson(usuarios.values() ));

        System.out.println( "Hello World!" );
    }
}
