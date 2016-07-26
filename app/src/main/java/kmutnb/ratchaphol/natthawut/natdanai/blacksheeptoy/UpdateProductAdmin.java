package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class UpdateProductAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product_admin);
        createListview();
    }

    private void createListview() {
        ListView listView = (ListView) findViewById(R.id.listView6);
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM productTABLE ", null);
        cursor.moveToFirst();
        int intCount = cursor.getCount();

        final String[] nameStrings = new String[intCount];
        final String[] brandStrings = new String[intCount];
        final String[] priceStrings = new String[intCount];
        final String[] stockStrings = new String[intCount];
        final String[] usedStrings = new String[intCount];
        final String[] detailStrings = new String[intCount];
        final String[] image1String = new String[intCount];


        for (int i = 0; i < intCount; i++) {

            nameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
            brandStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Brand));
            priceStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Price));
            stockStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Stock));
            usedStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Used));
            detailStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Detail));
            image1String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image1));



            cursor.moveToNext();

        }//for
        cursor.close();

        ToyAdapter toyAdapter = new ToyAdapter(this, nameStrings, brandStrings, priceStrings,
                stockStrings, usedStrings, detailStrings, image1String);
        listView.setAdapter(toyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(UpdateProductAdmin.this, EditProductAdmin.class);


                intent.putExtra("Name", nameStrings[i]);
                intent.putExtra("Brand", brandStrings[i]);
                intent.putExtra("Price", priceStrings[i]);
                intent.putExtra("Stock", stockStrings[i]);
                intent.putExtra("Used", usedStrings[i]);
                intent.putExtra("Detail", detailStrings[i]);
                intent.putExtra("Image1", image1String[i]);



                startActivity(intent);

            } //onItemClick
        });
    }//Create Listview

    public void clickBackUpdateProduct(View view) {
        startActivity(new Intent(UpdateProductAdmin.this, ProductAdmin.class));
    }

    public void clickAllUpdate(View view) {
        ListView listView = (ListView) findViewById(R.id.listView6);
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM productTABLE ", null);
        cursor.moveToFirst();
        int intCount = cursor.getCount();

        final String[] nameStrings = new String[intCount];
        final String[] brandStrings = new String[intCount];
        final String[] priceStrings = new String[intCount];
        final String[] stockStrings = new String[intCount];
        final String[] usedStrings = new String[intCount];
        final String[] detailStrings = new String[intCount];
        final String[] image1String = new String[intCount];


        for (int i = 0; i < intCount; i++) {

            nameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
            brandStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Brand));
            priceStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Price));
            stockStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Stock));
            usedStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Used));
            detailStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Detail));
            image1String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image1));



            cursor.moveToNext();

        }//for
        cursor.close();

        ToyAdapter toyAdapter = new ToyAdapter(this, nameStrings, brandStrings, priceStrings,
                stockStrings, usedStrings, detailStrings, image1String);
        listView.setAdapter(toyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(UpdateProductAdmin.this, EditProductAdmin.class);


                intent.putExtra("Name", nameStrings[i]);
                intent.putExtra("Brand", brandStrings[i]);
                intent.putExtra("Price", priceStrings[i]);
                intent.putExtra("Stock", stockStrings[i]);
                intent.putExtra("Used", usedStrings[i]);
                intent.putExtra("Detail", detailStrings[i]);
                intent.putExtra("Image1", image1String[i]);



                startActivity(intent);

            } //onItemClick
        });
    }

    public void clickOutofStock(View view) {
        ListView listView = (ListView) findViewById(R.id.listView6);
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM productTABLE WHERE Stock = 0", null);
        cursor.moveToFirst();
        int intCount = cursor.getCount();

        final String[] nameStrings = new String[intCount];
        final String[] brandStrings = new String[intCount];
        final String[] priceStrings = new String[intCount];
        final String[] stockStrings = new String[intCount];
        final String[] usedStrings = new String[intCount];
        final String[] detailStrings = new String[intCount];
        final String[] image1String = new String[intCount];


        for (int i = 0; i < intCount; i++) {

            nameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
            brandStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Brand));
            priceStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Price));
            stockStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Stock));
            usedStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Used));
            detailStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Detail));
            image1String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image1));



            cursor.moveToNext();

        }//for
        cursor.close();

        ToyAdapter toyAdapter = new ToyAdapter(this, nameStrings, brandStrings, priceStrings,
                stockStrings, usedStrings, detailStrings, image1String);
        listView.setAdapter(toyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(UpdateProductAdmin.this, EditProductAdmin.class);


                intent.putExtra("Name", nameStrings[i]);
                intent.putExtra("Brand", brandStrings[i]);
                intent.putExtra("Price", priceStrings[i]);
                intent.putExtra("Stock", stockStrings[i]);
                intent.putExtra("Used", usedStrings[i]);
                intent.putExtra("Detail", detailStrings[i]);
                intent.putExtra("Image1", image1String[i]);



                startActivity(intent);

            } //onItemClick
        });
    }

    public void clickLowStock(View view) {
        ListView listView = (ListView) findViewById(R.id.listView6);
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM productTABLE WHERE Stock = 1 OR Stock = 2 OR Stock = 3 ", null);
        cursor.moveToFirst();
        int intCount = cursor.getCount();

        final String[] nameStrings = new String[intCount];
        final String[] brandStrings = new String[intCount];
        final String[] priceStrings = new String[intCount];
        final String[] stockStrings = new String[intCount];
        final String[] usedStrings = new String[intCount];
        final String[] detailStrings = new String[intCount];
        final String[] image1String = new String[intCount];


        for (int i = 0; i < intCount; i++) {

            nameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
            brandStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Brand));
            priceStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Price));
            stockStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Stock));
            usedStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Used));
            detailStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Detail));
            image1String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image1));



            cursor.moveToNext();

        }//for
        cursor.close();

        ToyAdapter toyAdapter = new ToyAdapter(this, nameStrings, brandStrings, priceStrings,
                stockStrings, usedStrings, detailStrings, image1String);
        listView.setAdapter(toyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(UpdateProductAdmin.this, EditProductAdmin.class);


                intent.putExtra("Name", nameStrings[i]);
                intent.putExtra("Brand", brandStrings[i]);
                intent.putExtra("Price", priceStrings[i]);
                intent.putExtra("Stock", stockStrings[i]);
                intent.putExtra("Used", usedStrings[i]);
                intent.putExtra("Detail", detailStrings[i]);
                intent.putExtra("Image1", image1String[i]);



                startActivity(intent);

            } //onItemClick
        });
    }

    public void clickInstock(View view) {
        ListView listView = (ListView) findViewById(R.id.listView6);
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM productTABLE WHERE Stock != 0 ", null);
        cursor.moveToFirst();
        int intCount = cursor.getCount();

        final String[] nameStrings = new String[intCount];
        final String[] brandStrings = new String[intCount];
        final String[] priceStrings = new String[intCount];
        final String[] stockStrings = new String[intCount];
        final String[] usedStrings = new String[intCount];
        final String[] detailStrings = new String[intCount];
        final String[] image1String = new String[intCount];


        for (int i = 0; i < intCount; i++) {

            nameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
            brandStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Brand));
            priceStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Price));
            stockStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Stock));
            usedStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Used));
            detailStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Detail));
            image1String[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Image1));



            cursor.moveToNext();

        }//for
        cursor.close();

        ToyAdapter toyAdapter = new ToyAdapter(this, nameStrings, brandStrings, priceStrings,
                stockStrings, usedStrings, detailStrings, image1String);
        listView.setAdapter(toyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(UpdateProductAdmin.this, EditProductAdmin.class);


                intent.putExtra("Name", nameStrings[i]);
                intent.putExtra("Brand", brandStrings[i]);
                intent.putExtra("Price", priceStrings[i]);
                intent.putExtra("Stock", stockStrings[i]);
                intent.putExtra("Used", usedStrings[i]);
                intent.putExtra("Detail", detailStrings[i]);
                intent.putExtra("Image1", image1String[i]);



                startActivity(intent);

            } //onItemClick
        });
    }
}
