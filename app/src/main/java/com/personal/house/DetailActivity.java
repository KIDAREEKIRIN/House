package com.personal.house;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    Shape selectedShape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        
        getSelectedShape();
        setValues();
    }


    private void getSelectedShape() {
        Intent previousIntent = getIntent();
        String parsedStringID = previousIntent.getStringExtra("id");
        selectedShape = MainActivity.shapeList.get(Integer.valueOf(parsedStringID));

    }

    private void setValues() {
        TextView tv_shapeName = (TextView) findViewById(R.id.shapeName);
        ImageView iv_shapeName = (ImageView) findViewById(R.id.shapeImage);

        tv_shapeName.setText(selectedShape.getName());
        iv_shapeName.setImageResource(selectedShape.getImage());
    }

}