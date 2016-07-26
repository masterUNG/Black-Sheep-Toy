package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainAdmin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);



    }

    public void clickUser(View view) {
        startActivity(new Intent(MainAdmin.this, UserAdmin.class));

    }

    public void clickProduct(View view) {
        startActivity(new Intent(MainAdmin.this, ProductAdmin.class));
    }

    public void clickOrder(View view) {
        startActivity(new Intent(MainAdmin.this, OrderAdmin.class));
    }
}
