package tdc.edu.vn.test;

public class Xe {
    String soPhieu, loaiXe, tuyenXe, gioXuatPhat, ngayXuatPhat;

    public String getSoPhieu() {
        return soPhieu;
    }

    public void setSoPhieu(String soPhieu) {
        this.soPhieu = soPhieu;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public String getTuyenXe() {
        return tuyenXe;
    }

    public void setTuyenXe(String tuyenXe) {
        this.tuyenXe = tuyenXe;
    }

    public String getGioXuatPhat() {
        return gioXuatPhat;
    }

    public void setGioXuatPhat(String gioXuatPhat) {
        this.gioXuatPhat = gioXuatPhat;
    }

    public String getNgayXuatPhat() {
        return ngayXuatPhat;
    }

    public void setNgayXuatPhat(String ngayXuatPhat) {
        this.ngayXuatPhat = ngayXuatPhat;
    }

    @Override
    public String toString() {
        return "Xe{" +
                "soPhieu='" + soPhieu + '\'' +
                ", loaiXe='" + loaiXe + '\'' +
                ", tuyenXe='" + tuyenXe + '\'' +
                ", ngayXuatPhieu='" + gioXuatPhat + '\'' +
                ", ngayXuatPhat='" + ngayXuatPhat + '\'' +
                '}';
    }
}
