package com.example.algomark;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class algoListAdapter extends RecyclerView.Adapter<algoListAdapter.algoViewholder> {
    @NonNull
    private ArrayList<Data> data = new ArrayList<>();
    private Context context;

    public algoListAdapter(Context context) {
        this.context = context;
    }

    public void setData( ArrayList<Data> dataT) {
        this.data = dataT;
    }

    public algoViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.algo_adapter, parent, false);
        return new algoViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull algoViewholder holder, int position) {
        holder.algo_id.setText(String.valueOf(data.get(position).getId()));
        holder.algo_text.setText(data.get(position).getName());

        holder.algo_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class algoViewholder extends RecyclerView.ViewHolder{
        TextView algo_text;
        TextView algo_id , algo_test;

        public algoViewholder(@NonNull View itemView) {
            super(itemView);
            algo_text = itemView.findViewById(R.id.algo_name_id);
            algo_id = itemView.findViewById(R.id.algo_id);
            algo_test = itemView.findViewById(R.id.algo_test);
        }
    }
}
