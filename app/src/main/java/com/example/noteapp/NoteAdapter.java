package com.example.noteapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHoldern>{
    Context context;
    ArrayList<Note> noteArrayList;
    ArrayList<Integer> colorlist=new ArrayList<>();
    MainActivity2 mainActivity2;

    public NoteAdapter(Context context, ArrayList<Note> noteArrayList) {
        this.context = context;
        this.noteArrayList = noteArrayList;
        mainActivity2=(MainActivity2) context;
    }

    @NonNull
    @Override
    public NoteViewHoldern onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {




        View view= LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false);
        return new NoteViewHoldern(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHoldern holder, int position) {
        int red= android.R.color.holo_red_dark;
        int green= android.R.color.holo_blue_dark;
        int blue= R.color.purple_200;
        int yellow= android.R.color.holo_orange_light;

   colorlist.add(red);
   colorlist.add(green);
   colorlist.add(blue);
   colorlist.add(yellow);
        Collections.shuffle(colorlist);

        if (position%2==0){
            holder.textView1.setBackgroundResource(colorlist.get(0));
        }else {
            holder.textView1.setBackgroundResource(colorlist.get(1));

        }
holder.textView1.setText(noteArrayList.get(position).getId()+"");
holder.textView2.setText(noteArrayList.get(position).massage);
holder.textView3.setText(noteArrayList.get(position).datatime);

holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setMessage(noteArrayList.get(position).massage);
        builder.create().show();
    }
});
holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View view) {
        holder.cardView.setVisibility(View.VISIBLE);
        return true;
    }
});
holder.imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Note note = Note.findById(Note.class, noteArrayList.get(position).getId());
        note.delete();
        mainActivity2.readfromdatabse();
    }
});


    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }

    class NoteViewHoldern extends RecyclerView.ViewHolder {
        TextView textView1,textView2,textView3;
        CardView cardView;
        ImageView imageView;
        public NoteViewHoldern(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textviewteid);
            textView2=itemView.findViewById(R.id.textviewnotemessage);
            textView3=itemView.findViewById(R.id.textviewnotedatatime);
           cardView=itemView.findViewById(R.id.cardiviewactions);
           imageView=itemView.findViewById(R.id.imageviewdelete);
        }
    }
}
