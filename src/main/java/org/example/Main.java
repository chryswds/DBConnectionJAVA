package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException  {
        //using the db setup class, we can check if the operation went ok

        if(DatabaseSetup.setupDB()){
            //if after we run the setupDB method all is ok
            //We have now created a db schema and created a table
            System.out.println("DB has been created successfully or already exists");

            // Instantiating the writer and reader for the db
            DatabaseWriter dbw = new DatabaseWriter(); // This will allow us to write to the db
            DatabaseReader dbr = new DatabaseReader(); // This will allow us to read from the db
            Scanner scanner = new Scanner(System.in);

            // We want to present this menu to the user
            // We want the user to interact for as long as they please

            while(true){
                // Like all menus
                // We need a couple of print statements
                // To present to the user

                System.out.println("\nHospital Admin System (HAS)");
                System.out.println("Please select from the following options:\n");
                System.out.println("1. Insert a patient record");
                System.out.println("2. Read patient data");
                System.out.println("3. Exit");
                System.out.println("Enter your choice:\n");

                // Capture the user choice
                int choice = scanner.nextInt();
                scanner.nextLine(); // Add another line

                // Take in the user choice
                // Provide a functionality according to the user selection
                // There is going to be 3 options
                switch(choice){

                    // Since we know it's a number the cases are going to be numbers
                    case 1:
                        //Insert data to the db
                        System.out.println("Enter patient data: ");
                        System.out.println("Name: ");
                        String name = scanner.nextLine();
                        System.out.println("Date of Birth (YYYY-MM-DD): ");
                        String birthdate = scanner.nextLine();
                        System.out.println("Blood Type");
                        String bloodtype = scanner.nextLine();
                        // Collect all user input

                        Patient newPatient = new Patient(name, birthdate, bloodtype);


                        // Try adding the patient record
                        // Check if the process is successful
                        // Otherwise let the user know
                        if(dbw.addPatient(newPatient)){
                            System.out.println("Patient has been inserted successfully");
                        }else{
                            System.out.println("Patient could not be inserted, please check all field inputs");
                        }
                        break;
                    case 2: //read the data from the db
                        ArrayList<Patient> patients = dbr.getAllData();
                        // Retrieve the data from the db
                        // Store it as the patient arraylist
                        // Check if its empty
                        if(patients.isEmpty()){
                            System.out.println("No patients found");
                        }else{
                            System.out.printf("%-5s | %-20s | %-12s | %-8s", "\nID", "Name", "Date", "Blood Type");
                            System.out.println("\n------------------------------------------------------------");
                            // Print out all the patients records into the table
                            // This will require iterating through the patients arraylist

                            for(Patient patient : patients){
                                System.out.printf("%-5s | %-20s | %-12s | %-8s\n", patient.getPatientID(), patient.getName(), patient.getBirthdate(), patient.getBloodType());
                            }
                            break;

                        }
                        case 3:
                            System.out.println("Thank you for using our system");
                            System.out.println("System exit");
                            scanner.close(); // IO Stream and we don't want the user to be able to interact with the system
                            return;


                        default:
                            System.out.println("Invalid choice");
                }
            }
        }else{
            //this means there is an issue either connecting to the db or creating the schema
            System.out.println("There was a problem creating or connecting to the database.. \nPlease check db credentials");
            return;


        }


    }
}