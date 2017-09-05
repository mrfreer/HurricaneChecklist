package com.example.android.hurricanechecklist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<CheckBox> allCheckBoxes = new ArrayList<>();
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        addListenerOnButton();
    }


    public void addListenerOnButton(){
        allCheckBoxes.add((CheckBox)findViewById(R.id.checkBoxFlashLight));
        allCheckBoxes.add((CheckBox)findViewById(R.id.checkBoxFood));
        allCheckBoxes.add((CheckBox)findViewById(R.id.checkBoxMedicine));
        allCheckBoxes.add((CheckBox)findViewById(R.id.checkBoxWater));
        textView = (TextView)findViewById(R.id.textViewResults);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int sum = 0;

                        for(int i = 0; i < allCheckBoxes.size(); i++){
                            if(allCheckBoxes.get(i).isChecked()){
                                sum++;
                            }
                        }
                        textView.setVisibility(View.VISIBLE);
                        if(sum == 4)
                            textView.setText("Get ready to rock and roll.");
                        else
                            textView.setText("Get prepared and FAST.");
                        }
                    }
        );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
