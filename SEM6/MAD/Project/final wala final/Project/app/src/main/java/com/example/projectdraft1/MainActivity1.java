package com.example.projectdraft1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity {

    // creating a variable for our array list, adapter class,
    // recycler view, progressbar, nested scroll view
    private ArrayList<UserModal> userModalArrayList;
    private UserRVAdapter userRVAdapter;
    private RecyclerView userRV;
    private ProgressBar loadingPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to DashboardActivity
                Intent intent = new Intent(MainActivity1.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        // creating a new array list.
        userModalArrayList = new ArrayList<>();

        // initializing our views.
        userRV = findViewById(R.id.idRVUsers);
        loadingPB = findViewById(R.id.idPBLoading);

        // calling a method to load our API.
        getDataFromAPI();
    }

    private void getDataFromAPI() {

        // creating a string variable for URL.
        String url = "https://sheets.googleapis.com/v4/spreadsheets/1QQ8DT7k1c_xiEm3FBLzlSe23g0uQK8QvKIi6YhsZxVw/values/DemoData!A2:S42?key=AIzaSyDEa1iWZaxMOWwEiDjtGVw-9kLe8ezkj-8";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(MainActivity1.this);

        // creating a variable for our JSON object request and passing our URL to it.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            loadingPB.setVisibility(View.GONE);
            try {
                JSONObject feedObj = new JSONObject(String.valueOf(response));
                //Toast.makeText(MainActivity.this, " "+feedObj, Toast.LENGTH_LONG).show();
                JSONArray entryArray = feedObj.getJSONArray("values");
                //Toast.makeText(MainActivity.this, " "+entryArray, Toast.LENGTH_SHORT).show();

                for(int i=0; i<entryArray.length(); i++){
                    JSONArray entryObj = entryArray.getJSONArray(i);
                   // Toast.makeText(MainActivity.this, " "+entryObj, Toast.LENGTH_SHORT).show();

                    String id = String.valueOf((entryObj.get(0)));
                   // Toast.makeText(MainActivity.this, "id"+id, Toast.LENGTH_LONG).show();
                    //String studentId = entryObj.getJSONObject("gsx$id").getString("$t");
                    String studentName = String.valueOf(entryObj.get(1));
                    //String marks = entryObj.getJSONObject("gsx$marks").getString("$t");
                   // Toast.makeText(MainActivity.this, "studentName"+studentName, Toast.LENGTH_SHORT).show();
                    int m1 = Integer.parseInt(entryObj.get(2).toString());
                    //Toast.makeText(MainActivity.this, "FCC"+m1, Toast.LENGTH_SHORT).show();
                    int m2 = Integer.parseInt(String.valueOf(entryObj.get(3)));
                    int m3 = Integer.parseInt(String.valueOf(entryObj.get(4)));
                    int m4 = Integer.parseInt(String.valueOf(entryObj.get(5)));
                    int m5 = Integer.parseInt(String.valueOf(entryObj.get(6)));
                    int m6 = Integer.parseInt(String.valueOf(entryObj.get(7)));
                    int m7 = Integer.parseInt(String.valueOf(entryObj.get(8)));
                    int m8 = Integer.parseInt(String.valueOf(entryObj.get(9)));
                    int m9 = Integer.parseInt(String.valueOf(entryObj.get(10)));

                    //Toast.makeText(MainActivity.this, "implemented", Toast.LENGTH_SHORT).show();
                    userModalArrayList.add(new UserModal(id,studentName,m1,m2,m3,m4,m5,m6,m7,m8,m9));


                    //Toast.makeText(MainActivity.this, " **** "+userModalArrayList, Toast.LENGTH_LONG).show();

                    // passing array list to our adapter class.
                    userRVAdapter = new UserRVAdapter(userModalArrayList, MainActivity1.this);

                    // setting layout manager to our recycler view.
                    userRV.setLayoutManager(new LinearLayoutManager(MainActivity1.this));

                    // setting adapter to our recycler view.
                    userRV.setAdapter(userRVAdapter);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> {
            // handline on error listener method.
            Toast.makeText(MainActivity1.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
        });
        // calling a request queue method
        // and passing our json object
        queue.add(jsonObjectRequest);
    }
}
