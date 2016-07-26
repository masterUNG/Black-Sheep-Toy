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
import android.widget.AdapterView;
import android.widget.ListView;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class UserAdmin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_admin);


        createListview();
    }

    private void createListview() {

        ListView listView = (ListView) findViewById(R.id.listView3);
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userTABLE WHERE _id != 40 AND AdminUse = 'available'",
                null);
        cursor.moveToFirst();
        int intCount = cursor.getCount();

        final String[] userStrings = new String[intCount];
        final String[] nameStrings = new String[intCount];
        final String[] surnameStrings = new String[intCount];
        final String[] emailStrings = new String[intCount];
        final String[] phoneStrings = new String[intCount];


        for (int i = 0; i < intCount; i++) {

            userStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_User));
            nameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
            surnameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Surname));
            emailStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Email));
            phoneStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Phone));


            cursor.moveToNext();

        }//for
        cursor.close();

        UserAdminAdapter userAdminAdapter = new UserAdminAdapter(this, userStrings,
                nameStrings, surnameStrings, emailStrings, phoneStrings);

        listView.setAdapter(userAdminAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.
                                database_name,
                        MODE_PRIVATE, null);
                final Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userTABLE WHERE " +
                                "_id != 40 AND AdminUse = 'available'",
                        null);
                cursor.moveToFirst();

                cursor.moveToPosition(i);

                int intID = Integer.parseInt(cursor.getString(0));
                final String User = cursor.getString(4);

                AlertDialog.Builder confirmDelete = new AlertDialog.Builder(UserAdmin.this);
                confirmDelete.setTitle("ต้องการลบจริงใช่มั้ย?");
                confirmDelete.setIcon(R.drawable.danger);
                confirmDelete.setMessage("ต้องการลบ User :" + User + " ใช่ไหม");
                confirmDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        int intID = Integer.parseInt(cursor.getString(0));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("AdminUse", "delete");
                        sqLiteDatabase.update("userTABLE", contentValues, "_id = " + intID, null);

                        //SQL
                        String urlUpdate = "http://swiftcodingthai.com/sheep/php_delete_user.php";
                        OkHttpClient okHttpClient = new OkHttpClient();
                        RequestBody requestBody = new FormEncodingBuilder()
                                .add("isAdd", "true")
                                .add("User", User)
                                .add("AdminUse", "delete")
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

                        createListview();
                        dialog.dismiss();
                    }
                });

                confirmDelete.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                confirmDelete.show();


            }   // onItem
        });

    }

    public void clickAllUser(View view) {
        ListView listView = (ListView) findViewById(R.id.listView3);
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userTABLE WHERE _id != 40 AND AdminUse = 'available'",
                null);
        cursor.moveToFirst();
        int intCount = cursor.getCount();

        final String[] userStrings = new String[intCount];
        final String[] nameStrings = new String[intCount];
        final String[] surnameStrings = new String[intCount];
        final String[] emailStrings = new String[intCount];
        final String[] phoneStrings = new String[intCount];


        for (int i = 0; i < intCount; i++) {

            userStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_User));
            nameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
            surnameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Surname));
            emailStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Email));
            phoneStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Phone));


            cursor.moveToNext();

        }//for
        cursor.close();

        UserAdminAdapter userAdminAdapter = new UserAdminAdapter(this, userStrings,
                nameStrings, surnameStrings, emailStrings, phoneStrings);

        listView.setAdapter(userAdminAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.
                                database_name,
                        MODE_PRIVATE, null);
                final Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userTABLE WHERE " +
                                "_id != 40 AND AdminUse = 'available'",
                        null);
                cursor.moveToFirst();

                cursor.moveToPosition(i);

                int intID = Integer.parseInt(cursor.getString(0));
                final String User = cursor.getString(4);

                AlertDialog.Builder confirmDelete = new AlertDialog.Builder(UserAdmin.this);
                confirmDelete.setTitle("ต้องการลบจริงใช่มั้ย?");
                confirmDelete.setIcon(R.drawable.danger);
                confirmDelete.setMessage("ต้องการลบ User :" + User + " ใช่ไหม");
                confirmDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        int intID = Integer.parseInt(cursor.getString(0));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("AdminUse", "delete");
                        sqLiteDatabase.update("userTABLE", contentValues, "_id = " + intID, null);

                        //SQL
                        String urlUpdate = "http://swiftcodingthai.com/sheep/php_delete_user.php";
                        OkHttpClient okHttpClient = new OkHttpClient();
                        RequestBody requestBody = new FormEncodingBuilder()
                                .add("isAdd", "true")
                                .add("User", User)
                                .add("AdminUse", "delete")
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

                        createListview();
                        dialog.dismiss();
                    }
                });

                confirmDelete.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                confirmDelete.show();


            }   // onItem
        });
    }

    public void clickDeleteUser(View view) {
        ListView listView = (ListView) findViewById(R.id.listView3);
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userTABLE WHERE _id != 40 AND AdminUse = 'delete'",
                null);
        cursor.moveToFirst();
        int intCount = cursor.getCount();

        final String[] userStrings = new String[intCount];
        final String[] nameStrings = new String[intCount];
        final String[] surnameStrings = new String[intCount];
        final String[] emailStrings = new String[intCount];
        final String[] phoneStrings = new String[intCount];


        for (int i = 0; i < intCount; i++) {

            userStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_User));
            nameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Name));
            surnameStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Surname));
            emailStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Email));
            phoneStrings[i] = cursor.getString(cursor.getColumnIndex(MyManage.column_Phone));


            cursor.moveToNext();

        }//for
        cursor.close();

        UserAdminAdapter userAdminAdapter = new UserAdminAdapter(this, userStrings,
                nameStrings, surnameStrings, emailStrings, phoneStrings);

        listView.setAdapter(userAdminAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.
                                database_name,
                        MODE_PRIVATE, null);
                final Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userTABLE WHERE _id != 40 AND AdminUse = 'delete'",
                        null);
                cursor.moveToFirst();

                cursor.moveToPosition(i);

                int intID = Integer.parseInt(cursor.getString(0));
                final String User = cursor.getString(4);

                AlertDialog.Builder confirmDelete = new AlertDialog.Builder(UserAdmin.this);
                confirmDelete.setTitle("ต้องการปลดบลอค?");
                confirmDelete.setIcon(R.drawable.danger);
                confirmDelete.setMessage("ต้องการปลดบลอค User :" + User + " ใช่ไหม");
                confirmDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        int intID = Integer.parseInt(cursor.getString(0));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("AdminUse", "available");
                        sqLiteDatabase.update("userTABLE",contentValues, "_id = " + intID, null);

                        //SQL
                        String urlUpdate = "http://swiftcodingthai.com/sheep/php_delete_user.php";
                        OkHttpClient okHttpClient = new OkHttpClient();
                        RequestBody requestBody = new FormEncodingBuilder()
                                .add("isAdd", "true")
                                .add("User", User)
                                .add("AdminUse", "available")
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

                        createListview();
                        dialog.dismiss();
                    }
                });

                confirmDelete.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                confirmDelete.show();


            }   // onItem
        });
    }

    private void confirmDelete() {
        AlertDialog.Builder confirmDelete = new AlertDialog.Builder(this);
        confirmDelete.setTitle("ต้องการลบจริงใช่มั้ย?");
        confirmDelete.setIcon(R.drawable.danger);
        confirmDelete.setMessage("ต้องการลบ User นี้ใช่ไหม");
        confirmDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
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

    public void cilckBack(View view) {
        finish();
    }
}
