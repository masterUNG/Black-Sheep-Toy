package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InsertProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_product);
    }

    public void clickCancleInsert(View view) {
        finish();

    }
}
