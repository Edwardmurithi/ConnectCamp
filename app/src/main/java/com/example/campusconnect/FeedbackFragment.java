package com.example.campusconnect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class FeedbackFragment extends Fragment {

    private EditText editTextName, editTextEmail, editTextFeedback;
    private Button submitFeedbackButton;

    public FeedbackFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        // Initializing Views
        editTextName = view.findViewById(R.id.editTextName);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextFeedback = view.findViewById(R.id.editTextFeedback);
        submitFeedbackButton = view.findViewById(R.id.submitFeedbackButton);

        // Set onClick listener for the submit button
        submitFeedbackButton.setOnClickListener(v -> submitFeedback());

        return view;
    }

    private void submitFeedback() {
        // Retrieving user input
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String feedbackMessage = editTextFeedback.getText().toString();

        // Here you can perform validation and submit the feedback
        if (name.isEmpty() || email.isEmpty() || feedbackMessage.isEmpty()) {
            Toast.makeText(getActivity(), "Please fill in all fields.", Toast.LENGTH_SHORT).show();
        } else {
            // Handle feedback submission logic (e.g., send to server or save locally)
            Toast.makeText(getActivity(), "Feedback Submitted!", Toast.LENGTH_SHORT).show();
        }
    }
}
