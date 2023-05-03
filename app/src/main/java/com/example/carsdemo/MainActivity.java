package com.example.carsdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private final int [] carImages = {R.drawable.acura, R.drawable.audi, R.drawable.ferrari,
                                      R.drawable.infiniti, R.drawable.lexus, R.drawable.mercedes,
                                      R.drawable.mustang, R.drawable.porsche, R.drawable.tesla};

    private final String [] carNames = {"Acura", "Audi", "Ferrari", "Infiniti", "Lexus",
                                        "Mercedes", "Mustang", "Porsche", "Tesla"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a reference to the RecyclerView in activity_main.xml
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // set number of columns to 1 or 2 for portrait or landscape respectively
        // Please note the use of an xml integer here: portrait will be 1x9 and landscape 2x5; neat!
        final int COLUMNS = getResources ().getInteger (R.integer.rv_columns);

        // create and set a Grid Layout Manager to use as the Layout Manager for this RV
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, COLUMNS);
        recyclerView.setLayoutManager(gridLayoutManager);

        // create and set an adapter to use as the Layout Manager for this RV
        CarsItemAdapter carsItemAdapter = new CarsItemAdapter(carImages, carNames);
        recyclerView.setAdapter(carsItemAdapter);

    }
}
