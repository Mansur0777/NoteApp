package com.example.noteapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.noteapp.databinding.ActivityMain3Binding;

import java.util.Calendar;

public class MainActivity3 extends AppCompatActivity {
ActivityMain3Binding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Calendar calendar=Calendar.getInstance();
                int year=calendar.get(Calendar.YEAR);
                int month=calendar.get(Calendar.MONTH);
                int day=calendar.get(Calendar.DAY_OF_MONTH);
                int hour=calendar.get(Calendar.HOUR);
                int minut=calendar.get(Calendar.MINUTE);

                Note note=new Note();
                note.setMassage(binding.edittext1.getText().toString());
                note.setDatatime(year+"/"+month+"/"+day+" "+hour+":"+minut);
                note.save();
                binding.edittext1.setText("");
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity3.this);
                View view= LayoutInflater.from(MainActivity3.this).inflate(R.layout.add_layout,null);
                builder.setView(view);
                builder.create().show();



            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MainActivity3.this,MainActivity2.class));
        finish();
    }
}