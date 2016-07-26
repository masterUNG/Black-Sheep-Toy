package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class OrderDetail extends AppCompatActivity {

    //Explicit
    private String strId ,dateStr, refStr, nameStr, surnameStr, addressStr, statusStr, totalStr;
    private TextView dateTextView, refTextView, nameTextView, surnameTextView, addressTextView,
            statusTextView, totalTextView;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

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
        strId = getIntent().getStringExtra("ID_User");
        refStr = getIntent().getStringExtra("Ref");
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM historyTABLE WHERE Ref ="
                + "'" + refStr + "'", null);
        cursor.moveToFirst();

        dateStr = cursor.getString(cursor.getColumnIndex(MyManage.column_Date));
        Log.d("date == >", dateStr);
        nameStr = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
        surnameStr = cursor.getString(cursor.getColumnIndex(MyManage.column_Surname));
        addressStr = cursor.getString(cursor.getColumnIndex(MyManage.column_Address));
        statusStr = cursor.getString(cursor.getColumnIndex(MyManage.column_Status));
        totalStr = cursor.getString(cursor.getColumnIndex(MyManage.column_Total));




        cursor.close();

    }

    public void onclickOk(View view) {

        Intent intent = new Intent(OrderDetail.this, History.class);
        intent.putExtra("ID_User", strId);
        startActivity(intent);

    }


}
