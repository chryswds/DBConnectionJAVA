package org.example;

public class Patient {
    //This patient info will be utilised by the system to add or change
    //patient data from the hospital database


    private String name;
    private String birthdate;
    private String bloodType;
    private int patientID;


    //static attribute
    //statics attributes are a class variable
    //it will be shared by all the objects within the class
    //currentId this will be used to generate new ID values to patients and check the currentIDs

    private static int currentID = 1;

    //Create 2 constructors
    //first constructor will be the patient data
    public Patient(String name, String birthdate, String bloodType) {
        this.name = name;
        this.birthdate = birthdate;
        this.bloodType = bloodType;
        this.patientID = currentID; //static attribute value 1
        currentID++; //value 2

        System.out.println(name + " has a birthday on " + birthdate);
    }
    //second constructor is when adding a patient to the db
    public Patient(String name, String birthdate, String bloodType, int patientID) {
        //add a patient with an ID
        this.name = name;
        this.birthdate = birthdate;
        this.bloodType = bloodType;
        this.patientID = patientID;

        if (currentID <= patientID) {
            currentID = patientID + 1; // this will increment the current ID

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getBloodType() {
        return bloodType;
    }

    public int getPatientID() {
        return patientID;
    }

    public static int getCurrentID() {
        return currentID;
    }
}
