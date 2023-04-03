package com.example.users;

import java.io.Serializable;

public class User implements Serializable {

    protected String firstName;
    protected String lastName;
    protected String email;
    protected String degreeProgram;
    protected String completed;

    public User(String firstName, String lastName, String email, String degreeProgram, String completed){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.completed = completed;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getDegreeProgram(){
        return degreeProgram;
    }
    public String getCompleted(){return completed;}

    public void printInfo(){
        System.out.println(firstName + lastName);
        System.out.println(email);
        System.out.println(degreeProgram);
        System.out.println(completed);
    }

    public String toString(){return firstName+lastName;}
}
