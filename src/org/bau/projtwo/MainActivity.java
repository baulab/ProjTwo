package org.bau.projtwo;

import org.bau.projtwo.db.helper.DbHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	DbHelper help;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		help = new DbHelper(MainActivity.this);
		
		initButton();
	}
	
	private void initButton(){
		Button random = (Button)findViewById(R.id.btn_random);
		random.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	ShowAlertDialog("random","this is random");
            }
        });
		
		Button addData = (Button)findViewById(R.id.adddata);
		addData.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				addData();
			}
		});
	}
	
	private void addData(){
		SQLiteDatabase db = help.getWritableDatabase();
		ContentValues values = new ContentValues();
    	values.put("Name", "Name");
    	values.put("Address", "Address");
    	values.put("Phone", "phone");
    	values.put("Longitude", "Longitude");
    	values.put("Latitude", "Latitude");
    	values.put("Introduction", "Introduction");
    	values.put("Aircon", "Aircon");
    	values.put("Stars", "Stars");
    	long result = db.insert("Restaurant", null, values);
    	ShowAlertDialog("insert","result:" + result);
	}
	
	private void ShowAlertDialog(String title,String message)
	{
	 Builder MyAlertDialog = new AlertDialog.Builder(this);
	 MyAlertDialog.setTitle(title);
	 MyAlertDialog.setMessage(message);
	 MyAlertDialog.show();
	}
	
	private void closeDatabase(){
		help.close();
    }
	
	@Override
    protected void onDestroy() {
        super.onDestroy();
        closeDatabase();
    }
}
