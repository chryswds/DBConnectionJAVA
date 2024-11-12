package org.example;

import static org.example.DB_Connection.DB_URL;
import static org.example.DB_Connection.USER;
import static org.example.DB_Connection.PASSWORD;
import static org.example.DB_Connection.TABLE;


import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.sql.Connection;

public class DatabaseWriter {

    //This method will write information to the database

    public boolean addPatient(Patient patient) throws SQLException {
        //The patient instance == (name, birthdate, bloodtype, id)

        try(
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
        ){

            //Instert data into table INSTER INTO TABLE cols VALUES (?,?,?,?)
            String sql = String.format("INSERT INTO " + TABLE + " VALUES ("
                            + "'%s', '%s', '%s', '%d' );",
                    patient.getName(),
                    patient.getBirthdate(),
                    patient.getBloodType(),
                    patient.getPatientID()
            );
            stmt.executeUpdate(sql);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
