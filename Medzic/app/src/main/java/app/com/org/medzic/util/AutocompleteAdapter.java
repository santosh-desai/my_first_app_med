package app.com.org.medzic.util;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import app.com.org.medzic.R;
import app.com.org.medzic.model.Medicine;
import app.com.org.medzic.restAPIs.SearchDropDownLoader;

public class AutocompleteAdapter extends ArrayAdapter implements Filterable {
    private List<Medicine> medicines;
    String url;
    String cid;

    public AutocompleteAdapter(Context context, int resource, String url, String cid) {
        super(context, resource);
        medicines = new ArrayList<>();
        this.cid=cid;
        this.url=url;
    }

    @Override
    public int getCount() {
        return medicines.size();
    }

    @Override
    public Medicine getItem(int position) {
        return medicines.get(position);
    }


    @Override
    public Filter getFilter() {
        Filter myFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if(constraint != null){
                    try{
                        //get data from the web
                        String term = constraint.toString();
                        medicines = new getMyDropDowndata(url, cid).execute().get();
                    }catch (Exception e){
                        Log.d("SANDES","EXCEPTION "+e);
                    }
                    filterResults.values = medicines;
                    filterResults.count = medicines.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if(results != null && results.count > 0){
                    notifyDataSetChanged();
                }else{
                    notifyDataSetInvalidated();
                }
            }
        };

        return myFilter;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.search_autocomplete,parent,false);

        //get medicines
        Medicine medicine = medicines.get(position);

        TextView countryName = (TextView) view.findViewById(R.id.medicine_name);

        countryName.setText(medicine.getName());

        return view;
    }

    private class getMyDropDowndata extends AsyncTask<Void, Void, ArrayList> {
        String url ;
        String cid;

        public getMyDropDowndata(String url, String id){
            this.url=url;
            this.cid=id;
        }

        @Override
        protected ArrayList doInBackground(Void... params) {
            return (ArrayList<Medicine>) new SearchDropDownLoader(url, cid).medicines;
        }
    }

}
