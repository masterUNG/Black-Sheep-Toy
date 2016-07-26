package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class EditProductAdmin extends AppCompatActivity {

    private EditText nameTextView, brandTextView, priceTextView, usedTextView,
            stockTextView, detailTextView, vatEditText, shippingEditText;

    private String nameString, brandString, priceString,
            usedString, stockString, detailString, vatString, shippingString, nameString1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product_admin);

        //Bind Widget
        bindWidget();
        //Recieve Value
        recieveValue();

        showView();


    }

    private void showView() {

        nameTextView.setText(nameString1);
        brandTextView.setText(brandString);
        priceTextView.setText(priceString);
        usedTextView.setText(usedString);
        stockTextView.setText(stockString);
        detailTextView.setText(detailString);
        vatEditText.setText(vatString);
        shippingEditText.setText(shippingString);

    }//ShowView

    private void bindWidget() {
        nameTextView = (EditText) findViewById(R.id.editText19);
        brandTextView = (EditText) findViewById(R.id.editText20);
        priceTextView = (EditText) findViewById(R.id.editText21);
        usedTextView = (EditText) findViewById(R.id.editText10);
        stockTextView = (EditText) findViewById(R.id.editText22);
        detailTextView = (EditText) findViewById(R.id.editText25);
        vatEditText = (EditText) findViewById(R.id.editText23);
        shippingEditText = (EditText) findViewById(R.id.editText24);
    }

    private void recieveValue() {
        nameString1 = getIntent().getStringExtra("Name");
        brandString = getIntent().getStringExtra("Brand");
        priceString = getIntent().getStringExtra("Price");
        usedString = getIntent().getStringExtra("Used");
        stockString = getIntent().getStringExtra("Stock");
        detailString = getIntent().getStringExtra("Detail");

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM productTABLE WHERE Name = " +
                "'" + nameString1 + "'", null);
        cursor.moveToFirst();

        vatString = cursor.getString(cursor.getColumnIndex(MyManage.column_Vat));
        shippingString = cursor.getString(cursor.getColumnIndex(MyManage.column_Shipping));

    }

    public void clickSave(View view) {
        updateProduct();
        Toast.makeText(this, "แก้ไขเรียบร้อยแล้ว", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(EditProductAdmin.this, UpdateProductAdmin.class));
    }

    private void updateProduct() {
        nameString = nameTextView.getText().toString().trim();
        Log.d("Name ==>", nameString);
        Log.d("Name1 ==>", nameString1);
        brandString = brandTextView.getText().toString().trim();
        priceString = priceTextView.getText().toString().trim();
        usedString = usedTextView.getText().toString().trim();
        stockString = stockTextView.getText().toString().trim();
        vatString = vatEditText.getText().toString().trim();
        shippingString = shippingEditText.getText().toString().trim();
        detailString = detailTextView.getText().toString().trim();

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);

        /*Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM proTABLE WHERE Name = " + "'" +
                nameString + "'", null);
        cursor.moveToFirst();*/

        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", nameString);
        contentValues.put("Brand", brandString);
        contentValues.put("Price", priceString);
        contentValues.put("Used", usedString);
        contentValues.put("Stock", stockString);
        contentValues.put("Vat", vatString);
        contentValues.put("Shipping", shippingString);
        contentValues.put("Detail", detailString);

        sqLiteDatabase.update("productTABLE", contentValues, "Name =" +
                "'" + nameString1 + "'", null);

        //Update To SQL
        String urlUpdate = "http://swiftcodingthai.com/sheep/php_update_product.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("Name", nameString)
                .add("Name1", nameString1)
                .add("Brand", brandString)
                .add("Price", priceString)
                .add("Used", usedString)
                .add("Stock", stockString)
                .add("Vat", vatString)
                .add("Shipping", shippingString)
                .add("Detail", detailString)
                .build();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(urlUpdate).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

            }
        });




    }

    public void clickDeleteProduct(View view) {
        final SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.
                        database_name,
                MODE_PRIVATE, null);

        AlertDialog.Builder confirmDelete = new AlertDialog.Builder(this);
        confirmDelete.setTitle("สินค้านี้หมดแล้วใช่มั้ย?");
        confirmDelete.setIcon(R.drawable.danger);
        confirmDelete.setMessage("แน่ใจนะว่า " + nameString1 + " หมดแล้ว");
        confirmDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                ContentValues contentValues = new ContentValues();
                contentValues.put("Stock", "0");

                sqLiteDatabase.update("productTABLE", contentValues ,"Name = " + "'" + nameString1 + "'", null);

                //SQL
                String urlUpdate = "http://swiftcodingthai.com/sheep/php_delete_product.php";
                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody requestBody = new FormEncodingBuilder()
                        .add("isAdd", "true")
                        .add("Name", nameString1)
                        .add("Stock", "0")
                        .build();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlUpdate).post(requestBody).build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {

                    }

                    @Override
                    public void onResponse(Response response) throws IOException {

                    }
                });

                dialog.dismiss();
                startActivity(new Intent(EditProductAdmin.this, UpdateProductAdmin.class));
            }
        });

        confirmDelete.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        confirmDelete.show();




    }


    public void clickCancel(View view) {
        startActivity(new Intent(EditProductAdmin.this, UpdateProductAdmin.class));
    }
}
