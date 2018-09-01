package app.com.org.medzic;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import app.com.org.medzic.model.Medicine;
import app.com.org.medzic.restAPIs.SearchDropDownLoader;
import app.com.org.medzic.util.AutocompleteAdapter;

public class SearchActivity extends AppCompatActivity implements TextWatcher{
    AutoCompleteTextView actv;
    List<Medicine> medicines;
    AutocompleteAdapter adapter;
    boolean isClicked = false;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_location:

                    return true;
                case R.id.navigation_search:

                    return true;
                case R.id.navigation_profile:

                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //toolbar.setBackgroundColor(Color.parseColor("#80000000"));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_menu_sort));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked toolbar ", Toast.LENGTH_SHORT).show();
            }
        });

        //Getting the instance of AutoCompleteTextView


        actv= (AutoCompleteTextView)findViewById(R.id.search);

        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Medicine med = adapter.getItem(i);
                Intent intent = new Intent(SearchActivity.this, MedicineDetailsActivity.class);
                intent.putExtra("medName", med.getName());
                intent.putExtra("medId", med.getId());
                intent.putExtra("medType", med.getDrugType());
                intent.putExtra("medContent", med.getContent());
                startActivity(intent);
            }
        });

        actv.addTextChangedListener(this);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }



    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (actv.isPerformingCompletion()) {
            // An item has been selected from the list. Ignore.
            return;
        }
        String text = String.valueOf(actv.getText());
        adapter = new AutocompleteAdapter(this,android.R.layout.simple_dropdown_item_1line, getString(R.string.API_URL), text);
        actv.setAdapter(adapter);

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }


}
