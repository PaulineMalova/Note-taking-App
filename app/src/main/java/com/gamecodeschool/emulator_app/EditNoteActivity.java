package com.gamecodeschool.emulator_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gamecodeschool.database.DatabaseHelper;
import com.gamecodeschool.database.Note;

public class EditNoteActivity extends AppCompatActivity {
    Button btnUpdate;
    EditText etTitle;
    EditText etNote;
    String title;
    String noteText;
    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        etNote = findViewById(R.id.etNote);
        etTitle = findViewById(R.id.etTitle);
        btnUpdate = findViewById(R.id.btnUpdate);

        getNoteId();
        displayNote();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = etTitle.getText().toString();
                noteText = etNote.getText().toString();
                Note note = new Note(noteId, title, noteText);
                DatabaseHelper databaseHelper = new DatabaseHelper(getBaseContext(), "notes", null, 1);
                databaseHelper.updateNote(note);
                finish();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void getNoteId() {
        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            noteId = extras.getInt("NOTE_ID", 0);
        }
    }

    private void displayNote(){
        DatabaseHelper databaseHelper = new DatabaseHelper(getBaseContext(), "notes", null, 1);
        Note note = databaseHelper.getNoteById(noteId);
        etTitle.setText(note.getTitle());
        etNote.setText(note.getNoteText());
    }

}
