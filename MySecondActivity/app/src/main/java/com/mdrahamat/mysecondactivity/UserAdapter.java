package com.mdrahamat.mysecondactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User>userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user= userList.get(position);
        holder.idTV.setText(user.getId());
        holder.nameTV.setText(user.getName());
        holder.ageTV.setText(String.valueOf(user.getAge()));

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTV, ageTV, idTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idTV = itemView.findViewById(R.id.idTV);
            nameTV = itemView.findViewById(R.id.nameTV);
            ageTV = itemView.findViewById(R.id.ageTV);
        }
    }
}
