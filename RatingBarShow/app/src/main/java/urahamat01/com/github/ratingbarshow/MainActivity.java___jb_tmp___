package urahamat01.com.github.ratingbarshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RatingBar rationbarId;
    private TextView textViewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rationbarId = findViewById(R.id.rationbarId);
        textViewId = findViewById(R.id.textViewId);
        textViewId.setText("Rating Bar " + rationbarId.getProgress());
        rationbarId.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textViewId.setText("Rating Bar " + rating);
            }
        });
    }
}
