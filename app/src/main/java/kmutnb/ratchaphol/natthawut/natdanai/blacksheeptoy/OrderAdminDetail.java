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
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class OrderAdminDetail extends AppCompatActivity {

    //Explicit
    private String strId ,dateStr, refStr, nameStr, surnameStr, addressStr, statusStr, totalStr,
            adminStr, titleStr;
    private TextView dateTextView, refTextView, nameTextView, surnameTextView, addressTextView,
            statusTextView, totalTextView;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_admin_detail);

        bindWidget();

        recieveValue();

        showView();

        createListview();
    }

    private void createListview() {

        //Read All historyTABLE
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM historyTABLE WHERE Ref ="
                + "'" + refStr + "'", null);
        cursor.moveToFirst();

        int count = cursor.getCount();
        final String[] productStr = new String[count];
        final String[] priceStr = new String[count];
        final String[] vatStr = new String[count];
        final String[] shippingStr = new String[count];
        final String[] pieceStr = new String[count];
        final String[] netStr = new String[count];
        final String[] usedStr = new String[count];
        final String[] allStr = new String[count];



        for (int i = 0; i < count; i++) {
            productStr[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Product));
            Log.d("productStr ==>", productStr[i]);
            Cursor cursor1 = sqLiteDatabase.rawQuery("SELECT * FROM productTABLE WHERE Name ="
                    + "'" + productStr[i] + "'", null);
            cursor1.moveToFirst();


            String usedStr1 = cursor1.getString(cursor1.getColumnIndex(MyManage.column_Used));
            if (usedStr1.matches("1")) {
                usedStr[i] = "สินค้าใหม่";
            } else {
                usedStr[i] = "สินค้ามือสอง";
            }
            Log.d("productTable", Integer.toString(cursor1.getCount()));
            netStr[i] = cursor1.getString(cursor1.getColumnIndex(MyManage.column_Price));
            pieceStr[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Piece));
            String vatStr1 = cursor1.getString(cursor1.getColumnIndex(MyManage.column_Vat));
            Log.d("netStr ==> ", netStr[i]);
            Log.d("vatStr ==> ", vatStr1);
            Float Vat = Integer.parseInt(netStr[i]) * Float.parseFloat(vatStr1);
            vatStr[i] = String.valueOf(Math.round(Vat));
            Log.d("Vat ==> ", vatStr[i]);
            shippingStr[i] = cursor1.getString(cursor1.getColumnIndex(MyManage.column_Shipping));
            int priceOri = Integer.parseInt(netStr[i]) - Integer.parseInt(shippingStr[i])
                    - Math.round(Vat);
            priceStr[i] = Integer.toString(priceOri);
            int all = Integer.parseInt(netStr[i]) * Integer.parseInt(pieceStr[i]);
            allStr[i] = Integer.toString(all);

            cursor.moveToNext();
            cursor1.close();
        }//for

        cursor.close();

        ToyDetailAdapter toyDetailAdapter = new ToyDetailAdapter(this, productStr,
                priceStr, vatStr, shippingStr, pieceStr, netStr, usedStr, allStr);

        listView.setAdapter(toyDetailAdapter);
    }

    private void bindWidget() {

        dateTextView = (TextView) findViewById(R.id.textView42);
        refTextView = (TextView) findViewById(R.id.textView44);
        nameTextView = (TextView) findViewById(R.id.textView45);
        surnameTextView = (TextView) findViewById(R.id.textView46);
        addressTextView = (TextView) findViewById(R.id.textView48);
        statusTextView = (TextView) findViewById(R.id.textView64);
        totalTextView = (TextView) findViewById(R.id.textView54);
        listView = (ListView) findViewById(R.id.listView4);


    }//bind widget

    private void showView() {

        dateTextView.setText(dateStr);
        refTextView.setText(refStr);
        nameTextView.setText(nameStr);
        surnameTextView.setText(surnameStr);
        addressTextView.setText(addressStr);
        statusTextView.setText(statusStr);
        totalTextView.setText(totalStr +" บาท");
    }

    private void recieveValue() {
        refStr = getIntent().getStringExtra("Ref");
        adminStr = getIntent().getStringExtra("Admin");
        titleStr = getIntent().getStringExtra("Title");
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM historyTABLE WHERE Ref ="
                + "'" + refStr + "'", null);
        cursor.moveToFirst();

        dateStr = cursor.getString(cursor.getColumnIndex(MyManage.column_Date));
        nameStr = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
        surnameStr = cursor.getString(cursor.getColumnIndex(MyManage.column_Surname));
        addressStr = cursor.getString(cursor.getColumnIndex(MyManage.column_Address));
        statusStr = cursor.getString(cursor.getColumnIndex(MyManage.column_Status));
        totalStr = cursor.getString(cursor.getColumnIndex(MyManage.column_Total));




        cursor.close();

    }

    public void clickOK(View view) {
        startActivity(new Intent(OrderAdminDetail.this, OrderAdmin.class));
    }

    public void clickUpdate(View view) {
        final CharSequence[] statusCharSequence = {"รอชำระ","โอนเงินแล้ว","ส่งเรียบร้อยแล้ว"};
        AlertDialog.Builder choiceAlert = new AlertDialog.Builder(this);
        choiceAlert.setTitle("สถานะของบิล");
        choiceAlert.setIcon(R.drawable.icon_myaccount);
        choiceAlert.setSingleChoiceItems(statusCharSequence, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                statusStr = (String) statusCharSequence[i];
            }
        });
        choiceAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                statusTextView.setText(statusStr);
                updateStatus();
            }
        });
        choiceAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();

            }
        });

        choiceAlert.show();





    }

    private void updateStatus() {
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM historyTABLE WHERE Ref = " + "'" + refStr
                + "'", null);
        cursor.moveToFirst();
        int count = cursor.getCount();

        for (int i = 0; i < count; i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("Status", statusStr);

            sqLiteDatabase.update("historyTABLE", contentValues, "Ref =" +
                    "'" + refStr + "'", null);

        }//for

        //Update To SQL
        String urlUpdate = "http://swiftcodingthai.com/sheep/php_update_status.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("Ref", refStr)
                .add("Status", statusStr)
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

    public void clickDeleteOrder(View view) {
        final SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.
                        database_name,
                MODE_PRIVATE, null);

        AlertDialog.Builder confirmDelete = new AlertDialog.Builder(this);
        confirmDelete.setTitle(titleStr);
        confirmDelete.setIcon(R.drawable.danger);
        confirmDelete.setMessage("ต้องการแก้ไขสถานะ ใบเสร็จ :" + refStr + " ใช่ไหม");
        confirmDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                ContentValues contentValues = new ContentValues();
                contentValues.put("Admin", adminStr);
                sqLiteDatabase.update("historyTABLE",contentValues, "Ref = " + "'" + refStr + "'", null);

                //SQL
                String urlUpdate = "http://swiftcodingthai.com/sheep/php_delete_order.php";
                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody requestBody = new FormEncodingBuilder()
                        .add("isAdd", "true")
                        .add("Ref", refStr)
                        .add("Admin", adminStr)
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
                startActivity(new Intent(OrderAdminDetail.this, OrderAdmin.class));
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
}
