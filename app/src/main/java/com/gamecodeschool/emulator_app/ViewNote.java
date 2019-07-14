package com.gamecodeschool.emulator_app;

<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> origin/master
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
<<<<<<< HEAD

        getNoteId();

        displayNote();

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), EditNoteActivity.class);
                intent.putExtra("NOTE_ID", noteId);
                startActivity(intent);
            }
        });
=======
>>>>>>> origin/master
        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(getBaseContext(), "notes", null, 1);
                databaseHelper.deleteNote(noteId);
                finish();
            }
        });

<<<<<<< HEAD


=======
        getNoteId();
        displayNote();
>>>>>>> origin/master
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

<<<<<<< HEAD
    @Override
    protected void onResume() {
        super.onResume();
        displayNote();
    }
=======
>>>>>>> origin/master
}
