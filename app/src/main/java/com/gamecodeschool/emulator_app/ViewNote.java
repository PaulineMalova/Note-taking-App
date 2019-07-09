package com.gamecodeschool.emulator_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gamecodeschool.database.DatabaseHelper;
import com.gamecodeschool.database.Note;

public class ViewNote extends AppCompatActivity {
    int noteId;
    TextView tvTitle;
    TextView tvNoteText;
    Button btnEdit;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvTitle = findViewById(R.id.tvTitle);
        tvNoteText = findViewById(R.id.tvNoteText);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(getBaseContext(), "notes", null, 1);
                databaseHelper.deleteNote(noteId);
                finish();
            }
        });

        getNoteId();
        displayNote();
    }

    private void getNoteId() {
        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            noteId = extras.getInt("NOTE_ID");
        }
    }

    private void displayNote(){
        DatabaseHelper databaseHelper = new DatabaseHelper(getBaseContext(), "notes", null, 1);
        Note note = databaseHelper.getNoteById(noteId);
        tvTitle.setText(note.getTitle());
        tvNoteText.setText(note.getNoteText());
    }

}
