package tdc.edu.vn.test;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DanhSach extends AppCompatActivity {
    ListView lvDanhSach;
    CustomAdapter apdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        lvDanhSach = findViewById(R.id.lvDanhSach);
        registerForContextMenu(lvDanhSach);
        CapnhapDL();
    }

    public  void  CapnhapDL()
    {
        try {
            DBXe db = new DBXe(this);
            apdapter = new CustomAdapter(this, R.layout.list_item_layout, db.LayDL());
            lvDanhSach.setAdapter(apdapter);
        }
        catch (Exception ex)
        {
            lvDanhSach.setVisibility(View.GONE);
            Toast.makeText(this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        onBackPressed();
        return true;

    }
}
