package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException  {
        //using the db setup class, we can check if the operation went ok

        if(DatabaseSetup.setupDB()){
            //if after we run the setupDB method all is ok
            //We have now created a db schema and created a table
            System.out.println("DB has been created successfully or already exists");
        }else{
            //this means there is an issue either connecting to the db or creating the schema
            System.out.println("There was a problem creating or connecting to the database.. \nPlease check db credentials");
            return;
        }
        // Add some patients to the db and check


    }
}