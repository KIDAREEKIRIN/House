package com.personal.house;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ShapeAdapter extends ArrayAdapter<Shape> {

    public ShapeAdapter(Context context, int resource, List<Shape> shapeList) {
        super(context,resource,shapeList);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Shape shape = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.shape_cell,parent,false);

        }
        TextView tv_shapeName = (TextView) convertView.findViewById(R.id.tv_shapeName);
        ImageView iv_shapeName = (ImageView) convertView.findViewById(R.id.iv_shapeImage);

        tv_shapeName.setText(shape.getName());
        iv_shapeName.setImageResource(shape.getImage());

        return convertView;
    }
}
