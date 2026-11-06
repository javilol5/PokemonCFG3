package Connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnector {
    public static Connection conexion() {

        try {
            String url = "jdbc:postgresql://10.0.9.226:5432/probas";

            Connection conn = DriverManager.getConnection(url, "postgres", "admin");
            return conn;
        } catch (Exception e) {
            System.out.println("Erro na conexión: "+ e.getMessage());
            return null;
        }

    }

    public static void main(String[] args) {

        Connection conn = DBconnector.conexion();

        if (conn != null) {
            System.out.println("Conexion correcta");

            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Erro ao pechar a conexión: " + e.getMessage());
            }

        } else {
            System.out.println("No se pudo conectar");
        }

        System.out.println();
        System.out.println("CASAL");
    }
}