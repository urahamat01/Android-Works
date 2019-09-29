package github.com.urahamat01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   //valueable
    private ImageView imageViewId1, imageViewId2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //imageView inatialigation value
        imageViewId1 = findViewById(R.id.imageViewId1);
        imageViewId2= findViewById(R.id.imageViewId2);
        imageViewId1.setOnClickListener(this);
        imageViewId2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //condition follow
        if (v.getId() == R.id.imageViewId1){
            Toast.makeText(this, "First Picter", Toast.LENGTH_SHORT).show();
        }else if (v.getId() == R.id.imageViewId2){
            Toast.makeText(this, "This my Secand picter", Toast.LENGTH_SHORT).show();
        }

    }
}
