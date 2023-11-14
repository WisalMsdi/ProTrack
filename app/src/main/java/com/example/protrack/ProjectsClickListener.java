package com.example.protrack;

import androidx.cardview.widget.CardView;

import com.example.protrack.Models.Project;

public interface ProjectsClickListener {
    void onClick(Project project);
    void onLongClick(Project project, CardView cardView);
}
