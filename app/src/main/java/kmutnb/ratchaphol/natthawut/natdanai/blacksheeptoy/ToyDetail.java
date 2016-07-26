package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToyDetail extends AppCompatActivity {

    //Explicit
    private TextView nameTextView, brandTextView, priceTextView, usedTextView,
            stockTextView, detailTextView;


    private ImageView imageView;
    private String idString, nameString, brandString, priceString,
            usedString, stockString, detailString;
    private String amountString = "1";
    private String[] imageStrings;
    private int indexAnInt = 0;
    private int cal = 0;
    private int xnow = 0;
    private int xstart = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toy_detail);

        //Bind Widget
        bindWidget();

        //Recieve Value
        recieveValue();

        //Show View
        showView();

        //Change Image
        changeImage(imageStrings[0]);

        //touchscreen
        touchScreen();

    } //Main Method

    private void touchScreen() {
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                Float xdown,xmove,xup;

                switch (motionEvent.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        xdown = motionEvent.getX();

                        xstart = Math.round(xdown);
                        break;


                    case MotionEvent.ACTION_UP:

                        xup = motionEvent.getX();

                        xnow = Math.round(xup);

                        cal = indexAnInt;

                        break;

                    case MotionEvent.ACTION_MOVE:

                        xmove = motionEvent.getX();

                        indexAnInt = (cal +  (xstart - Math.round(xmove))/30);

                        if (indexAnInt < 0) {
                            indexAnInt += 31;
                        }
                        if (indexAnInt > 31) {
                            indexAnInt -= 31 ;
                        }
                        changeImage(imageStrings[indexAnInt]);


                        break;

                }

                return true;
            }
        });
    }


    private void changeImage(String imageString) {



        Picasso.with(this).load(imageString).resize(300,400).into(imageView);


    }//change image

    private void showView() {

        nameTextView.setText(nameString);
        brandTextView.setText(brandString);
        priceTextView.setText(priceString + " บาท");
        usedTextView.setText(findUsed(usedString));
        stockTextView.setText(stockString + " ชิ้น");
        detailTextView.setText(detailString);

    }//ShowView

    private String findUsed(String usedString) {

        String[] resultStrings = {"", "สินค้าใหม่", "สินค้ามือ 2"};
        int index = Integer.parseInt(usedString);

        return resultStrings[index];
    }; //กำหนดมือ 1 มือ 2

    private void recieveValue() {

        idString = getIntent().getStringExtra("ID_User");
        nameString = getIntent().getStringExtra("Name");
        brandString = getIntent().getStringExtra("Brand");
        priceString = getIntent().getStringExtra("Price");
        usedString = getIntent().getStringExtra("Used");
        stockString = getIntent().getStringExtra("Stock");
        detailString = getIntent().getStringExtra("Detail");

        imageStrings = new String[32];
        imageStrings[0] = getIntent().getStringExtra("Image1");
        imageStrings[1] = getIntent().getStringExtra("Image2");
        imageStrings[2] = getIntent().getStringExtra("Image3");
        imageStrings[3] = getIntent().getStringExtra("Image4");
        imageStrings[4] = getIntent().getStringExtra("Image5");
        imageStrings[5] = getIntent().getStringExtra("Image6");
        imageStrings[6] = getIntent().getStringExtra("Image7");
        imageStrings[7] = getIntent().getStringExtra("Image8");
        imageStrings[8] = getIntent().getStringExtra("Image9");
        imageStrings[9] = getIntent().getStringExtra("Image10");
        imageStrings[10] = getIntent().getStringExtra("Image11");
        imageStrings[11] = getIntent().getStringExtra("Image12");
        imageStrings[12] = getIntent().getStringExtra("Image13");
        imageStrings[13] = getIntent().getStringExtra("Image14");
        imageStrings[14] = getIntent().getStringExtra("Image15");
        imageStrings[15] = getIntent().getStringExtra("Image16");
        imageStrings[16] = getIntent().getStringExtra("Image17");
        imageStrings[17] = getIntent().getStringExtra("Image18");
        imageStrings[18] = getIntent().getStringExtra("Image19");
        imageStrings[19] = getIntent().getStringExtra("Image20");
        imageStrings[20] = getIntent().getStringExtra("Image21");
        imageStrings[21] = getIntent().getStringExtra("Image22");
        imageStrings[22] = getIntent().getStringExtra("Image23");
        imageStrings[23] = getIntent().getStringExtra("Image24");
        imageStrings[24] = getIntent().getStringExtra("Image25");
        imageStrings[25] = getIntent().getStringExtra("Image26");
        imageStrings[26] = getIntent().getStringExtra("Image27");
        imageStrings[27] = getIntent().getStringExtra("Image28");
        imageStrings[28] = getIntent().getStringExtra("Image29");
        imageStrings[29] = getIntent().getStringExtra("Image30");
        imageStrings[30] = getIntent().getStringExtra("Image31");
        imageStrings[31] = getIntent().getStringExtra("Image32");



    }//RecieveValue

    private void bindWidget() {

        nameTextView = (TextView) findViewById(R.id.textView10);
        brandTextView = (TextView) findViewById(R.id.textView11);
        priceTextView = (TextView) findViewById(R.id.textView12);
        usedTextView = (TextView) findViewById(R.id.textView13);
        stockTextView = (TextView) findViewById(R.id.textView14);
        detailTextView = (TextView) findViewById(R.id.editText5);
        imageView = (ImageView) findViewById(R.id.imageView2);





    }


    public void clickCancelDetail(View view) {

        finish();

    }


    public void clickOrderDetail(View view) {

        CharSequence[] pieceCharSequence = new CharSequence[Integer.parseInt(stockString)];

        for (int i = 1; i <= Integer.parseInt(stockString); i++ ) {
            pieceCharSequence[i - 1] = Integer.toString(i);
        }//for

        AlertDialog.Builder choiceAlert = new AlertDialog.Builder(this);
        choiceAlert.setTitle("ต้องการสั่งกี่ชิ้น");
        choiceAlert.setIcon(R.drawable.icon_myaccount);
        choiceAlert.setSingleChoiceItems(pieceCharSequence, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                amountString = Integer.toString(i + 1);
            }
        });
        choiceAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                uploadOrder();

            }
        });
        choiceAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();

            }
        });

        choiceAlert.show();





    } //clickOrderdetail

    private void uploadOrder() {

        if (checkProduct(nameString) || checkOrderTABLE() == true) {
            //True สั่งได้

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String strDate = dateFormat.format(date);

        MyManage myManage = new MyManage(this);
        myManage.addOrder(idString, strDate, "n/a", nameString, priceString, amountString,"n/a");

        Toast.makeText(this, "บันทึก " + nameString + " แล้ว", Toast.LENGTH_SHORT).show();
        finish();}
        else {
            //False สั่งไม่ได้

            MyAlertDialog myAlertDialog = new MyAlertDialog();
            myAlertDialog.myDialog(this,R.drawable.danger,
                    "ไม่สามารถสั่งซื้อได้" , "มีสินค้าอยู่ในตะกร้าแล้ว\n" +
                            "หากต้องการสั่งเพิ่ม\n" +
                            "ท่านต้องลบข้อมูลเดิมออกก่อน");
        }


    }

    private boolean checkOrderTABLE() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM orderTABLE", null);
        cursor.moveToFirst();

        if (cursor.getCount() == 0) {
            return true;
        } else {
            return false;
        }

    }

    private boolean checkProduct(String nameString) {


            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                    MODE_PRIVATE, null);
            Cursor ocursor = sqLiteDatabase.rawQuery("SELECT * FROM orderTABLE WHERE Product = "
                    + "'" + nameString + "'", null);
            ocursor.moveToFirst();
            int i = ocursor.getCount();
            if (i == 0) {
                return true;
            } else {
                return false;
            }
    }


} //Main Class
