package com.example.recycleview_with_searchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private ExampleAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ExampleItem> exampleItemArrayList;
    private EditText insert_edit_text,delete_edit_text;
    private Button insert_btn,delete_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createExampleList();
        buildindRecycleView();
        insert_edit_text = (EditText)findViewById(R.id.insert_edit_id);
        delete_edit_text = (EditText)findViewById(R.id.delete_id);
        insert_btn =(Button)findViewById(R.id.insertId);
        delete_btn = (Button)findViewById(R.id.delete_id_btn);
        insert_btn.setOnClickListener(this);
        delete_btn.setOnClickListener(this);



    }

    public void createExampleList(){
        exampleItemArrayList = new ArrayList<>();
        exampleItemArrayList.add(new ExampleItem(R.drawable.rakib_bro,"Line1","Line2"));
        exampleItemArrayList.add(new ExampleItem(R.drawable.rakib_bro,"Line1","Line2"));
        exampleItemArrayList.add(new ExampleItem(R.drawable.rakib_bro,"Line1","Line2"));
        exampleItemArrayList.add(new ExampleItem(R.drawable.rakib_bro,"Line1","Line2"));
    }
    public void buildindRecycleView(){
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView_id);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        myAdapter = new ExampleAdapter(exampleItemArrayList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id==R.id.insertId){
            int position = Integer.parseInt(insert_edit_text.getText().toString());
            insertItem(position);
        }else if (id==R.id.delete_id_btn){
            int position = Integer.parseInt(delete_edit_text.getText().toString());
            int exactValue = exampleItemArrayList.size();
            if (position>exactValue){
                Toast.makeText(getApplicationContext(),"No data found in this position",Toast.LENGTH_SHORT).show();
            }else {
                deleteItem(position);
            }

        }
    }


    public void insertItem(int position){
        exampleItemArrayList.add(position,new
                ExampleItem(R.drawable.rakib_bro,"Item add at the position of "+position,"Line number 2"));
        myAdapter.notifyItemInserted(position);
        insert_edit_text.setText("");
    }
    public void deleteItem(int position){
        exampleItemArrayList.remove(position);
        myAdapter.notifyItemRemoved(position);
        delete_edit_text.setText("");

    }
}