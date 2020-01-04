package com.example.justloginregistertest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private List<Course> courseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCourse();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CourseAdapter adapter = new CourseAdapter(courseList);
        recyclerView.setAdapter(adapter);
    }

    private void initCourse() {
        for(int i = 0; i < 1; i++) {
            Course AD = new Course(R.drawable.main_button_1,"Android Development","2019SSE_001","ICT_SW_001","A course for base",0,"Open","2019-09-01","2019-11-25 09:11","basic",0,"null","001\\av001.jpg","null","BJTU","Forever");
            courseList.add(AD);
            Course WD = new Course(R.drawable.main_button_2,"Web Development","2019SSE_002","ICT_SW_002","HTML,CSS,JS",0,"Open","2019-09-06","2019-11-26 10:20","basic",0,"null","001\\av002.jpg","null","BJTU SSE","Forever");
            courseList.add(WD);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_back: //返回登录页面
                Intent intent1 = new Intent(this, loginActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.main_title:
                break;
        }
    }
}
