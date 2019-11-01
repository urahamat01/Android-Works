package com.mdrahamat.firbasedata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<User> mUserList;

    public UserAdapter(List<User> mUserList) {
        this.mUserList = mUserList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User users = mUserList.get(position);
        holder.name.setText(users.getName());
        holder.email.setText(users.getEmail());
        holder.age.setText(users.getAge());
        holder.bloadGroup.setText(users.getBloadGroup());

    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, email, age, bloadGroup;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameTV);
            email = itemView.findViewById(R.id.emailTV);
            age = itemView.findViewById(R.id.ageTV);
            bloadGroup = itemView.findViewById(R.id.bloadGroupTV);

        }
    }
}
