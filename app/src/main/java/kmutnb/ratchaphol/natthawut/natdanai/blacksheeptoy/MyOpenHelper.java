package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    public static final String database_name = "Sheep.db";
    private static final int database_version = 1;

    private static final String create_user_table = "create table userTABLE (" +
            "_id integer primary key, " +
            "Name text," +
            "Surname text," +
            "idCard text," +
            "User text," +
            "Password text," +
            "Email text," +
            "Phone text," +
            "AdminUse text);";

    private static final String create_product_table = "create table productTABLE (" +
            "_id integer primary key," +
            "Name text," +
            "Brand text," +
            "Price text," +
            "Stock text," +
            "Used text," +
            "Vat text," +
            "Shipping text," +
            "Detail text," +
            "Image1 text," +
            "Image2 text," +
            "Image3 text," +
            "Image4 text," +
            "Image5 text," +
            "Image6 text," +
            "Image7 text," +
            "Image8 text," +
            "Image9 text," +
            "Image10 text," +
            "Image11 text," +
            "Image12 text," +
            "Image13 text," +
            "Image14 text," +
            "Image15 text," +
            "Image16 text," +
            "Image17 text," +
            "Image18 text," +
            "Image19 text," +
            "Image20 text," +
            "Image21 text," +
            "Image22 text," +
            "Image23 text," +
            "Image24 text," +
            "Image25 text," +
            "Image26 text," +
            "Image27 text," +
            "Image28 text," +
            "Image29 text," +
            "Image30 text," +
            "Image31 text," +
            "Image32 text);";

    private static final String create_order_table = "create table orderTABLE (" +
            "_id integer primary key," +
            "ID_User text," +
            "Date text," +
            "Sent_To text," +
            "Product text," +
            "Price text," +
            "Piece text," +
            "Total text);";

    private static final String create_history_table = "create table historyTABLE(" +
            "_id integer primary key," +
            "Ref text," +
            "IDUser text," +
            "Date text," +
            "Name text," +
            "Surname text," +
            "Address text," +
            "Product text," +
            "Price text," +
            "Piece text," +
            "Total text," +
            "Status text," +
            "Admin text);";




    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_version);
    } //Constructor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_product_table);
        sqLiteDatabase.execSQL(create_user_table);
        sqLiteDatabase.execSQL(create_order_table);
        sqLiteDatabase.execSQL(create_history_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
} //Main Class
