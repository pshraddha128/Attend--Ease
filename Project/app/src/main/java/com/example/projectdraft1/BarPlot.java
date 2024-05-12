package com.example.projectdraft1;

import static android.util.Half.toFloat;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;

public class BarPlot extends AppCompatActivity {
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_plot);
        barChart = findViewById(R.id.chart);
        //ArrayList<Integer> barEntries = intent.getSerializableExtra("key");
        b1 = findViewById(R.id.button);
        barChart.animateXY(1000, 1000); // Example animation duration
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getAxisRight().setDrawGridLines(false);
        barChart.getAxisLeft().setDrawGridLines(false);

        barChart.setBackgroundColor(Color.TRANSPARENT);
        getEntries();
        barDataSet = new BarDataSet(barEntries,"");
        //barDataSet.setLabel(String.valueOf(entryObj));
        //Toast.makeText(this, ""+barDataSet, Toast.LENGTH_SHORT).show();
        barData = new BarData(barDataSet);
        //Toast.makeText(this, ""+barData, Toast.LENGTH_LONG).show();
        barChart.setData(barData);
        //barChart.setDrawValueAboveBar(true);
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);

        barChart.getXAxis().setGranularity(1);
        barChart.getAxisLeft().setGranularity(3);



        barChart.getDescription().setEnabled(false);
        int[] colors = new int[] {Color.parseColor("#BEFCFF"), Color.parseColor("#DEFFFA"), Color.parseColor("#FFDAF5"), Color.parseColor("#B0E1FF"), Color.parseColor("#E6C6FF"), Color.parseColor("#EE8EA5"), Color.parseColor("#E2E2E2"), Color.parseColor("#B84656"), Color.parseColor("#97E589")};
        barDataSet.setColors(colors);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(18f);
        barDataSet.setDrawValues(true);
        barChart.setVisibleXRangeMaximum(4);


        //barChart.setXAxisRenderer(new CustomXAxisRenderer(barChart.getViewPortHandler(), barChart.getXAxis(), barChart.getTransformer(YAxis.AxisDependency.LEFT)));

        barChart.invalidate();


        getDataFromAPI();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BarPlot.this, MainActivity1.class);
                startActivity(intent);
            }
        });



    }
    private void getEntries() {



        ArrayList<Integer> customObjects = (ArrayList<Integer>) getIntent().getSerializableExtra("key");
        //Toast.makeText(this, " **** "+customObjects, Toast.LENGTH_SHORT).show();
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1f, customObjects.get(0),"xdhsbz"));
        barEntries.add(new BarEntry(2f, customObjects.get(1)));
        barEntries.add(new BarEntry(3f, customObjects.get(2)));
        barEntries.add(new BarEntry(4f, customObjects.get(3)));
        barEntries.add(new BarEntry(5f, customObjects.get(4)));
        barEntries.add(new BarEntry(6f, customObjects.get(5)));
        barEntries.add(new BarEntry(7f, customObjects.get(6)));
        barEntries.add(new BarEntry(8f, customObjects.get(7)));
        barEntries.add(new BarEntry(9f, customObjects.get(8)));


        barChart.setDrawValueAboveBar(true);
        barChart.invalidate();

        barChart.setDrawGridBackground(false);


}

    private void getDataFromAPI() {

        // creating a string variable for URL.
        String url = "https://sheets.googleapis.com/v4/spreadsheets/1QQ8DT7k1c_xiEm3FBLzlSe23g0uQK8QvKIi6YhsZxVw/values/DemoData!A1:S1?key=AIzaSyDEa1iWZaxMOWwEiDjtGVw-9kLe8ezkj-8";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(BarPlot.this);

        // creating a variable for our JSON object request and passing our URL to it.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            //loadingPB.setVisibility(View.GONE);
            try {
                JSONObject feedObj = new JSONObject(String.valueOf(response));
                //Toast.makeText(MainActivity.this, " "+feedObj, Toast.LENGTH_LONG).show();
                JSONArray entryArray = feedObj.getJSONArray("values");
                //Toast.makeText(MainActivity.this, " "+entryArray, Toast.LENGTH_SHORT).show();
                JSONArray entryObj = entryArray.getJSONArray(0);
                //Toast.makeText(this, ""+entryObj, Toast.LENGTH_SHORT).show();
                //ArrayList<String> labels = new ArrayList<>((Collection) entryObj);
                //Toast.makeText(this, ""+labels, Toast.LENGTH_SHORT).show();
                //barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
                //ArrayList<String> labels1 = labels;
                //return labels1;

                ArrayList<String> labels = new ArrayList<String>();

                if (entryObj != null) {
                    for (int i=0;i<entryObj.length();i++){
                        labels.add(entryObj.getString(i));
                    }
                }
                labels.remove(0);
                //labels.remove(1);
                //Toast.makeText(this, ""+labels, Toast.LENGTH_SHORT).show();
                //barChart.setXAxisRenderer(new CustomXAxisRenderer(barChart.getViewPortHandler(),barChart.getXAxis(),barChart.getTransformer(YAxis.AxisDependency.LEFT)));
                barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
                barChart.getXAxis().setXOffset(1);
                barChart.getXAxis().setLabelRotationAngle(-90);
                barChart.getXAxis().setTextSize(15f);
                barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> {
            // handline on error listener method.
            Toast.makeText(BarPlot.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
        });
        // calling a request queue method
        // and passing our json object
        queue.add(jsonObjectRequest);



    }




}

