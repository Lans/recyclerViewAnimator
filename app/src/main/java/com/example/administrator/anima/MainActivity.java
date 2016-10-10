package com.example.administrator.anima;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import recyclerview.animation.SlideInBottomAnimationAdapter;

public class MainActivity extends AppCompatActivity implements MyAdapter.MyOnClick {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private Toolbar toolbar;
    private Activity context;
    /* private static String[] data = new String[]{
             "Apple", "Ball", "Camera", "Day", "Egg", "Foo", "Google", "Hello", "Iron", "Japan", "Coke",
             "Dog", "Cat", "Yahoo", "Sony", "Canon", "Fujitsu", "USA", "Nexus", "LINE", "Haskell", "C++",
             "Java", "Go", "Swift", "Objective-c", "Ruby", "PHP", "Bash", "ksh", "C", "Groovy", "Kotlin",
             "Chip", "Japan", "U.S.A", "San Francisco", "Paris", "Tokyo", "Silicon Valley", "London",
             "Spain", "China", "Taiwan", "Asia", "New York", "France", "Kyoto", "Android", "Google",
             "iPhone", "iPad", "iPod", "Wasabeef"
     };*/
    private List<Test> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        for (int i = 0; i < 10; i++) {
            Test test = new Test();
            test.setName("Apple" + i);
            data.add(test);
        }


        myAdapter = new MyAdapter(data, MainActivity.this);
        myAdapter.setMyOnClick(this);
        SlideInBottomAnimationAdapter slideInBottomAnimationAdapter = new SlideInBottomAnimationAdapter(myAdapter);
        slideInBottomAnimationAdapter.setFirstOnly(true);
        slideInBottomAnimationAdapter.setDuration(1000);
        slideInBottomAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(slideInBottomAnimationAdapter);
    }

    public void add(View v) {
        Toast.makeText(context, "add", Toast.LENGTH_SHORT).show();
        Test test = new Test();
        test.setName("------------->");
        myAdapter.addItem(test,0);
    }

    public void delete(View v) {
        Toast.makeText(context, "delete", Toast.LENGTH_SHORT).show();
        myAdapter.removeData(0);
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(context, position + "", Toast.LENGTH_SHORT);
        Log.e(getClass().getSimpleName().toString(), position + "");
    }
}
