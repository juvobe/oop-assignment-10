package com.example.users;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context context;

    private ArrayList<User> users = new ArrayList<>();

    public UserListAdapter(Context context, ArrayList<User> users){
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder h, int position){
        h.name.setText(users.get(position).getFirstName() + " " + users.get(position).getLastName());
        h.degreeProgram.setText(users.get(position).getDegreeProgram());
        h.email.setText(users.get(position).getEmail());
        h.completed.setText("Suoritetut tutkinnot:\n" + users.get(position).getCompleted());
    }

    @Override
    public int getItemCount(){
        return users.size();
    }

}
