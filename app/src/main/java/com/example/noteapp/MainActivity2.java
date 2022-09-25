package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.noteapp.databinding.ActivityMain2Binding;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
ActivityMain2Binding binding;
ArrayList<Note> noteArrayList;
NoteAdapter noteAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        readfromdatabse();

        binding.floatingactionbotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this,MainActivity3.class));
                finish();
            }
        });

    }
    public void  readfromdatabse(){
        noteArrayList= (ArrayList<Note>) Note.listAll(Note.class);

        binding.recyclerview1.setLayoutManager(new LinearLayoutManager(MainActivity2.this));
        noteAdapter=new NoteAdapter(MainActivity2.this,noteArrayList);
        binding.recyclerview1.setAdapter(noteAdapter);
    }
}