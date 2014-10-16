package com.cissy.rpiwhenwhere;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class SearchPage extends ActionBarActivity {
	
	EditText searchEditText;
	TextView locationTextView, hourTextView;
	Button textButton, searchButton, catalogButton;
	ListView listView;
	final static String[][] orgArray = {
		{"Student Mail Center","Mondays - Fridays: 8am - 12:30pm & 1pm - 4:25pm","Commons Dining Hall"},
		{"Faculty and Staff Mail Center","Mondays - Fridays: 8am - 4:30pm","J Building"},
		{"Advising & Learning Assistance Center","HrNULL","Academy Hall 4226"},
		{"International Services for Students and Scholars","Mondays - Fridays: 8:30am - 5pm","Academy Hall 4600"},
		{"Rensselaer Newman Foundation","HrNULL","Chapel and Cultural Center"},
		{"Tetherless World Constellation","HrNULL","Winslow Building"},
		{"BARH Dining Hall","M-R: 7:30a - 10a & 4p - 9p F: 7:30a - 10a & 3:30p - 7p Weekend: 10:10a - 1:30p & 5p - 7p","BARH"},
		{"Evelyns Cafe","Mondays - Fridays: 12pm - 3pm","EMPAC"},
		{"Delta Tau Delta, Upsilon Chapter","HrNULL","133 Sunset Terrace"},
		{"Office of the Registrar","Mon ~ Fri 9:00am to 4:30pm","2000 Level Academy Hall"},
		{"Bursar Office","Mon ~ Fri 9:00am to 4:30pm","1000 Level Academy Hall"},
		{"ISSS Office","Monday - Friday 8:30 a.m. - 5:00 p.m.","4000 Level Academy Hall"},
		{"Dean of Students","Monday - Friday 8:30 a.m. - 5:00 p.m.","4000 Level Academy Hall"},
		{"Student Experience office","Monday - Friday 8:30 a.m. - 5:00 p.m.","4000 Level Academy Hall"},
		{"Financial Aid","Mon ~ Fri 9:00am to 4:30pm","1000 Level Academy Hall"},
		{"Center for Career & Professional Development","Monday - Friday, 8:30 am: 5:00 p.m","Darrin Communications Center, Suite 209"},
		{"Jazzman Cafe","Monday - Friday, 7:30am - midnight","Darrin Communications Center, Main floor"},
		{"The Library Cafe","Closed for summer","Folsom Library level 2"},
		{"Union Club & Orgnization","HrNULL","Union Level 3"},
		{"Sports Organizations","HrNULL","Union Level 3"},
		{"Extracurricular Activities","HrNULL","Union Level 3"},
		{"Media Organizations (Publications)","HrNULL","Union Level 3"},
		{"Multicultural Organizations","HrNULL","Union Level 3"},
		{"Performing and Visual Arts","HrNULL","Union Level 3"},
		{"Professional/Honor Societies","HrNULL","Union Level 3"},
		{"Religious Organizations","HrNULL","Union Level 3"},
		{"Service Organizations","HrNULL","Union Level 3"},
		{"Greek Life Organizations","HrNULL","Union Level 3"},
		{"Student Government","HrNULL","Union Level 3"},
		{"Union Programs Activities Committee (UPAC)","HrNULL","Union Level 3"},
		{"Campus Unisex Hair","M-F 8a-8p","Union Level 1"},
		{"Game Room","M-R 9am-midnight F: 9a - 1a Sat: 12p - 1a Sun: 12p - midnight","Union Level 1"},
		{"Post Office","Mon-Fri 12:00pm-4:00pm","Union Level 1"},
		{"SEFCU Bank","M-F 8a-6p","Union Level 1"},
		{"Union Book Store","M-F 8:30a-5p","Union Level 1"},
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_page);
		
		searchEditText = (EditText) findViewById(R.id.searchEditText);
		textButton = (Button) findViewById(R.id.textButton);
		textButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name = searchEditText.getText().toString();
				System.out.println("Inside searchdata " + name);
				System.out.println("The first item is " + orgArray[0][0]);
				int i = 0;
				boolean notOrg = true;
				boolean notBuilding = true;
				for (String[] org : DBHelper.orgArray){
					System.out.println("the index is " + i++);
					if (org[0].equals(name)) {
						System.out.println("ORG FOUND!!!");
						hourTextView.setText("HOUR: \n" + org[1]);
						System.out.println("hour is " + org[1]);
						locationTextView.setText("LOCATION: \n" + org[2]);
						System.out.println("location is " + org[2]);
						notOrg = false;
						break;
					}
				}
				i = 0;
				if (notOrg) {
					for (String[] building : DBHelper.buildingArray){
						System.out.println("the index is " + i++);
						if (building[0].equals(name)) {
							System.out.println("BUILDING FOUND!!!");
							notBuilding = false;
							if (building[1].contains("NULL") && building[2].contains("NULL")) {
								//do nothing
							} else if (building[2].contains("NULL")) {
								hourTextView.setText("HOUR: \n" + building[1]);
								System.out.println("hour is " + building[1]);
							} else {
								hourTextView.setText("HOUR: \n" + building[1] + "\n" + building[2]);
								System.out.println("hour is " + building[1] + "\n" + building[2]);
							}
							if (building[3].contains("NULL")) {
								break;
							} else {
								locationTextView.setText("ORGANIZATION INSIDE: \n" + building[3]);
								System.out.println("organization inside is " + building[3]);
								break;
							}
						}
					}
				}
				if (notOrg && notBuilding) {
					hourTextView.setText("");
					locationTextView.setText("");
				}
				
			}
			
		});
		searchButton = (Button) findViewById(R.id.searchButton);
		catalogButton = (Button) findViewById(R.id.catalogButton);
		hourTextView = (TextView) findViewById(R.id.hourTextView);
		locationTextView = (TextView) findViewById(R.id.locationTextView);
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_page, menu);
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
	
	
	public void switchToCatalogPage(View view) {
    	Intent theIntent = new Intent(this, CatalogPage.class);
    	startActivity(theIntent);
    }
	
	
	
	
}



