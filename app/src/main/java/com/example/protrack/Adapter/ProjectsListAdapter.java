package com.example.protrack.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protrack.Models.Project;
import com.example.protrack.ProjectsClickListener;
import com.example.protrack.R;

import java.util.List;

public class ProjectsListAdapter extends  RecyclerView.Adapter<ProjectViewHolder> {
Context context;
List<Project> list;
ProjectsClickListener listener ;

    public ProjectsListAdapter(Context context, List<Project> list, ProjectsClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProjectViewHolder(LayoutInflater.from(context).inflate(R.layout.my_row,parent,false)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        Project currentProject = list.get(position);

        // Use safe access for TextViews
        if (holder.project_title_txt != null) {
            holder.project_title_txt.setText(currentProject.getTitle());
            holder.project_title_txt.setSelected(true);
        }

        if (holder.project_description_txt != null) {
            holder.project_description_txt.setText(currentProject.getDescription());
            // holder.project_description_txt.setSelected(true); // Uncomment if needed
        }
        if (list.get(position).isActive()){
             holder.project_active.setImageResource(R.drawable.green_circle);
        } else {
            holder.project_active.setImageResource(R.drawable.red_circle);
        }



        holder.projects_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(list.get(holder.getAdapterPosition()));
            }
        });
        holder.projects_container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onLongClick(list.get(holder.getAdapterPosition()),holder.projects_container);
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void filterList(List<Project> filterList){
        list=filterList;
        notifyDataSetChanged();
    }

}
class ProjectViewHolder extends RecyclerView.ViewHolder {

    CardView projects_container;
    TextView project_title_txt;
    TextView project_description_txt;
    ImageView project_active;

    public ProjectViewHolder(@NonNull View itemView) {
        super(itemView);
        projects_container = itemView.findViewById(R.id.projects_container);
        project_title_txt = itemView.findViewById(R.id.project_title_txt);
        project_description_txt = itemView.findViewById(R.id.project_description_txt);
        project_active = itemView.findViewById(R.id.project_active);

    }
}

