package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private MyManage myManage;
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        userEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText2);

        myManage = new MyManage(this);

        //Delete All SQLite
        deleteAllSQLite();

        //Synchronize JSON to SQLite
        synJSON();


    } //Main Method

    @Override
    protected void onRestart() {
        super.onRestart();

        deleteAllSQLite();
        synJSON();

    }

    public void clickSignIn(View view) {

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //Check Space
        if (userString.equals("") || passwordString.equals("")) {

            MyAlertDialog myAlertDialog = new MyAlertDialog();
            myAlertDialog.myDialog(this,R.drawable.danger,
                    "มีช่องว่าง","กรุณากรอกทุกช่องค่ะ");

        } else {

            checkUser();

        }

    }//clickSignIn

    private void checkUser() {

        try {

            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                    MODE_PRIVATE, null);
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userTABLE WHERE User = " +
                    "'" + userString + "'", null);
            cursor.moveToFirst();

            //Check Password
            if (passwordString.equals(cursor.getString(5))) {
                Toast.makeText(this, "ยินดีต้อนรับ คุณ " + cursor.getString(1),
                        Toast.LENGTH_SHORT).show();

                if (cursor.getString(0).matches("40")) {
                    Intent intent = new Intent(MainActivity.this, MainAdmin.class);
                    startActivity(intent);
                    finish();
                } else {
                    if (cursor.getString(8).matches("delete")) {
                        MyAlertDialog myAlertDialog = new MyAlertDialog();
                        myAlertDialog.myDialog(this, R.drawable.danger,
                                "User ของคุณมีปัญหา",
                                "User ของคุณทำผิดกติกาของเรา \n" +
                                        "ทางเราจึงลบ User ของคุณ \n" +
                                        "หากท่านมีอะไรชี้แจงสามารถติดต่อ Admin ผ่านทาง Email ");
                    } else {
                        Intent intent = new Intent(MainActivity.this, ToyListView.class);
                        intent.putExtra("ID_User", cursor.getString(0));
                        startActivity(intent);
                        finish();
                    }

                }


            } else {

                MyAlertDialog myAlertDialog = new MyAlertDialog();
                myAlertDialog.myDialog(this, R.drawable.danger,
                        "Password False", " password ผิด \n กรุณากรอกใหม่ให้ถูกต้องด้วยครับ");

            }

        } catch (Exception e) {
            MyAlertDialog myAlertDialog = new MyAlertDialog();
            myAlertDialog.myDialog(this, R.drawable.danger,
                    "ไม่มี User นี้","ไม่มี" + userString + "ในฐานข้อมูลของเรา");
        }


    }//CheckUser


    private void synJSON() {

        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                .Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        int intTABLE = 0;
        while (intTABLE <= 2) {

            InputStream inputStream = null;
            String strJSON = null;
            String strLine = null;
            String[] urlJSONStrings = {"http://swiftcodingthai.com/sheep/php_get_user.php",
                    "http://swiftcodingthai.com/sheep/php_get_product.php",
                    "http://swiftcodingthai.com/sheep/php_get_order.php"};

            try {

                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(urlJSONStrings[intTABLE]);
                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                inputStream = httpEntity.getContent();

                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(inputStream, "UTF-8")
                );
                StringBuilder stringBuilder = new StringBuilder();
                while ((strLine = bufferedReader.readLine()) != null) {

                    stringBuilder.append(strLine);

                }
                inputStream.close();
                strJSON = stringBuilder.toString();

                JSONArray jsonArray = new JSONArray(strJSON);


                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    switch (intTABLE) {
                        case 0:

                            String strID = jsonObject.getString("id");
                            String strName = jsonObject.getString(MyManage.column_Name);
                            String strSurname = jsonObject.getString(MyManage.column_Surname);
                            String strIDcard = jsonObject.getString(MyManage.column_idCard);
                            String strUser = jsonObject.getString(MyManage.column_User);
                            String strPassword = jsonObject.getString(MyManage.column_Password);
                            String strEmail = jsonObject.getString(MyManage.column_Email);
                            String strPhone = jsonObject.getString(MyManage.column_Phone);
                            String strAdminUse = jsonObject.getString(MyManage.column_AdminUse);

                            myManage.addUser(strID, strName, strSurname, strIDcard, strUser,
                                    strPassword, strEmail, strPhone, strAdminUse);

                            break;
                        case 1:

                            String strNameProduct = jsonObject.getString(MyManage.column_Name);
                            String strBrand = jsonObject.getString(MyManage.column_Brand);
                            String strPrice = jsonObject.getString(MyManage.column_Price);
                            String strStock = jsonObject.getString(MyManage.column_Stock);
                            String strUsed = jsonObject.getString(MyManage.column_Used);
                            String strVat = jsonObject.getString(MyManage.column_Vat);
                            String strShipping = jsonObject.getString(MyManage.column_Shipping);
                            String strDetail = jsonObject.getString(MyManage.column_Detail);
                            String strImage1 = jsonObject.getString(MyManage.column_Image1);
                            String strImage2 = jsonObject.getString(MyManage.column_Image2);
                            String strImage3 = jsonObject.getString(MyManage.column_Image3);
                            String strImage4 = jsonObject.getString(MyManage.column_Image4);
                            String strImage5 = jsonObject.getString(MyManage.column_Image5);
                            String strImage6 = jsonObject.getString(MyManage.column_Image6);
                            String strImage7 = jsonObject.getString(MyManage.column_Image7);
                            String strImage8 = jsonObject.getString(MyManage.column_Image8);
                            String strImage9 = jsonObject.getString(MyManage.column_Image9);
                            String strImage10 = jsonObject.getString(MyManage.column_Image10);
                            String strImage11 = jsonObject.getString(MyManage.column_Image11);
                            String strImage12 = jsonObject.getString(MyManage.column_Image12);
                            String strImage13 = jsonObject.getString(MyManage.column_Image13);
                            String strImage14 = jsonObject.getString(MyManage.column_Image14);
                            String strImage15 = jsonObject.getString(MyManage.column_Image15);
                            String strImage16 = jsonObject.getString(MyManage.column_Image16);
                            String strImage17 = jsonObject.getString(MyManage.column_Image17);
                            String strImage18 = jsonObject.getString(MyManage.column_Image18);
                            String strImage19 = jsonObject.getString(MyManage.column_Image19);
                            String strImage20 = jsonObject.getString(MyManage.column_Image20);
                            String strImage21 = jsonObject.getString(MyManage.column_Image21);
                            String strImage22 = jsonObject.getString(MyManage.column_Image22);
                            String strImage23 = jsonObject.getString(MyManage.column_Image23);
                            String strImage24 = jsonObject.getString(MyManage.column_Image24);
                            String strImage25 = jsonObject.getString(MyManage.column_Image25);
                            String strImage26 = jsonObject.getString(MyManage.column_Image26);
                            String strImage27 = jsonObject.getString(MyManage.column_Image27);
                            String strImage28 = jsonObject.getString(MyManage.column_Image28);
                            String strImage29 = jsonObject.getString(MyManage.column_Image29);
                            String strImage30 = jsonObject.getString(MyManage.column_Image30);
                            String strImage31 = jsonObject.getString(MyManage.column_Image31);
                            String strImage32 = jsonObject.getString(MyManage.column_Image32);

                            myManage.addProduct(strNameProduct, strBrand, strPrice,
                                    strStock, strUsed, strVat, strShipping, strDetail, strImage1,
                                    strImage2, strImage3, strImage4, strImage5,
                                    strImage6, strImage7, strImage8,
                                    strImage9, strImage10, strImage11, strImage12,
                                    strImage13, strImage14, strImage15,
                                    strImage16, strImage17, strImage18, strImage19,
                                    strImage20, strImage21, strImage22,
                                    strImage23, strImage24, strImage25, strImage26,
                                    strImage27, strImage28, strImage29,
                                    strImage30, strImage31, strImage32);


                            break;
                        case 2:

                            String strbillNo = jsonObject.getString(MyManage.column_Ref);
                            String strIDuser = jsonObject.getString(MyManage.column_IDuser);
                            String strDate = jsonObject.getString(MyManage.column_Date);
                            String strNameHis = jsonObject.getString(MyManage.column_Name);
                            String strSurnameHis = jsonObject.getString(MyManage.column_Surname);
                            String strAddress = jsonObject.getString(MyManage.column_Address);
                            String strProduct = jsonObject.getString(MyManage.column_Product);
                            String strPriceHis = jsonObject.getString(MyManage.column_Price);
                            String strPiece = jsonObject.getString(MyManage.column_Piece);
                            String strTotal = jsonObject.getString(MyManage.column_Total);
                            String strStatus = jsonObject.getString(MyManage.column_Status);
                            String strAdmin = jsonObject.getString(MyManage.column_Admin);


                            myManage.addHistory(strbillNo, strIDuser, strDate, strNameHis,
                                    strSurnameHis, strAddress, strProduct, strPriceHis, strPiece,
                                    strTotal, strStatus, strAdmin);

                            break;

                    } // switch

                } //for


            } catch (Exception e) {
                Log.d("Sheep", "Error ==>" + e.toString());
            }


            intTABLE += 1;
        } //while


    } //synJSON

    private void deleteAllSQLite() {
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        sqLiteDatabase.delete(MyManage.product_table, null, null);
        sqLiteDatabase.delete(MyManage.user_table, null, null);
        sqLiteDatabase.delete(MyManage.order_table, null, null);
        sqLiteDatabase.delete(MyManage.history_table, null, null);
    }

    public void clickSignUp(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

} //Main class
