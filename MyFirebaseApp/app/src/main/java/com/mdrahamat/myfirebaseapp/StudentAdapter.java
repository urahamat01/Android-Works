package com.mdrahamat.myfirebaseapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private List<Student> mstudentList;

    public StudentAdapter(List<Student> mstudentList) {
        this.mstudentList = mstudentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.semple_layout, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Student mstudent = mstudentList.get(position);
        holder.nameTV.setText(mstudent.getName());
        holder.ageTV.setText(mstudent.getAge());
    }

    @Override
    public int getItemCount() {
        return mstudentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView nameTV, ageTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTV = itemView.findViewById(R.id.nameTvId);
            ageTV = itemView.findViewById(R.id.ageTvId);

        }
    }
}
