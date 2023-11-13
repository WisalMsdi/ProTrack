package com.example.seif.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seif.R;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder>{

    private Context context;
    private List<Note> noteList;
    private AdapterListener adapterListener;

    public NoteAdapter(Context context,AdapterListener listener) {
        this.context = context;
        noteList=new ArrayList<>();
        this.adapterListener=listener;
    }
    public void addNote(Note note){
        noteList.add(note);
        notifyDataSetChanged();
    }

    public void removeNote(int position){
        noteList.remove(position);
        notifyDataSetChanged();

    }

    public void clearData(){
        noteList.clear();
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_row,parent,false);
        return new  MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Note note=noteList.get(position);
        holder.title.setText(note.getTitle());
        holder.content.setText(note.getContent());
        holder.creationDate.setText(note.getCreationDate());
        holder.lastModifiedDate.setText(note.getLastModifiedDate());
        holder.status.setText(note.getStatus());
      holder.projectId.setText(String.valueOf(note.getProjectId()));

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterListener.OnUpdate(note);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterListener.OnDelete(note.getId(), position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView title,content,creationDate,lastModifiedDate,status;
        private TextView  projectId;
        private ImageView update,delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            content=itemView.findViewById(R.id.content);
            creationDate=itemView.findViewById(R.id.creationDate);
            lastModifiedDate=itemView.findViewById(R.id.lastModifiedDate);
            status=itemView.findViewById(R.id.status);
           projectId=itemView.findViewById(R.id.projectId);
            update=itemView.findViewById(R.id.update);
            delete=itemView.findViewById(R.id.delete);
        }
    }
}
