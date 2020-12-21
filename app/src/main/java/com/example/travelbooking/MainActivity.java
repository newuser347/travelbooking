package com.example.travelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    Spinner countries;
    TextView Capital,visitorsNo,amount;
    ImageView img;
    ListView lv;
    SeekBar SB;
    String counts[]={"Canada","USA","England"};
    ArrayList<country> countryList = new ArrayList<>();
    ArrayList<String> countryName = new ArrayList<>();
    ArrayList<Place> placeList = new ArrayList<>();
    public void fillarray() {
        placeList.add(new Place("Niagara falls", 100.0, "nf"));
        placeList.add(new Place("CN Tower", 30.0, "cn"));
        placeList.add(new Place("Butchart Gardens", 30.0, "garden"));
        placeList.add(new Place("NotreDam Basilica", 50.0, "bas"));
        placeList.add(new Place("Statue of Liberty", 90.0, "statue"));
        placeList.add(new Place("Time Square", 75.0, "time"));
        placeList.add(new Place("White House", 60.0, "white"));
        placeList.add(new Place("Big Ben", 30.0, "big"));
        placeList.add(new Place("West Minister Abbey", 25.0, "wes"));
        placeList.add(new Place("Hyde Park", 15.0, "hyde"));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countries = findViewById(R.id.countrySp);
        Capital = findViewById(R.id.cap);
        img = findViewById(R.id.iv);
        lv = findViewById(R.id.placesLV);
        visitorsNo = findViewById(R.id.vNo);
        SB = findViewById(R.id.seekBar);

        fillData();
        fillarray();
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,counts);
        countries.setAdapter(aa);
        countries.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        Capital.setText(String.valueOf(countryList.get(0).getcCap()));
        lv.setAdapter(new PlaceAdapter(this,placeList));
        lv.setOnItemClickListener(this);
        SB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                visitorsNo.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

    public void fillData() {
        countryList.add(new country(counts[0], "Ottawa", "canada"));
        countryList.add(new country(counts[1], "Washington", "usa"));
        countryList.add(new country(counts[2], "Washington", "usa"));


        // for (int i = 0; i < countryList.size(); i++) {
            //countryName.add(countryList.get(i).getcName());
        //}
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Capital.setText(countryList.get(i).getcCap());
        int imgId = getResources().getIdentifier(countryList.get(i).getcImg(),"drawable",getPackageName());
        img.setImageResource(imgId);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        lv.setAdapter(new PlaceAdapter(this,placeList));
    }
}