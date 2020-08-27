package tdc.edu.vn.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "QLSinhVien", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="Create table Xe (soPhieu Text,ngayXuatPhat text , gioXuatPhat text,tuyenXe text, loaiXe text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}