package com.example.algomark;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity3 extends AppCompatActivity {

    private TextView view,timeTaken,complexity, sComplexity, stability, algoName;
    private int position;
    private ArrayList<Data> dataPrimary;
    private ArrayList<Integer> timeList;
    private sortingFunctions sortingFunctions;
    private BarChart barChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        timeTaken = findViewById(R.id.time_taken);
        complexity = findViewById(R.id.complexity);
        sComplexity = findViewById(R.id.spacetime);
        stability = findViewById(R.id.stability);
        algoName = findViewById(R.id.algo_name);
        view = findViewById(R.id.view);
        barChart = findViewById(R.id.chart);

        sortingFunctions = new sortingFunctions();
        dataPrimary = Utils.getDataEntry();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
        String[] strings = extras.getStringArray("ARRAY");
        long time = extras.getLong("time");
        position = extras.getInt("pos");

        Thread tempThread = new Thread(){
            @Override
            public void run() {
                super.run();
                timeList = sortingFunctions.timeFunction(strings);

                ArrayList<BarEntry> barEntry1 = new ArrayList<>();
                for(int i = 0; i<timeList.size();i++){
                barEntry1.add(new BarEntry(Float.valueOf(timeList.get(i)),i));}

                ArrayList<String> labels = new ArrayList<String>();
                labels.add("S. S");
                labels.add("I. S");
                labels.add("B. S");
                labels.add("M. S");
                labels.add("Q. S");

                BarDataSet barDataSet = new BarDataSet(barEntry1,"Cells");
                barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                barDataSet.setValueTextSize(10f);

                BarData barData = new BarData(labels,barDataSet);
                barChart.setData(barData);
                barChart.setDrawValueAboveBar(true);
                barChart.setDescription("Time Taken by Algorithms");
                //barChart.animateY(2000);
            }
        };
        tempThread.start();

        algoName.setText(dataPrimary.get(position).getName());
        complexity.setText(dataPrimary.get(position).getComplexity());
        sComplexity.setText(dataPrimary.get(position).getsComplexity());
        stability.setText(dataPrimary.get(position).getStability());
        String tTaken= "time taken: " +String.valueOf(time)+" Unit Time";
        timeTaken.setText(tTaken);
        view.setText(Arrays.toString(strings).replaceAll("\\[|\\]", ""));
        }
    }

    private void alertDialog() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage("Yet to done");
        dialog.setTitle("Complexity");

        dialog.setNegativeButton("Dismiss",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"cancel is clicked", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }
}