package org.example;

public class DB_Connection {
    protected final static String DB_BASE_URL = "jdbc:mysql://localhost";
    protected final static String USER = "root";
    protected final static String PASSWORD = "password";
    protected final static String DB_NAME = "hospital";
    protected final static String TABLE = "patient_data";
    protected final static String DB_URL = DB_BASE_URL + "/" + DB_NAME;

}
