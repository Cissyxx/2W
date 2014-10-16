package com.cissy.rpiwhenwhere;

import com.cissy.rpiwhenwhere.R;
import com.cissy.rpiwhenwhere.SearchPage;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	
	EditText mainPageET;
	
	Button textButton, searchButton, catalogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mainPageET = (EditText) findViewById(R.id.search_filed);
        textButton = (Button) findViewById(R.id.textButton);
        searchButton = (Button) findViewById(R.id.searchButton);
        catalogButton = (Button) findViewById(R.id.catalogButton);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void switchToSearchPage(View view){		
		Intent theIntent = new Intent(this, SearchPage.class);
		startActivity(theIntent);
	}
    
    public void switchToCatalogPage(View view) {
    	Intent theIntent = new Intent(this, CatalogPage.class);
    	startActivity(theIntent);
    }
    
    
    
}
