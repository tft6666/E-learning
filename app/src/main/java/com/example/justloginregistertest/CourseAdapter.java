package com.example.justloginregistertest;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    private List<Course> mCourseList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View courseView;
        ImageView courseImage;
        TextView courseName;
        TextView courseInformation;

        public ViewHolder(View view) {
            super(view);
            courseView = view;
            courseName = view.findViewById(R.id.course_name);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.courseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext() , NavigationActivity.class);
                view.getContext().startActivity(intent);
                int position = holder.getAdapterPosition();
                Course course = mCourseList.get(position);

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course course = mCourseList.get(position);
        holder.courseName.setText(course.getName());
    }

    @Override
    public int getItemCount() {
        return mCourseList.size();
    }

    public CourseAdapter(List<Course> courseList) {
        mCourseList = courseList;
    }

}
