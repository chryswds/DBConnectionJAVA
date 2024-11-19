package org.example;

import java.sql.*;
import java.util.ArrayList;


public class DatabaseReader extends DB_Connection {


    // We will need to be able to read data back
    // from the database to the user
    // Since we have formatted the patient data
    // We can use a collection method to store and retrieve all the patient data



    // This method will handle retrieval and storage of patient data
    public ArrayList<Patient> getAllData(){

        // In order to retrieve the information we first must
        // Connect to the database
        // This method will act as "SELECT * FROM TABLE" SQL Command
        ArrayList<Patient> patients = new ArrayList<>();

        // Try to connect to the database and retrieve the information

        try(
                Connection conn = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
                ){
            // In this block we will handle any requirements for pulling the data from the db
            // Handle any validations
            // Now that the connection is established
            // We begin creating the logic for reading the data from the db
            // There will be multiple records, we would like to iterate through all the records
            ResultSet results = stmt.executeQuery(String.format("SELECT * FROM %s;", TABLE));
            // Create a check for results and create a while loop to iterate through them
            // For every result we have the data will look like this
            // Name, BirthData, BloodType, ID
            // As long as we have more rows to go through we will keep iterating
            while(results.next()){
                String name = results.getString("name"); // Patient name
                String birthdate = results.getString("birth_date"); // Patient BD
                String bloodtype = results.getString("blood_type"); // Patient BT
                int id = results.getInt("id"); // Patient ID
                // Format the output from the query and insert into a collection
                Patient patient = new Patient(name, birthdate, bloodtype, id);
                patients.add(patient);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        //returning the arraylist data
        return patients;


    }
}
