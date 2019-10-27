package com.mdrahamat.articitureexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTA_TITLE = "com.mdrahamat.articitureexample.EXTA_TITLE";
    public static final String EXTA_DESCRIPTION = "com.mdrahamat.articitureexample.EXTA_DESCRIPTION";
    public static final String EXTA_PRORITY = "com.mdrahamat.articitureexample.EXTA_PRIORITY";

    private EditText addNoteTitle, addNoteDescription;
    private NumberPicker numberPickerProiety;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        init();
    }

    private void init() {
        addNoteTitle = findViewById(R.id.edit_text_title);
        addNoteDescription = findViewById(R.id.edit_text_description);
        numberPickerProiety = findViewById(R.id.number_picker_priority);
        numberPickerProiety.setMinValue(1);
        numberPickerProiety.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_24dp);
        setTitle("Add Note");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    private void saveNote() {
        String title = addNoteTitle.getText().toString().trim();
        String description = addNoteDescription.getText().toString().trim();
        int priority = numberPickerProiety.getValue();

        if (title.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, " saveNote ", Toast.LENGTH_SHORT).show();

            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTA_TITLE, title);
        intent.putExtra(EXTA_DESCRIPTION, description);
        intent.putExtra(EXTA_PRORITY, priority);
        setResult(RESULT_OK, intent);
        finish();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
