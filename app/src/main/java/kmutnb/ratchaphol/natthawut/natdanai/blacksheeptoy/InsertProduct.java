package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.jibble.simpleftp.SimpleFTP;

import java.io.File;


public class InsertProduct extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private ImageView[] productImageViews;
    private Button[] productButtons;
    private static final int[] pickImageINTS = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    private String[] nameImageStrings = new String[32];
    private String[] pathImageStrings = new String[32];
    private EditText nameEditText, brandEditText, priceEditText, stockEditText, vatEditText,
            shippingEditText, detailEditText;
    private String nameString, brandString, priceString, stockString, vatString,
            shippingString, detailString;
    private boolean statusImageABoolean = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_product);

        //BindWidget
        bindWidget();

        //Button Controller
        buttonController();

    }   // Main Method

    private String findPath(Uri uri) {
        String imagePath;

        String[] columns = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, columns, null, null, null);

        if (cursor != null) { // case gallery
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            imagePath = cursor.getString(columnIndex);
        } else { // case another app
            imagePath = uri.getPath();

        }
        return imagePath;

    }   // findPath

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        int intIndex = requestCode;
        Log.d("26JulyV1", "Index ==> " + intIndex);

        if ((requestCode == pickImageINTS[intIndex]) && (resultCode == RESULT_OK)) {

            String strImagePath = findPath(data.getData());
            Log.d("26JulyV1", "ImagePath = " + strImagePath);
            pathImageStrings[intIndex] = strImagePath;
            nameImageStrings[intIndex] = strImagePath.substring(strImagePath.lastIndexOf("/") + 1);
            Log.d("26JulyV1", "nameImage ==> " + nameImageStrings[intIndex]);

            // Show Choose Image
            try {

                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(data.getData()));
                productImageViews[intIndex].setImageBitmap(bitmap);

            } catch (Exception e) {
                Log.d("26JulyV1", "e ==> " + e.toString());
            }   // try

        }   // if


    }   // onActivityResult

    private void buttonController() {

        for (int i = 0; i < productButtons.length; i += 1) {

            productButtons[i].setOnClickListener(this);

        }   //for

    }   // buttonController

    private void bindWidget() {

        productImageViews = new ImageView[32];
        productImageViews[0] = (ImageView) findViewById(R.id.imageView5);
        productImageViews[1] = (ImageView) findViewById(R.id.imageView6);
        productImageViews[2] = (ImageView) findViewById(R.id.imageView7);
        productImageViews[3] = (ImageView) findViewById(R.id.imageView8);
        productImageViews[4] = (ImageView) findViewById(R.id.imageView9);
        productImageViews[5] = (ImageView) findViewById(R.id.imageView10);
        productImageViews[6] = (ImageView) findViewById(R.id.imageView11);
        productImageViews[7] = (ImageView) findViewById(R.id.imageView12);
        productImageViews[8] = (ImageView) findViewById(R.id.imageView13);
        productImageViews[9] = (ImageView) findViewById(R.id.imageView14);
        productImageViews[10] = (ImageView) findViewById(R.id.imageView15);
        productImageViews[11] = (ImageView) findViewById(R.id.imageView16);
        productImageViews[12] = (ImageView) findViewById(R.id.imageView17);
        productImageViews[13] = (ImageView) findViewById(R.id.imageView18);
        productImageViews[14] = (ImageView) findViewById(R.id.imageView19);
        productImageViews[15] = (ImageView) findViewById(R.id.imageView20);
        productImageViews[16] = (ImageView) findViewById(R.id.imageView21);
        productImageViews[17] = (ImageView) findViewById(R.id.imageView22);
        productImageViews[18] = (ImageView) findViewById(R.id.imageView23);
        productImageViews[19] = (ImageView) findViewById(R.id.imageView24);
        productImageViews[20] = (ImageView) findViewById(R.id.imageView25);
        productImageViews[21] = (ImageView) findViewById(R.id.imageView26);
        productImageViews[22] = (ImageView) findViewById(R.id.imageView27);
        productImageViews[23] = (ImageView) findViewById(R.id.imageView28);
        productImageViews[24] = (ImageView) findViewById(R.id.imageView29);
        productImageViews[25] = (ImageView) findViewById(R.id.imageView30);
        productImageViews[26] = (ImageView) findViewById(R.id.imageView31);
        productImageViews[27] = (ImageView) findViewById(R.id.imageView32);
        productImageViews[28] = (ImageView) findViewById(R.id.imageView33);
        productImageViews[29] = (ImageView) findViewById(R.id.imageView34);
        productImageViews[30] = (ImageView) findViewById(R.id.imageView34);
        productImageViews[31] = (ImageView) findViewById(R.id.imageView36);

        productButtons = new Button[32];
        productButtons[0] = (Button) findViewById(R.id.button36);
        productButtons[1] = (Button) findViewById(R.id.button18);
        productButtons[2] = (Button) findViewById(R.id.button37);
        productButtons[3] = (Button) findViewById(R.id.button38);
        productButtons[4] = (Button) findViewById(R.id.button39);
        productButtons[5] = (Button) findViewById(R.id.button40);
        productButtons[6] = (Button) findViewById(R.id.button41);
        productButtons[7] = (Button) findViewById(R.id.button42);
        productButtons[8] = (Button) findViewById(R.id.button43);
        productButtons[9] = (Button) findViewById(R.id.button44);
        productButtons[10] = (Button) findViewById(R.id.button45);
        productButtons[11] = (Button) findViewById(R.id.button46);
        productButtons[12] = (Button) findViewById(R.id.button47);
        productButtons[13] = (Button) findViewById(R.id.button48);
        productButtons[14] = (Button) findViewById(R.id.button49);
        productButtons[15] = (Button) findViewById(R.id.button50);
        productButtons[16] = (Button) findViewById(R.id.button51);
        productButtons[17] = (Button) findViewById(R.id.button52);
        productButtons[18] = (Button) findViewById(R.id.button53);
        productButtons[19] = (Button) findViewById(R.id.button54);
        productButtons[20] = (Button) findViewById(R.id.button55);
        productButtons[21] = (Button) findViewById(R.id.button56);
        productButtons[22] = (Button) findViewById(R.id.button57);
        productButtons[23] = (Button) findViewById(R.id.button58);
        productButtons[24] = (Button) findViewById(R.id.button59);
        productButtons[25] = (Button) findViewById(R.id.button60);
        productButtons[26] = (Button) findViewById(R.id.button61);
        productButtons[27] = (Button) findViewById(R.id.button62);
        productButtons[28] = (Button) findViewById(R.id.button63);
        productButtons[29] = (Button) findViewById(R.id.button64);
        productButtons[30] = (Button) findViewById(R.id.button65);
        productButtons[31] = (Button) findViewById(R.id.button66);

        nameEditText = (EditText) findViewById(R.id.editText10);
        brandEditText = (EditText) findViewById(R.id.editText13);
        priceEditText = (EditText) findViewById(R.id.editText14);
        stockEditText = (EditText) findViewById(R.id.editText15);
        vatEditText = (EditText) findViewById(R.id.editText17);
        shippingEditText = (EditText) findViewById(R.id.editText18);
        detailEditText = (EditText) findViewById(R.id.editText16);

    }   // bindWidget

    public void clickCancelInsert(View view) {
        finish();

    }   // clickCancel

    public void clickInsert(View view) {

        nameString = nameEditText.getText().toString().trim();
        brandString = brandEditText.getText().toString().trim();
        priceString = priceEditText.getText().toString().trim();
        stockString = stockEditText.getText().toString().trim();
        vatString = vatEditText.getText().toString().trim();
        shippingString = shippingEditText.getText().toString().trim();
        detailString = detailEditText.getText().toString().trim();

        //Check Space
        if (nameString.equals("") || brandString.equals("") ||
                priceString.equals("") || stockString.equals("") ||
                vatString.equals("") || shippingString.equals("") ||
                detailString.equals("")) {

            //Have Space
            MyAlertDialog myAlertDialog = new MyAlertDialog();
            myAlertDialog.myDialog(this, R.drawable.icon_myaccount, "Have Space",
                    "Please Fill All Every Blank");

        } else if (checkChooseImage()) {
            //Complete Image
            upLoadImageToServer();


        } else {
            // Not Choose Image Some
            MyAlertDialog myAlertDialog = new MyAlertDialog();
            myAlertDialog.myDialog(this, R.drawable.icon_myaccount, "Not Choose Image",
                    "Please Choose Image all");
        }


    }   // clickInsert

    private void upLoadImageToServer() {

        try {

            SimpleFTP simpleFTP = new SimpleFTP();
            simpleFTP.connect("ftp.swiftcodingthai.com", 21, "sheep@swiftcodingthai.com", "Abc12345");
            simpleFTP.bin();
            simpleFTP.cwd("web");
            simpleFTP.stor(new File(pathImageStrings[0]));
            simpleFTP.disconnect();


        } catch (Exception e) {
            Log.d("26JulyV1", "e upload ==> " + e.toString());
        }

    }   // upLoadImage

    private boolean checkChooseImage() {

        boolean result = true;

       // for (int i=0;i<nameImageStrings.length;i+=1) {  // นี่คือต้นฉบับ

        for (int i=0;i<2;i+=1) {
            if (nameImageStrings[i] == null ) {
                return false; // Have null on String
            }   //if
        }   // for

        Log.d("26JulyV1", "Result ChooseImage ==> " + result);

        return result;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.button36:
                Log.d("26JulyV1", "Click Button 1");

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),
                        pickImageINTS[0]);


                break;
            case R.id.button18:
                Log.d("26JulyV1", "Click Button 2");

                Intent intent1 = new Intent(Intent.ACTION_GET_CONTENT);
                intent1.setType("image/*");
                startActivityForResult(Intent.createChooser(intent1, "Select Picture"),
                        pickImageINTS[1]);

                break;
            case R.id.button37:
                Log.d("26JulyV1", "Click Button 3");

                Intent intent2 = new Intent(Intent.ACTION_GET_CONTENT);
                intent2.setType("image/*");
                startActivityForResult(Intent.createChooser(intent2, "Select Picture"),
                        pickImageINTS[2]);

                break;
            case R.id.button38:
                Log.d("26JulyV1", "Click Button 4");

                Intent intent3 = new Intent(Intent.ACTION_GET_CONTENT);
                intent3.setType("image/*");
                startActivityForResult(Intent.createChooser(intent3, "Select Picture"),
                        pickImageINTS[3]);

                break;
            case R.id.button39:
                Log.d("26JulyV1", "Click Button 5");

                Intent intent4 = new Intent(Intent.ACTION_GET_CONTENT);
                intent4.setType("image/*");
                startActivityForResult(Intent.createChooser(intent4, "Select Picture"),
                        pickImageINTS[4]);

                break;
            case R.id.button40:
                Log.d("26JulyV1", "Click Button 6");

                Intent intent5 = new Intent(Intent.ACTION_GET_CONTENT);
                intent5.setType("image/*");
                startActivityForResult(Intent.createChooser(intent5, "Select Picture"),
                        pickImageINTS[5]);

                break;
            case R.id.button41:
                Log.d("26JulyV1", "Click Button 7");

                Intent intent6 = new Intent(Intent.ACTION_GET_CONTENT);
                intent6.setType("image/*");
                startActivityForResult(Intent.createChooser(intent6, "Select Picture"),
                        pickImageINTS[6]);

                break;
            case R.id.button42:
                Log.d("26JulyV1", "Click Button 8");
                Intent intent7 = new Intent(Intent.ACTION_GET_CONTENT);
                intent7.setType("image/*");
                startActivityForResult(Intent.createChooser(intent7, "Select Picture"),
                        pickImageINTS[7]);

                break;
            case R.id.button43:
                Log.d("26JulyV1", "Click Button 9");

                Intent intent8 = new Intent(Intent.ACTION_GET_CONTENT);
                intent8.setType("image/*");
                startActivityForResult(Intent.createChooser(intent8, "Select Picture"),
                        pickImageINTS[8]);

                break;
            case R.id.button44:
                Log.d("26JulyV1", "Click Button 10");

                Intent intent9 = new Intent(Intent.ACTION_GET_CONTENT);
                intent9.setType("image/*");
                startActivityForResult(Intent.createChooser(intent9, "Select Picture"),
                        pickImageINTS[9]);

                break;
            case R.id.button45:
                Log.d("26JulyV1", "Click Button 11");

                Intent intent10 = new Intent(Intent.ACTION_GET_CONTENT);
                intent10.setType("image/*");
                startActivityForResult(Intent.createChooser(intent10, "Select Picture"),
                        pickImageINTS[10]);

                break;
            case R.id.button46:
                Log.d("26JulyV1", "Click Button 12");

                Intent intent11 = new Intent(Intent.ACTION_GET_CONTENT);
                intent11.setType("image/*");
                startActivityForResult(Intent.createChooser(intent11, "Select Picture"),
                        pickImageINTS[11]);

                break;
            case R.id.button47:
                Log.d("26JulyV1", "Click Button 13");

                Intent intent12 = new Intent(Intent.ACTION_GET_CONTENT);
                intent12.setType("image/*");
                startActivityForResult(Intent.createChooser(intent12, "Select Picture"),
                        pickImageINTS[12]);

                break;
            case R.id.button48:
                Log.d("26JulyV1", "Click Button 14");

                Intent intent13 = new Intent(Intent.ACTION_GET_CONTENT);
                intent13.setType("image/*");
                startActivityForResult(Intent.createChooser(intent13, "Select Picture"),
                        pickImageINTS[13]);

                break;
            case R.id.button49:
                Log.d("26JulyV1", "Click Button 15");

                Intent intent14 = new Intent(Intent.ACTION_GET_CONTENT);
                intent14.setType("image/*");
                startActivityForResult(Intent.createChooser(intent14, "Select Picture"),
                        pickImageINTS[14]);

                break;
            case R.id.button50:
                Log.d("26JulyV1", "Click Button 16");
                Intent intent15 = new Intent(Intent.ACTION_GET_CONTENT);
                intent15.setType("image/*");
                startActivityForResult(Intent.createChooser(intent15, "Select Picture"),
                        pickImageINTS[15]);

                break;
            case R.id.button51:
                Log.d("26JulyV1", "Click Button 17");
                Intent intent16 = new Intent(Intent.ACTION_GET_CONTENT);
                intent16.setType("image/*");
                startActivityForResult(Intent.createChooser(intent16, "Select Picture"),
                        pickImageINTS[16]);

                break;
            case R.id.button52:
                Log.d("26JulyV1", "Click Button 18");
                Intent intent17 = new Intent(Intent.ACTION_GET_CONTENT);
                intent17.setType("image/*");
                startActivityForResult(Intent.createChooser(intent17, "Select Picture"),
                        pickImageINTS[17]);

                break;
            case R.id.button53:
                Log.d("26JulyV1", "Click Button 19");
                Intent intent18 = new Intent(Intent.ACTION_GET_CONTENT);
                intent18.setType("image/*");
                startActivityForResult(Intent.createChooser(intent18, "Select Picture"),
                        pickImageINTS[18]);

                break;
            case R.id.button54:
                Log.d("26JulyV1", "Click Button 20");
                Intent intent19 = new Intent(Intent.ACTION_GET_CONTENT);
                intent19.setType("image/*");
                startActivityForResult(Intent.createChooser(intent19, "Select Picture"),
                        pickImageINTS[19]);

                break;
            case R.id.button55:
                Log.d("26JulyV1", "Click Button 21");
                Intent intent20 = new Intent(Intent.ACTION_GET_CONTENT);
                intent20.setType("image/*");
                startActivityForResult(Intent.createChooser(intent20, "Select Picture"),
                        pickImageINTS[20]);

                break;
            case R.id.button56:
                Log.d("26JulyV1", "Click Button 22");
                Intent intent21 = new Intent(Intent.ACTION_GET_CONTENT);
                intent21.setType("image/*");
                startActivityForResult(Intent.createChooser(intent21, "Select Picture"),
                        pickImageINTS[21]);

                break;
            case R.id.button57:
                Log.d("26JulyV1", "Click Button 23");
                Intent intent22 = new Intent(Intent.ACTION_GET_CONTENT);
                intent22.setType("image/*");
                startActivityForResult(Intent.createChooser(intent22, "Select Picture"),
                        pickImageINTS[22]);

                break;
            case R.id.button58:
                Log.d("26JulyV1", "Click Button 24");
                Intent intent23 = new Intent(Intent.ACTION_GET_CONTENT);
                intent23.setType("image/*");
                startActivityForResult(Intent.createChooser(intent23, "Select Picture"),
                        pickImageINTS[23]);

                break;
            case R.id.button59:
                Log.d("26JulyV1", "Click Button 25");
                Intent intent24 = new Intent(Intent.ACTION_GET_CONTENT);
                intent24.setType("image/*");
                startActivityForResult(Intent.createChooser(intent24, "Select Picture"),
                        pickImageINTS[24]);

                break;
            case R.id.button60:
                Log.d("26JulyV1", "Click Button 26");
                Intent intent25 = new Intent(Intent.ACTION_GET_CONTENT);
                intent25.setType("image/*");
                startActivityForResult(Intent.createChooser(intent25, "Select Picture"),
                        pickImageINTS[25]);

                break;
            case R.id.button61:
                Log.d("26JulyV1", "Click Button 27");
                Intent intent26 = new Intent(Intent.ACTION_GET_CONTENT);
                intent26.setType("image/*");
                startActivityForResult(Intent.createChooser(intent26, "Select Picture"),
                        pickImageINTS[26]);

                break;
            case R.id.button62:
                Log.d("26JulyV1", "Click Button 28");
                Intent intent27 = new Intent(Intent.ACTION_GET_CONTENT);
                intent27.setType("image/*");
                startActivityForResult(Intent.createChooser(intent27, "Select Picture"),
                        pickImageINTS[27]);

                break;
            case R.id.button63:
                Log.d("26JulyV1", "Click Button 29");
                Intent intent28 = new Intent(Intent.ACTION_GET_CONTENT);
                intent28.setType("image/*");
                startActivityForResult(Intent.createChooser(intent28, "Select Picture"),
                        pickImageINTS[28]);

                break;
            case R.id.button64:
                Log.d("26JulyV1", "Click Button 30");
                Intent intent29 = new Intent(Intent.ACTION_GET_CONTENT);
                intent29.setType("image/*");
                startActivityForResult(Intent.createChooser(intent29, "Select Picture"),
                        pickImageINTS[29]);

                break;
            case R.id.button65:
                Log.d("26JulyV1", "Click Button 31");
                Intent intent30 = new Intent(Intent.ACTION_GET_CONTENT);
                intent30.setType("image/*");
                startActivityForResult(Intent.createChooser(intent30, "Select Picture"),
                        pickImageINTS[30]);

                break;
            case R.id.button66:
                Log.d("26JulyV1", "Click Button 32");
                Intent intent31 = new Intent(Intent.ACTION_GET_CONTENT);
                intent31.setType("image/*");
                startActivityForResult(Intent.createChooser(intent31, "Select Picture"),
                        pickImageINTS[31]);

                break;

        }   // switch

    }   // onClick

}   // Main Class
