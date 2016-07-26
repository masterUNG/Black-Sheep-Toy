package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.AvoidXfermode;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class ToyListView extends AppCompatActivity {

    private String strID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toy_list_view);

        strID = getIntent().getStringExtra("ID_User");

        createListview();



    } // Main Method

    public void clickMegahouse(View view) {
        ListView listView = (ListView) findViewById(R.id.listView);
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM productTABLE WHERE Brand = " +
                "'Megahouse' AND Stock !=0", null);
        cursor.moveToFirst();
        int intCount = cursor.getCount();

        final String[] nameStrings = new String[intCount];
        final String[] brandStrings = new String[intCount];
        final String[] priceStrings = new String[intCount];
        final String[] stockStrings = new String[intCount];
        final String[] usedStrings = new String[intCount];
        final String[] detailStrings = new String[intCount];
        final String[] image1String = new String[intCount];
        final String[] image2String = new String[intCount];
        final String[] image3String = new String[intCount];
        final String[] image4String = new String[intCount];
        final String[] image5String = new String[intCount];
        final String[] image6String = new String[intCount];
        final String[] image7String = new String[intCount];
        final String[] image8String = new String[intCount];
        final String[] image9String = new String[intCount];
        final String[] image10String = new String[intCount];
        final String[] image11String = new String[intCount];
        final String[] image12String = new String[intCount];
        final String[] image13String = new String[intCount];
        final String[] image14String = new String[intCount];
        final String[] image15String = new String[intCount];
        final String[] image16String = new String[intCount];
        final String[] image17String = new String[intCount];
        final String[] image18String = new String[intCount];
        final String[] image19String = new String[intCount];
        final String[] image20String = new String[intCount];
        final String[] image21String = new String[intCount];
        final String[] image22String = new String[intCount];
        final String[] image23String = new String[intCount];
        final String[] image24String = new String[intCount];
        final String[] image25String = new String[intCount];
        final String[] image26String = new String[intCount];
        final String[] image27String = new String[intCount];
        final String[] image28String = new String[intCount];
        final String[] image29String = new String[intCount];
        final String[] image30String = new String[intCount];
        final String[] image31String = new String[intCount];
        final String[] image32String = new String[intCount];

        for (int i = 0; i < intCount; i++) {

            nameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
            brandStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Brand));
            priceStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Price));
            stockStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Stock));
            usedStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Used));
            detailStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Detail));
            image1String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image1));
            image2String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image2));
            image3String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image3));
            image4String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image4));
            image5String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image5));
            image6String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image6));
            image7String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image7));
            image8String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image8));
            image9String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image9));
            image10String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image10));
            image11String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image11));
            image12String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image12));
            image13String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image13));
            image14String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image14));
            image15String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image15));
            image16String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image16));
            image17String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image17));
            image18String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image18));
            image19String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image19));
            image20String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image20));
            image21String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image21));
            image22String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image22));
            image23String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image23));
            image24String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image24));
            image25String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image25));
            image26String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image26));
            image27String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image27));
            image28String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image28));
            image29String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image29));
            image30String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image30));
            image31String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image31));
            image32String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image32));


            cursor.moveToNext();

        }//for
        cursor.close();

        ToyAdapter toyAdapter = new ToyAdapter(this, nameStrings, brandStrings, priceStrings,
                stockStrings, usedStrings, detailStrings, image1String);
        listView.setAdapter(toyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(ToyListView.this, ToyDetail.class);

                intent.putExtra("ID_User", strID);
                intent.putExtra("Name", nameStrings[i]);
                intent.putExtra("Brand", brandStrings[i]);
                intent.putExtra("Price", priceStrings[i]);
                intent.putExtra("Stock", stockStrings[i]);
                intent.putExtra("Used", usedStrings[i]);
                intent.putExtra("Detail", detailStrings[i]);
                intent.putExtra("Image1", image1String[i]);
                intent.putExtra("Image2", image2String[i]);
                intent.putExtra("Image3", image3String[i]);
                intent.putExtra("Image4", image4String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image6", image6String[i]);
                intent.putExtra("Image7", image7String[i]);
                intent.putExtra("Image8", image8String[i]);
                intent.putExtra("Image9", image9String[i]);
                intent.putExtra("Image10", image10String[i]);
                intent.putExtra("Image11", image11String[i]);
                intent.putExtra("Image12", image12String[i]);
                intent.putExtra("Image13", image13String[i]);
                intent.putExtra("Image14", image14String[i]);
                intent.putExtra("Image15", image15String[i]);
                intent.putExtra("Image16", image16String[i]);
                intent.putExtra("Image17", image17String[i]);
                intent.putExtra("Image18", image18String[i]);
                intent.putExtra("Image19", image19String[i]);
                intent.putExtra("Image20", image20String[i]);
                intent.putExtra("Image21", image21String[i]);
                intent.putExtra("Image22", image22String[i]);
                intent.putExtra("Image23", image23String[i]);
                intent.putExtra("Image24", image24String[i]);
                intent.putExtra("Image25", image25String[i]);
                intent.putExtra("Image26", image26String[i]);
                intent.putExtra("Image27", image27String[i]);
                intent.putExtra("Image28", image28String[i]);
                intent.putExtra("Image29", image29String[i]);
                intent.putExtra("Image30", image30String[i]);
                intent.putExtra("Image31", image31String[i]);
                intent.putExtra("Image32", image32String[i]);


                startActivity(intent);

            } //onItemClick
        });
    }

    public void clickAll(View view) {
        ListView listView = (ListView) findViewById(R.id.listView);
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM productTABLE WHERE Stock != 0",
                null);
        cursor.moveToFirst();
        int intCount = cursor.getCount();

        final String[] nameStrings = new String[intCount];
        final String[] brandStrings = new String[intCount];
        final String[] priceStrings = new String[intCount];
        final String[] stockStrings = new String[intCount];
        final String[] usedStrings = new String[intCount];
        final String[] detailStrings = new String[intCount];
        final String[] image1String = new String[intCount];
        final String[] image2String = new String[intCount];
        final String[] image3String = new String[intCount];
        final String[] image4String = new String[intCount];
        final String[] image5String = new String[intCount];
        final String[] image6String = new String[intCount];
        final String[] image7String = new String[intCount];
        final String[] image8String = new String[intCount];
        final String[] image9String = new String[intCount];
        final String[] image10String = new String[intCount];
        final String[] image11String = new String[intCount];
        final String[] image12String = new String[intCount];
        final String[] image13String = new String[intCount];
        final String[] image14String = new String[intCount];
        final String[] image15String = new String[intCount];
        final String[] image16String = new String[intCount];
        final String[] image17String = new String[intCount];
        final String[] image18String = new String[intCount];
        final String[] image19String = new String[intCount];
        final String[] image20String = new String[intCount];
        final String[] image21String = new String[intCount];
        final String[] image22String = new String[intCount];
        final String[] image23String = new String[intCount];
        final String[] image24String = new String[intCount];
        final String[] image25String = new String[intCount];
        final String[] image26String = new String[intCount];
        final String[] image27String = new String[intCount];
        final String[] image28String = new String[intCount];
        final String[] image29String = new String[intCount];
        final String[] image30String = new String[intCount];
        final String[] image31String = new String[intCount];
        final String[] image32String = new String[intCount];

        for (int i = 0; i < intCount; i++) {

            nameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
            brandStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Brand));
            priceStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Price));
            stockStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Stock));
            usedStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Used));
            detailStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Detail));
            image1String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image1));
            image2String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image2));
            image3String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image3));
            image4String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image4));
            image5String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image5));
            image6String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image6));
            image7String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image7));
            image8String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image8));
            image9String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image9));
            image10String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image10));
            image11String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image11));
            image12String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image12));
            image13String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image13));
            image14String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image14));
            image15String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image15));
            image16String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image16));
            image17String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image17));
            image18String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image18));
            image19String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image19));
            image20String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image20));
            image21String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image21));
            image22String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image22));
            image23String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image23));
            image24String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image24));
            image25String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image25));
            image26String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image26));
            image27String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image27));
            image28String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image28));
            image29String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image29));
            image30String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image30));
            image31String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image31));
            image32String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image32));


            cursor.moveToNext();

        }//for
        cursor.close();

        ToyAdapter toyAdapter = new ToyAdapter(this, nameStrings, brandStrings, priceStrings,
                stockStrings, usedStrings, detailStrings, image1String);
        listView.setAdapter(toyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(ToyListView.this, ToyDetail.class);

                intent.putExtra("ID_User", strID);
                intent.putExtra("Name", nameStrings[i]);
                intent.putExtra("Brand", brandStrings[i]);
                intent.putExtra("Price", priceStrings[i]);
                intent.putExtra("Stock", stockStrings[i]);
                intent.putExtra("Used", usedStrings[i]);
                intent.putExtra("Detail", detailStrings[i]);
                intent.putExtra("Image1", image1String[i]);
                intent.putExtra("Image2", image2String[i]);
                intent.putExtra("Image3", image3String[i]);
                intent.putExtra("Image4", image4String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image6", image6String[i]);
                intent.putExtra("Image7", image7String[i]);
                intent.putExtra("Image8", image8String[i]);
                intent.putExtra("Image9", image9String[i]);
                intent.putExtra("Image10", image10String[i]);
                intent.putExtra("Image11", image11String[i]);
                intent.putExtra("Image12", image12String[i]);
                intent.putExtra("Image13", image13String[i]);
                intent.putExtra("Image14", image14String[i]);
                intent.putExtra("Image15", image15String[i]);
                intent.putExtra("Image16", image16String[i]);
                intent.putExtra("Image17", image17String[i]);
                intent.putExtra("Image18", image18String[i]);
                intent.putExtra("Image19", image19String[i]);
                intent.putExtra("Image20", image20String[i]);
                intent.putExtra("Image21", image21String[i]);
                intent.putExtra("Image22", image22String[i]);
                intent.putExtra("Image23", image23String[i]);
                intent.putExtra("Image24", image24String[i]);
                intent.putExtra("Image25", image25String[i]);
                intent.putExtra("Image26", image26String[i]);
                intent.putExtra("Image27", image27String[i]);
                intent.putExtra("Image28", image28String[i]);
                intent.putExtra("Image29", image29String[i]);
                intent.putExtra("Image30", image30String[i]);
                intent.putExtra("Image31", image31String[i]);
                intent.putExtra("Image32", image32String[i]);


                startActivity(intent);

            } //onItemClick
        });
    }
    public void clickBanpresto(View view) {
        ListView listView = (ListView) findViewById(R.id.listView);
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM productTABLE WHERE Brand = " +
                "'Banpresto' AND Stock !=0", null);
        cursor.moveToFirst();
        int intCount = cursor.getCount();

        final String[] nameStrings = new String[intCount];
        final String[] brandStrings = new String[intCount];
        final String[] priceStrings = new String[intCount];
        final String[] stockStrings = new String[intCount];
        final String[] usedStrings = new String[intCount];
        final String[] detailStrings = new String[intCount];
        final String[] image1String = new String[intCount];
        final String[] image2String = new String[intCount];
        final String[] image3String = new String[intCount];
        final String[] image4String = new String[intCount];
        final String[] image5String = new String[intCount];
        final String[] image6String = new String[intCount];
        final String[] image7String = new String[intCount];
        final String[] image8String = new String[intCount];
        final String[] image9String = new String[intCount];
        final String[] image10String = new String[intCount];
        final String[] image11String = new String[intCount];
        final String[] image12String = new String[intCount];
        final String[] image13String = new String[intCount];
        final String[] image14String = new String[intCount];
        final String[] image15String = new String[intCount];
        final String[] image16String = new String[intCount];
        final String[] image17String = new String[intCount];
        final String[] image18String = new String[intCount];
        final String[] image19String = new String[intCount];
        final String[] image20String = new String[intCount];
        final String[] image21String = new String[intCount];
        final String[] image22String = new String[intCount];
        final String[] image23String = new String[intCount];
        final String[] image24String = new String[intCount];
        final String[] image25String = new String[intCount];
        final String[] image26String = new String[intCount];
        final String[] image27String = new String[intCount];
        final String[] image28String = new String[intCount];
        final String[] image29String = new String[intCount];
        final String[] image30String = new String[intCount];
        final String[] image31String = new String[intCount];
        final String[] image32String = new String[intCount];

        for (int i = 0; i < intCount; i++) {

            nameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
            brandStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Brand));
            priceStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Price));
            stockStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Stock));
            usedStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Used));
            detailStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Detail));
            image1String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image1));
            image2String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image2));
            image3String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image3));
            image4String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image4));
            image5String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image5));
            image6String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image6));
            image7String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image7));
            image8String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image8));
            image9String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image9));
            image10String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image10));
            image11String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image11));
            image12String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image12));
            image13String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image13));
            image14String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image14));
            image15String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image15));
            image16String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image16));
            image17String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image17));
            image18String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image18));
            image19String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image19));
            image20String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image20));
            image21String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image21));
            image22String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image22));
            image23String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image23));
            image24String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image24));
            image25String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image25));
            image26String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image26));
            image27String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image27));
            image28String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image28));
            image29String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image29));
            image30String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image30));
            image31String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image31));
            image32String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image32));


            cursor.moveToNext();

        }//for
        cursor.close();

        ToyAdapter toyAdapter = new ToyAdapter(this, nameStrings, brandStrings, priceStrings,
                stockStrings, usedStrings, detailStrings, image1String);
        listView.setAdapter(toyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(ToyListView.this, ToyDetail.class);

                intent.putExtra("ID_User", strID);
                intent.putExtra("Name", nameStrings[i]);
                intent.putExtra("Brand", brandStrings[i]);
                intent.putExtra("Price", priceStrings[i]);
                intent.putExtra("Stock", stockStrings[i]);
                intent.putExtra("Used", usedStrings[i]);
                intent.putExtra("Detail", detailStrings[i]);
                intent.putExtra("Image1", image1String[i]);
                intent.putExtra("Image2", image2String[i]);
                intent.putExtra("Image3", image3String[i]);
                intent.putExtra("Image4", image4String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image6", image6String[i]);
                intent.putExtra("Image7", image7String[i]);
                intent.putExtra("Image8", image8String[i]);
                intent.putExtra("Image9", image9String[i]);
                intent.putExtra("Image10", image10String[i]);
                intent.putExtra("Image11", image11String[i]);
                intent.putExtra("Image12", image12String[i]);
                intent.putExtra("Image13", image13String[i]);
                intent.putExtra("Image14", image14String[i]);
                intent.putExtra("Image15", image15String[i]);
                intent.putExtra("Image16", image16String[i]);
                intent.putExtra("Image17", image17String[i]);
                intent.putExtra("Image18", image18String[i]);
                intent.putExtra("Image19", image19String[i]);
                intent.putExtra("Image20", image20String[i]);
                intent.putExtra("Image21", image21String[i]);
                intent.putExtra("Image22", image22String[i]);
                intent.putExtra("Image23", image23String[i]);
                intent.putExtra("Image24", image24String[i]);
                intent.putExtra("Image25", image25String[i]);
                intent.putExtra("Image26", image26String[i]);
                intent.putExtra("Image27", image27String[i]);
                intent.putExtra("Image28", image28String[i]);
                intent.putExtra("Image29", image29String[i]);
                intent.putExtra("Image30", image30String[i]);
                intent.putExtra("Image31", image31String[i]);
                intent.putExtra("Image32", image32String[i]);


                startActivity(intent);

            } //onItemClick
        });

    }

    public void clickBandai(View view) {
        ListView listView = (ListView) findViewById(R.id.listView);
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM productTABLE WHERE Brand = " +
                        "'Bandai' AND Stock !=0", null);
        cursor.moveToFirst();
        int intCount = cursor.getCount();

        final String[] nameStrings = new String[intCount];
        final String[] brandStrings = new String[intCount];
        final String[] priceStrings = new String[intCount];
        final String[] stockStrings = new String[intCount];
        final String[] usedStrings = new String[intCount];
        final String[] detailStrings = new String[intCount];
        final String[] image1String = new String[intCount];
        final String[] image2String = new String[intCount];
        final String[] image3String = new String[intCount];
        final String[] image4String = new String[intCount];
        final String[] image5String = new String[intCount];
        final String[] image6String = new String[intCount];
        final String[] image7String = new String[intCount];
        final String[] image8String = new String[intCount];
        final String[] image9String = new String[intCount];
        final String[] image10String = new String[intCount];
        final String[] image11String = new String[intCount];
        final String[] image12String = new String[intCount];
        final String[] image13String = new String[intCount];
        final String[] image14String = new String[intCount];
        final String[] image15String = new String[intCount];
        final String[] image16String = new String[intCount];
        final String[] image17String = new String[intCount];
        final String[] image18String = new String[intCount];
        final String[] image19String = new String[intCount];
        final String[] image20String = new String[intCount];
        final String[] image21String = new String[intCount];
        final String[] image22String = new String[intCount];
        final String[] image23String = new String[intCount];
        final String[] image24String = new String[intCount];
        final String[] image25String = new String[intCount];
        final String[] image26String = new String[intCount];
        final String[] image27String = new String[intCount];
        final String[] image28String = new String[intCount];
        final String[] image29String = new String[intCount];
        final String[] image30String = new String[intCount];
        final String[] image31String = new String[intCount];
        final String[] image32String = new String[intCount];

        for (int i = 0; i < intCount; i++) {

            nameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
            brandStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Brand));
            priceStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Price));
            stockStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Stock));
            usedStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Used));
            detailStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Detail));
            image1String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image1));
            image2String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image2));
            image3String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image3));
            image4String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image4));
            image5String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image5));
            image6String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image6));
            image7String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image7));
            image8String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image8));
            image9String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image9));
            image10String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image10));
            image11String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image11));
            image12String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image12));
            image13String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image13));
            image14String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image14));
            image15String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image15));
            image16String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image16));
            image17String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image17));
            image18String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image18));
            image19String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image19));
            image20String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image20));
            image21String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image21));
            image22String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image22));
            image23String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image23));
            image24String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image24));
            image25String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image25));
            image26String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image26));
            image27String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image27));
            image28String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image28));
            image29String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image29));
            image30String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image30));
            image31String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image31));
            image32String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image32));


            cursor.moveToNext();

        }//for
        cursor.close();

        ToyAdapter toyAdapter = new ToyAdapter(this, nameStrings, brandStrings, priceStrings,
                stockStrings, usedStrings, detailStrings, image1String);
        listView.setAdapter(toyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(ToyListView.this, ToyDetail.class);

                intent.putExtra("ID_User", strID);
                intent.putExtra("Name", nameStrings[i]);
                intent.putExtra("Brand", brandStrings[i]);
                intent.putExtra("Price", priceStrings[i]);
                intent.putExtra("Stock", stockStrings[i]);
                intent.putExtra("Used", usedStrings[i]);
                intent.putExtra("Detail", detailStrings[i]);
                intent.putExtra("Image1", image1String[i]);
                intent.putExtra("Image2", image2String[i]);
                intent.putExtra("Image3", image3String[i]);
                intent.putExtra("Image4", image4String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image6", image6String[i]);
                intent.putExtra("Image7", image7String[i]);
                intent.putExtra("Image8", image8String[i]);
                intent.putExtra("Image9", image9String[i]);
                intent.putExtra("Image10", image10String[i]);
                intent.putExtra("Image11", image11String[i]);
                intent.putExtra("Image12", image12String[i]);
                intent.putExtra("Image13", image13String[i]);
                intent.putExtra("Image14", image14String[i]);
                intent.putExtra("Image15", image15String[i]);
                intent.putExtra("Image16", image16String[i]);
                intent.putExtra("Image17", image17String[i]);
                intent.putExtra("Image18", image18String[i]);
                intent.putExtra("Image19", image19String[i]);
                intent.putExtra("Image20", image20String[i]);
                intent.putExtra("Image21", image21String[i]);
                intent.putExtra("Image22", image22String[i]);
                intent.putExtra("Image23", image23String[i]);
                intent.putExtra("Image24", image24String[i]);
                intent.putExtra("Image25", image25String[i]);
                intent.putExtra("Image26", image26String[i]);
                intent.putExtra("Image27", image27String[i]);
                intent.putExtra("Image28", image28String[i]);
                intent.putExtra("Image29", image29String[i]);
                intent.putExtra("Image30", image30String[i]);
                intent.putExtra("Image31", image31String[i]);
                intent.putExtra("Image32", image32String[i]);


                startActivity(intent);

            } //onItemClick
        });
    }

    private void createListview() {
        ListView listView = (ListView) findViewById(R.id.listView);
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM productTABLE WHERE Stock != 0",
                null);
        cursor.moveToFirst();
        int intCount = cursor.getCount();

        final String[] nameStrings = new String[intCount];
        final String[] brandStrings = new String[intCount];
        final String[] priceStrings = new String[intCount];
        final String[] stockStrings = new String[intCount];
        final String[] usedStrings = new String[intCount];
        final String[] detailStrings = new String[intCount];
        final String[] image1String = new String[intCount];
        final String[] image2String = new String[intCount];
        final String[] image3String = new String[intCount];
        final String[] image4String = new String[intCount];
        final String[] image5String = new String[intCount];
        final String[] image6String = new String[intCount];
        final String[] image7String = new String[intCount];
        final String[] image8String = new String[intCount];
        final String[] image9String = new String[intCount];
        final String[] image10String = new String[intCount];
        final String[] image11String = new String[intCount];
        final String[] image12String = new String[intCount];
        final String[] image13String = new String[intCount];
        final String[] image14String = new String[intCount];
        final String[] image15String = new String[intCount];
        final String[] image16String = new String[intCount];
        final String[] image17String = new String[intCount];
        final String[] image18String = new String[intCount];
        final String[] image19String = new String[intCount];
        final String[] image20String = new String[intCount];
        final String[] image21String = new String[intCount];
        final String[] image22String = new String[intCount];
        final String[] image23String = new String[intCount];
        final String[] image24String = new String[intCount];
        final String[] image25String = new String[intCount];
        final String[] image26String = new String[intCount];
        final String[] image27String = new String[intCount];
        final String[] image28String = new String[intCount];
        final String[] image29String = new String[intCount];
        final String[] image30String = new String[intCount];
        final String[] image31String = new String[intCount];
        final String[] image32String = new String[intCount];

        for (int i = 0; i < intCount; i++) {

            nameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
            brandStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Brand));
            priceStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Price));
            stockStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Stock));
            usedStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Used));
            detailStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Detail));
            image1String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image1));
            image2String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image2));
            image3String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image3));
            image4String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image4));
            image5String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image5));
            image6String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image6));
            image7String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image7));
            image8String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image8));
            image9String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image9));
            image10String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image10));
            image11String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image11));
            image12String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image12));
            image13String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image13));
            image14String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image14));
            image15String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image15));
            image16String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image16));
            image17String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image17));
            image18String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image18));
            image19String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image19));
            image20String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image20));
            image21String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image21));
            image22String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image22));
            image23String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image23));
            image24String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image24));
            image25String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image25));
            image26String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image26));
            image27String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image27));
            image28String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image28));
            image29String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image29));
            image30String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image30));
            image31String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image31));
            image32String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image32));


            cursor.moveToNext();

        }//for
        cursor.close();

        ToyAdapter toyAdapter = new ToyAdapter(this, nameStrings, brandStrings, priceStrings,
                stockStrings, usedStrings, detailStrings, image1String);
        listView.setAdapter(toyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(ToyListView.this, ToyDetail.class);

                intent.putExtra("ID_User", strID);
                intent.putExtra("Name", nameStrings[i]);
                intent.putExtra("Brand", brandStrings[i]);
                intent.putExtra("Price", priceStrings[i]);
                intent.putExtra("Stock", stockStrings[i]);
                intent.putExtra("Used", usedStrings[i]);
                intent.putExtra("Detail", detailStrings[i]);
                intent.putExtra("Image1", image1String[i]);
                intent.putExtra("Image2", image2String[i]);
                intent.putExtra("Image3", image3String[i]);
                intent.putExtra("Image4", image4String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image5", image5String[i]);
                intent.putExtra("Image6", image6String[i]);
                intent.putExtra("Image7", image7String[i]);
                intent.putExtra("Image8", image8String[i]);
                intent.putExtra("Image9", image9String[i]);
                intent.putExtra("Image10", image10String[i]);
                intent.putExtra("Image11", image11String[i]);
                intent.putExtra("Image12", image12String[i]);
                intent.putExtra("Image13", image13String[i]);
                intent.putExtra("Image14", image14String[i]);
                intent.putExtra("Image15", image15String[i]);
                intent.putExtra("Image16", image16String[i]);
                intent.putExtra("Image17", image17String[i]);
                intent.putExtra("Image18", image18String[i]);
                intent.putExtra("Image19", image19String[i]);
                intent.putExtra("Image20", image20String[i]);
                intent.putExtra("Image21", image21String[i]);
                intent.putExtra("Image22", image22String[i]);
                intent.putExtra("Image23", image23String[i]);
                intent.putExtra("Image24", image24String[i]);
                intent.putExtra("Image25", image25String[i]);
                intent.putExtra("Image26", image26String[i]);
                intent.putExtra("Image27", image27String[i]);
                intent.putExtra("Image28", image28String[i]);
                intent.putExtra("Image29", image29String[i]);
                intent.putExtra("Image30", image30String[i]);
                intent.putExtra("Image31", image31String[i]);
                intent.putExtra("Image32", image32String[i]);


                startActivity(intent);

            } //onItemClick
        });
    }//Create Listview

    public void clickHistory(View view) {
        if (checkHistory() == false) {
            MyAlertDialog myAlertDialog = new MyAlertDialog();
            myAlertDialog.myDialog(this, R.drawable.icon_myaccount,
                    "ยังไม่มีประวัติการสั่งซื้อ", "โปรดเลือกสินค้า");
        } else {
            Intent intent = new Intent(ToyListView.this, History.class);
            intent.putExtra("ID_User", strID);
            startActivity(intent);
        }

    }

    public void clickHowtoOrder(View view) {

        startActivity(new Intent(ToyListView.this, HowToOrder.class));

    }

    public boolean checkHistory() {
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM historyTABLE WHERE IDUser ="
                + "'" + strID + "'", null);
        cursor.moveToFirst();

        if (cursor.getCount() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void clickReadOrder(View view) {


        if (checkOrder()) {
            //have data
            Intent intent = new Intent(ToyListView.this, OrderToy.class);
            intent.putExtra("ID_User", strID);
            startActivity(intent);


        } else {
            //no data
            MyAlertDialog myAlertDialog = new MyAlertDialog();
            myAlertDialog.myDialog(this, R.drawable.icon_myaccount,
                    "ยังไม่มี Order", "โปรดเลือกสินค้า");

        }

    }// clickReadOrder

    private boolean checkOrder() {

        boolean result = true;
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + MyManage.order_table, null);
        cursor.moveToFirst();

        if (cursor.getCount() == 0) {
            result = false;

        }

        return result;
    }

} // Main Class
