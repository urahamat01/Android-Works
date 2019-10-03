package com.beskilled.recyclearview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAddapter extends RecyclerView.Adapter<StudentAddapter.ViewHolder> {


    List<Student> studentList;

    public StudentAddapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_student_design,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Student student = studentList.get(position);

        holder.nameTV.setText(student.getName());
        holder.idTV.setText(String.valueOf(student.getId()));
        holder.phoneTV.setText(student.getPhone());
        holder.emailTV.setText(student.getEmail());
        holder.profileIV.setImageResource(student.getProfileImage());


    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView profileIV;
        private TextView nameTV, idTV, phoneTV, emailTV;





        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileIV = itemView.findViewById(R.id.profileIV);
            nameTV = itemView.findViewById(R.id.nameEV);
            idTV = itemView.findViewById(R.id.idEV);
            phoneTV = itemView.findViewById(R.id.phoneEV);
            emailTV = itemView.findViewById(R.id.emailEV);


        }
    }
}
