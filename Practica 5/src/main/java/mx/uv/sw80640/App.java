package mx.uv.sw80640;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        port(80);
        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));


        get("/", (req, res) -> "Hola desde Spark");
        get("/hola", (request, response) -> "Hola hola" ->(
            System.out.println("Request: " + request.queryParams());
            System.out.println("Request: " + request.queryParams("PrmEmail"));
            System.out.println("Request: " + request.queryParams("PrmPassword"));
            return "Hola " + request.queryParams("PrmEmail")+ " desde spark";
        ));
        post("/adios", (request, response) -> {
            return null;
        )}
    }
}