package com.example.studentmanagementsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.Viewholder> {

    List<Student>studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_all_model_design,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.Viewholder holder, int position) {

        Student student = studentList.get(position);
        /*holder.dataIdTV.setText(String.valueOf(student.getId()));*/
        holder.nameTV.setText(student.getName());
        holder.studentIdTV.setText(student.getStudentID());
        holder.departmentTV.setText(student.getDepartment());
        holder.contactTV.setText(student.getContact());
        holder.genderTV.setText(student.getGender());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView dataIdTV,nameTV,studentIdTV,departmentTV,contactTV,genderTV;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            /*dataIdTV = itemView.findViewById(R.id.dataIdTV);*/
            nameTV = itemView.findViewById(R.id.nameTV);
            studentIdTV = itemView.findViewById(R.id.studentIdTV);
            departmentTV = itemView.findViewById(R.id.departmentTV);
            contactTV = itemView.findViewById(R.id.contactTV);
            genderTV = itemView.findViewById(R.id.genderTV);

        }
    }
}
