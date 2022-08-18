package com.personal.house;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Shape> shapeList = new ArrayList<Shape>();

    private Button allButton, triangleButton, squareButton, octagonButton, rectangleButton, circleButton;

    private ListView listView;

    private String selectedFilter = "all";
    private String currentSearchText = "";
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSearchWidgets();
        initFilterWidgets();
        setUpData();
        setUpList();
        setUpOnclickListener();
    }

    private void initFilterWidgets() {
        Button allButton = (Button) findViewById(R.id.allFilter);
        Button triangleButton = (Button) findViewById(R.id.triangleFilter);
        Button squareButton = (Button) findViewById(R.id.squareFilter);
        Button rectangleButton = (Button) findViewById(R.id.rectangleFilter);
        Button octagonButton = (Button) findViewById(R.id.octagonFilter);
        Button circleButton = (Button) findViewById(R.id.circleFilter);
    }

    private void initSearchWidgets(){
        searchView = (SearchView) findViewById(R.id.shapeListSearchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                currentSearchText = s;

                ArrayList<Shape> filteredShapes = new ArrayList<Shape>();
                for(Shape shape: shapeList) {
                    if(shape.getName().toLowerCase().contains(s.toLowerCase())) {
                        if(selectedFilter.equals("all")) {
                            filteredShapes.add(shape);
                        } else {
                            if(shape.getName().toLowerCase().contains(selectedFilter)) {
                                filteredShapes.add(shape);
                            }
                        }

                    }
                }
                ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(),0,filteredShapes);
                listView.setAdapter(adapter);

                return false;
            }
        });
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
                Shape selectShape = (Shape) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DetailActivity.class);
                showDetail.putExtra("id",selectShape.getId());
                startActivity(showDetail);
            }
        });
    }

    private void filterList(String status) {

        selectedFilter = status;

        ArrayList<Shape> filteredShapes = new ArrayList<Shape>();

        for (Shape shape : shapeList) {
            if(shape.getName().toLowerCase().contains(status)) {
                if(currentSearchText == "") {
                    filteredShapes.add(shape);

                } else {
                    if(shape.getName().toLowerCase().contains(currentSearchText.toLowerCase())) {
                        filteredShapes.add(shape);
                    }
                }
            }
        }
        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, filteredShapes);
        listView.setAdapter(adapter);
    }

    public void allFilterTapped(View view) {

        selectedFilter = "all";
        searchView.setQuery("",false);
        searchView.clearFocus();

        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);
    }

    public void rectangleFilterTapped(View view) {
        filterList("rectangle");
    }

    public void triangleFilterTapped(View view) {
        filterList("triangle");

    }

    public void squareFilterTapped(View view) {
        filterList("square");

    }

    public void circleFilterTapped(View view) {
        filterList("circle");

    }

    public void octagonFilterTapped(View view) {
        filterList("octagon");
    }
}