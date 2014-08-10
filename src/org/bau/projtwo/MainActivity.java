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
		
		Button button = (Button)findViewById(R.id.btn_random);
		button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	SQLiteDatabase  db = help.getWritableDatabase();
            	ContentValues values = new ContentValues();
            	values.put("name", "name");
            	values.put("address", "address");
            	values.put("phone", "phone");
            	values.put("Longitude", "Longitude");
            	values.put("Latitude", "Latitude");
            	values.put("type", "type");
            	values.put("memo", "memo");
            	db.insert("Restaurant", null, values);
            	ShowAlertDialog();
            }
        });
	}
	
	private void ShowAlertDialog()
	{
	 Builder MyAlertDialog = new AlertDialog.Builder(this);
	 MyAlertDialog.setTitle("result");
	 MyAlertDialog.setMessage("ok");
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
