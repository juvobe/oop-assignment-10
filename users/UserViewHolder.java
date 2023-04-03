package com.example.users;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView name, degreeProgram, email, completed;

    public UserViewHolder(@NonNull View itemView){
        super(itemView);
        name = itemView.findViewById(R.id.txtName);
        degreeProgram = itemView.findViewById(R.id.txtDegreeProgram);
        email = itemView.findViewById(R.id.txtEmail);
        completed = itemView.findViewById(R.id.txtCompleted);

    }
}
