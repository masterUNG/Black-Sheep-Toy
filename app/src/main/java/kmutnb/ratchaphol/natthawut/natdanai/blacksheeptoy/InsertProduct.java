package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class InsertProduct extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private ImageView[] productImageViews;
    private Button[] productButtons;
    private static final int[] pickImageINTS = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    private String[] nameImageStrings = new String[32];

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

        if ((requestCode == pickImageINTS[0]) && (resultCode == RESULT_OK)) {

            String strImagePath = findPath(data.getData());
            Log.d("26JulyV1", "ImagePath = " + strImagePath);
            nameImageStrings[0] = strImagePath.substring(strImagePath.lastIndexOf("/") + 1);
            Log.d("26JulyV1", "nameImage ==> " + nameImageStrings[0]);

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

    }   // bindWidget

    public void clickCancleInsert(View view) {
        finish();

    }   // clickCancel

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
                break;
            case R.id.button37:
                Log.d("26JulyV1", "Click Button 3");
                break;
            case R.id.button38:
                Log.d("26JulyV1", "Click Button 4");
                break;
            case R.id.button39:
                Log.d("26JulyV1", "Click Button 5");
                break;
            case R.id.button40:
                Log.d("26JulyV1", "Click Button 6");
                break;
            case R.id.button41:
                Log.d("26JulyV1", "Click Button 7");
                break;
            case R.id.button42:
                Log.d("26JulyV1", "Click Button 8");
                break;
            case R.id.button43:
                Log.d("26JulyV1", "Click Button 9");
                break;
            case R.id.button44:
                Log.d("26JulyV1", "Click Button 10");
                break;
            case R.id.button45:
                Log.d("26JulyV1", "Click Button 11");
                break;
            case R.id.button46:
                Log.d("26JulyV1", "Click Button 12");
                break;
            case R.id.button47:
                Log.d("26JulyV1", "Click Button 13");
                break;
            case R.id.button48:
                Log.d("26JulyV1", "Click Button 14");
                break;
            case R.id.button49:
                Log.d("26JulyV1", "Click Button 15");
                break;
            case R.id.button50:
                Log.d("26JulyV1", "Click Button 16");
                break;
            case R.id.button51:
                Log.d("26JulyV1", "Click Button 17");
                break;
            case R.id.button52:
                Log.d("26JulyV1", "Click Button 18");
                break;
            case R.id.button53:
                Log.d("26JulyV1", "Click Button 19");
                break;
            case R.id.button54:
                Log.d("26JulyV1", "Click Button 20");
                break;
            case R.id.button55:
                Log.d("26JulyV1", "Click Button 21");
                break;
            case R.id.button56:
                Log.d("26JulyV1", "Click Button 22");
                break;
            case R.id.button57:
                Log.d("26JulyV1", "Click Button 23");
                break;
            case R.id.button58:
                Log.d("26JulyV1", "Click Button 24");
                break;
            case R.id.button59:
                Log.d("26JulyV1", "Click Button 25");
                break;
            case R.id.button60:
                Log.d("26JulyV1", "Click Button 26");
                break;
            case R.id.button61:
                Log.d("26JulyV1", "Click Button 27");
                break;
            case R.id.button62:
                Log.d("26JulyV1", "Click Button 28");
                break;
            case R.id.button63:
                Log.d("26JulyV1", "Click Button 29");
                break;
            case R.id.button64:
                Log.d("26JulyV1", "Click Button 30");
                break;
            case R.id.button65:
                Log.d("26JulyV1", "Click Button 31");
                break;
            case R.id.button66:
                Log.d("26JulyV1", "Click Button 32");
                break;

        }   // switch

    }   // onClick

}   // Main Class
