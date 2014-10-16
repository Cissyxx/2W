package com.cissy.rpiwhenwhere;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	
	final static String[][] buildingArray = {
		{"Pittsburgh Building","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"West Hall","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Carnegie Building","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Walker Laboratory","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Boiler House, Sage Avenue","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Russell Sage Laboratory","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Troy Building","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Norh Hall","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"E Complex","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Ricketts Building","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"87 Gymnasium","M-F: 11am - 2pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Quad","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Russell Sage Dining Hall","M-F: Breakfast: 7:30a-9a Lunch: 11:30a-1p Dinner: 5p-6:30p","Sun:Brunch: 11:30a-1pm Dinner: 5p-6:30p", "orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"CII","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Play House","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Darrin Communications Center","M-F: 8am - 5pm","HrNULL","CCPD","Jazzman Cafe","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Engineering Center, J.Erik Jonsson","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Science Center, Jonsson-Rowland(Hirsch Observatory)","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Cogswell Laboratory","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Materials Research Center","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Voorhees Computing Center","M-R 8:30a - 5:00p F: 8:30a - 4p","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Folsom Library","(Summer) M-R 7:30a - 6p F: 7:30a - 5p","Sat: Closed Sun: 12noon-8p","The Library Cafe","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Greene Building(Home of the School of Architecture)","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Lally Hall","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Amos Eaton Hall(Dept. of Mathematical Sciences)","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Black Cultural Center","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Service Building","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Blaw-Knox 1 & 2","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Incubator center","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"H building","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Alumni House (Heffner)","M-F 8:30am-5:00pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"College Administrative Building","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Office of Admissions","M-F 9:00am-4:30pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Rensselaer Union","Open for 24 Hours","Sat & Sun: Open except 1a - 8a","Campus Unisex Hair","Game Room","Post Office","SEFCU Bank","Union Book Store","orgNULL","orgNULL","orgNULL"},
		{"Public Safety","24 Hours","24 Hours","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Alumni Sports & Recreation Center","M- F: 9am - 6:30pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Robison Swimming Pool","M-F: 12pm - 2pm & 4pm - 6pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Commons Dining Hall","M-R: 7:30a - 7:30p & 10:30p - 11:30p F: 7:30a - 7:30p ","9a - 7:30p", "Student Mail Center","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Crockett Hall","7am - 11pm for Commons Area Residents","Same","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Nason Hall","7am - 11pm for Commons Area Residents","Same","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Davison Hall","7am - 11pm for Commons Area Residents","Same","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Sharp Hall","7am - 11pm for Commons Area Residents","Same","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Nugent Hall","7am - 11pm for Commons Area Residents","Same","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Warren Hall","7am - 11pm for Commons Area Residents","Same","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Hall Hall","7am - 11pm for Commons Area Residents","Same","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Cary Hall","7am - 11pm for Commons Area Residents","Same","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Bray Hall","7am - 11pm for Commons Area Residents","Same","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Chapel and Cultural Center","MTW: 5:15p RF: 12:10p", "Sat: 5:15p Sun: 9a 10:30a 5p", "Rensselaer Newman Foundation","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Burdett Avenue Residence Hall","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"RPI Parking and Transportation","M-F: 8:00a to 4:00p, excluding RPI staff holidays","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Field House, Houston","Open from third Monday in August to second Friday in May: M-F: 9a-5p","Game Days: F:9a - Sat 10a-","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"RAHP A Site (Single Students)","All day","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Seismograph Laboratory","8am - 5pm", "HrNULL", "orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Greenhouses and Grounds Barn","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"LINAC Facility (Gaerttner Laboratory)","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Stacwyck Apartments","HrNULL","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Rousseau Apartments","HrNULL","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Williams Apartments","HrNULL","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Wiltsie Apartments","HrNULL","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"McGiffert Apartments","HrNULL","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Thompson Apartments","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Radio Club W2SZ","Meetings for the 2013-2014 school year are every Tuesday evening from 5:30pm to 7:30pm at the 250 Sunset Terrace W2SZ Shack","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Bryckwyck","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"RAHP B Site (Married Students)","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Patroon Manor","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Colonie Apartments","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Academy Hall","M-F: 8am - 5pm","HrNULL","ALAC","ISSS","Registrar","Busar","Student Experience Office","Financial Aid","Dean of Student","orgNULL"},
		{"Empire State Hall","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Beman Park Firehouse","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"133 Sunset Terrace","M-F: 8am - 5pm","HrNULL","Delta Tau Delta, Upsilon Chapter","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Mueller Center","M-F: 9am - 7pm","Weekends : 11am - 5pm","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Barton Hall","7am - 11pm for Commons Area Residents","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Center for Biotechnology and","HrNULL","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Interdisciplinary Studies","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Parking Garage (Faculty/Staff)","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Experimental Media & Performing Arts Center","M-F: 9am - 6pm","Sat: 12p - 5a","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Boiler House, 11th Street","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Winslow Building","M-F: 8am - 5pm","HrNULL","Tetherless World Constellation","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Louis Rubin Memorial Approach","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Moe''s Southwest Grill","10pm - 8pm","Same","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"RPI Ambulance","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Blitman Residence Commons","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Polytechnic Residence Commons","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"East Campus Athletic Village Arena","M-R: 7a - 7p F: 7a - 6p","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"East Campus Athletic Village Stadium","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
		{"Graduate Education","M-F: 8am - 5pm","HrNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL","orgNULL"},
	};
	
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
		{"Bursar","Mon ~ Fri 9:00am to 4:30pm","1000 Level Academy Hall"},
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
	
	public ArrayList<String> generateBuildingInsert(String[][] theArray, String tableName, String cellName1, String cellName2, String cellName3, String cellName4,
			String cellName5, String cellName6, String cellName7, String cellName8, String cellName9, String cellName10, String cellName11){
		
		ArrayList<String> theStatements = new ArrayList<String>();
		
		for(String[] item : theArray){
		
			String statement;
			
			statement = "insert into " + tableName + " (" +
					cellName1 + ", " + cellName2 + ", " + cellName3 + ", " + cellName4 + ", " + cellName5 + ", " + cellName6 + ", "+
					cellName7 + ", " + cellName8 + ", " + cellName9 + ", " + cellName10 + ", " + cellName11 + ") values ('" + 
					item[0] + "', '" + item[1] + "', '" + item[2] + "', '" + item[3] + "', '" + item[4] + "', '" + item[5]
					+ "', '" + item[6] + "', '" + item[7] + "', '" + item[8] + "', '" + item[9] + "', '" + item[10]+ "');";
			
			theStatements.add(statement);
					
		}
		
		return theStatements;
		
	}
	
	public ArrayList<String> generateOrgInsert(String[][] theArray, String tableName, String cellName1, String cellName2, String cellName3, String cellName4){
		
		ArrayList<String> theStatements = new ArrayList<String>();
		
		for(String[] item : theArray){
			
			String statement;
			
			statement = "insert into " + tableName + " (" +
					cellName1 + ", " + cellName2 + ", " + cellName3 + ", " + cellName4 + ") values ('" + 
					item[0] + "', '" + item[1] + "', '" + item[2] + "', '" + "hnull" + "');";
			
			theStatements.add(statement);
					
		}
		
		return theStatements;
		
	}

	
	public DBHelper(Context context) {
		super(context, "w2.db", null, 1);		
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		// TODO Auto-generated method stub
		String query = "CREATE TABLE orgInfo ( contactID INTEGER PRIMARY KEY, " +
				"org_name TEXT, hour1 TEXT, hour2 TEXT, location TEXT)";
		database.execSQL(query);
		ArrayList<String> orgInsert = new ArrayList<String>();
		orgInsert = generateOrgInsert(orgArray, "orgInfo", "org_name", "hour1", "location", "hour2");
		for (String statement:orgInsert) {
			database.execSQL(statement);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String query = "DROP TABLE IF EXISTS contacts";		
		database.execSQL(query);
		onCreate(database);
	}
	
	public void insertOrg(HashMap<String, String> queryValues) {		
		SQLiteDatabase database = this.getWritableDatabase();		
		ContentValues values = new ContentValues();		
		
		values.put("contactID", queryValues.get("contactID"));
		values.put("org_name", queryValues.get("org_name"));
		values.put("hour1", queryValues.get("hour1"));
		values.put("hour2", queryValues.get("hour2"));
		values.put("location", queryValues.get("location"));
		
		database.insert("orgInfo", null, values);		
		database.close();		
	}
	
	public ArrayList<HashMap<String, String>> getAllOrg() {
		ArrayList<HashMap<String, String>> orgArrayList = new ArrayList<HashMap<String, String>>();
		String orgQuery = "SELECT * FROM orgInfo ORDER BY org_name";
		SQLiteDatabase database = this.getWritableDatabase();
		Cursor cursor = database.rawQuery(orgQuery, null);
		if (cursor.moveToFirst()) {
			do {
				HashMap<String, String> orgMap = new HashMap<String, String>();
			
				orgMap.put("contactID", cursor.getString(0));
				orgMap.put("org_name", cursor.getString(1));
				orgMap.put("hour1", cursor.getString(2));
				orgMap.put("hour2", cursor.getString(3));
				orgMap.put("location", cursor.getString(4));
				
				orgArrayList.add(orgMap);
			} while (cursor.moveToNext());			
		}
		return orgArrayList;		
	}
	
	
	public HashMap<String, String> getOrgInfo(String name) {
		HashMap<String, String> orgMap = new HashMap<String, String>();
		SQLiteDatabase database = this.getReadableDatabase();
		String orgQuery = "SELECT * FROM orgInfo WHERE org_name ='" + name + "'";
		Cursor cursor = database.rawQuery(orgQuery, null);
		if (cursor.moveToFirst()) {
			do{
				orgMap.put("contactID", cursor.getString(0));
				orgMap.put("org_name", cursor.getString(1));
				orgMap.put("hour1", cursor.getString(2));
				orgMap.put("hour2", cursor.getString(3));
				orgMap.put("location", cursor.getString(4));
			} while (cursor.moveToNext());
		}
		return orgMap;
	}
	
	
	public ArrayList<HashMap<String, String>> getOrgList(String name) {
		ArrayList<HashMap<String, String>> orgArrayList = new ArrayList<HashMap<String, String>>();
		SQLiteDatabase database = this.getReadableDatabase();
		String orgQuery = "SELECT * FROM orgInfo WHERE org_name LIKE '%" + name + "%'";
		Cursor cursor = database.rawQuery(orgQuery, null);
		if (cursor.moveToFirst()) {
			do {
				HashMap<String, String> orgMap = new HashMap<String, String>();
				
				orgMap.put("contactID", cursor.getString(0));
				orgMap.put("org_name", cursor.getString(1));
				orgMap.put("hour1", cursor.getString(2));
				orgMap.put("hour2", cursor.getString(3));
				orgMap.put("location", cursor.getString(4));
				
				orgArrayList.add(orgMap);				
			} while (cursor.moveToNext());
		}
		return orgArrayList;
		
	}
	
	
	
}
