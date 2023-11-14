package com.example.formulaire;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignupTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignupTabFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button signupButton;
    private TextView successMessageTextView;
    private View view;
    public SignupTabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignupTabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignupTabFragment newInstance(String param1, String param2) {
        SignupTabFragment fragment = new SignupTabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup_tab, container, false);

        // Initialize your views
        emailEditText = view.findViewById(R.id.signup_email);
        passwordEditText = view.findViewById(R.id.signup_password);
        confirmPasswordEditText = view.findViewById(R.id.signup_confirm);
        signupButton = view.findViewById(R.id.signup_button);

        // Initialize your success message TextView
        successMessageTextView = view.findViewById(R.id.success_message);

        // Set onClickListener for the signup button
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                // Check if passwords match
                if (!password.equals(confirmPassword)) {
                    // Handle password mismatch
                    // You can show a Toast or setError on the confirm password field
                    return;
                }

                // Create Inscrire object
                Inscrire inscrire = new Inscrire();
                inscrire.setSpecificEmail(email);
                inscrire.setSpecificPassword(password);

                // Insert data into the database
                MyApplication.appDatabase.inscrireDao().insert(inscrire);

                // Show the success message
                showSignupSuccessMessage();
                resetFields();

            }
        });
        Button resetPasswordButton = view.findViewById(R.id.reset_password_button);

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the method to reset the password fields
                resetFields();
            }
        });

        return view;
    }
    private void showSignupSuccessMessage() {
        // Display the success message
        successMessageTextView.setVisibility(View.VISIBLE);
        successMessageTextView.setText("Signup succeeded!");

        // Optional: Delay for a few seconds and then hide the message
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                successMessageTextView.setVisibility(View.GONE);
            }
        }, 3000); // Adjust the duration as needed (here, it's set to 3 seconds)
    }
    private void resetFields() {
        // Clear the email, password, and confirm password fields
        emailEditText.setText("");
        passwordEditText.setText("");
        confirmPasswordEditText.setText("");
    }

}

