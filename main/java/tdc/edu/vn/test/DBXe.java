package tdc.edu.vn.test;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBXe {
    DBHelper dbHelper;

    public DBXe(Context context) {
        dbHelper= new DBHelper(context);
    }

    public  void Them(Xe xe)
    {
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("soPhieu",xe.getSoPhieu());
        values.put("ngayXuatPhat",xe.getNgayXuatPhat());
        values.put("gioXuatPhat",xe.getGioXuatPhat());
        values.put("loaiXe",xe.getLoaiXe());
        values.put("tuyenXe",xe.getTuyenXe());
        db.insert("Xe",null,values);
    }

    public  void Sua(Xe xe)
    {
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("soPhieu",xe.getSoPhieu());
        values.put("ngayXuatPhat",xe.getNgayXuatPhat());
        values.put("gioXuatPhat",xe.getGioXuatPhat());
        values.put("loaiXe",xe.getLoaiXe());
        values.put("tuyenXe",xe.getTuyenXe());

        db.update("Xe",values,"soPhieu = '"+xe.getSoPhieu()+"'",null);

    }

    public  void Xoa(Xe xe)
    {

        SQLiteDatabase db= dbHelper.getWritableDatabase();
        String sql="Delete from Xe where soPhieu= '"+ xe.getSoPhieu()+"'";
        db.execSQL(sql);



    }

    public ArrayList<Xe> LayDL()
    {
        ArrayList<Xe> data = new ArrayList<>();
        String sql =" select * from Xe";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        do{
            Xe xe = new Xe();
            xe.setSoPhieu(cursor.getString(0));
//            if(cursor.getString(1).equals("Nam"))
//                sinhVien.setGioiTinh(true);
//            else
//                sinhVien.setGioiTinh(false);

            xe.setGioXuatPhat(cursor.getString(2));
            xe.setNgayXuatPhat(cursor.getString(2));
            xe.setLoaiXe(cursor.getString(2));
            xe.setTuyenXe(cursor.getString(2));
            data.add(xe);
        }
        while (cursor.moveToNext());
        return  data;
    }
}
