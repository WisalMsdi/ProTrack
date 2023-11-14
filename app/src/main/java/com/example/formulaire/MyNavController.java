package com.example.formulaire;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MyNavController {

    private FragmentManager fragmentManager;

    public MyNavController(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void navigateToDashboard() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, new DashboardFragment());
        transaction.addToBackStack(null); // Facultatif : permet de revenir en arrière
        transaction.commit();
    }
}
