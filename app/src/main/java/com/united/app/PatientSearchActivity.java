package com.united.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.united.data.DatabaseManager;
import com.united.data.PatientData;

import java.util.ArrayList;
import java.util.List;

public class PatientSearchActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton searchButton = (ImageButton) findViewById(R.id.patientSearchButton);
        searchButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // load all patients
        // todo for now it is completely fine to load all patiens at once, but when the DB
        // grows we should load only parts at the same time on load
        //List<PatientData> patients = PatientData.listAll(PatientData.class);

        /**for( PatientData patient : patients)
         {
         System.out.println(patient);
         }*/
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        ListView patientListView = (ListView) findViewById(R.id.patientListView);
        setupListView(patientListView);
    }

    private void setupListView(ListView listView)
    {
        final List<PatientData> wishLists = DatabaseManager.getInstance().getAllPatients();

        List<String> titles = new ArrayList<String>();
        for (PatientData patientData : wishLists)
        {
            titles.add(patientData.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles);
        listView.setAdapter(adapter);

        final Activity activity = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                //WishList wishList = wishLists.get(position);
                //Intent intent = new Intent(activity, WishItemListActivity.class);
                //intent.putExtra(Constants.keyWishListId, wishList.getId());
                //startActivity(intent);
            }
        });
    }

}
