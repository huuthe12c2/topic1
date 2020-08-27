package tdc.edu.vn.test;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<Xe> dataXe;

    public CustomAdapter( Context context, int resource,ArrayList<Xe> dataXe  ) {
        super(context, resource);
        this.context = context;
        this.dataXe = dataXe;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return dataXe.size();
    }
    private static class Holder {
        ImageView imgLoaiXe;
        TextView gioXuatPhat;
        TextView ngayXuatPhat;
        TextView tvSoPhieu;
        TextView tvTuyenXe;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(resource, null);
            holder = new Holder();
            holder.imgLoaiXe = view.findViewById(R.id.imgLoaiXe);
            holder.gioXuatPhat = view.findViewById(R.id.tvGioXuatPhat);
            holder.ngayXuatPhat = view.findViewById(R.id.tvNgayXuatPhat);
            holder.tvSoPhieu = view.findViewById(R.id.tvSoPhieu);
            holder.tvTuyenXe = view.findViewById(R.id.tvTuyen);
            view.setTag(holder);
        } else
            view.getTag();
        final Xe xe = dataXe.get(position);
        if(xe.getLoaiXe()=="Xe 16")
            holder.imgLoaiXe.setImageResource(R.drawable.xe16_ic_airport_shuttle_black_24dp);
        else if(xe.getLoaiXe()=="Tàu Hỏa")
            holder.imgLoaiXe.setImageResource(R.drawable.tauhoa_ic_directions_railway_black_24dp);
        else
            holder.imgLoaiXe.setImageResource(R.drawable.ic_flight_black_24dp);
        holder.tvSoPhieu.setText(xe.getSoPhieu());
        holder.ngayXuatPhat.setText(xe.getNgayXuatPhat());
        holder.gioXuatPhat.setText(xe.getGioXuatPhat());
        holder.tvTuyenXe.setText(xe.getTuyenXe());
        return view;
    }
}
