package com.example.protrack;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList project_id,project_title,project_description,project_statue;
 int position;
    CustomAdapter(Context context, ArrayList project_id,ArrayList project_title,ArrayList project_description,ArrayList project_statue){
        this.context = context;
        this.project_id = project_id;
        this.project_title = project_title;
        this.project_description = project_description;
        this.project_statue = project_statue;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //this.position =position;

       holder.project_id_txt.setText(String.valueOf(project_id.get(position)));
       holder.project_title_txt.setText(String.valueOf(project_title.get(position)));
       holder.project_description_txt.setText(String.valueOf(project_description.get(position)));
       holder.project_statue_txt.setText(String.valueOf(project_statue.get(position)));
       holder.listLayout.setOnClickListener((new View.OnClickListener(){
           @Override
           public void onClick(View view){
               Intent intent = new Intent(context,DetailActivity.class);
               intent.putExtra("id",String.valueOf(project_id.get(position)));
               intent.putExtra("title",String.valueOf(project_title.get(position)));
               intent.putExtra("description",String.valueOf(project_description.get(position)));
               intent.putExtra("statue",String.valueOf(project_statue.get(position)));


               context.startActivity(intent);
           }
       }));


    }

    @Override
    public int getItemCount() {
        return project_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView project_id_txt,project_title_txt,project_description_txt,project_statue_txt;
        LinearLayout listLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            project_id_txt = itemView.findViewById(R.id.project_id_txt);
            project_title_txt= itemView.findViewById(R.id.project_title_txt);
            project_description_txt= itemView.findViewById(R.id.project_description_txt);
            project_statue_txt= itemView.findViewById(R.id.project_statue_txt);

            listLayout=itemView.findViewById(R.id.listLayout);

        }
    }


}
