package com.example.recycleview_with_searchview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<ExampleItem> mExampleList;


    public class ExampleViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        private TextView textView1,textView2;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image_view_id);
            textView1 = (TextView)itemView.findViewById(R.id.contact_name);
            textView2 = (TextView)itemView.findViewById(R.id.contact_number);
        }

    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleList){
        mExampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_layout,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(view);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);
        holder.imageView.setImageResource(currentItem.getmImage());
        holder.textView1.setText(currentItem.getText1());
        holder.textView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

}
