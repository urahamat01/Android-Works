package com.rahamat.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expendableListViewId);

        preparedListData();


    }

    private void preparedListData() {

        String[] headerString = getResources().getStringArray(R.array.abbreviation_list_header);
        String[] chaildString = getResources().getStringArray(R.array.abbreviation_list_child);

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        for (int i = 0; i < headerString.length; i++) {

            listDataHeader.add(headerString[i]);

            List<String> child = new ArrayList<>();
            child.add(chaildString[i]);
            listDataChild.put(listDataHeader.get(i), child);

        }
    }
}
