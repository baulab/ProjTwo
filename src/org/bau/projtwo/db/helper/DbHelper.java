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
		String restaurant = "create table if not exists Restaurant("
				+ "_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL,"
				+ "Name VARCHAR,"
				+ "Address VARCHAR,"
				+ "Phone VARCHAR,"
				+ "Longitude VARCHAR,"
				+ "Latitude VARCHAR,"
				+ "Introduction VARCHAR,"
				+ "Aircon VARCHAR,"
				+ "Stars VARCHAR "
				+ ")";
		db.execSQL(restaurant);
		
		String menu = "create table if not exists Menu("
				+ "_id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL,"
				+ "RestaurantId int,"
				+ "Name VARCHAR,"
				+ "Price VARCHAR,"
				+ "Introduction VARCHAR,"
				+ "Type VARCHAR,"
				+ "remark VARCHAR"
				+ ")";
		db.execSQL(menu);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + DbSetting.dbName); //刪除舊有的資料表
		onCreate(db);
	}

}
