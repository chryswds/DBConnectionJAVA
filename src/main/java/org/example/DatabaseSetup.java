package org.example;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup extends DB_Connection{

    public static boolean setupDB() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{

        //Create an instance of the driver clas
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        //try to connect to the database
        try{

            Connection conn = DriverManager.getConnection(DB_BASE_URL,USER,PASSWORD);

            Statement stmt = conn.createStatement();
            //This is the query (Statement)
            //Check if we have the db otherwise we create it
            stmt.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME + ";");

            //Query the db using the USE
            stmt.execute("USE " + DB_NAME + ";"); //database (schema) pointer

            //Create a query to insert into the db
            String sql =
                    //CREATE TABLE IF NOT EXISTS PATIENT_DATA COLL (COL TYPE)
                    "CREATE TABLE IF NOT EXISTS " + TABLE + "("
                            + "name VARCHAR(255),"
                            + "birthdate DATE,"
                            + "bloodType VARCHAR(3),"
                            + "id INT(10)"
                            + ");";

            //take this String query and execute it

            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
