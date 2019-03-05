package com.example.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShowRating extends AppCompatActivity {
   // RatingBar ratingbar;
    // Button button;
    DatabaseReference reff;
    RatingBar ratingRatingBar;
    Button submitrating,btnsave;
    TextView ratingDisplayTextView;
    EditText ratingDisplayText;
    RatingBarValue rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_rating);

         ratingRatingBar= (RatingBar)findViewById(R.id.ratingBar);
         submitrating= (Button)findViewById(R.id.buttonRating);
         ratingDisplayTextView = (TextView)findViewById(R.id.rating_display_text_view);


        submitrating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingDisplayTextView.setText("your rating is: "+ ratingRatingBar.getRating());

            }
        });
        rating=new RatingBarValue();
        reff= FirebaseDatabase.getInstance().getReference().child("rating");
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int  value =Integer.parseInt(String.valueOf(ratingRatingBar.getRating()));
               rating.setValue(value);
                reff.push().setValue(rating);
                //Toast toast = Toast.makeText(ShowRating.this ,"data inserted sussefully",Toast.LENGTH_LONG).show();
            }
        });
    }

    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick(){
        ratingbar=(RatingBar)findViewById(R.id.ratingBar);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating=String.valueOf(ratingbar.getRating());
                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
            }
        });
    }
    */
}
