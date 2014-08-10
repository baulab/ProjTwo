package org.bau.projtwo.db.helper;

import org.bau.projtwo.variable.DbSetting;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{
	public DbHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, DbSetting.dbVersion);
		// TODO Auto-generated constructor stub
	}
	
	public DbHelper(Context context, String name) {
		super(context, name, null, DbSetting.dbVersion);
		// TODO Auto-generated constructor stub
	} 
	
	public DbHelper(Context context) {
		super(context, DbSetting.dbName, null, DbSetting.dbVersion);
		// TODO Auto-generated constructor stub
	}  

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String restaurant = "create table Restaurant("
				+ "_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL,"
				+ "name VARCHAR,"
				+ "address VARCHAR,"
				+ "phone VARCHAR,"
				+ "Longitude VARCHAR,"
				+ "Latitude INT,"
				+ "type VARCHAR,"
				+ "memo VARCHAR"
				+ ")";
		db.execSQL(restaurant);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + DbSetting.dbName); //刪除舊有的資料表
		onCreate(db);
	}

}
