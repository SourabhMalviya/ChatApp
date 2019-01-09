package com.example.saura.chatapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView boxerTextView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boxerTextView = findViewById(R.id.boxerTextView);

        boxerTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.boxerTextView:
                final ParseObject boxer = new ParseObject("Boxer");
                boxer.put("name", "Sourabh");
                boxer.put("weight", 123);
                boxer.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null)
                            Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Boxer");
        query.getInBackground("npr8XQgUL1", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    Toast.makeText(MainActivity.this, object.getString("name"), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
