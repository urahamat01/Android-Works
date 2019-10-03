package com.beskilled.recyclearview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        holder.emailTV.setText(student.getEmail());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView nameTV, idTV, emailTV;





        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.nameEV);
            idTV = itemView.findViewById(R.id.idEV);
            emailTV = itemView.findViewById(R.id.emailEV);


        }
    }
}
