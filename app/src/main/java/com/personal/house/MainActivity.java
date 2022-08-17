package com.personal.house;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<Shape> shapeList = new ArrayList<Shape>();

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpData();
        setUpList();
        setUpOnclickListener();
    }


    private void setUpData() {

        Shape circle = new Shape("0","Circle",R.drawable.circle);
        shapeList.add(circle);

        Shape triangle = new Shape("1","Triangle",R.drawable.triangle);
        shapeList.add(triangle);

        Shape square = new Shape("2","Square",R.drawable.square);
        shapeList.add(square);

        Shape rectangle = new Shape("3","Rectangle",R.drawable.rectangle);
        shapeList.add(rectangle);

        Shape octagon = new Shape("4","Octagon",R.drawable.octagon);
        shapeList.add(octagon);

    }

    private void setUpList() {

        listView = (ListView) findViewById(R.id.shapesListView);

        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Shape sele
            }
        });
    }

}