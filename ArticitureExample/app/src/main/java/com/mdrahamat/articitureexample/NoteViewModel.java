package com.mdrahamat.articitureexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.app.Application;
import android.os.Bundle;

import java.util.List;
import java.util.Objects;

public class NoteViewModel extends AppCompatActivity {
    private NoteRepository repository;
    private LiveData<List<Note>>allNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_view_model);
    }

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNote = repository.getAllNote();
    }

    public void insert(Note note){
        repository.insert(note);

    }

    public void update(Note note){
        repository.update(note);

    }

    public void delete(Note note){
        repository.delete(note);

    }

    public void deleteAllNote(Note note){
        repository.deleteAllNote(note);

    }

    public void LiveData<List<Note>>

    public LiveData<List<Note>> getAllNote() {
        return allNote;
    }



}
