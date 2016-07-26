package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {


    //Explicit

    private EditText nameEditText, surnameEditText, idCardEditText,
            userEditText, passwordEditText, emailEditText, phoneEditText;

    private Button registerButton;
    private String nameString, surnameString, idCardString,
            userString, passwordString, emailString, phoneString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //BindWidget
        bindWidget();

        //Botton Controller
        buttonController();


    }//Main Method

    private void buttonController() {

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get Value From Edit Text
                nameString = nameEditText.getText().toString().trim();
                surnameString = surnameEditText.getText().toString().trim();
                idCardString = idCardEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();
                emailString = emailEditText.getText().toString().trim();
                phoneString = phoneEditText.getText().toString().trim();

                //Check Space ห้ามว่างนะ
                if (checkSpace()) {
                    //Have Space
                    MyAlertDialog myAlertDialog = new MyAlertDialog();
                    myAlertDialog.myDialog(SignUpActivity.this, R.drawable.danger,
                            "มีช่องว่าง", "กรุณากรอกทุกช่องด้วยครับ");

                } else if (idCardEditText.length() != 13) {
                    MyAlertDialog myAlertDialog = new MyAlertDialog();
                    myAlertDialog.myDialog(SignUpActivity.this, R.drawable.danger,
                            "โปรดเช็คข้อมูล", "กรุณากรอกหมายเลขประจำตัวประชาชนให้ถูกต้องด้วยครับ");
                } else if (checkUser() == true) {
                    //User ซ้ำ
                    MyAlertDialog myAlertDialog = new MyAlertDialog();
                    myAlertDialog.myDialog(SignUpActivity.this, R.drawable.danger,
                            "User นี้ไม่สามารถใช้งานได้", "มีผู้อื่นใช้ User นี้แล้ว!");

                } else if (checkID() == false) {

                    MyAlertDialog myAlertDialog = new MyAlertDialog();
                    myAlertDialog.myDialog(SignUpActivity.this, R.drawable.danger,
                            "UserName ไม่สามารถใช้ภาษาไทยได้", "กรุณาใช้ภาษาอังกฤษหรือตัวเลขเท่านั้น");


                } else if (checkPass() == false) {

                    MyAlertDialog myAlertDialog = new MyAlertDialog();
                    myAlertDialog.myDialog(SignUpActivity.this, R.drawable.danger,
                            "Password ไม่สามารถใช้ภาษาไทยได้", "กรุณาใช้ภาษาอังกฤษหรือตัวเลขเท่านั้น");


                }else {
                    //No Space
                    confirmData();

                } //if


            }//event
        });

    }

    private void confirmData() {

        String strN = "\n";
        String strE = " = ";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.icon_myaccount);
        builder.setTitle("โปรดตรวจข้อมูล");
        builder.setMessage(getResources().getString(R.string.name) + strE + nameString + strN +
                getResources().getString(R.string.surname) + strE + surnameString + strN +
                getResources().getString(R.string.idcard) + strE + idCardString + strN +
                getResources().getString(R.string.user) + strE + userString + strN +
                getResources().getString(R.string.password) + strE + passwordString + strN +
                getResources().getString(R.string.email) + strE + emailString + strN +
                getResources().getString(R.string.phone_number) + strE + phoneString);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                updateToMySQL();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    } //confirm data

    private void updateToMySQL() {

        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                .Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        try {


            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("isAdd","true" ));
            nameValuePairs.add(new BasicNameValuePair("Name",nameString ));
            nameValuePairs.add(new BasicNameValuePair("Surname",surnameString ));
            nameValuePairs.add(new BasicNameValuePair("idCard",idCardString ));
            nameValuePairs.add(new BasicNameValuePair("User",userString ));
            nameValuePairs.add(new BasicNameValuePair("Password", passwordString ));
            nameValuePairs.add(new BasicNameValuePair("Email", emailString));
            nameValuePairs.add(new BasicNameValuePair("Phone", phoneString));
            nameValuePairs.add(new BasicNameValuePair("AdminUse", "available"));

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://swiftcodingthai.com/sheep/php_add_user.php");
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            httpClient.execute(httpPost);

            Toast.makeText(SignUpActivity.this, "บันทึกเรียบร้อยแล้ว ขอบคุณค่ะ",
                    Toast.LENGTH_SHORT).show();
            finish();


        } catch (Exception e) {
            Toast.makeText(SignUpActivity.this, "ไม่สามารถบันทึกได้", Toast.LENGTH_SHORT).show();
        }


    }// updateToMySQL

    private boolean checkUser() {

        boolean result = false;
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userTABLE WHERE User = " +
                "'" + userString + "'", null);
        cursor.moveToFirst();
        int i = cursor.getCount();
        Log.i("User", Integer.toString(i));
        if (i != 0) {
            return true;
        }

        return result;


    }


    private boolean checkSpace() {

        boolean spaceStatus = true;

        spaceStatus = nameString.equals("") ||
                surnameString.equals("") ||
                idCardString.equals("") ||
                userString.equals("") ||
                passwordString.equals("") ||
                emailString.equals("") ||
                phoneString.equals("");

        return spaceStatus;
    }

    private void bindWidget() {

        nameEditText = (EditText) findViewById(R.id.edtName);
        surnameEditText = (EditText) findViewById(R.id.edtSurname);
        idCardEditText = (EditText) findViewById(R.id.edtIDcard);
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        emailEditText = (EditText) findViewById(R.id.edtEmail);
        phoneEditText = (EditText) findViewById(R.id.edtPhone);
        registerButton = (Button) findViewById(R.id.btnRegister);


    } //bindWidget

    private boolean checkPass() {
        if (passwordString.matches("[A-Za-z0-9]+")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkID() {

        if (userString.matches("[A-Za-z0-9]+")) {
            return true;
        } else {
            return false;
        }

    }

}//Main Class
