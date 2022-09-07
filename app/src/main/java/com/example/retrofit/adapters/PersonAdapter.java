package com.example.retrofit.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.R;
import com.example.retrofit.models.Person;
import com.example.retrofit.models.Result;

import java.util.List;

public class PersonAdapter  extends RecyclerView.Adapter<PersonAdapter.UsersViewHolder>{
    Context context;
    Person personList;

    public PersonAdapter(Context context, Person userListResponseData) {
        this.personList = userListResponseData;
        this.context = context;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        UsersViewHolder usersViewHolder = new UsersViewHolder(view);

        return usersViewHolder;
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // set the data
        holder.name.setText("Name: " + personList.getResults().get(position).getName().toString());
        holder.email.setText("Email: " + personList.getResults().get(position).getEmail());

    }


    @Override
    public int getItemCount() {
        return 1; // size of the list items
    }

    static class UsersViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name, email;

        public UsersViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            email = (TextView) itemView.findViewById(R.id.email);
        }
    }

}
