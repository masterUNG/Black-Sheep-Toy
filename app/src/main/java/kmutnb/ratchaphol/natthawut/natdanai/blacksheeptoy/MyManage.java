package kmutnb.ratchaphol.natthawut.natdanai.blacksheeptoy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class MyManage {

    //explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public static final String user_table = "userTABLE";
    public static final String column_id = "_id";
    public static final String column_Name = "Name";
    public static final String column_Surname = "Surname";
    public static final String column_idCard = "idCard";
    public static final String column_User = "User";
    public static final String column_Password = "Password";
    public static final String column_Email = "Email";
    public static final String column_Phone = "Phone";
    public static final String column_AdminUse = "AdminUse";


    public static final String product_table = "productTABLE";
    public static final String column_Brand = "Brand";
    public static final String column_Price = "Price";
    public static final String column_Stock = "Stock";
    public static final String column_Used = "Used";
    public static final String column_Vat = "Vat";
    public static final String column_Shipping = "Shipping";
    public static final String column_Detail = "Detail";
    public static final String column_Image1 = "Image1";
    public static final String column_Image2 = "Image2";
    public static final String column_Image3 = "Image3";
    public static final String column_Image4 = "Image4";
    public static final String column_Image5 = "Image5";
    public static final String column_Image6 = "Image6";
    public static final String column_Image7 = "Image7";
    public static final String column_Image8 = "Image8";
    public static final String column_Image9 = "Image9";
    public static final String column_Image10 = "Image10";
    public static final String column_Image11 = "Image11";
    public static final String column_Image12 = "Image12";
    public static final String column_Image13 = "Image13";
    public static final String column_Image14 = "Image14";
    public static final String column_Image15 = "Image15";
    public static final String column_Image16 = "Image16";
    public static final String column_Image17 = "Image17";
    public static final String column_Image18 = "Image18";
    public static final String column_Image19 = "Image19";
    public static final String column_Image20 = "Image20";
    public static final String column_Image21 = "Image21";
    public static final String column_Image22 = "Image22";
    public static final String column_Image23 = "Image23";
    public static final String column_Image24 = "Image24";
    public static final String column_Image25 = "Image25";
    public static final String column_Image26 = "Image26";
    public static final String column_Image27 = "Image27";
    public static final String column_Image28 = "Image28";
    public static final String column_Image29 = "Image29";
    public static final String column_Image30 = "Image30";
    public static final String column_Image31 = "Image31";
    public static final String column_Image32 = "Image32";

    public static final String order_table = "orderTABLE";
    public static final String colunm_IDuser = "ID_User";
    public static final String colunm_Date = "Date";
    public static final String colunm_Product = "Product";
    public static final String colunm_SentTo = "Sent_To";


    public static final String history_table = "historyTABLE";
    public static final String column_Ref = "Ref";
    public static final String column_IDuser = "IDUser";
    public static final String column_Date = "Date";
    public static final String column_Address = "Address";
    public static final String column_Product = "Product";
    public static final String column_Piece = "Piece";
    public static final String column_Total = "Total";
    public static final String column_Status = "Status";
    public static final String column_Admin = "Admin";

    public MyManage(Context context) {

        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();


    } //Constructor

    public long addOrder(String strIDUser,
                         String strDate,
                         String strSent_To,
                         String strProduct,
                         String strPrice,
                         String strPiece,
                         String strTotal) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(colunm_IDuser, strIDUser);
        contentValues.put(colunm_Date, strDate);
        contentValues.put(colunm_SentTo, strSent_To);
        contentValues.put(colunm_Product, strProduct);
        contentValues.put(column_Price, strPrice);
        contentValues.put(column_Piece, strPiece);
        contentValues.put(column_Total, strTotal);




        return sqLiteDatabase.insert(order_table, null, contentValues);
    }

    public long addHistory(String strbillNo,
                          String strIDUser,
                          String strDate,
                          String strNameHis,
                          String strSurnameHis,
                          String strAddress,
                          String strProduct,
                          String strPriceHis,
                          String strPiece,
                          String strTotal,
                          String strStatus,
                           String strAdminHis) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_Ref, strbillNo);
        contentValues.put(column_IDuser, strIDUser);
        contentValues.put(column_Date, strDate);
        contentValues.put(column_Name, strNameHis);
        contentValues.put(column_Surname, strSurnameHis);
        contentValues.put(column_Address, strAddress);
        contentValues.put(column_Product, strProduct);
        contentValues.put(column_Price, strPriceHis);
        contentValues.put(column_Piece, strPiece);
        contentValues.put(column_Total, strTotal);
        contentValues.put(column_Status, strStatus);
        contentValues.put(column_Admin, strAdminHis);

        return sqLiteDatabase.insert(history_table, null, contentValues);
    }

    public long addProduct(String strName,
                           String strBrand,
                           String strPrice,
                           String strStock,
                           String strUsed,
                           String strVat,
                           String strShipping,
                           String strDetail,
                           String strImage1,
                           String strImage2,
                           String strImage3,
                           String strImage4,
                           String strImage5,
                           String strImage6,
                           String strImage7,
                           String strImage8,
                           String strImage9,
                           String strImage10,
                           String strImage11,
                           String strImage12,
                           String strImage13,
                           String strImage14,
                           String strImage15,
                           String strImage16,
                           String strImage17,
                           String strImage18,
                           String strImage19,
                           String strImage20,
                           String strImage21,
                           String strImage22,
                           String strImage23,
                           String strImage24,
                           String strImage25,
                           String strImage26,
                           String strImage27,
                           String strImage28,
                           String strImage29,
                           String strImage30,
                           String strImage31,
                           String strImage32) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_Name, strName);
        contentValues.put(column_Brand, strBrand);
        contentValues.put(column_Price, strPrice);
        contentValues.put(column_Stock, strStock);
        contentValues.put(column_Used, strUsed);
        contentValues.put(column_Vat, strVat);
        contentValues.put(column_Shipping, strShipping);
        contentValues.put(column_Detail, strDetail);
        contentValues.put(column_Image1, strImage1);
        contentValues.put(column_Image2, strImage2);
        contentValues.put(column_Image3, strImage3);
        contentValues.put(column_Image4, strImage4);
        contentValues.put(column_Image5, strImage5);
        contentValues.put(column_Image6, strImage6);
        contentValues.put(column_Image7, strImage7);
        contentValues.put(column_Image8, strImage8);
        contentValues.put(column_Image9, strImage9);
        contentValues.put(column_Image10, strImage10);
        contentValues.put(column_Image11, strImage11);
        contentValues.put(column_Image12, strImage12);
        contentValues.put(column_Image13, strImage13);
        contentValues.put(column_Image14, strImage14);
        contentValues.put(column_Image15, strImage15);
        contentValues.put(column_Image16, strImage16);
        contentValues.put(column_Image17, strImage17);
        contentValues.put(column_Image18, strImage18);
        contentValues.put(column_Image19, strImage19);
        contentValues.put(column_Image20, strImage20);
        contentValues.put(column_Image21, strImage21);
        contentValues.put(column_Image22, strImage22);
        contentValues.put(column_Image23, strImage23);
        contentValues.put(column_Image24, strImage24);
        contentValues.put(column_Image25, strImage25);
        contentValues.put(column_Image26, strImage26);
        contentValues.put(column_Image27, strImage27);
        contentValues.put(column_Image28, strImage28);
        contentValues.put(column_Image29, strImage29);
        contentValues.put(column_Image30, strImage30);
        contentValues.put(column_Image31, strImage31);
        contentValues.put(column_Image32, strImage32);

        return sqLiteDatabase.insert(product_table, null, contentValues);
    }


    public long addUser(String strID,
                        String strName,
                        String strSurname,
                        String strIDcard,
                        String strUser,
                        String strPassword,
                        String strEmail,
                        String strPhone,
                        String strAdminUse) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_id, strID);
        contentValues.put(column_Name, strName);
        contentValues.put(column_Surname, strSurname);
        contentValues.put(column_idCard, strIDcard);
        contentValues.put(column_User, strUser);
        contentValues.put(column_Password, strPassword);
        contentValues.put(column_Email, strEmail);
        contentValues.put(column_Phone, strPhone);
        contentValues.put(column_AdminUse, strAdminUse);

        return sqLiteDatabase.insert(user_table, null, contentValues);
    }

} // Main Class
