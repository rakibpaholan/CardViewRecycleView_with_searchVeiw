package com.example.recycleview_with_searchview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> implements Filterable {

    private ArrayList<ExampleItem> mExampleList;
    private ArrayList<ExampleItem> exampleFullList;


    private static ClickListener clickListener;

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<ExampleItem> filtered = new ArrayList<ExampleItem>();

            if (constraint == null || constraint.length()==0){
                filtered.addAll(exampleFullList);
            }else {
                String filerPattern = constraint.toString().toLowerCase().trim();
                for (ExampleItem item : exampleFullList){
                    if (item.getText1().toLowerCase().contains(filerPattern)){
                        filtered.add(item);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filtered;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mExampleList.clear();
            mExampleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


    public class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private ImageView imageView;

        private TextView textView1,textView2;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image_view_id);
            textView1 = (TextView)itemView.findViewById(R.id.contact_name);
            textView2 = (TextView)itemView.findViewById(R.id.contact_number);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }
        @Override
        public void onClick(View v) {
            clickListener.OnSingleClick(getAdapterPosition(),v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.OnLongClick(getAdapterPosition(),v);
            return false;
        }

    }
    public ExampleAdapter(ArrayList<ExampleItem> exampleList){
        mExampleList = exampleList;
        exampleFullList = new ArrayList<>(mExampleList);
    }
   
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.simple_layout,parent,false);

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

    public interface ClickListener{
        void OnSingleClick(int position, View v);
        void OnLongClick(int position, View v);
    }

    void OnclickListener(ClickListener clickListener){
        ExampleAdapter.clickListener = clickListener;
    }

}
