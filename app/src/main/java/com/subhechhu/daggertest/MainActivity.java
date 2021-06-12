package com.subhechhu.daggertest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.subhechhu.daggertest.di.DepComponent;
import com.subhechhu.daggertest.model.ItemsItem;
import com.subhechhu.daggertest.model.MainResponse;
import com.subhechhu.daggertest.school.School;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    DepComponent depComponent;
    RvAdapter rvAdapter;

    ArrayList<ItemsItem> mainList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        depComponent = ((MyApp) getApplication()).getDepComponent();

        findViewById(R.id.floatingActionButton).setOnClickListener(v -> {
            School school = depComponent.provideSchool();

            school.addStudentName("David");
            school.addStudentGrade("10");
            school.setMonitor(false);

            school.addTeacherName("Wayne");
            school.addTeacherSubject("Computer Science");
            school.setClassTeacher(true);

            Log.e(TAG, "onCreate: student name:" + school.getStudentName());
            Log.e(TAG, "onCreate: student grades:" + school.getStudentGrades());
            Log.e(TAG, "onCreate: student isMonitor:" + school.isMonitor());
            Log.e(TAG, "onCreate: Teacher name:" + school.getTeacherName());
            Log.e(TAG, "onCreate: Teacher subject:" + school.getTeacherSubject());
            Log.e(TAG, "onCreate: Teacher isClassTeacher:" + school.isClassTeacher());

        });
        rvAdapter = new RvAdapter();

        initRV();
        getDataFromServer();
    }

    private void initRV() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(rvAdapter);

    }

    private void getDataFromServer() {
        MainActivityVM mainActivityVM = new ViewModelProvider(this).get(MainActivityVM.class);
        mainActivityVM.getData().observe(this, new Observer<MainResponse>() {
            @Override
            public void onChanged(MainResponse mainResponse) {
                if (mainResponse == null) {
                    Log.e(TAG, "onChanged: MainResponse is null");
                } else {
                    Log.e(TAG, "onChanged: main response: " + mainResponse.getItems());
                    rvAdapter.updateData(mainResponse.getItems());
                    rvAdapter.notifyDataSetChanged();
                }
            }
        });

        mainActivityVM.makeApiCall();
    }
}