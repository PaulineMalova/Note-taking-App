package com.gamecodeschool.emulator_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
    EditText etTitle;
    EditText etNote;
    Button btnAddPhoto;
    Button btnAddVoiceNote;
    Button btnSave;
    String title;
    String note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etTitle = findViewById(R.id.etTitle);
        etNote = findViewById(R.id.etNote);
        btnAddPhoto = findViewById(R.id.btnAddPhoto);
        btnAddVoiceNote = findViewById(R.id.btnAddVoiceNote);
        btnSave = findViewById(R.id.btnSave);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = etTitle.getText().toString();
                note = etNote.getText().toString();
                Log.d("editText", title);
                Log.d("editText", note);
                Toast.makeText(getBaseContext(), "Saving...", Toast.LENGTH_LONG).show();
            }
        });



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
