package com.example.algomark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarContentLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {

    private Button btnSort;
    private TextView long_desc, algo_name;
    private int arr[], arrNew[];
    private ArrayList<Data> DataList;
    private int position;
    private int id;
    private String text;
    private EditText ed;
    private sortingFunctions sortingFunctions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DataList = Utils.getDataEntry();
        long_desc = findViewById(R.id.textView1);
        algo_name = findViewById(R.id.algo_name);
        ed = findViewById(R.id.editText2);
        sortingFunctions = new sortingFunctions();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            position = extras.getInt("position");
            long_desc.setText(DataList.get(position).getLongDesc());
            algo_name.setText(DataList.get(position).getName());
        }

        id = DataList.get(position).getId();
        btnSort = findViewById(R.id.btn_sort);
        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed.getText() != null){
                sortClicked();}
            }
        });

    }

    private void sortClicked() {
            text = ed.getText().toString();

            //Assuming no spaces and user is using one comma between numbers
            String[] strings = text.split(",");
            String[] strings1;
            if(strings != null){
                    try{
            switch (id){
                case 1:
                    strings1 = sortingFunctions.selectionSort(strings);
                    long time1 = (strings.length == 0)?0:4+strings.length*strings.length;
                    Intent intent1 = new Intent(MainActivity2.this, MainActivity3.class);
                    intent1.putExtra("ARRAY",strings1);
                    intent1.putExtra("time",time1);
                    intent1.putExtra("pos",position);
                    startActivity(intent1);
                    break;
                case 2:
                    strings1 = sortingFunctions.InsertionSort(strings);
                    long time = (strings.length == 0)?0:5+strings.length*strings.length;
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("ARRAY",strings1);
                    intent.putExtra("time",time);
                    intent.putExtra("pos",position);
                    startActivity(intent);
                    break;
                case 3:
                    strings1 = sortingFunctions.bubbleSort(strings);
                    long time2 = (strings.length == 0)?0:strings.length*(strings.length)/2;
                    Intent intent2 = new Intent(MainActivity2.this, MainActivity3.class);
                    intent2.putExtra("ARRAY",strings1);
                    intent2.putExtra("time",time2);
                    intent2.putExtra("pos",position);
                    startActivity(intent2);
                    break;
                case 4:
                    Thread mergeThread = new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            String[] strings2;
                            strings2 = sortingFunctions.sortM(strings,0,strings.length-1);
                            long time3 = (strings.length == 0)?0:sortingFunctions.getRandom()+strings.length*sortingFunctions.Log2n(strings.length);
                            Intent intent3 = new Intent(MainActivity2.this, MainActivity3.class);
                            intent3.putExtra("ARRAY",strings2);
                            intent3.putExtra("time",time3);
                            intent3.putExtra("pos",position);
                            startActivity(intent3);
                        }
                    };
                    mergeThread.start();
                    break;
                case 5:
                    strings1 = sortingFunctions.sort(strings,0,strings.length-1);
                    long time4 = (strings.length == 0)?0:sortingFunctions.getRandom()+strings.length*sortingFunctions.Log2n(strings.length);
                    Intent intent4 = new Intent(MainActivity2.this, MainActivity3.class);
                    intent4.putExtra("ARRAY",strings1);
                    intent4.putExtra("time",time4);
                    intent4.putExtra("pos",position);
                    startActivity(intent4);
                    break;
                default:
                    break;
            }}catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(this, "Wrong Format", Toast.LENGTH_SHORT).show();
                    }
            }
    }

    private void setClipboard(Context context) {
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(text);
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show();
        }
    }
}