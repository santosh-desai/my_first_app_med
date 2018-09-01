package app.com.org.medzic;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import app.com.org.medzic.model.DetailsPage;
import app.com.org.medzic.restAPIs.MedicineDetailsLoader;

public class MedicineDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    DetailsPage detailsPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_menu_sort));
        Intent intent = getIntent();
        String name = intent.getStringExtra("medName");
        String id = intent.getStringExtra("medId");
        String content = intent.getStringExtra("medContent");
        getMedicineDetails(id);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked toolbar ", Toast.LENGTH_SHORT).show();
            }
        });
        TextView medName = (TextView)findViewById(R.id.medicineName);
        medName.setText(name);
        TextView contentN = (TextView)findViewById(R.id.medicinedetail);
        contentN.setText(content);

        TextView review = (TextView)findViewById(R.id.writeReview);
        review.setOnClickListener(this);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void getMedicineDetails(String id) {
        try {
            new getMedicineData(getString(R.string.API_URL), id).execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

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
    public void onClick(View view) {
        startActivity(new Intent(MedicineDetailsActivity.this, ReviewActivity.class));
    }

    private class getMedicineData extends AsyncTask<Void, Void, Boolean> {
        String url ;
        String cid;

        public getMedicineData(String url, String id){
            this.url=url;
            this.cid=id;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            detailsPage = new DetailsPage();
            //detailsPage.setMedicineDetails(new MedicineDetailsLoader(url, cid).medicines);
            detailsPage.setAlternateMedicines(new MedicineDetailsLoader(url+"search/getDrugByATCcode?atc_code=J01CA12,J01CG02&drgID=5599&limitVal1=0&limitVal2=4&drugTy=POWDER").medicineDetails);
            return true;
        }
    }
}
