package com.example.justloginregistertest;
import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.Fragment;

import android.media.MediaPlayer;
import android.net.Uri;
import android.nfc.tech.NfcA;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.justloginregistertest.Fragment.CourseFragment;
import com.example.justloginregistertest.Fragment.ExercisesFragment;
import com.example.justloginregistertest.Fragment.MyinfoFragment;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/*
 * FragmentManager manager = getSupportFragmentManager();
 * FragmentTransaction transaction = manager.beginTransaction();
 * transaction.add(R.id.main_body,new CourseFragment()).commit();
 * */
public class NavigationActivity extends FragmentActivity implements View.OnClickListener{
    //来自activity_main.xml
    private RelativeLayout main_body;
    private TextView bottom_bar_text_course;
    private ImageView bottom_bar_image_course;
    private TextView bottom_bar_text_exercises;
    private ImageView bottom_bar_image_exercises;
    private TextView bottom_bar_text_myinfo;
    private ImageView bottom_bar_image_myinfo;
    private LinearLayout main_bottom_bar;
    private ImageView ti;
    //  android:id="@+id/main_body"
    //  android:id="@+id/bottom_bar_course_btn" 按钮
    // android:id="@+id/bottom_bar_text_course"
    // android:id="@+id/bottom_bar_image_course"
    // android:id="@+id/title_bar";
    /*main_exercises_icon.png、
    main_course_icon.png、
    main_my_icon.png
    main_exercises_icon_selected.png、
    main_course_icon_selected.png、
    main_my_icon_selected.png*/
    //private View mCourseBtn,mExercisesBtn,mMyInfoBtn;
    private RelativeLayout bottom_bar_course_btn;
    private RelativeLayout bottom_bar_exercises_btn;
    private RelativeLayout bottom_bar_myinfo_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initBody();
        initBottomBar();;
        setInitStatus();
    }


    private void initBody() {
        main_body = (RelativeLayout) findViewById(R.id.main_body);
    }

    private void initBottomBar() {
        bottom_bar_text_course = (TextView) findViewById(R.id.bottom_bar_text_course);
        bottom_bar_image_course = (ImageView) findViewById(R.id.bottom_bar_image_course);
        bottom_bar_course_btn = (RelativeLayout) findViewById(R.id.bottom_bar_course_btn);
        bottom_bar_text_exercises = (TextView) findViewById(R.id.bottom_bar_text_exercises);
        bottom_bar_image_exercises = (ImageView) findViewById(R.id.bottom_bar_image_exercises);
        bottom_bar_exercises_btn = (RelativeLayout) findViewById(R.id.bottom_bar_exercises_btn);
        bottom_bar_text_myinfo = (TextView) findViewById(R.id.bottom_bar_text_myinfo);
        bottom_bar_image_myinfo = (ImageView) findViewById(R.id.bottom_bar_image_myinfo);
        bottom_bar_myinfo_btn = (RelativeLayout) findViewById(R.id.bottom_bar_myinfo_btn);
        main_bottom_bar = (LinearLayout) findViewById(R.id.main_bottom_bar);
        ti=(ImageView) findViewById(R.id.ti);
        setListener();
    }

    private void setListener() {
        for (int i = 0; i < main_bottom_bar.getChildCount(); i++) {
            main_bottom_bar.getChildAt(i).setOnClickListener(this);
        }
    }

    private void setInitStatus() {
        clearBottomImageState();
        setSelectedStatus(0);
        getSupportFragmentManager().beginTransaction().add(R.id.main_body, new CourseFragment()).commit();
    }

    private void setSelectedStatus(int index) {
        switch (index) {
            case 0:
                //mCourseBtn.setSelected(true);
                bottom_bar_image_course.setImageResource(R.drawable.main_button_1_selected);
                bottom_bar_text_course.setTextColor(Color.parseColor("#0097f7"));
                setTitle("course");
                break;
            case 1:
                //mExercisesBtn.setSelected(true);
                bottom_bar_image_exercises.setImageResource(R.drawable.main_button_2_selected);
                bottom_bar_text_exercises.setTextColor(Color.parseColor("#0097f7"));
                setTitle("6");
                break;
            case 2:
                //mMyInfoBtn.setSelected(true);
                bottom_bar_image_myinfo.setImageResource(R.drawable.main_button_3_selected);
                //ti.setImageResource(R.drawable.kk);
                bottom_bar_text_myinfo.setTextColor(Color.parseColor("#0097f7"));
                setTitle("3");
                break;
        }
    }

    private void clearBottomImageState() {
        bottom_bar_text_course.setTextColor(Color.parseColor("#666666"));
        bottom_bar_text_exercises.setTextColor(Color.parseColor("#666666"));
        bottom_bar_text_myinfo.setTextColor(Color.parseColor("#666666"));

        bottom_bar_image_course.setImageResource(R.drawable.main_button_1);
        bottom_bar_image_exercises.setImageResource(R.drawable.main_button_2);
        bottom_bar_image_myinfo.setImageResource(R.drawable.main_button_3);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bottom_bar_course_btn:
                clearBottomImageState();
                /**  replacing instead of adding **/
                getSupportFragmentManager().beginTransaction().replace(R.id.main_body, new CourseFragment()).commit();
                setSelectedStatus(0);
                break;
            case R.id.bottom_bar_exercises_btn:
                clearBottomImageState();
                setSelectedStatus(1);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_body, new ExercisesFragment()).commit();
                break;
            case R.id.bottom_bar_myinfo_btn:
                clearBottomImageState();
                setSelectedStatus(2);
                getSupportFragmentManager().beginTransaction().replace(R.id.main_body, new MyinfoFragment()).commit();
                break;
            case R.id.main_back:
                startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
        }
    }





    protected long exitTime;//记录第一次点击的时间


}