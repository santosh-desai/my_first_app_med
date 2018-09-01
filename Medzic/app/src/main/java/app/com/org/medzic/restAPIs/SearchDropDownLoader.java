package app.com.org.medzic.restAPIs;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import org.json.JSONObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import app.com.org.medzic.SearchActivity;
import app.com.org.medzic.model.Medicine;

public class SearchDropDownLoader  {

    public List<Medicine> medicines = new ArrayList<Medicine>();

    public SearchDropDownLoader(String url, String name){
        getDropDownDetails(url, name);
    }

    private void getDropDownDetails(String site_url, String name){
        String resultToDisplay;

        InputStream in = null;
        String urlString = site_url+"/search/getDrugDetailsOnKeyUp?drugName="+name;
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            urlConnection.setRequestProperty("Accept", "*/*");
            urlConnection.connect();
            in = new BufferedInputStream(urlConnection.getInputStream());

            StringBuilder str = new StringBuilder();
            int i;
            char c;
            // reads till the end of the stream
            while ((i = in.read()) != -1) {
                // converts integer to character
                c = (char) i;

                str.append(c);
            }

            String data = str.toString();
            System.out.println(data);
            String[] arr = data.split("\\],\\[");

            if(data.length()>5){
                for (String med : arr) {
                    Medicine medicine = new Medicine();
                    String remove_brac = med.replaceAll("\\[", "").replaceAll("\\]","");
                    String[] med1 = remove_brac.split(",");
                    medicine.setId(Integer.parseInt(med1[0]));
                    medicine.setCmsId(Integer.parseInt(med1[2]));
                    medicine.setName(med1[1].replaceAll("\"",""));
                    medicine.setContent(med1[4].replaceAll("\"",""));
                    medicine.setDrugType(med1[3].replaceAll("\"",""));
                    medicines.add(medicine);
                }
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
