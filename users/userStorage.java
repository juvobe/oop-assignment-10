package com.example.users;

import android.content.Context;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class userStorage {

    /*private TextView nameOutput;
    private TextView degreeOutput;
    private TextView emailOutput;*/


    private ArrayList<User> users = new ArrayList<>();

    private static userStorage storage = null;

    private userStorage(){
    }

    public static userStorage getInstance(){
        if(storage == null){
            storage = new userStorage();
        }
        return storage;
    }

    public ArrayList<User>getUsers(){return users;}

    public void addUser(User user){
        users.add(user);
    }

    public void listUsers(){
        for(User user : users){
            user.printInfo();
            /*nameOutput.setText(user.firstName);
            degreeOutput.setText(user.getDegreeProgram());
            emailOutput.setText(user.getEmail());*/
        }
    }

    public void saveUsers(Context context){
        try{
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("users.data", context.MODE_PRIVATE));
            userWriter.writeObject(users);
            userWriter.close();
        } catch (IOException e){
            System.out.println("Käyttäjien tallentaminen epäonnistui");
        }
    }

    public void loadUsers(Context context){
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("users.data"));
            users = (ArrayList<User>) userReader.readObject();
            userReader.close();
        } catch (FileNotFoundException e){
            System.out.println("Käyttäjien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Käyttäjien lukemine ei onnistunut");
            e.printStackTrace();
        } catch(ClassNotFoundException e){
            System.out.println("Käyttäjien lukeminen ei onnistunut");
            e.printStackTrace();
        }
    }

    public void sortList(){
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User n1, User n2) {
                return n1.getLastName().compareTo(n2.getLastName());
            }
        });
        /*UserListAdapter.notifyDataChange();*/
    }
}