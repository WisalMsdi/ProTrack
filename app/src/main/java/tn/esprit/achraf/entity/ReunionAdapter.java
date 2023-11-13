package tn.esprit.achraf.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import tn.esprit.achraf.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReunionAdapter extends RecyclerView.Adapter<ReunionAdapter.MyViewHolder>{

    private Context context;
    private List<Reunion> reunionList;
    private ReunionAdapterListener reunionAdapterListener;

    public ReunionAdapter(Context context,ReunionAdapterListener listener) {
        this.context = context;
        reunionList=new ArrayList<>();
        this.reunionAdapterListener=listener;
    }
    public void addReunion(Reunion reunion){
        reunionList.add(reunion);
        notifyDataSetChanged();
    }

    public void removeReunion(int position){
        reunionList.remove(position);
        notifyDataSetChanged();

    }

    public void clearData(){
        reunionList.clear();
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
        Reunion reunion=reunionList.get(position);
        holder.sujet.setText(reunion.getSujet());
        holder.dateDebut.setText(reunion.getDateDebut());
        holder.dateFin.setText(reunion.getDateFin());

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reunionAdapterListener.OnUpdate(reunion);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reunionAdapterListener.OnDelete(reunion.getId(), position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return reunionList.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView sujet,dateDebut,dateFin;

        private ImageView update,delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sujet=itemView.findViewById(R.id.sujet);
            dateDebut=itemView.findViewById(R.id.dateDebut);
            dateFin=itemView.findViewById(R.id.dateFin);

            update=itemView.findViewById(R.id.update);
            delete=itemView.findViewById(R.id.delete);
        }
    }





}
