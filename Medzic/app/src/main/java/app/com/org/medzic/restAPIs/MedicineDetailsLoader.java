package app.com.org.medzic.restAPIs;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.com.org.medzic.model.Medicine;
import app.com.org.medzic.model.MedicineDetails;

public class MedicineDetailsLoader {

    public MedicineDetails medicines;
    public List<MedicineDetails> medicineDetails;

    public MedicineDetailsLoader(String url, String mId){
        getMedicineDetails(url, mId);
    }

    public MedicineDetailsLoader(String url){
        System.out.println(url);
        getAlternateMedicines(url);
    }

    private void getAlternateMedicines(String surl) {
        String resultToDisplay;

        InputStream in = null;
        String urlString = surl;
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
            //JsonArray jsonArray = new JsonArray(data);
            JSONArray jsonArray = new JSONArray(data);

            /*if(data.length()>5){
                List<String> med1 = Arrays.asList(arr);
                medicines = new MedicineDetails();
                medicines.setMediPackId(Integer.parseInt(med1.get(0)));
                medicines.setDrugId(Integer.parseInt(med1.get(1)));
                medicines.setDrugType(med1.get(2).trim());
                medicines.setMrp(med1.get(3).trim());
                medicines.setPacking(med1.get(4).trim());
                medicines.setAtcCode(med1.get(5).trim());
                medicines.setManfacturer(med1.get(6).trim());
                medicines.setDrugName(med1.get(7).trim());
                medicines.setCimsClass(med1.get(8).trim());
                medicines.setDrugContent(med1.get(9).trim());
                medicines.setTreatmentType(med1.get(10).trim());
                medicines.setDosage(med1.get(11).trim());
                medicines.setUniqueDrgId(Integer.parseInt(med1.get(12)));
                medicines.setAtcCodeId(Integer.parseInt(med1.get(13)));
            }*/


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getMedicineDetails(String site_url, String mId){
        String resultToDisplay;

        InputStream in = null;
        String urlString = site_url+"/search/getDesiredMediPackDetails?drppckID="+mId;
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
            String arr = data.replaceFirst("\\[", "{").replace("\\]","}");

            if(data.length()>5){
                    List<String> med1 = Arrays.asList(arr);
                    medicines = new MedicineDetails();
                    medicines.setMediPackId(Integer.parseInt(med1.get(0)));
                    medicines.setDrugId(Integer.parseInt(med1.get(1)));
                    medicines.setDrugType(med1.get(2).trim());
                    medicines.setMrp(med1.get(3).trim());
                    medicines.setPacking(med1.get(4).trim());
                    medicines.setAtcCode(med1.get(5).trim());
                    medicines.setManfacturer(med1.get(6).trim());
                    medicines.setDrugName(med1.get(7).trim());
                    medicines.setCimsClass(med1.get(8).trim());
                    medicines.setDrugContent(med1.get(9).trim());
                    medicines.setTreatmentType(med1.get(10).trim());
                    medicines.setDosage(med1.get(11).trim());
                    medicines.setUniqueDrgId(Integer.parseInt(med1.get(12)));
                    medicines.setAtcCodeId(Integer.parseInt(med1.get(13)));
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
