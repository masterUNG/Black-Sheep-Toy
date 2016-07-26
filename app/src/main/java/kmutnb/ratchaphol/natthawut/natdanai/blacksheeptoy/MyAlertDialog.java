package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;


public class MyAlertDialog {

    public void myDialog(Context context, int intIcon, String strTitle, String strMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(intIcon);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

}// Main Class
