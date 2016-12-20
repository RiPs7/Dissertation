package eu.operando.operandoapp.filters.domain;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.List;

import eu.operando.operandoapp.R;
import eu.operando.operandoapp.database.DatabaseHelper;

public class PermissionsPerDomainActivity extends AppCompatActivity {

    private ScrollView PermissionsPerAllowedDomainScrollView = null, PermissionsPerBlockedDomainScrollView = null;
    private TabHost tabHost = null;
    private Button exportAllPermissionsPerDomainBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permissions_per_domain_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            setTitle("Permissions Per Domain");
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        PermissionsPerAllowedDomainScrollView = (ScrollView) findViewById(R.id.PermissionsPerAllowedDomainScrollView);
        PermissionsPerBlockedDomainScrollView = (ScrollView) findViewById(R.id.PermissionsPerBlockedDomainScrollView);

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("allowed");
        tabSpec.setContent(R.id.PermissionsPerAllowedDomainScrollView);
        tabSpec.setIndicator("Allowed");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("blocked");
        tabSpec.setContent(R.id.PermissionsPerBlockedDomainScrollView);
        tabSpec.setIndicator("Blocked");
        tabHost.addTab(tabSpec);

        try {
            DatabaseHelper db = new DatabaseHelper(this);
            for (String[] s : db.getAllPermissionsPerAllowedDomain()) {
                TextView tv = new TextView(this);
                tv.setText("Application Name: " + s[0].replaceAll("\\s\\(.+?\\)", "") + "\nPermissions Requested: " + s[1]);
                TableRow tr = new TableRow(this);
                tr.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                tr.addView(tv);
                ((TableLayout) PermissionsPerAllowedDomainScrollView.getChildAt(0)).addView(tr);

                View separator = new View(this);
                separator.setBackgroundColor(Color.BLACK);
                separator.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 5));
                ((TableLayout) PermissionsPerAllowedDomainScrollView.getChildAt(0)).addView(separator);
            }
            for (String[] s : db.getAllPermissionsPerBlockedDomain()) {
                TextView tv = new TextView(this);
                tv.setText("Application Name: " + s[0].replaceAll("\\s\\(.+?\\)", "") + "\nPermissions Requested: " + s[1]);
                TableRow tr = new TableRow(this);
                tr.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                tr.addView(tv);
                ((TableLayout) PermissionsPerBlockedDomainScrollView.getChildAt(0)).addView(tr);

                View separator = new View(this);
                separator.setBackgroundColor(Color.BLACK);
                separator.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 5));
                ((TableLayout) PermissionsPerBlockedDomainScrollView.getChildAt(0)).addView(separator);
            }
        } catch (Exception e) {
            Log.d("ERROR", e.getMessage());
        }

        /*exportAllPermissionsPerDomainBtn = (Button) findViewById(R.id.exportAllPermissionsPerDomainBtn);
        final DatabaseHelper db = new DatabaseHelper(this);
        exportAllPermissionsPerDomainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File path = new File("/storage/emulated/0/");
                String result;
                if ((result = db.exportAllPermissionsPerDomain(path)) != null){
                    Toast.makeText(PermissionsPerDomainActivity.this, "Exported to " + result, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(PermissionsPerDomainActivity.this, "Failed to export the settings", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }
}