package com.example.myapplication;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class MyActivity extends TabActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, TestActivity.class);
        // Create our custom view. 
        View tabView = createTabView(this, "푸드");
        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("푸드").setIndicator(tabView)
                .setContent(intent);
        tabHost.addTab(spec);
        // Do the same for the other tabs
        tabView = createTabView(this, "세제");
        intent = new Intent().setClass(this, TestActivity.class);
        spec = tabHost.newTabSpec("세제").setIndicator(tabView)
                .setContent(intent);
        tabHost.addTab(spec);
        tabView = createTabView(this, "바디");
        intent = new Intent().setClass(this, TestActivity.class);
        spec = tabHost.newTabSpec("바디").setIndicator(tabView)
                .setContent(intent);
        tabHost.addTab(spec);
        tabView = createTabView(this, "페이스");
        intent = new Intent().setClass(this, TestActivity.class);
        spec = tabHost.newTabSpec("페이스").setIndicator(tabView)
                .setContent(intent);
        tabHost.addTab(spec);
    }

    private static View createTabView(Context context, String tabText) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null, false);
        TextView tv = (TextView) view.findViewById(R.id.tabTitleText);
        tv.setText(tabText);
        return view;
    }
}