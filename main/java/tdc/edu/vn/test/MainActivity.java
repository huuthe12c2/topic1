package tdc.edu.vn.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvDanhSachQLXe;
    Button btnThem, btnXoa, btnSua, btnClear;
    Spinner spLoaiXe, spTuyenXe;
    EditText txtSoPhieu, txtNgayXuatPhat, txtGioXuatPhat;
    ArrayList<String> dataTuyenXe = new ArrayList<>();
    ArrayList<String> dataLoaiXe = new ArrayList<>();
    ArrayList<Xe> dataXe = new ArrayList<>();
    ArrayAdapter adapterLoaiXe;
    ArrayAdapter adapterTuyenXe;
    CustomAdapter adapterXe;
    int index = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        KhoiTao();
        adapterLoaiXe = new ArrayAdapter(this, android.R.layout.simple_spinner_item, dataLoaiXe);
        spLoaiXe.setAdapter(adapterLoaiXe);
        adapterTuyenXe = new ArrayAdapter(this, android.R.layout.simple_spinner_item, dataTuyenXe);
        spTuyenXe.setAdapter(adapterTuyenXe);
        adapterXe = new CustomAdapter(this, R.layout.list_item_layout, dataXe);
        lvDanhSachQLXe.setAdapter(adapterXe);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Xe xe = getXe();
                DBXe dbXe = new DBXe(getApplicationContext());
                dbXe.Them(xe);
            }
        });
        lvDanhSachQLXe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Xe xe = dataXe.get(position);
                txtSoPhieu.setText(xe.getSoPhieu());
                txtNgayXuatPhat.setText(xe.getNgayXuatPhat());
                txtGioXuatPhat.setText(xe.getGioXuatPhat());
                spLoaiXe.setSelection(dataLoaiXe.indexOf(xe.getLoaiXe()));
                spTuyenXe.setSelection(dataTuyenXe.indexOf(xe.getTuyenXe()));
                index = position;
            }
        });
        lvDanhSachQLXe.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Xe xe = dataXe.get(position);
                index = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn Xóa?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dataXe.remove(index);
                        adapterXe.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                return false;
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn Xóa?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dataXe.remove(index);
                        adapterXe.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xe xe = dataXe.get(index);
                xe.setSoPhieu(txtSoPhieu.getText().toString());
                xe.setNgayXuatPhat(txtGioXuatPhat.getText().toString());
                xe.setGioXuatPhat(txtGioXuatPhat.getText().toString());
                xe.setLoaiXe(spLoaiXe.getSelectedItem().toString());
                xe.setTuyenXe(spTuyenXe.getSelectedItem().toString());

                adapterXe.notifyDataSetChanged();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSoPhieu.setText("");
                txtNgayXuatPhat.setText("");
                txtGioXuatPhat.setText("");
                spLoaiXe.setSelection(0);
                spTuyenXe.setSelection(0);
            }
        });
    }
    private Xe getXe() {
        Xe xe = new Xe();
        xe.setSoPhieu(txtSoPhieu.getText().toString());
        xe.setGioXuatPhat(txtGioXuatPhat.getText().toString());
        xe.setTuyenXe(spTuyenXe.getSelectedItem().toString());
        xe.setLoaiXe(spLoaiXe.getSelectedItem().toString());
        xe.setNgayXuatPhat(txtNgayXuatPhat.getText().toString());
        return xe;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.doc:
                Log.d("test", "Luu");
                Toast.makeText(getApplication(), "Doc", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, DanhSach.class);
                startActivity(intent);
                break;
            case R.id.luu:
                Log.d("test", "Luu");
                Toast.makeText(getApplication(), "Lưu", Toast.LENGTH_LONG).show();
                break;
            case R.id.thoat:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void KhoiTao() {
        dataLoaiXe.add("Xe 16");
        dataLoaiXe.add("Máy Bay");
        dataLoaiXe.add("Tàu Hỏa");
        dataTuyenXe.add("Tuyến Đà Lạt - Bình Dương");
        dataTuyenXe.add("Tuyến Bình Dương - Đà Lạt");
        dataTuyenXe.add("Tuyến Thành Phố HCM - Hà Nội");
        Xe xe = new Xe();

        xe.setLoaiXe("Xe 16");
        xe.setSoPhieu("SoPhieu001");
        xe.setGioXuatPhat("10/10/2020");
        xe.setNgayXuatPhat("15 Giờ");
        xe.setTuyenXe("Tuyến Bình Dương - Đà Lạt");
        dataXe.add(xe);
    }

    private void setControl() {
        lvDanhSachQLXe = (ListView) findViewById(R.id.lvDSSV);
        btnThem = (Button) findViewById(R.id.buttonThem);
        btnXoa = (Button) findViewById(R.id.buttonXoa);
        btnSua = (Button) findViewById(R.id.buttonSua);
        btnClear = (Button) findViewById(R.id.buttonClear);
        spLoaiXe = (Spinner) findViewById(R.id.spinnerXe);
        spTuyenXe = (Spinner) findViewById(R.id.spinnerTuyen);
        txtSoPhieu = (EditText) findViewById(R.id.editTextSoPhieu);
        txtNgayXuatPhat = (EditText) findViewById(R.id.editTextNgayXuatPhat);
        txtGioXuatPhat = (EditText) findViewById(R.id.editTextGioXuatPhat);
    }
}
