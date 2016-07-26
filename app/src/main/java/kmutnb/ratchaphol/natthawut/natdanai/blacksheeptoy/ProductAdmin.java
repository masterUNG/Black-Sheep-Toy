package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProductAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_admin);
    }

    public void clickUpdate(View view) {
        startActivity(new Intent(ProductAdmin.this, UpdateProductAdmin.class));
    }

    public void clickBackProduct(View view) {
        startActivity(new Intent(ProductAdmin.this, MainAdmin.class));
    }

    public void clickInsertProduct(View view) {
        startActivity(new Intent(ProductAdmin.this, InsertProduct.class));
    }
}
